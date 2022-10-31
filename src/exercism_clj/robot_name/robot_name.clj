(ns exercism-clj.robot-name.robot-name)

(def alphabet-upper
  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  )

(defn- two-random-letters
  []
  (apply str
         (repeatedly 2 #(rand-nth alphabet-upper))
         )
  )

(defn- three-random-numbers
  []
  (str (rand-int 1000))
  )

(def robot-state
  (atom {})
  )

(defn- generate-name
  []
  (apply
    str
    (two-random-letters)
    (three-random-numbers)
    )
  )

(defn robot
  []
  (let [name (generate-name)]
    (swap! robot-state assoc :name name)
    {
     :name name
     }
    )
  )

(defn robot-name
  [robot]
  (get @robot-state :name)
  )


(defn reset-name
  [robot]
  (let [new-name (generate-name)]
    (swap! robot-state assoc :name new-name)
    (get @robot-state :name))
  )
