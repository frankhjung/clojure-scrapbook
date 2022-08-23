(ns scrapbook.randoms)

(defn d6 "D6 dice simulator"
  []
  (lazy-seq
   (cons (inc (rand-int 6)) (d6))))

(defn rolls "Roll D6 n times"
  [n]
  (take n (d6)))
