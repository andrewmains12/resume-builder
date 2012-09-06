(ns resume-builder.views.base-elements
    (:require [resume-builder.views.common :as common]             
              [clojure.string :as string]
              )
    (:use noir.core hiccup.core hiccup.page hiccup.element hiccup.def
          ))

(defpartial body-start []
  [:hr.body-start])

(defpartial sec-sep []
  [:hr.sec-sep])

(defpartial address [{:keys [street city state zip]}]
  (string/join ", " [street city (str state " " zip)])
  )


(defelem table [& rows]
  [:table
   (for [row rows]
     [:tr
      (for [item row]
          (if (and (coll? item) (>= (count item) 2))
            (let [[actual_item attrs] item]
              [:td attrs actual_item])
            [:td item]
            )
          )
      ])
   ])



(defelem affiliation [institution location title date]
  ^{:doc
    (str "Represents an affiliation between yourself and an institution (e.g. a" 
         "school or business")}
  (table {:class "Affiliation"}
         [[(html [:h3 institution]) {:class "Left"}] [location {:class "Right"}]]
         [[title {:class "Left"}] [date {:class "Right"}]]
         )
  )



