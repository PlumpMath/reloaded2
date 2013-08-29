(ns com.example.handler-test
  (:require [com.example.handler :refer [my-handler]]
            [clojure.contrib.string :refer [substring?]]
            [clojure.test :refer :all]))

(deftest handler
  (is (substring? "milliseconds" (my-handler nil))))
