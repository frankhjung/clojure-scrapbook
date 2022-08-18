(ns scrapbook.loops "Loop examples")

(defn loop_n "Loop n times"
  [n]
  (loop [i 1 acc []]
    (if (< i n)
      (recur (inc i) (conj acc i))
      acc)))

(defn find_digits "Find digits in the input"
  [input]
  (let [digit_match #"\d+"                        ;; regex for digits
        matcher (re-matcher digit_match input)]   ;; regex matcher
    (loop [match (re-find matcher)                ;; find next match
           digits []]                             ;; vector of matches
      (if-not match                               ;; repeat until no more matches
        digits                                    ;; return vector of matches
        (recur (re-find matcher) (conj digits (Integer/parseInt match)))))))
