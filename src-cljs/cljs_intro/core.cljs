(ns cljs-intro.core
  (:require [dommy.core :as dom])
  (:require-macros [dommy.macros :refer [sel1]]))

(defn add1 []
  (let [element (sel1 :#number)
        value (js/parseInt (dom/html element))]
    (dom/set-html! element (+ value 1))))

(defn ^:export init []
  (dom/listen! (sel1 :#plusone) "click" (fn [e] (add1))))

(set! (.-onload js/window) init)
