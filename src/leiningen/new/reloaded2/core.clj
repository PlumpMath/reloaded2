(ns com.example.core
  (:gen-class)
  (:require (com.example [components :refer [start]] 
                         [application :refer [assemble-prod]])))

(defn -main 
  []
  "Start the application"
  (-> (assemble-prod {:listening-port 8000 :blocking false :repl-port 8001}) start))


