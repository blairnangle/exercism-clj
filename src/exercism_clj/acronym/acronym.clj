(ns exercism-clj.acronym.acronym
  (:require [clojure.string :as str]))

(defn- split-camel-or-pascal
  [s]
  (str/split s #"(?<=[a-z])(?=[A-Z])"))

(defn- split-phrase-into-words
  [phrase]
  (flatten (map split-camel-or-pascal (str/split phrase #" |-"))))

(defn- first-letter
  [word]
  (str/capitalize (str (first (char-array word)))))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (apply str (map first-letter (split-phrase-into-words phrase))))
