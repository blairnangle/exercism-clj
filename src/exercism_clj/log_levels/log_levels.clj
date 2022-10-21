(ns exercism-clj.log-levels.log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/trim (last (str/split s #":"))))

(defn- remove-square-brackets
  [s]
  (-> (str/replace s "[" "")
      (str/replace "]" "")))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (str/lower-case (remove-square-brackets (str/trim (first (str/split s #":"))))))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))
