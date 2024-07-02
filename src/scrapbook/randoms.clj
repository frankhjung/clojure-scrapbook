(ns scrapbook.randoms)

;; uses an anonymous function to simulate a D6 dice
(defn d6 "D6 dice simulator. Returns an infinite sequence of D6 rolls."
  []
  (repeatedly #(inc (rand-int 6))))

(defn rolls "D6 rolled 'n' times. Returns a sequence of 'n' D6 rolls."
  [n]
  (take n (d6)))
