(ns reloaded2.utilities)

(defmacro stringify-form [form & variables]
  (if variables
    `(format (str ~form) (str ~@variables))
    `(str ~form)))




