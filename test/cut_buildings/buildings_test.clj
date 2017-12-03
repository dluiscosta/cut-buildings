(ns cut-buildings.buildings-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.buildings :refer :all]))

;Tests for both the manipulations of the persistent and thread-safe buildings collection

;Number of buildings cut by a horizontal laser at a given height

;Building registering