(ns exercism-clj.squeaky-clean.squeaky-clean
  (:require [clojure.string :as str]))


(defn- kebab-to-camel
  [s]
  (str/replace s #"-(\p{L})"
               (fn [[_ lower-letter]]
                 (str/upper-case lower-letter))))

(defn clean
  [s]
  (->
    (str/replace s " " "_")
    (str/replace #"\p{Cc}" "CTRL")
    (kebab-to-camel)
    (str/replace #"[^\p{L}_]" "")
    (str/replace #"[\u03B1-\u03C9]" "")
    ))
