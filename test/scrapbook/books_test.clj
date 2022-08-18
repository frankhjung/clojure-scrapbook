(ns scrapbook.books_test
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.books :refer [book1 book2]]))

(deftest test_book1
  (testing "keys"
    (is (every? identity (map #(contains? book1 %) `(:author :title :published)))))
  (testing "author"
    (is (= (:author book1) "Charles Darwin")))
  (testing "title"
    (is (= (:title book1) "On the Origin of Species")))
  (testing "published"
    (is (= (:published book1) 1859))))

(deftest test_book2
  (testing "book2 has pages"
    (is (contains? book2 :pages))))