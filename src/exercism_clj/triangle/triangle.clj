(ns exercism-clj.triangle.triangle)

(defn is-valid?
  [a b c]
  (let [sides (sort (vector a b c))]
    (and
      (every? #(> % 0) sides)
      (<= (last sides) (+ (nth sides 0) (nth sides 1)))
      ))
  )

(defn equilateral?
  [a b c]
  (and
    (is-valid? a b c)
    (= a b c))
  )

(defn isosceles?
  [a b c]
  (and
    (<= (count (set (vector a b c))) 2)
    (is-valid? a b c))
  )

(defn scalene?
  [a b c]
  (and
    (not (equilateral? a b c))
    (not (isosceles? a b c))
    (is-valid? a b c))
  )
