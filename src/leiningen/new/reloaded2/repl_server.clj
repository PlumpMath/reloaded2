(ns com.example.repl-server
  (:require (com.example [lifecycle :refer [Lifecycle]])
            [clojure.tools.nrepl.server :refer [start-server stop-server]]))

(defrecord ReplServer [port]
  Lifecycle
  (start [{:keys [port] :as component}]
    (assoc component :server (start-server :port port)))
  (stop [{:keys [server] :as component}]
    (stop-server server)
    component))



