(ns com.example.web-server
  (:require (com.example [lifecycle :refer [Lifecycle]]
                         [handler :refer [app]])
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [server]
  Lifecycle
  (start [{:keys [server] :as web-server}]
    (.start server)
    web-server)
  (stop [{:keys [server] :as web-server}]
    (.stop server)
    web-server))

(defn ->WebServer
  "Creates and returns a web server record/component in a stopped state."
  [listening-port blocking]
  (let [server (run-jetty #'app {:port listening-port :join? blocking})]
    (.stop server)
    (WebServer. server)))
