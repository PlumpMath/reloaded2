(ns reloaded2.web-server
  (:require (reloaded2 [lifecycle :refer [Lifecycle]]
                         [handler :refer [app app-with-debugging]])
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [listening-port blocking debug]
  Lifecycle
  (start [{:keys [listening-port blocking debug] :as component}]
    (let [handler (if debug 
                    #'app-with-debugging 
                    #'app)]
      (assoc component :server (run-jetty handler {:port listening-port :join? blocking}))))
  (stop [{:keys [server] :as component}]
    (.stop server)
    component))


