(ns cut-buildings.buildings-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.buildings :refer :all]))

;-- Tests for both the manipulations of the thread-safe 'buildings' collection.
;-- Number of buildings cut by a horizontal laser at a given height and building registering.

(against-background [(before :facts (reset_buildings))] ;Restarts the building heights before the test of each fact
                    (fact "failed correctly store the building heights"
                          (let [_ (register_building 1)
                                _ (register_building 2)
                                _ (register_building 4)
                                _ (register_building 8)
                                _ (register_building 4)]
                            (laser_cut 2) => 3))

                    (fact "wrong number of cut buildings with empty array"
                          (laser_cut 2) => 0)
                    )