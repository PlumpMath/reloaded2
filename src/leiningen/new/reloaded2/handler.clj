(ns reloaded2.handler 
  (:require [liberator.core :refer [resource defresource]]
            [liberator.dev :refer [wrap-trace]]
            [compojure.core :refer [defroutes GET]]
            [environ.core :refer [env]]))


(defroutes app
  (GET "/bar" [] (resource :available-media-types ["text/html"]
                           :handle-ok (format "<html>It's %d milliseconds since the end of the current epoch."
                                              (System/currentTimeMillis)))))

(def app-with-debugging
  (-> app 
      (wrap-trace :header :ui)))
