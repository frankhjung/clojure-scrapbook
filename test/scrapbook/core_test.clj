(ns scrapbook.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.core :refer [book1 book2 paradigms all-paradigms some-paradigms my-echo]]))

(deftest test-book1
  (testing "keys"
    (is (every? identity (map #(contains? book1 %) `(:author :title :published)))))
  (testing "author"
    (is (= (:author book1) "Charles Darwin")))
  (testing "title"
    (is (= (:title book1) "On the Origin of Species")))
  (testing "published"
    (is (= (:published book1) 1859))))

(deftest test-book2
  (testing "book2 has pages"
    (is (contains? book2 :pages))))

(deftest test-paradigms
  (testing "logical"
    (is (contains? paradigms :logical)))
  (testing "functional"
    (is (= (paradigms :functional) :functional)))
  (testing "imperative"
    (is (not (contains? paradigms :imperative)))))

(deftest test-all-paradigms
  (testing "mathematical"
    (is (contains? all-paradigms :mathematical))))

(deftest test-some-paradigms
  (testing "not object-orientated"
    (is (not (contains? some-paradigms :object-orientated)))))

(deftest test-maps
  (testing "not in map"
    (let [paradigms #{"procedural" "functional" "logical" "mathematical"}]
      (is (not (paradigms :object-orientated)))))
  (testing "functional in map"
    (let [paradigms #{"procedural" "functional" "logical" "mathematical"}]
      (is (paradigms "functional"))))
  (testing "logical in map"
    (let [paradigms #{:procedural :functional :logical :mathematical}]
      (is (paradigms :logical)))))

(deftest test-my-echo
  (testing "one"
    (is (= (my-echo :one) "argument:one")))
  (testing "one two"
    (is (= (my-echo :one :two) "arguments:one:two"))))