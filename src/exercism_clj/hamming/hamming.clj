(ns exercism-clj.hamming.hamming
  (:require [clojure.string :as str]))

(defn distance
  [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (count
      (filter
        #(not (= (first %) (second %)))
        (map list
             (str/split strand1 #"")
             (str/split strand2 #"")
             )
        )
      ) nil
    )
  )
