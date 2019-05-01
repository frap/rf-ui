(ns atea-ui.view
  (:require
   [reagent.core :as reagent]
   [reagent-material-ui.core :as ui]
   [re-frame.core :as re-frame]
   [atea-ui.views.typeahead :as typeahead]) )

;; some helpers
(def el reagent/as-element)
(defn icon [nme] [ui/FontIcon {:className "material-icons"} nme])
(defn color [nme] (aget ui/colors nme))

;; create a new theme based on the dark theme from Material UI
(defonce theme-defaults {:muiTheme (ui/getMuiTheme
                                    (-> ui/darkBaseTheme
                                        (js->clj :keywordize-keys true)
                                        (update :palette merge {:primary1Color (color "amber200")
                                                                :primary2Color (color "amber800")})
                                        clj->js))})


(defn simple-nav []
  (let [is-open? (atom false)
        close #(reset! is-open? false)]
    (fn []
      [:div
       [ui/AppBar {:title "yippe-yiyay" :onLeftIconButtonTouchTap #(reset! is-open? true)}]
       [ui/Drawer {:open @is-open? :docked false}
        [ui/List
         [ui/ListItem {:leftIcon (el [:i.material-icons "home"])
                       :on-click (fn []
                                  ;; (accountant/navigate! "/")
                                   (close))}
          "Home"]
         [ui/Divider]

         ]
        ]])))

(defn home []
  [ui/MuiThemeProvider theme-defaults
   [:div
    [simple-nav]
    [:div
     [:h2 "Typeahead"]
     [typeahead/typeahead]]]])
