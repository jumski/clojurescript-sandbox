(ns app.main
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(def rows-num (r/atom 5))
(def cols-num (r/atom 5))

(defn create-cols [num body-fn]
  (for [i (range num)]
    ^{:key (body-fn i)} [:td (body-fn i)]))

(defn table []
  [:table
   [:tbody
    (doall
      (for [rn (range @rows-num)
            :let [col-body-fn #(str "row=" rn " col=" %)]]
        ^{:key rn} [:tr (create-cols @cols-num col-body-fn)]))]])

(defn button [btn-name click-handler]
  [:button {:on-click click-handler} btn-name])

(defn layout []
  [:div
   [:div "rows" [button "+" #(swap! rows-num inc)] "/" [button "-" #(swap! rows-num dec)]],
   [:div "cols" [button "+" #(swap! cols-num inc)] "/" [button "-" #(swap! cols-num dec)]]
   [table]])

(defn ^:export main! []
  (rdom/render [layout] (js/document.getElementById "app")))
