(ns com.example.application
  (:require (com.example [components :refer [add]]
                         web-server
                         repl-server)))


(defn assemble-base
  "Assembles and returns components for a base application"
  [{:keys [listening-port blocking]}]
  (let [components [(com.example.web-server/->WebServer listening-port blocking)]]
    components))

(defn assemble-dev 
  "Alias for assemble-base"
  [args]
  (assemble-base args))

(defn assemble-prod
  "Assembles and returns components for a production application"
  [{:keys [listening-port blocking repl-port] :as params}]
  (let [components (assemble-base params)]
    ((add components) 
     (com.example.repl-server/->ReplServer repl-port))))


