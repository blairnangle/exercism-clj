(ns exercism-clj.rna-transcription.rna-transcription
  (:require [clojure.string :as str]))

(def dna->rna
  {
   "A" "U",
   "C" "G",
   "G" "C",
   "T" "A"
   }
  )

(defn to-rna [dna]
  (let [dna-nucleotides (str/split dna #"")]
    (if-not
      (every? #(contains? dna->rna %) dna-nucleotides)
      (throw (AssertionError. "error"))
      (apply str
             (map
               #(get dna->rna %)
               (str/split dna #"")
               )
             )
      )
    )
  )
