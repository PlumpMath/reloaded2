(ns reloaded2.web-server
  (:require (reloaded2 [lifecycle :refer [Lifecycle]]
                       [handler :refer [app app-with-debugging]])
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [listening-port debug instance]
  Lifecycle
  (start [_]
    (let [handler (if debug #'app-with-debugging #'app)]
      (reset! instance (run-jetty handler {:port listening-port :join? false}))))
  (stop [_]
    (when @instance
      (.stop @instance)
      (reset! instance nil))))


