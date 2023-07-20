(ns exercism-clj.phone-number.phone-number
  (:require [clojure.string :as str]))

(defn- remove-punctuation
  [num-string]
  (str/replace num-string #"[^\d]" "")
  )

(defn- trim-leading-1
  [num-string]
  (str/replace num-string #"^1" "")
  )

(defn- clean
  [num-string]
  (-> num-string
      (remove-punctuation)
      (trim-leading-1)
      ))

(def invalid "0000000000")

(defn- valid?
  [cleaned]
  (and
    (not= (first cleaned) \0)
    (not (contains? (set '(\0 \1)) (nth cleaned 3)))
    (= (count cleaned) 10))
  )

(defn number
  [num-string]
  (let [cleaned (clean num-string)]
    (if (valid? cleaned)
      (-> cleaned
          (str/replace #"[^\d]" "")
          (str/replace #"^1" "")
          )
      invalid
      ))
  )

(defn area-code
  [num-string]
  (-> num-string
      (remove-punctuation)
      (trim-leading-1)
      (subs 0 3)
      )
  )

(defn pretty-print
  [num-string]
  (-> num-string
      (remove-punctuation)
      (trim-leading-1)
      (#(str "("
             (area-code %)
             ") "
             (subs % 3 6)
             "-"
             (subs % 6))
        )
      )
  )
