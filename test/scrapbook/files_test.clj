(ns scrapbook.files-test
  (:require [clojure.test :refer [deftest is testing]]
            [scrapbook.files :refer [get_words_1
                                     get_words_2]]))

(deftest test_get_words_1
  (testing "get version 1"
    (is (some #{"aardvark"} (get_words_1 "words")))))

(deftest test_get_words_3
  (testing "get version 3"
    (is (some #{"aardvark"} (get_words_2 "words")))))
