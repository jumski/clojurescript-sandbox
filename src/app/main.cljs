(ns app.main
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(defn example-component []
  [:strong "i work properly"])

(defn ^:export main! []
  (rdom/render [example-component] (js/document.getElementById "app")))
