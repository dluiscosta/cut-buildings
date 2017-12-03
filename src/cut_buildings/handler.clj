(ns cut-buildings.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cut-buildings.buildings :as buildings]))

;Defines the routes for both interactions.


;Routes definition example.
(defroutes app-routes
         (GET "/" [] "Hello World")
         (route/not-found "Not Found"))

;Wraps the defined routes to Ring.
(def app
  (wrap-defaults app-routes site-defaults))
