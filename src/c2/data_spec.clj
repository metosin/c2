(ns c2.data-spec
  (:require [compojure.api.sweet :refer [context GET resource]]
            [ring.util.http-response :refer [ok]]))

(def routes
  (context "/data-spec" []
    :tags ["data-spec"]
    :coercion :spec

    (GET "/plus" []
      :summary "plus with clojure.spec using data-specs"
      :query-params [x :- int?, {y :- int? 0}]
      :return {:total int?}
      (ok {:total (+ x y)}))

    (context "/data-plus" []
      (resource
        {:post
         {:summary "data-driven plus with clojure.spec using data-specs"
          :parameters {:body-params {:x int?, :y int?}}
          :responses {200 {:schema {:total int?}}}
          :handler (fn [{{:keys [x y]} :body-params}]
                     (ok {:total (+ x y)}))}}))))