(ns com.example.application
  (:require (com.example [lifecycle :as lifecycle]
                         web-server)))

(defn create
  "Create and returns all the components of the application"
  [{:keys [listening-port blocking]}]
  (let [components [(com.example.web-server/->WebServer listening-port blocking)]]
    components))

(defn start
  "Runs all the stopped components. Returns a vector with the components in a started state"
  [components]
  (doall (map lifecycle/start components)))

(defn stop
  "Stops all running components. Returns a vector with the components in a stopped state"
  [components]
  (doall (map lifecycle/stop components)))

