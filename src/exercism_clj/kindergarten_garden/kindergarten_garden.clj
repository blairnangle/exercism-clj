(ns exercism-clj.kindergarten-garden.kindergarten-garden
  (:require [clojure.string :as str]))

(def default-students [:alice :bob :charlie :david :eve :fred :ginny :harriet :ileana :joseph :kincaid :larry])

(def letter-plant
  {
   \C :clover
   \G :grass
   \R :radishes
   \V :violets
   }
  )

(defn- get-row
  [students row]
  (let [plant-list (map #(get letter-plant %) row)]
    (zipmap students (partition 2 plant-list))
    )
  )

(defn garden
  ([string]
   (apply (fn [map1 map2] (merge-with concat map1 map2)) (map #(get-row default-students %) (str/split-lines string))))
  ([string students]
   (apply (fn [map1 map2] (merge-with concat map1 map2)) (map #(get-row (map (fn [raw-student] (keyword (str/lower-case raw-student))) (sort students)) %) (str/split-lines string))))
  )
