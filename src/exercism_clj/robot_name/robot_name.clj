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
  (atom
    {:name (generate-name)})
  )

(defn robot-name
  [robot]
  (:name @robot))

(defn reset-name
  [robot]
  (swap! robot assoc :name (generate-name))
  )
