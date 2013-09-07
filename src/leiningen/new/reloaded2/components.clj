(ns reloaded2.components
  (:require (reloaded2 [lifecycle :as lifecycle])))

(defn add [components]
  "Add a component to a collection of components"
  (partial conj components))

(defn start
  "Runs all the stopped components. Returns a collection with the components in a started state"
  [components]
  (vec (doall (map lifecycle/start components))))

(defn stop
  "Stops all running components. Returns a collection with the components in a stopped state"
  [components]
  (dorun (map lifecycle/stop components))
  components)
