(ns exercism-clj.perfect-numbers.perfect-numbers)

(defn- get-proper-divisors
  [n]
  (filter #(= (mod n %) 0) (range 1 n))
  )

(defn- aliquot-sum
  [n]
  (reduce + (get-proper-divisors n))
  )

(defn classify
  [n]
  (cond
    (< n 0) (throw (IllegalArgumentException. "numbers must be positive"))
    (< (aliquot-sum n) n) :deficient
    (> (aliquot-sum n) n) :abundant
    :else :perfect
    )
  )
