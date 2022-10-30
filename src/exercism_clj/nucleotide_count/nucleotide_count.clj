(ns exercism-clj.nucleotide-count.nucleotide-count
  (:require [clojure.string :as str]))

(defn count-of-nucleotide-in-strand
  [nucleotide strand]
  (if
    (not
      (contains? #{\A \T \C \G} nucleotide)
      ) (throw (Throwable. "error"))
        (count (filter #(= % (str nucleotide)) (str/split strand #""))))
  )


(defn nucleotide-counts
  [strand]
  (into {}
        (map #(assoc {} %
                        (count-of-nucleotide-in-strand % strand)) [\A \T \C \G]
             )
        )
  )
