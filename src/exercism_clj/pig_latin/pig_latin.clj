(ns exercism-clj.pig-latin.pig-latin
  (:require [clojure.string :as str]))

(defn- leading-vowel?
  [word]
  (not-empty (re-find #"^[aeiou]+" word))
  )

(defn- leading-yt-or-xr?
  [word]
  (not-empty (re-find #"^xr|^yt" word)))

(defn- qu?
  [word]
  (not-empty (re-find #"[^aeiou]*qu" word))
  )

(defn- get-qu-with-optional-leading-consonant-sound
  [word]
  (first (re-find #"([^aeiou]*qu)" word)))

(defn- leading-consonant-with-y?
  [word]
  (not-empty (re-find #"([^aeiou]+y)" word))
  )

(defn- get-leading-consonant-sound-before-y
  [word]
  (first (re-find #"([^aeiouy]+)" word)))

(defn- get-leading-consonant-sound
  [word]
  (first (re-find #"([^aeiou]*)" word)))

(defn- append-ay [word] (str word "ay"))

(defn- reshuffle
  [word prefix-now-suffix]
  (str
    (subs
      word
      (count prefix-now-suffix)
      (count word)
      )
    prefix-now-suffix
    )
  )

(defn- translate-word
  [word]
  (cond
    (leading-vowel? word) (append-ay word)
    (leading-yt-or-xr? word) (append-ay word)
    (qu? word) (append-ay (reshuffle word (get-qu-with-optional-leading-consonant-sound word)))
    (leading-consonant-with-y? word) (append-ay (reshuffle word (get-leading-consonant-sound-before-y word)))
    :else (append-ay (reshuffle word (get-leading-consonant-sound word)))
    )
  )

(defn translate
  [text]
  (str/join " " (map translate-word (str/split text #" ")))
  )
