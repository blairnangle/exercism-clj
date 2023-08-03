(ns exercism-clj.say.say
  (:require [clojure.string :as str]))

(def numeral-to-word
  {1  "one"
   2  "two"
   3  "three"
   4  "four"
   5  "five"
   6  "six"
   7  "seven"
   8  "eight"
   9  "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"})

(def tens
  {1 "ten"
   2 "twenty"
   3 "thirty"
   4 "forty"
   5 "fifty"
   6 "sixty"
   7 "seventy"
   8 "eighty"
   9 "ninety"})

(def tens-words (vals tens))

(defn say-two-digits
  [n]
  (cond
    (< n 20) (get numeral-to-word n)
    :else (if (= (mod n 10) 0)
            (str (get tens (quot n 10)))
            (str (get tens (quot n 10)) "-" (get numeral-to-word (mod n 10)))
            )
    )
  )

(defn- str-split-reverse
  [num]
  (reverse (str/split (str num) #""))
  )

(defn- digit-and-power-of-ten-to-word
  [digit power-of-ten]
  (let [num (Integer/parseInt digit)]
    (if (= 0 num)
      ""
      (cond
        (= 0 power-of-ten) (get numeral-to-word num)
        (= 1 power-of-ten) (get tens num)
        (= 2 power-of-ten) (str (get numeral-to-word num) " hundred")
        (= 3 power-of-ten) (str (get numeral-to-word num) " thousand")
        (= 4 power-of-ten) (digit-and-power-of-ten-to-word digit 1)
        (= 5 power-of-ten) (digit-and-power-of-ten-to-word digit 2)
        (= 6 power-of-ten) (str (get numeral-to-word num) " million")
        (= 7 power-of-ten) (digit-and-power-of-ten-to-word digit 1)
        (= 8 power-of-ten) (digit-and-power-of-ten-to-word digit 2)
        (= 9 power-of-ten) (str (get numeral-to-word num) " billion")
        (= 10 power-of-ten) (digit-and-power-of-ten-to-word digit 1)
        (= 11 power-of-ten) (digit-and-power-of-ten-to-word digit 2)
        :else ""
        )
      )
    )
  )

(defn- say
  [reversed-words]
  (str/trim
    (reduce
      (fn [acc x]
        (if (some #{x} tens-words)
          (str acc "" x "-")
          (str acc "" x " ")
          )
        )
      ""
      (filter #(not (str/blank? %)) (flatten (map #(str/split % #" ") (reverse reversed-words))))
      )
    )
  )

(defn number
  [num]
  (cond
    (= num 0) "zero"
    (< num 0) (throw (IllegalArgumentException. "numbers must not be below zero"))
    (> num 999999999999) (throw (IllegalArgumentException. "numbers must not be above 999999999999"))
    (< num 100) (say-two-digits num)
    :else (let [str-split-reversed (str-split-reverse num)
                final-power-of-ten (count str-split-reversed)]
            (loop [power-of-ten 0
                   str-digits str-split-reversed
                   numbers-as-words []]
              (if (= final-power-of-ten power-of-ten)
                (say numbers-as-words)
                (recur (inc power-of-ten) (rest str-digits) (conj numbers-as-words (digit-and-power-of-ten-to-word (first str-digits) power-of-ten)))
                )
              )
            )
    )
  )
