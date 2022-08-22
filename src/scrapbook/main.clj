;; https://clojure.org/guides/learn/namespaces
(ns scrapbook.main "Run all functions in main"
    (:gen-class)
    (:require [scrapbook.books :refer [book1 book2]]
              [scrapbook.echo :refer [greet my_echo]]
              [scrapbook.files :refer [get_words_1]]
              [scrapbook.lists :refer [f_nth my_nth]]
              [scrapbook.loops :refer [loop_n find_digits]]
              [scrapbook.paradigms :refer [paradigms all_paradigms some_paradigms]]))

(defn -main "Main" [& _]
  (println (str "Main: run code examples.\n"))
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
  (println (find_digits "my phone number is no +611-0123-456-789"))
  (println (str "   nth 4 [a b c d e f g h]: " (nth '[a b c d e f g h] (dec 5))))
  (println (str " f_nth 5 [a b c d e f g h]: " ((f_nth 5) '[a b c d e f g h])))
  (println (str "my_nth 5 [a b c d e f g h]: " (my_nth 5 '[a b c d e f g h])))
  (println (str "get word: " (some #{"aardvark"} (get_words_1 "words")))))