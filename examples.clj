(def item1 #:book{:title "On the Origin of Species" :author "Charles Darwin" :published 1859})
(:book/author item1)

(def book {:title "On the Origin of Species" :author "Charles Darwin" :published 1859})
(dissoc book :published)

(assoc [:title :by :published] 1 :author)

(keys book)
(vals book)

(def paradigms #{:functional :procedural :object-orientated :logical})
(println paradigms)
(contains? paradigms :imperative)
(contains? paradigms :logical)
(paradigms :functional)

(def all-paradigms (conj paradigms :mathematical))
(println all-paradigms)

(disj all-paradigms :object-orientated)

(#{"procedural" "functional" "logical" "mathematical"} "object-orientated")
(#{"procedural" "functional" "logical" "mathematical"} "functional")

(#{:procedural :functional :logical :mathematical} :functional)

(defn greet [w & who]
  (map #(str w " " % "!") who))
(greet "Welcome" "Alice" "Bob" "Charles")

(defn my-echo
  ([one] (println "one argument" one))
  ([one two] (println "two arguments" one two)))
(my-echo "one")
(my-echo "one" "two")