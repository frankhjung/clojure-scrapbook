(ns scrapbook.liststest
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.lists :refer [f_nth my_nth]]))

(def vs '[a b c d e f g h])
(def xs "abcdefgh")

(deftest test_f_nth_5
  (testing "get 5th"
    (is (= ((f_nth 5) vs) (nth vs (dec 5))))))

(deftest test_f_nth_same_as_my_nth
  (testing "f_nth same as my_nth"
    (is (= ((f_nth 3) vs) (my_nth 3 vs)))))

(deftest test_my_nth
  (testing "my_nth same as nth"
    (is (= (my_nth 2 xs) (nth xs (dec 2))))))
