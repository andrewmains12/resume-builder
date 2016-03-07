(ns resume-builder.views.base-elements
    (:require [resume-builder.views.common :as common]
              [clojure.string :as string]
              [clojure.contrib.seq-utils :as seq-utils]
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
            [:td {} item]
            )
          )
      ])
   ])

(defn -classes-for-pos [[height width] [i j]]
  ^{:doc "List of CSS classes based on the position of a cell in a table"
    :private true}

  [(cond (= i (- height 1)) "table-bottom"
         (= i 0)            "table-top"
         :else                 "table-vert-mid")
   (cond (= j (- width 1))  "table-right"
         (= j 0)            "table-left"
         :else              "table-horizontal-mid")])


(defelem -labeled-table [[table-tag rows]]
  [table-tag
   (let [height (count rows)]
     (for [[i [row-tag row]] (seq-utils/indexed rows)]
       [row-tag
        (let [width (count row)]
          (for [[j [cell-tag attrs & rest]] (seq-utils/indexed row)]
            (into []
                  (concat
                     [cell-tag
                      (assoc attrs
                        :class
                        (string/join " "
                                     (concat (if (:class attrs) [(:class attrs)] [])
                                             (-classes-for-pos [height width] [i j]))))]
                     rest))))
          ]
       ))
   ])

(defelem labeled-table [& rows]
 (-labeled-table (apply table rows)))


(defelem affiliation [institution location & extra-rows]
  ^{:doc
    (str "Represents an affiliation between yourself and an institution (e.g. a"
         "school or business")}
  (let [the-table (concat [{:class "Affiliation"}
                           [(html [:h3 institution]) location]]
                          extra-rows)]
    (apply labeled-table
           the-table
           )
    )
  )
