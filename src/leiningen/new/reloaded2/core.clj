(ns reloaded2.core
  (:gen-class)
  (:require (reloaded2 [components :refer [start]] 
                       [application :refer [assemble-prod]])))

(def system
  "A Var containing an object representing the application under
  production."
  nil)

(defn -main 
  []
  "Start the application"
  (alter-var-root #'system (constantly (-> 
                                        (assemble-prod {:listening-port 8000 :blocking false :repl-port 8001}) 
                                        start))))


