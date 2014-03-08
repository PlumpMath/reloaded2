(defproject reloaded2/{{ns-name}} "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [liberator "0.10.0"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [environ "0.4.0"]]
  :plugins [[lein-environ "0.4.0"]]
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]
                   :source-paths ["dev"]
                   :env {:http-port 3000 :trace-headers true}}
             :production {:env {:http-port 8000 :repl-port 8001 :trace-headers false}}
             :uberjar {:aot :all}}
  :resource-paths ["resources"]
  :main {{ns-name}}.core)
