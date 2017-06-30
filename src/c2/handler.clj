(ns c2.handler
  (:require [compojure.api.sweet :refer [api]]
            [c2.schema]
            [c2.spec]
            [c2.data-spec]))

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Compojure-api 2.0.0 (alpha) demo"
                    :description "Demonstrating upcoming 2.0.0 features"}
             :tags [{:name "schema", :description "math with schema coercion"}
                    {:name "spec", :description "math with clojure.spec coercion"}
                    {:name "data-spec", :description "math with data-specs coercion"}]}}}

    c2.schema/routes
    c2.spec/routes
    c2.data-spec/routes))
