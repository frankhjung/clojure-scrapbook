(ns scrapbook.files
  (:require [clojure.java.io :as io]))

(with-open [r (io/reader "project.clj")]
  (doseq [l (line-seq r)]
    (println l)))

(defn get_words* "Get English words from 3-9 characters long."
  [file]
  (with-open [reader (io/reader file)]
    (reduce conj []
            (filter (fn [x] (re-find #"[a-z]{3,9}" x))
                    (line-seq reader)))))

(defn get_words "Get English words from 3-9 characters long."
  [file]
  (with-open [reader (io/reader file)]
    (->> (line-seq reader)
         (filter (fn [x] (re-find #"^[a-z]{3,9}$" x)))
         (reduce conj []))))
