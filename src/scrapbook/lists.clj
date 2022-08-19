(ns scrapbook.lists)

;; ((f_nth 5) '[a b c d e])
;; e
;; comp = compose functions comp f g = (f(g))
;; repeat = lazy list
;; first = head
;; dec = decrement
;; cons = cons
;; apply =
;; rest = tail

(defn f_nth "Get nth value from collection"
  [n]
  (apply comp
         (cons first
               (take (dec n) (repeat rest)))))

(defn my_nth "My versoin of get nth value from collection"
  [n xs]
  (last (take n xs)))
