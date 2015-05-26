(defproject ksafe "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [selmer "0.8.2"]
                 [com.taoensso/timbre "3.4.0"]
                 [com.taoensso/tower "3.0.2"]
                 [markdown-clj "0.9.66"]
                 [environ "1.0.0"]
                 [compojure "1.3.4"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-session-timeout "0.1.0"]
                 [metosin/ring-middleware-format "0.6.0"]
                 [metosin/ring-http-response "0.6.2"]
                 [bouncer "0.3.2"]
                 [prone "0.8.2"]
                 [org.clojure/tools.nrepl "0.2.10"]
                 [ring-server "0.4.0"]
                 [ragtime "0.3.8"]
                 [org.clojure/java.jdbc "0.3.7"]
                 [instaparse "1.4.0"]
                 [yesql "0.5.0-rc2"]
                 [org.postgresql/postgresql "9.3-1102-jdbc41"]]

  :min-lein-version "2.0.0"
  :uberjar-name "ksafe.jar"
  :jvm-opts ["-server"]

;;enable to start the nREPL server when the application launches
  :env {:repl-port 7001}

  :main ksafe.core

  :plugins [[lein-ring "0.9.1"]
            [lein-environ "1.0.0"]
            [lein-ancient "0.6.5"]
            [ragtime/ragtime.lein "0.3.8"]]
  

  
  :ring {:handler ksafe.handler/app
         :init    ksafe.handler/init
         :destroy ksafe.handler/destroy
         :uberwar-name "ksafe.war"}

  
  :ragtime
  {:migrations ragtime.sql.files/migrations
   :database
   "jdbc:postgresql://localhost/ksafe?user=postgres&password=changeme"}
  
  
  
  
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             
             :aot :all}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.3.2"]
                        [pjstadig/humane-test-output "0.7.0"]
                        ]
         :source-paths ["env/dev/clj"]
         
         
         
         :repl-options {:init-ns ksafe.core}
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]
         :env {:dev true}}})
