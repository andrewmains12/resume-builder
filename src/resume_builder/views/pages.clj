(ns resume-builder.views.pages
  (:require [resume-builder.views.my_resume :as my_resume])
  (:use noir.core))
;;Pages
;;Hacked together--TODO: fix this to take in information from elsewhere

(defpage "/" []
  (my_resume/the-resume))
