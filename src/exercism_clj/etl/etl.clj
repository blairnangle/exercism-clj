(ns exercism_clj.etl.etl
  (:require [clojure.string :as str]))

(defn- assign-score-to-word
  [words score]
  (into {}
        (map #(assoc {} % score) words)
        )
  )

(defn transform
  [source]
  (into {}
        (map #(assign-score-to-word
                (map str/lower-case
                     (get source %)) %) (keys source)
             )
        )
  )
