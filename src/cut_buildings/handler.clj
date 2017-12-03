(ns cut-buildings.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cut-buildings.buildings :as buildings]))

;Casts a string to an integer.
(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

;Defines the routes for both interactions.
(defroutes app-routes
           ;Initial presentation.
           (GET "/" [] "Hello World")

           ;Receives a laser height and outputs the number of buildings that would get cut by it.
           (GET "/laser_cut/:n" [n]
             (str (buildings/laser_cut (parse-int n))))

           ;Receives the height of a new building and inserts it into the collection of buildings heights.
           (POST "/register_building/:n" [n]
             (str (buildings/register_building (parse-int n))))

           ;Route not found.
           (route/not-found "Not Found"))

;Wraps the defined routes to Ring.
(def app
  (wrap-defaults
    app-routes
    (assoc-in site-defaults [:security :anti-forgery] false))) ;disable anti-forge, required to mock requests
