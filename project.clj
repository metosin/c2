(defproject c2 "0.1.0-SNAPSHOT"
  :description "Compojure-api 2.0.0 (alpha) demo"
  :dependencies [[org.clojure/clojure "1.9.0-RC2"]
                 [metosin/compojure-api "2.0.0-alpha16"]
                 [metosin/spec-tools "0.5.1"]
                 [manifold "0.1.6"]]
  :ring {:handler c2.handler/app, :async? true}
  :uberjar-name "server.jar"
  :profiles {:dev {:plugins [[lein-ring "0.12.1"]]}})
