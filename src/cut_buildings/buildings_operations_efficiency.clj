(ns cut-buildings.buildings-operations-efficiency
  (:require [compojure.core :refer :all]))

;Defines an empty collection with the structure used by the other operations.
(def empty_collection [])

;Returns the index of the first element of a given array that is greater than a given value.
;Returns nil if there are none.
(defn binary_search
  ([array number l r] ;for each iteration
   (if (< r l) nil ;no greater element
               (let [m (int (/ (+ l r) 2)) ;finds middle
                     e (get array m)] ;get middle element value
                 (if (and (> e number) (or (= m 0) (<= (get array (- m 1)) number))) m ;first greater element found
                   ;otherwise, binary search on half of the array
                   (if (<= e number)
                     (binary_search array number (+ m 1) r) ;to the right
                     (binary_search array number l (- m 1)) ;to the left
                     )))))
  ([array number] ;for the initial call
   (binary_search array number 0 (- (count array) 1))))

;Return the number of elements in the collection with value greater than a provided value.
;Collection is an ordered array. O(log|array|) time.
(defn count_greater [number array]
  (let [first_greater (binary_search array number)]
    (if (nil? first_greater) 0 (- (count array) first_greater))))

;Insert element to the collection.
;Collection is an ordered array and the element is inserted as to maintain this property.
;I could not figure out if the insertion of an element at a given position,
; and thus this function, is O(log|array|) or O(|array|) time.
(defn insert_element [array number]
  (let [first_greater (binary_search array number)
        [before after] (split-at first_greater array)]
    (if (nil? first_greater) (conj array number) (vec (concat before [number] after)))))