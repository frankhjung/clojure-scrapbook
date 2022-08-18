(ns scrapbook.paradigms)

;; default
(def paradigms #{:functional :procedural :object-orientated :logical})

;; update paradigms
(def all-paradigms (conj paradigms :mathematical))

;; remove object-orientated
(def some-paradigms (disj all-paradigms :object-orientated))
