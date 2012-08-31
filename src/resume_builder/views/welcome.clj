(ns resume-builder.views.welcome
  (:require [resume-builder.views.common :as common]
            [noir.content.getting-started])
  (:use noir.core 
        hiccup.core
        hiccup.page)

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to resume-builder"]))
