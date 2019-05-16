(ns demo.components.product-detail
  (:require
    [demo.env :as env]
    ;; just assume that it provides some shared components
    [demo.components.product-listing :as l]
    ["react-table" :as rt]
    ["react-select" :as rs]))

(defn root []
  [:div
   [:h1 "Product Detail"]
   [:div (pr-str (:product @env/app-state))]])
