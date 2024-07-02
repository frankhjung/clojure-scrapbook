(ns scrapbook.randomstest
  (:require [clojure.test :refer [deftest is testing]]
            [clojure.spec.alpha :refer [int-in-range?]]
            [scrapbook.randoms :refer [d6 rolls]]))

(deftest test_d6
  (testing "role d6 1000 times"
    (let [many_rolls #(take 1000 (d6))]
      ;; all d6 rolls are values from 1 to 6
      (is (every? true? (map #(int-in-range? 1 7 %) (many_rolls)))))))

(deftest test_rolls
  (testing "rolls give expected count"
    (is (= 1000 (count (rolls 1000))))))
