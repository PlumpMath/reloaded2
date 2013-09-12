(ns {{ns-name}}.repl-server
  (:require ({{ns-name}} [lifecycle :refer [Lifecycle]])
            [clojure.tools.nrepl.server :refer [start-server stop-server]]))

(defrecord ReplServer [port instance]
  Lifecycle
  (start [_]
    (if port (reset! instance (start-server :port port))))
  (stop [_]
    (when @instance
      (.stop @instance)
      (reset! instance nil))))



