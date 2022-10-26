(ns exercism-clj.collatz-conjecture.collatz-conjecture)

(defn- collatz-algorithm
  [num]
  (if (even? num) (/ num 2) (+ (* num 3) 1)))

(defn collatz
  [num]
  (loop [starting-num num
         passes 0]
    (if (< starting-num 1) (throw Throwable)
                           (if (= starting-num 1)
                             passes
                             (recur (collatz-algorithm starting-num) (inc passes)))))
  )
