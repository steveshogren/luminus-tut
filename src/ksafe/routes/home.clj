(ns ksafe.routes.home
  (:require [ksafe.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render "home.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/data" [] (ok (int (/ (.getTime (java.util.Date.)) 1000))))
  (GET "/docs" [] (ok (-> "docs/docs.md" io/resource slurp))))

