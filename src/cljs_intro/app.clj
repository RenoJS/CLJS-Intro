(ns cljs-intro.app
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [selmer.parser :refer [render-file]]))

(defroutes app-routes
  (GET "/" [] (render-file "cljs_intro/templates/index.html" {:build "public"}))
  (GET "/dev" [] (render-file "cljs_intro/templates/index.html" {:build "dev"}))
  (route/resources "/" {:root ""})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
