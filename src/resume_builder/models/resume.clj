;;Controls access to resume files
(ns resume-builder.models.resume
  (:require [clojure.string :as string]
            [fs.core :as fs]
            [pathetic.core :as path])
  (:use [clojure.java.io :only [file]]))
  


(defn absolute-path [file_str]
  (.getAbsolutePath (file file_str)))


(def resume-path (string/join "/" [(path/normalize (absolute-path ".")) "src" "resume_builder" "views" "resumes"]))

;;This implementation is very temporary--does what I need it to right now, but obviously
;;makes no sense in a production app.
(defn all-resumes []
  (map fs/name (fs/list-dir resume-path)))

(defn resume-page [name]
  (let [resume-name
        (str (string/join  "." ["resume-builder" "views" "resumes" name])
             ),
        resume-fn (ns-resolve (symbol resume-name) 'the-resume)]    
    (resume-fn)
   ))
    
  
    

  
