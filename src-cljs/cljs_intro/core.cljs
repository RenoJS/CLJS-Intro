(ns cljs-intro.core
  (:require [cljs.core.async :refer [<! >! put! chan]]
            [dommy.core :as dom])
  (:require-macros [cljs.core.async.macros :refer [go alt!]]
                   [dommy.macros :refer [sel1 node]])
  (:import [goog.net Jsonp]
           [goog Uri]))

(def search-chan (chan))
(def result-chan (chan))
(def search-url
  "http://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=")

(defn user-query []
  (dom/value (sel1 :#query)))

(defn query-url [q]
  (str search-url q))

(defn jsonp [uri]
  (Jsonp. (Uri. uri)))

(defn render-query [res]
  (node
    [:ul
     (for [result res]
       [:li result])]))

(defn query-serv []
  (go (while true
        (<! search-chan)
        (let [uri (query-url (user-query))
              req (jsonp uri)]
          (.send req nil (fn [res] (put! result-chan res)))))))

(defn render-serv []
  (go (while true
        (let [[_ res] (<! result-chan)]
          (dom/replace-contents! (sel1 :#results) (render-query res))))))

(defn ^:export init []
  (query-serv)
  (render-serv)
  (dom/listen! (sel1 :#submit) "click" (fn [e] (put! search-chan e))))

(set! (.-onload js/window) init)
