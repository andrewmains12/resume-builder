
(ns resume-builder.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial normal-layout [& content]
            (html5
              [:head
               [:title "resume-builder"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))


