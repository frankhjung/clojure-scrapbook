(ns scrapbook.echo_test
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.echo :refer [greet my_echo]]))

(deftest test_greet
  (testing "greet"
    (is (= (greet "Do" "foo" "bar") `("Do foo!" "Do bar!")))))

(deftest test_my_echo
  (testing "one"
    (is (= (my_echo :one) "argument:one")))
  (testing "one two"
    (is (= (my_echo :one :two) "arguments:one:two"))))
