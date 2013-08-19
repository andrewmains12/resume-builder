(ns resume-builder.views.resume
    (:require [resume-builder.views.common :as common]
              [clojure.string :as string]
              )
    (:use resume-builder.views.base-elements
          noir.core hiccup.core hiccup.page hiccup.element hiccup.def
          ))

(def style "/css/default.css")
;;The base of the resume document
(defpartial resume-wrapper [& content]
  (html5
   [:head (include-css style)]
   [:body content
    ]
   )
)

(defpartial resume [header & sections]
  (resume-wrapper
   header
   (body-start)
   (string/join (sec-sep) sections)
     )
  )

(defpartial contact [{:keys [resume-name, address, number, email, portfolio]
                      :as contact-info}]

   (table {:id "contact"}
          [address]
          [[number {:id "number"}] email portfolio]
    )
   )


;;Want to arrange the elements
(defpartial header [resume-name content]
  [:div#header
   [:h1 resume-name]
   content
   ])



(defpartial ^:private base-section [type title & items]
  [:div {:class "Section" :id (string/lower-case (name type))}
   [:h2 title]
   [:div.Content items]
   ]
  )

(defmulti section
  (fn [type title & items]
    type
    )
  :default
  ::BaseSection
  )

(defmethod section ::BaseSection [type title & items]
  (base-section type title items)
  )

(defmethod section ::ListSection [type title & list-items]
  (base-section type title
                 (unordered-list list-items))
   )

;; (defmethod section :Experience [type title & positions]
;;   (base-section type title
;;                 positions))

(defmethod section ::Objective [type title & objective-copy]
  (base-section type title
                [:p objective-copy]))


(derive ::Skills ::ListSection)
(derive ::Education ::ListSection)
(derive ::ClassProjects ::ListSection)
(derive ::CourseWork ::ListSection)
(derive ::Experience ::ListSection)


;; (defmethod section :Skills [type title & skill-items]
;;    (base-section type title
;;                  (unordered-list skill-items))
;;   )


;; (defmethod section :Education [type title & schools]
;;   (base-section type title
;;                 (unordered-list schools)))

;; (defmethod section :ClassProjects [type title & projects]
;;   (base-section type title
;;                 (unordered-list projects)))

;; (defmethod section :CourseWork [type title & classes]
;;   (base-section type title
;;                 (unordered-list classes)))


(defpartial school [{:keys [institution location degree dates & gpa] :as info}]
  [:div.School
   (affiliation
    institution
    location
    (if gpa (str degree " " (html [:span.gpa gpa])) degree)
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
