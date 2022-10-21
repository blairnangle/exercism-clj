(ns exercism-clj.reverse-string.reverse-string)

(defn reverse-string [s]
  (apply str (into () (seq (char-array s))))
)
