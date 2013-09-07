(ns reloaded2.remote.commands
  (:require (reloaded2.remote [monitor :refer [send-command]])))


(defn debugging-command
  "Actual debugging command to send"
  [& {:keys [toggle]}]
  (format 
   "(let [component (first reloaded2.core/system)]
    (->> 
     (->
      (reloaded2.lifecycle/stop component)
      (assoc :debug %s)
      (reloaded2.lifecycle/start))
     (assoc reloaded2.core/system 0)
     (constantly)
     (alter-var-root #'reloaded2.core/system)))" 
   (str toggle)))


(defn toggle-debugging
  "Restart web server with debugging off"
  [& {:keys [host port toggle] :or {host "localhost" port 8001}}]
  (let [commands [(debugging-command :toggle toggle)]]
    (send-command commands :host host :port port)))

(toggle-debugging :toggle false)

