(ns exercism-clj.cars-assemble.cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [max-rate (* speed 221)]
    (cond (<= speed 4) (* 1.0 max-rate)
          (<= speed 8) (* 0.9 max-rate)
          (<= speed 9) (* 0.8 max-rate)
          :else (* 0.77 max-rate)
          ))
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
