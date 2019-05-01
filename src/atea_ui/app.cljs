(ns ^:figwheel-hooks atea-ui.app
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent]
   [atea-ui.view :as view]))

(defn app-element []
  (gdom/getElement "app"))

(def app (js/document.getElementById "app"))

(defn- mount-app []
  (reagent/render [view/home] app))

(defn- init []
  (mount-app))

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (mount-app)
)

(.addEventListener js/document "DOMContentLoaded" init)
