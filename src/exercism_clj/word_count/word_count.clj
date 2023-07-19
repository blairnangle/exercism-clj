(ns exercism-clj.word-count.word-count
  (:require [clojure.string :as str]))

(defn word-count
  [s]
  (frequencies
    (map str/lower-case
         (str/split
           (str/replace s #"[^\w+\d+\s]" "")
           #"\s+"
           )
         )
    )
  )
