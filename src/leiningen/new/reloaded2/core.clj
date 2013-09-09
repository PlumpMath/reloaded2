(ns reloaded2.core
  (:gen-class)
  (:require (reloaded2 [lifecycle :refer [start-all]] 
                       [application :refer [assemble-prod]])))

(def system
  "A Var containing an object representing the application under
  production."
  nil)

(defn -main 
  []
  "Start the application"
  (alter-var-root #'system (constantly (-> 
                                        (assemble-prod) 
                                        start-all)))) 


