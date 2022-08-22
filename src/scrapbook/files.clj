(ns scrapbook.files
  (:require [clojure.java.io :as io]))

(defn get_words_1 "Get English words from 3-9 characters long."
  [file]
  (with-open [reader (io/reader file)]
    (->> (line-seq reader)
         (filter (fn [x] (re-find #"^[a-z]{3,9}$" x)))
         (set))))

(defn get_words_2 "Get 8 letter English word."
  [file]
  (with-open [reader (io/reader file)]
    (reduce conj []
            (filter (fn [x] (re-find #"[a-z]{3,9}" x))
                    (line-seq reader)))))
