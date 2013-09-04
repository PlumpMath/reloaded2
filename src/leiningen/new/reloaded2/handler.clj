(ns com.example.handler 
  (:require [liberator.core :refer [resource defresource]]
            [liberator.dev :refer [wrap-trace]]
            [compojure.core :refer [defroutes GET]]
            [environ.core :refer [env]]))


(defroutes routes
  (GET "/bar" [] (resource :available-media-types ["text/html"]
                           :handle-ok (format "<html>It's %d milliseconds since the end of the current epoch."
                                              (System/currentTimeMillis)))))

(def app
  (if (= (env :appenv) "development")
    (-> routes (wrap-trace :header :ui))
    routes))
