(ns scrapbook.core (:gen-class))

(def book1 {:title "On the Origin of Species" :author "Charles Darwin" :published 1859})

;; create a new book with more attributes
(def book2 (merge book1 {:pages 502}))

(def paradigms #{:functional :procedural :object-orientated :logical})

;; update paradigms
(def all-paradigms (conj paradigms :mathematical))

;; remove object-orientated
(def some-paradigms (disj all-paradigms :object-orientated))

(defn greet "Function with variable number of arguments."
  [w & who]
  (map #(str w " " % "!") who))

(defn my-echo
  "Function with different processing for arguments passed."
  ([one] (str "argument" one))
  ([one two] (str "arguments" one two)))

(defn -main "Main" [& _]
  (println (str "book1 keys: " (keys book1)))
  (println (str "book1 vals: " (vals book1)))
  (println (str "book2 contains pages? " (contains? book2 :pages)))
  (println (str "paradigms: " paradigms))
  (println (str "all paradigms: " all-paradigms))
  (println (str "some paradigms: " some-paradigms))
  (println (greet "Welcome" "Alice" "Bob" "Charles"))
  (println (my-echo :one))
  (println (my-echo :one :two)))