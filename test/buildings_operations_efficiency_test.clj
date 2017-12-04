(ns buildings-operations-efficiency-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.buildings-operations-efficiency :refer :all]))

;-- Tests for binary search

(fact "binary search failed"
      (binary_search [1, 2, 4, 4, 8] 2) => 2
      (binary_search [1, 2, 4, 4, 8] 8) => nil)


;---- Tests for both the manipulations of a collection

;-- Number of values greater than provided value

(fact "wrong number of elements greater than value, with occurrence of the element at the array"
      (count_greater 2 [1, 2, 4, 4, 8]) => 3)

(fact "wrong number of elements greater than value, with no occurrence of the element at the array"
      (count_greater 2 [1, 1, 4, 4, 8]) => 3)

(fact "wrong number of elements greater than value, with empty array"
      (count_greater 10 []) => 0)

;-- Element insertion

(fact "incorrect insertion came unordered"
      (insert_element [1, 2, 4] 2) => [1, 2, 2, 4])

(fact "incorrect insertion came ordered"
      (insert_element [1, 2, 4] 5) => [1, 2, 4, 5])


