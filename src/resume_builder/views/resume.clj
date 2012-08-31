(ns resume-builder.views.resume
    (:require [resume-builder.views.common :as common]             
              [clojure.string :as string]
              )
    (:use resume-builder.views.base-elements
          noir.core hiccup.core hiccup.page hiccup.element hiccup.def
          ))


;;The base of the resume document 
(defpartial common [& content]
  (html5
   [:body content
    ]
   )
)

(defpartial resume [header & sections]
  (common
   header
   (body-start)
   (string/join (sec-sep) sections)
     )
  )


;;Want to arrange the elements                      
(defpartial header [{:keys [resume-name, address, number, email] :as contact-info}]
  [:div#header 
   [:h1 resume-name]
   [:ul#contact
    (for [[key, val] contact-info]
      (if (not= key :resume-name)
        [:li
         {:id (name key)}
         val]))
    ]
   ]
  )

(defpartial ^:private base-section [title type & items]
  [:div {:class (str "Section " (name type))}
   [:h2 title]
   items
   ]
  )

(defmulti section
  (fn [title type & items]
    type
    )
  :default
  :BaseSection
  )

(defmethod section :BaseSection [title type & items]
  (base-section title type items)
  )

                          
(defmethod section :Experience [title type & positions]
  (base-section title type
                positions))

(defmethod section :Objective [title type & objective-copy]
  (base-section title type
                objective-copy))

(defmethod section :Skills [title type & skill-items]
  (base-section title type
                (unordered-list skill-items)))

(defmethod section :Education [title type & schools]
  (base-section title type
                (unordered-list schools)))


(defpartial school [institution location degree dates]  
  ;;TODO: implement an easier way of composing classes
  (affiliation {:class "School Affiliation"}
   institution
   location
   degree
   dates)
   )

(defpartial position [{:keys [company location title dates]} & details]
  [:div.Position
   (affiliation 
   company
   location
   title
   dates)

   details
   ]
  )

(defelem project [title accomplishments]
  [:div.Project
   [:h4 title]
   (unordered-list accomplishments)
   ])


       




