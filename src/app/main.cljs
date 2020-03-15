(ns app.main
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(def state (r/atom "yoflaki"))

(defn example-component []
  [:strong "message: " @state])

(defn ^:export main! []
  (rdom/render [example-component] (js/document.getElementById "app")))
