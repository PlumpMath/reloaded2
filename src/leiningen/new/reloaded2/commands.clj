(ns reloaded2.remote.commands
  (:require (reloaded2.remote [monitor :refer [send-command]])
            (reloaded2 [utilities :refer [stringify-form]])))

(def debugging-cmd  
  '(let [component (:web-server reloaded2.core/system)]
     (reloaded2.lifecycle/stop component)
     (->>
      %s
      (assoc component :debug)
      (assoc reloaded2.core/system :web-server)
      (constantly)
      (alter-var-root #'reloaded2.core/system))
     (reloaded2.lifecycle/start (:web-server reloaded2.core/system))))

(defn toggle-debugging
  "Restart web server with debugging off"
  [& {:keys [toggle]}]
  (let [commands [(stringify-form debugging-cmd toggle)]]
    (send-command commands)))

;;(toggle-debugging :toggle false)





