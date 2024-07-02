(ns scrapbook.wordstest
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.words :refer [validWord?]]))

(deftest test_valid_word
  (testing "word contains valid letters"
    (is (validWord? "foobar" "barfoo")))
  (testing "word contains valid subset"
    (is (validWord? "foobar" "for")))
  (testing "invalid word"
    (is (not (validWord? "foobar" "bartez"))))
  (testing "invalid letter frequency"
    (is (not (validWord? "foobar" "baafor")))))