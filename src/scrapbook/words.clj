(ns scrapbook.words
  (:require [clojure.string :refer [replace-first]]))

;; Check if a word constains only characters from a list of letters.
(defn validWord? "Check if a word constains only characters from a list of letters."
  [letters word]
  (let [[x & xs] letters]
    (cond
      (empty? word) true
      (empty? letters) false
      :else (recur xs (replace-first word x "")))))