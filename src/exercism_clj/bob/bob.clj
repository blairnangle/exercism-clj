(ns exercism-clj.bob.bob
  (:require [clojure.string :as str]))

(defn- question?
  [chars]
  (= (last chars) \?)
  )

(defn- all-uppercase?
  [chars]
  (if
    (not-any? #(Character/isLetter %) chars) false
                                             (every? #(Character/isUpperCase %) (filter #(Character/isLetter %) chars)))
  )

(defn response-for
  [s]
  (let [s-chars (char-array (str/trim s))]
    (cond
      (or (empty? s-chars) (every? #(Character/isWhitespace %) s-chars)) "Fine. Be that way!"
      (and (question? s-chars) (all-uppercase? s-chars)) "Calm down, I know what I'm doing!"
      (question? s-chars) "Sure."
      (all-uppercase? s-chars) "Whoa, chill out!"
      :else "Whatever."
      )
    )
  )
