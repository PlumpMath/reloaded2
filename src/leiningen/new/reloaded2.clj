(ns leiningen.new.reloaded2
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "reloaded2"))

(defn reloaded2
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/reloaded2/remote/monitor.clj" (render "monitor.clj" data)]
["src/reloaded2/application.clj" (render "application.clj" data)]
["src/reloaded2/remote/commands.clj" (render "commands.clj" data)]
["src/reloaded2/repl_server.clj" (render "repl_server.clj" data)]
["project.clj" (render "project.clj" data)]
["test/reloaded2/handler_test.clj" (render "handler_test.clj" data)]
["src/reloaded2/core.clj" (render "core.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["src/reloaded2/web_server.clj" (render "web_server.clj" data)]
["src/reloaded2/handler.clj" (render "handler.clj" data)]
["src/reloaded2/lifecycle.clj" (render "lifecycle.clj" data)]
["src/reloaded2/utilities.clj" (render "utilities.clj" data)]
)))