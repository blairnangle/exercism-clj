(ns exercism-clj.elyses-destructured-enchantments.elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[one] deck] one))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ two] deck] two))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[one two & remaining] deck]
    (into [] (conj (conj remaining one) two))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (into [(first-card deck)] [(next deck)]))

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (vec (filter some? (cons (first-card deck) (concat face-cards (nthnext deck 1))))))
