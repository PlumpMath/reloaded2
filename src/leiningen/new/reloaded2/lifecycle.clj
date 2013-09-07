(ns reloaded2.lifecycle)

(defprotocol Lifecycle
  (start [component]
    "Runs side effects to start the component. Returns the component.")
  (stop [component]
    "Runs side effects to stop the component. Returns the component."))
