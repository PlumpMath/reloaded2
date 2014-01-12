(ns {{ns-name}}.wiring.lifecycle)

(defprotocol Lifecycle
  (start [component]
    "Runs side effects to start the component.")
  (stop [component]
    "Runs side effects to stop the component."))

(defn add [components]
  "Add a component to a collection of components"
  (partial conj components))

(defn start-all
  "Returns a collection of the components in a started state"
  [components]
  (doseq [[k v] components] (start v))
  components)

(defn stop-all
  "Returns a collection of components in a stopped state"
  [components]
  (doseq [[k v] components] (stop v))
  components)
