(ns exercism-clj.accumulate.accumulate)

(defn accumulate [op coll]
  (for [x coll] (op x)))
