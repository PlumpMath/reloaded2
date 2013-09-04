(ns com.example.components
  (:require (com.example [lifecycle :as lifecycle])))

(defn add [components]
  "Add a component to a vector of components"
  (partial conj components))

(defn start
  "Runs all the stopped components. Returns a vector with the components in a started state"
  [components]
  (doall (map lifecycle/start components)))

(defn stop
  "Stops all running components. Returns a vector with the components in a stopped state"
  [components]
  (doall (map lifecycle/stop components)))
