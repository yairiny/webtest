(ns webtest.core
  (:use compojure.core)
  (:require [compojure.route :as route])
  (:require [webtest.data :as data])
  (:require [clj-time.format :as dtf])
  (:use hiccup.core)
  (:use hiccup.page-helpers)
  (:use compojure.handler))

(defn get-log-divs []
  (defn log-div [log]
    [:div.entry.primary-4
     [:div
      {:style "height:20px;font-weight:bold;margin-left:5px;margin-right:5px;"}
      [:div {:style "float:left;"}
       (dtf/unparse (dtf/formatters :date) (:date log))]
      [:div
       {:style "float:right"} (:type log)]]])
  (map log-div (data/get-all-records)))

(defn home-page []
  (html
   [:html
    [:head
     [:title "Training Log - Yair Iny"]
     (include-css "/css/main.css")]
    [:body
     [:div#main.primary-5
      [:div#header.primary-3
       [:h1 "Training Log - Yair Iny"]]
      [:div#content
       [:div
        {:style "border:1px solid black;border-bottom:0px;"}
        (get-log-divs)]]
      [:div#footer.complement-5]]]]))

(defroutes main-routes
  (GET "/" [] (home-page))
  (route/files "/")
  (route/not-found "Page not found"))

(def app
  (-> main-routes
      api))


