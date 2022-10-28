(ns exercism-clj.pangram.pangram
  (:require [clojure.string :as str]))

(def alphabet #{"a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"})

(defn pangram?
  [sentence]
  (= alphabet
     (set
       (filter #(re-matches #"[a-z]" %)
               (str/split
                 (str/lower-case sentence) #"")
               )
       )
     )
  )
