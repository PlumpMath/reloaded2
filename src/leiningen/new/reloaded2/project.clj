(defproject reloaded2/{{ns-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.nrepl "0.2.3"]
                 [liberator "0.9.0"]
                 [compojure "1.1.3"]
                 [environ "0.4.0"]
                 [ring/ring-jetty-adapter "1.1.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [ring-mock "0.1.5"]]
                   :source-paths ["dev"]
                   :env {:appenv "development"}}
             :uberjar {:aot :all}}
  :main reloaded2.core)
