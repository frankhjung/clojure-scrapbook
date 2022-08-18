(ns scrapbook.echo "Function parameter polymorphism")

(defn greet "Function with variable number of arguments"
  [w & who]
  (map #(str w " " % "!") who))

(defn my_echo
  "Function with different processing for arguments passed"
  ([one] (str "argument" one))
  ([one two] (str "arguments" one two)))

;; comp = compose functions comp f g = (f(g))
;; repeat = lazy list
;; first = head
;; dec = decrement
;; cons = cons
;; apply =
;; rest = tail
(defn fnth [n]
  (apply comp
    (cons first
      (take (dec n) (repeat rest)))))

((fnth 5) '[a b c d e])
;; e
