(ns exercism-clj.leap.leap)

(defn leap-year?
  [year]
  (if (zero? (mod year 100))
    (zero? (mod year 400))
    (zero? (mod year 4))
    )
  )
