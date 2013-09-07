(ns reloaded2.remote.commands
  (:require (reloaded2.remote [monitor :refer [send-command]])))

(def debugging-command 
  '(let [component (first reloaded2.core/system)]
     (->> 
      (->
       (reloaded2.lifecycle/stop component)
       (assoc :debug %s)
       (reloaded2.lifecycle/start))
      (assoc reloaded2.core/system 0)
      (constantly)
      (alter-var-root #'reloaded2.core/system))))

(defmacro stringify-cmd [command & variables]
  (if variables
    `(format (str ~command) (str ~@variables))
    `(str ~command)))

(defn toggle-debugging
  "Restart web server with debugging off"
  [& {:keys [host port toggle] :or {host "localhost" port 8001}}]
  (let [commands [(stringify-cmd debugging-command toggle)]]
    (send-command commands :host host :port port)))

;;(toggle-debugging :toggle true)


