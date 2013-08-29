(ns com.example.handler 
  (:require [liberator.core :refer [resource defresource]]
            [compojure.core :refer [defroutes ANY]]))

(defn my-handler [ctx]
  (format "<html>It's %d milliseconds since the end of the current epoch."
          (System/currentTimeMillis)))

(defroutes app
  (ANY "/bar" [] (resource :available-media-types ["text/html"]
                           :handle-ok my-handler)))
