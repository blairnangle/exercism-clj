(ns exercism-clj.proverb.proverb
  (:require [clojure.string :as str]))

(defn- build-closing-line
  [item]
  (format "And all for the want of a %s." item)
  )

(defn- build-line
  [item-1 item-2]
  (format "For want of a %s the %s was lost." item-1 item-2)
  )

(defn- join-lines
  [lines]
  (str/join "\n" lines)
  )

(defn recite
  [items]
  (case (count items)
    0 ""
    1 (build-closing-line (first items))
    (let [first-item (first items)]
      (loop [items items
             lines []]
        (if (= (count items) 2)
          (join-lines (conj (conj lines (build-line (first items) (second items))) (build-closing-line first-item)))
          (recur
            (rest items)
            (conj lines (build-line (first items) (second items))))
          )
        )
      )
    )
  )
