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
   (table {:id "contact"}
          [address]
          [number email]
          )          
   ]
  )

(defpartial ^:private base-section [type title & items]
  [:div {:class (str "Section " (name type))}
   [:h2 title]
   items
   ]
  )

(defmulti section
  (fn [type title & items]
    type
    )
  :default
  :BaseSection
  )

(defmethod section :BaseSection [type title & items]
  (base-section type title items)
  )

                          
(defmethod section :Experience [type title & positions]
  (base-section type title
                positions))

(defmethod section :Objective [type title & objective-copy]
  (base-section type title
                objective-copy))

(defmethod section :Skills [type title & skill-items]  
   (base-section type title
                 (unordered-list skill-items))
  )

(defmethod section :Education [type title & schools]
  (base-section type title
                (unordered-list schools)))

(defmethod section :ClassProjects [type title & projects]
  (base-section type title
                (unordered-list projects)))

(defpartial school [{:keys [institution location degree dates & gpa] :as info}]  
  [:div.School
   (affiliation
    institution
    location
    (if gpa (str degree " " (html [:span.GPA gpa])) degree)
    dates
    )
   ]
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


       




