(ns com.example.web-server
  (:require (com.example [lifecycle :refer [Lifecycle]]
                         [handler :refer [app]])
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [listening-port blocking]
  Lifecycle
  (start [{:keys [listening-port blocking] :as component}]
    (assoc component :server (run-jetty #'app {:port listening-port :join? blocking})))
  (stop [{:keys [server] :as component}]
    (.stop server)
    component))


