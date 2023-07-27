(ns exercism-clj.atbash-cipher.atbash-cipher
  (:require [clojure.string :as str]))

(def lower-a-int (int \a))

(def lower-z-int (int \z))

(def alphabet-shift (+ lower-a-int lower-z-int))

(defn- encode-char
  [c]
  (if (and (>= (int c) lower-a-int) (<= (int c) lower-z-int))
    (char (- alphabet-shift (int c)))
    c
    )
  )

(defn- encode-str
  [s]
  (apply str (map #(encode-char %) s))
  )

(defn- split-every-n
  [s n]
  (clojure.string/join " " (map #(clojure.string/join %) (partition-all n s)))
  )

(defn encode
  [s]
  (-> s
      (str/replace #"[^a-zA-Z0-9]" "")
      (str/lower-case)
      (encode-str)
      (split-every-n 5)
      )
  )
