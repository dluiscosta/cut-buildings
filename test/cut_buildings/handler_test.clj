(ns cut-buildings.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cut-buildings.handler :refer :all]))

(fact "on main route"
      (let [response (app (mock/request :get "/"))]
        (:status response) => 200
        (:body response) => "Hello World"))

(fact "not found route"
      (let [response (app (mock/request :get "/invalid"))]
        (:status response) => 404))
