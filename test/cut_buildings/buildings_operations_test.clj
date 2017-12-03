(ns cut-buildings.buildings-operations-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.buildings-operations :refer :all]))

;---- Tests for both the manipulations of a collection

;-- Number of values greater than provided value

(fact "wrong number of elements greater than value, with occurrence of the element at the array"
      (count_greater 2 [1, 2, 4, 8, 4]) => 3)

(fact "wrong number of elements greater than value, with no occurrence of the element at the array"
      (count_greater 2 [1, 1, 4, 8, 4]) => 3)

(fact "wrong number of elements greater than value, with empty array"
      (count_greater 10 []) => 0)

;-- Element insertion

(fact "incorrect insertion"
      (insert_element [1, 2, 4] 2) => [1, 2, 4, 2])

