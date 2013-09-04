(ns leiningen.new.reloaded2
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "reloaded2"))

(defn reloaded2
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/com/example/lifecycle.clj" (render "lifecycle.clj" data)]
["src/com/example/utilities.clj" (render "utilities.clj" data)]
["src/com/example/handler.clj" (render "handler.clj" data)]
["src/com/example/components.clj" (render "components.clj" data)]
["src/com/example/application.clj" (render "application.clj" data)]
["src/com/example/repl_server.clj" (render "repl_server.clj" data)]
["test/com/example/handler_test.clj" (render "handler_test.clj" data)]
["project.clj" (render "project.clj" data)]
["src/com/example/core.clj" (render "core.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["src/com/example/web_server.clj" (render "web_server.clj" data)]
)))