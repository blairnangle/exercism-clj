(ns exercism-clj.complex-numbers.complex-numbers)

(defn real
  [[a _]]
  a
  )

(defn imaginary
  [[_ b]]
  b
  )

(defn absolute-value
  [[a b]]
  (Math/sqrt (+ (Math/pow a 2) (Math/pow b 2)))
  )

(defn conjugate
  [[a b]]
  [a (- b)]
  )

(defn add
  [[a b] [c d]]
  [(+ a c) (+ b d)]
  )

(defn sub
  [[a b] [c d]]
  [(- a c) (- b d)]
  )

(defn mul
  [[a b] [c d]]
  [(+ (* a c) (* (- b) d)) (+ (* a d) (* c b))]
  )

(defn div [[a b] [c d]]
  [
   (/ (+ (* a c) (* b d)) (+ (Math/pow c 2) (Math/pow d 2)))
   (/ (- (* b c) (* a d)) (+ (Math/pow c 2) (Math/pow d 2)))
   ]
  )
