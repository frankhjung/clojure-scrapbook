(ns scrapbook.paradigmstest
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.paradigms :refer [paradigms all_paradigms some_paradigms]]))

(deftest test_paradigms
  (testing "logical"
    (is (contains? paradigms :logical)))
  (testing "functional"
    (is (= (paradigms :functional) :functional)))
  (testing "imperative"
    (is (not (contains? paradigms :imperative)))))

(deftest test_all_paradigms
  (testing "mathematical"
    (is (contains? all_paradigms :mathematical))))

(deftest test_some_paradigms
  (testing "not object-orientated"
    (is (not (contains? some_paradigms :object-orientated)))))

(deftest test_maps
  (testing "not in map"
    (let [paradigms #{"procedural" "functional" "logical" "mathematical"}]
      (is (not (paradigms :object-orientated)))))
  (testing "functional in map"
    (let [paradigms #{"procedural" "functional" "logical" "mathematical"}]
      (is (paradigms "functional"))))
  (testing "logical in map"
    (let [paradigms #{:procedural :functional :logical :mathematical}]
      (is (paradigms :logical)))))