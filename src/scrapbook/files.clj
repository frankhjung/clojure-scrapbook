(ns scrapbook.files
  (:require [clojure.java.io :as io]))

;; returns a lazy sequence using thread last macro
(defn get_words_1 "Get English words from 3-9 characters long."
  [file]
  (with-open [reader (io/reader file)]
    (->> (line-seq reader)
         (filter #(re-find #"^[a-z]{3,9}$" %))
         (set))))

;; returns a persistent vector
(defn get_words_2 "Get 8 letter English word."
  [file]
  (with-open [reader (io/reader file)]
    (reduce conj []
            (filter (fn [word] (re-find #"[a-z]{3,9}" word))
                    (line-seq reader)))))

;; returns a lazy sequence
(defn get_words_3 "Get English words from 3-9 characters long."
  [file]
  (with-open [reader (io/reader file)]
    (doall (filter #(re-find #"^[a-z]{3,9}$" %1) (line-seq reader)))))
