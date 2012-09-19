(ns resume-builder.views.pages
  (:require ;[resume-builder.views.resume :as resumes]
   [resume-builder.models.resume :as db]
   [resume-builder.views.common :as common])
  (:use noir.core [noir.response :only [redirect]]
        hiccup.page hiccup.element))

;;Pages
;;Hacked together--TODO: fix this to take in information from elsewhere

(defpage "/" []
  (redirect "/resumes"))

(defpage "/resumes" []
  (common/normal-layout
   (ordered-list
    (for [resume (db/all-resumes)]
      (link-to (str "/resumes/" resume) resume)))))

(defpage "/resumes/:res-name" {:keys [res-name]}
  (db/resume-page res-name))
