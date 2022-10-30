(ns exercism-clj.raindrops.raindrops)

(def div->sound
  {
   3 "Pling",
   5 "Plang",
   7 "Plong"
   }
  )

(defn convert
  [n]
  (let [sounds
        (filter some?
                (map
                  (fn [x]
                    (if (= (mod n x) 0)
                      (get div->sound x)
                      nil
                      )
                    ) [3 5 7]
                  )
                )
        ]
    (if
      (< 0 (count sounds))
      (apply str sounds)
      (str n))
    )
  )
