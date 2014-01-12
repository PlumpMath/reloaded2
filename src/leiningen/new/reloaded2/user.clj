(ns user
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require
   [clojure.string :as str]
   [clojure.test :as test]
   [clojure.tools.namespace.repl :refer (refresh refresh-all)]
   [{{ns-name}}.wiring.application :refer [assemble-dev]]
   [{{ns-name}}.wiring.lifecycle :refer [start-all stop-all]]))

(def system
  "A Var containing an object representing the application under
  development."
  nil)

(defn init
  "Creates and initializes the system under development in the Var
  #'system."
  []
  (alter-var-root #'system (constantly (assemble-dev))))

(defn start
  "Starts all components, updates the Var #'system."
  []
  (alter-var-root #'system start-all)
  :started)

(defn stop
  "Stops all components, updates the Var #'system."
  []
  (alter-var-root #'system stop-all)
  :stopped)

(defn go
  "Initializes and starts the system running."
  []
  (init)
  (start)
  :ready)

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after 'user/go))
