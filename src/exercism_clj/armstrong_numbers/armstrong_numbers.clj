(ns exercism-clj.armstrong-numbers.armstrong-numbers)

(defn- digits-to-sequence
  [n]
  (if (> n 9)
    (conj (digits-to-sequence (quot n 10))
          (rem n 10))
    [n]))

(defn- ** [x n] (reduce * (repeat n x)))

(defn- sum-of-exponents
  [seq]
  (reduce #(+ %1 (** %2 (count seq))) 0 seq))

(defn armstrong?
  [n]
  (= (sum-of-exponents (digits-to-sequence n)) n))
