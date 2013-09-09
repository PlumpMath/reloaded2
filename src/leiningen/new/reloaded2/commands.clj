(ns reloaded2.remote.commands
  (:require (reloaded2.remote [monitor :refer [send-command]])))

(def debugging-command  
  '(let [component (:web-server reloaded2.core/system)]
     (reloaded2.lifecycle/stop component)
     (->>
      %s
      (assoc component :debug)
      (assoc reloaded2.core/system :web-server)
      (constantly)
      (alter-var-root #'reloaded2.core/system))
     (reloaded2.lifecycle/start (:web-server reloaded2.core/system))))

(defmacro stringify-cmd [command & variables]
  (if variables
    `(format (str ~command) (str ~@variables))
    `(str ~command)))

(defn toggle-debugging
  "Restart web server with debugging off"
  [& {:keys [toggle]}]
  (let [commands [(stringify-cmd debugging-command toggle)]]
    (send-command commands)))

;;(toggle-debugging :toggle true)




