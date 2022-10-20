(ns exercism-clj.beer-song.beer-song-test
  (:require [clojure.test :refer [deftest is]]
            [exercism-clj.beer-song.beer-song :as beer-song]))

(def n-bottles-0
  (str "no more bottles"))

(def n-bottles-1
  (str "1 bottle"))

(def n-bottles-2
  (str "2 bottles"))

(def first-line-0
  (str "No more bottles of beer on the wall, no more bottles of beer."))

(def first-line-1
  (str "1 bottle of beer on the wall, 1 bottle of beer."))

(def first-line-2
  (str "2 bottles of beer on the wall, 2 bottles of beer."))

(def pass-or-buy-0
  (str "Go to the store and buy some more,"))

(def pass-or-buy-1
  (str "Take it down and pass it around,"))

(def pass-or-buy-2
  (str "Take one down and pass it around,"))

(def second-line-0
  (str "Go to the store and buy some more, 99 bottles of beer on the wall."))

(def second-line-1
  (str "Take it down and pass it around, no more bottles of beer on the wall."))

(def second-line-2
  (str "Take one down and pass it around, 1 bottle of beer on the wall."))

(def verse-8
  (str "8 bottles of beer on the wall, 8 bottles of beer.\n"
       "Take one down and pass it around, 7 bottles of beer on the wall.\n"))

(def verse-2
  (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
       "Take one down and pass it around, 1 bottle of beer on the wall.\n"))

(def verse-1
  (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
       "Take it down and pass it around, no more bottles of beer on the wall.\n"))

(def verse-0
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(def song-8-6
  (str "8 bottles of beer on the wall, 8 bottles of beer.\n"
       "Take one down and pass it around, 7 bottles of beer on the wall.\n\n"
       "7 bottles of beer on the wall, 7 bottles of beer.\n"
       "Take one down and pass it around, 6 bottles of beer on the wall.\n\n"
       "6 bottles of beer on the wall, 6 bottles of beer.\n"
       "Take one down and pass it around, 5 bottles of beer on the wall.\n"))

(def song-3-0
  (str "3 bottles of beer on the wall, 3 bottles of beer.\n"
       "Take one down and pass it around, 2 bottles of beer on the wall.\n\n"
       "2 bottles of beer on the wall, 2 bottles of beer.\n"
       "Take one down and pass it around, 1 bottle of beer on the wall.\n\n"
       "1 bottle of beer on the wall, 1 bottle of beer.\n"
       "Take it down and pass it around, no more bottles of beer on the wall.\n\n"
       "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(deftest test-n-bottles
  (is (= n-bottles-0 (beer-song/n-bottles 0)))
  (is (= n-bottles-1 (beer-song/n-bottles 1)))
  (is (= n-bottles-2 (beer-song/n-bottles 2))))

(deftest test-first-line
  (is (= first-line-0 (beer-song/first-line 0)))
  (is (= first-line-1 (beer-song/first-line 1)))
  (is (= first-line-2 (beer-song/first-line 2))))

(deftest test-pass-or-buy
  (is (= pass-or-buy-0 (beer-song/pass-or-buy 0)))
  (is (= pass-or-buy-1 (beer-song/pass-or-buy 1)))
  (is (= pass-or-buy-2 (beer-song/pass-or-buy 2))))

(deftest second-line
  (is (= second-line-0 (beer-song/second-line 0)))
  (is (= second-line-1 (beer-song/second-line 1))))

(deftest bottle-range
  (is (= '(5 4 3 2 1 0) (beer-song/bottle-range 5 0)))
  (is (= '(0) (beer-song/bottle-range 0 0)))
  (is (= '(1 0) (beer-song/bottle-range 1 0))))

(deftest test-verse
  (is (= verse-8 (beer-song/verse 8)))
  (is (= verse-2 (beer-song/verse 2)))
  (is (= verse-1 (beer-song/verse 1)))
  (is (= verse-0 (beer-song/verse 0))))

(deftest test-song
  (is (= song-8-6 (beer-song/sing 8 6)))
  (is (= song-3-0 (beer-song/sing 3))))
