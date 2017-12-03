(defproject cut-buildings "0.1.0-SNAPSHOT"
  :description "A Clojure learning project."
  :url "https://github.com/dluiscosta/cut-buildings"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.6.0"]
                 [ring/ring-defaults "0.3.1"]]
  :plugins [[lein-ring "0.12.1"]
            [lein-midje "3.2.1"]]
  :ring {:handler cut-buildings.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        [midje "1.9.0"]]}})
