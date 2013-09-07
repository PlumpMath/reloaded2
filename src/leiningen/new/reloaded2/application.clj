(ns reloaded2.application
  (:require (reloaded2 [components :refer [add]]
                       web-server
                       repl-server)))


(defn assemble-base
  "Assembles and returns components for a base application"
  [{:keys [listening-port blocking debug] :or {blocking false}}]
  (let [components [(reloaded2.web-server/->WebServer listening-port blocking debug)]]
    components))

(defn assemble-dev 
  "Alias for assemble-base"
  [& params]
  (assemble-base params))

(defn assemble-prod
  "Assembles and returns components for a production application"
  [& {:keys [repl-port] :as params}]
  (let [components (assemble-base params)]
    ((add components) 
     (reloaded2.repl-server/->ReplServer repl-port))))


