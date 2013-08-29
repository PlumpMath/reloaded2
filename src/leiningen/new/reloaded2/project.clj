(defproject com.example/{{ns-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [liberator "0.9.0"]
                 [compojure "1.1.3"]
                 [ring/ring-jetty-adapter "1.1.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/clojure-contrib "1.2.0"]]
                   :source-paths ["dev"]}
             :uberjar {:aot :all}}
  :main com.example.core)
