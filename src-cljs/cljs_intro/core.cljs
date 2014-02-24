(ns cljs-intro.core
  (:require [dommy.core :as dom]
            [cljs.core.async :refer [<! >! put! chan]])
  (:require-macros [dommy.macros :refer [sel1]]
                   [cljs.core.async.macros :refer [go alt!]]))

(def click-chan (chan))

(defn square []
  (go (while true
        (<! click-chan)
        (let [base (dom/value (sel1 :#num-base))
              expo (dom/value (sel1 :#num-expo))]
          (dom/set-value! (sel1 :#num-base) (.pow js/Math base expo))))))

(defn ^:export init []
  (square)
  (dom/listen! (sel1 :#submit) "click" (fn [e] (put! click-chan e))))

(set! (.-onload js/window) init)
