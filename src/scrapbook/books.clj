(ns scrapbook.books)

;; TODO: refactor to use defrecord
;; see also deftype, defprotocol, definterface

;; create base book
(def book1
  {:title "On the Origin of Species"
   :author "Charles Darwin"
   :published 1859})

;; create a new book with more attributes
(def book2
  (merge book1 {:pages 502}))
