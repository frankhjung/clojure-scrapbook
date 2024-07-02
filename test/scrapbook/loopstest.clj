(ns scrapbook.loopstest
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.loops :refer [loop_n find_digits]]))

(deftest test_loop_n
  (testing "loop 10"
    (is (= (loop_n 10) `[1 2 3 4 5 6 7 8 9]))))

(deftest test_find_digits
  (testing "find digits"
    (let [data "a0_b1_c2_d3_e4_f5"]
      (is (= (find_digits data) `[0 1 2 3 4 5])))))
