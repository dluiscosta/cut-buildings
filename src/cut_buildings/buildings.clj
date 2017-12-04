(ns cut-buildings.buildings
  (:require [compojure.core :refer :all]
            [cut-buildings.buildings-operations-efficiency :as operations]))

;Persistent structure with the collection of buildings heights.
(def buildings_heights (atom operations/empty_collection))
(defn reset_buildings []
  (reset! buildings_heights operations/empty_collection))

;Register new building.
(defn register_building [height]
  (swap! buildings_heights operations/insert_element height))

;Count the number of buildings cut by a horizontal laser at the provided height.
(defn laser_cut [height]
  (operations/count_greater height @buildings_heights))