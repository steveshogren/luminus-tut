(ns ksafe.app
  (:require [ksafe.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
