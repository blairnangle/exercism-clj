(ns exercism-clj.anagram.anagram
  (:require [clojure.string :as str]))

(defn- are-anagrams?
  [str-one str-two]
  (if (not (= str-one str-two))
  (=
    (sort (str/split (str/lower-case str-one) #""))
    (sort (str/split (str/lower-case str-two) #""))
  ) false)
)

(defn anagrams-for [word prospect-list]
  (let [word-lower (str/lower-case word)]
    (filter #(are-anagrams? word-lower %) prospect-list))
  )
