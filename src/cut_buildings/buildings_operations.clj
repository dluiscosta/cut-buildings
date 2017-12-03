(ns cut-buildings.buildings-operations
  (:require [compojure.core :refer :all]))

;Defines an empty collection with the structure used by the other operations.
(def empty_collection [])

;Return the number of elements in the collection with value greater than a provided value.
;Collection is an unordered array. O(|array|) time.
(defn count_greater [number array]
  (reduce (fn [acc element] (if (> element number) (+ acc 1) acc)) 0 array))

;Insert element to the collection.
;Collection is an array and the element is inserted at the end. O(1) time.
(defn insert_element [array number] (conj array number))