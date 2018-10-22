(ns c2.spec
  (:require [compojure.api.sweet :refer [context GET resource]]
            [ring.util.http-response :refer [ok]]
            [clojure.spec.alpha :as s]
            [spec-tools.spec :as spec]))

(s/def ::x int?)
(s/def ::y int?)
(s/def ::total int?)
(s/def ::total-map (s/keys :req-un [::total]))

(def routes
  (context "/spec" []
    :tags ["spec"]
    :coercion :spec

    (GET "/plus" []
      :summary "plus with clojure.spec"
      :query-params [x :- ::x, {y :- ::y 0}]
      :return ::total-map
      (ok {:total (+ x y)}))

    (context "/data-plus" []
      (resource
        {:post
         {:summary "data-driven plus with clojure.spec"
          :parameters {:body-params (s/keys :req-un [::x ::y])}
          :responses {200 {:schema ::total-map}}
          :handler (fn [{{:keys [x y]} :body-params}]
                     (ok {:total (+ x y)}))}}))))
