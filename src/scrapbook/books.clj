(ns scrapbook.books)

;; create base book
(def book1 {:title "On the Origin of Species" :author "Charles Darwin" :published 1859})

;; create a new book with more attributes
(def book2 (merge book1 {:pages 502}))
