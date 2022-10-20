(ns exercism_clj.hello-world.hello-world-test
  (:require [clojure.test :refer [deftest is]]
            [exercism-clj.hello-world.hello-world :as hello-world]))

(deftest hello-world-test
  (is (= "Hello, World!" (hello-world/hello))))
