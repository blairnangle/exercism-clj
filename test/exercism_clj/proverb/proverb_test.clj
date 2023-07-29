(ns exercism-clj.proverb.proverb-test
  (:require [clojure.test :refer [deftest is]]
            [exercism-clj.proverb.proverb :as proverb]
            [clojure.string :as str]))

(deftest zero-pieces
  (is (=
        (proverb/recite ())
        "")))

(deftest one-piece
  (is (=
        (proverb/recite '("nail"))
        "And all for the want of a nail.")))

(deftest two-pieces
  (is (=
        (proverb/recite '("nail" "shoe"))
        (str/join "\n" ["For want of a nail the shoe was lost."
                        "And all for the want of a nail."]))))

(deftest three-pieces
  (is (=
        (proverb/recite '("nail" "shoe" "horse"))
        (str/join "\n" ["For want of a nail the shoe was lost."
                        "For want of a shoe the horse was lost."
                        "And all for the want of a nail."]))))

(deftest full-proverb
  (is (= (proverb/recite '("nail" "shoe" "horse" "rider" "message" "battle" "kingdom"))
         (str/join "\n" ["For want of a nail the shoe was lost."
                         "For want of a shoe the horse was lost."
                         "For want of a horse the rider was lost."
                         "For want of a rider the message was lost."
                         "For want of a message the battle was lost."
                         "For want of a battle the kingdom was lost."
                         "And all for the want of a nail."]))))

(deftest four-pieces-modernized
  (is (=
        (proverb/recite '("pin" "gun" "soldier" "battle"))
        (str/join "\n" ["For want of a pin the gun was lost."
                        "For want of a gun the soldier was lost."
                        "For want of a soldier the battle was lost."
                        "And all for the want of a pin."]))))
