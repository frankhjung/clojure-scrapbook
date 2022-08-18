(ns scrapbook.paradigms)

;; default
(def paradigms "programming paradigms"
  #{:functional :procedural :object-orientated :logical})

;; update paradigms
(def all_paradigms "more paradigms"
  (conj paradigms :mathematical))

;; remove object-orientated
(def some_paradigms "only some paradigms"
  (disj all_paradigms :object-orientated))
