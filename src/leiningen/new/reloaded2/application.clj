(ns {{ns-name}}.application
  (:require ({{ns-name}} [lifecycle :refer [add]]
                       [web-server :refer [->WebServer]]
                       [repl-server :refer [->ReplServer]])
            [environ.core :refer [env]]))


(defn assemble-base
  "Assembles and returns components for a base application"
  []
  ((add {}) {:web-server (->WebServer (env :http-port) (env :trace-headers) (atom nil))}))

(defn assemble-dev 
  "Alias for assemble-base"
  []
  (assemble-base))

(defn assemble-prod
  "Assembles and returns components for a production application"
  []
  (let [components (assemble-base)]
    ((add components) 
     {:repl-server (->ReplServer (env :repl-port) (atom nil))})))


