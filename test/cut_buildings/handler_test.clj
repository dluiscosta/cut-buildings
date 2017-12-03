(ns cut-buildings.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.handler :refer :all]
            [cut-buildings.buildings :refer :all]))

(fact "on main route"
      (let [response (app (mock/request :get "/"))]
        (:status response) => 200
        (:body response) => "Hello World"))

(fact "not found route"
      (let [response (app (mock/request :get "/invalid"))]
        (:status response) => 404))

;Tests for both the interactions with the web application.
(against-background [(before :facts (reset_buildings))] ;restarts the building heights before the test of each fact
                    (fact "failed to persistently store the building heights and consult laser cut"
                          (let [_ (app (mock/request :post "/register_building/1"))
                                _ (app (mock/request :post "/register_building/2"))
                                _ (app (mock/request :post "/register_building/4"))
                                _ (app (mock/request :post "/register_building/8"))
                                _ (app (mock/request :post "/register_building/4"))
                                response (app (mock/request :get "/laser_cut/2"))]
                            (:status response) => 200
                            (:body response) => "3"))
                    )