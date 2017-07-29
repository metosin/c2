(defproject c2 "0.1.0-SNAPSHOT"
  :description "Compojure-api 2.0.0 (alpha) demo"
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [metosin/compojure-api "2.0.0-alpha6"]
                 [metosin/spec-tools "0.3.2"]]
  :ring {:handler c2.handler/app, :async? true}
  :uberjar-name "server.jar"
  :profiles {:dev {:plugins [[lein-ring "0.12.0"]]}})
