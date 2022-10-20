(ns exercism-clj.tracks-on-tracks-on-tracks.tracks-on-tracks-on-tracks)

(defn new-list [] '())

(defn add-language [lst lang] (conj lst lang))

(defn first-language [lst] (first lst))

(defn remove-language [lst] (rest lst))

(defn count-languages [lst] (count lst))

(defn learning-list []
  (count-languages (add-language (add-language (remove-language (add-language (add-language (new-list) "Clojure") "Lisp")) "Java") "JavaScript")))
