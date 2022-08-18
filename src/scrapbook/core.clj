;; https://clojure.org/guides/learn/namespaces
(ns scrapbook.core
  (:gen-class)
  (:require [scrapbook.books :refer [book1 book2]]
            [scrapbook.paradigms :refer [paradigms all-paradigms some-paradigms]]
            [scrapbook.echo :refer [greet my-echo]]
            [scrapbook.loops :refer [loop-n find-digits]]))

(defn -main "Main" [& _]
  (println (str "book1 keys: " (keys book1)))
  (println (str "book1 vals: " (vals book1)))
  (println (str "book2 contains pages? " (contains? book2 :pages)))
  (println (str "paradigms: " paradigms))
  (println (str "all paradigms: " all-paradigms))
  (println (str "some paradigms: " some-paradigms))
  (println (greet "Welcome" "Alice" "Bob" "Charles"))
  (println (my-echo :one))
  (println (my-echo :one :two))
  (println (loop-n 10))
  (println (find-digits "my phone number is no +611-0123-456-789")))
