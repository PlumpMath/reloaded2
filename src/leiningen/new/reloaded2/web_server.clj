(ns {{ns-name}}.wiring.components.web-server
  (:require ({{ns-name}}.wiring [lifecycle :refer [Lifecycle]])
            ({{ns-name}}.webapp [handler :refer [app app-with-debugging]])
            [ring.adapter.jetty :refer [run-jetty]]))

(defrecord WebServer [listening-port debug instance]
  Lifecycle
  (start [_]
    (let [handler (if debug #'app-with-debugging #'app)]
      (reset! instance (run-jetty handler {:port (Integer. listening-port) :join? false}))))
  (stop [_]
    (when @instance
      (.stop @instance)
      (reset! instance nil))))


