(ns leiningen.new.reloaded2
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "reloaded2"))

(defn reloaded2
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/{{sanitized}}/remote/monitor.clj" (render "monitor.clj" data)]
["src/{{sanitized}}/application.clj" (render "application.clj" data)]
["src/{{sanitized}}/remote/commands.clj" (render "commands.clj" data)]
["src/{{sanitized}}/repl_server.clj" (render "repl_server.clj" data)]
["project.clj" (render "project.clj" data)]
["test/{{sanitized}}/handler_test.clj" (render "handler_test.clj" data)]
["src/{{sanitized}}/core.clj" (render "core.clj" data)]
["dev/user.clj" (render "user.clj" data)]
["src/{{sanitized}}/web_server.clj" (render "web_server.clj" data)]
["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
["src/{{sanitized}}/lifecycle.clj" (render "lifecycle.clj" data)]
["src/{{sanitized}}/utilities.clj" (render "utilities.clj" data)]
)))
