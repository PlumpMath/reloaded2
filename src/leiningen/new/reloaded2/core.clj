(ns com.example.core
  (:gen-class)
  (:require (com.example application)))

(defn -main 
  []
  "Start the application"
  (-> (com.example.application/create {:listening-port 8000 :blocking true})
      com.example.application/start))


