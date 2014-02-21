(ns cljs-intro.core
  (:require [goog.dom :as dom]
            [goog.events :as events]))

(defn add1 []
  (let [element (dom/getElement "number")
        value (js/parseInt (.-innerHTML element))]
    (set! (.-innerHTML element) (+ value 1))))

(defn ^:export init []
  (events/listen (dom/getElement "plusone") "click" (fn [e] (add1))))

(set! (.-onload js/window) init)
