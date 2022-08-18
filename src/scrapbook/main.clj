;; https://clojure.org/guides/learn/namespaces
(ns scrapbook.main "Run all functions in main"
    (:gen-class)
    (:require [scrapbook.books :refer [book1 book2]]
              [scrapbook.paradigms :refer [paradigms all_paradigms some_paradigms]]
              [scrapbook.echo :refer [greet my_echo]]
              [scrapbook.loops :refer [loop_n find_digits]]))

(defn -main "Main" [& _]
  (println (str "book1 keys: " (keys book1)))
  (println (str "book1 vals: " (vals book1)))
  (println (str "book2 contains pages? " (contains? book2 :pages)))
  (println (str "paradigms: " paradigms))
  (println (str "all paradigms: " all_paradigms))
  (println (str "some paradigms: " some_paradigms))
  (println (greet "Welcome" "Alice" "Bob" "Charles"))
  (println (my_echo :one))
  (println (my_echo :one :two))
  (println (loop_n 10))
  (println (find_digits "my phone number is no +611-0123-456-789")))
