(ns resume-builder.views.my_resume
  (:use resume-builder.views.resume
        resume-builder.views.base-elements
        noir.core
   )
  )

(defpartial the-resume []
  (resume
   (header (array-map :resume-name "Andrew Robert Mains",
            :address (address {:street "1624 Milvia Apt 6"
                               :city "Berkeley" :state "CA" :zip "94709"
                               })
            :number "408-710-2521"
            :email "andrewmains12@berkeley.edu"
            )
           )

   ;;Sections   
    (section :Objective "OBJECTIVE"
             "A full time software engineering position, ideally with a focus on language/runtime implementation and or distributed systems."
             )

    (section :Education "EDUCATION"
             (school (array-map
                      :institution "UC Berkeley"
                      :location "Berkeley, CA"
                      :degree "B.A., Computer Science, Cognitive Science"
                      :gpa "GPA: 3.86"
                      :dates "December 2012")
                     )
             )

    (section :Skills "SKILLS AND TECHNOLOGIES"
             ["Languages: Python, Java, C/C++, Ruby, SQL,  Scheme, R, Clojure (currently learning)"
              "Technologies: Hadoop, Hive, Rails, Django, Noir, ANTLR, Bison/Flex"
              ])
    (section :Experience "EXPERIENCE"
             (position (array-map
                        :company "Oracle"
                        :location "Redwood Shores"
                        :title "Software Engineering Intern"
                        :dates"Summer 2012")

                       (project "SAS to R Converter"
                                [
                                 "Architected and implemented a translator from SAS to R from the ground up using ANTLR and Java"
                                 "Created a static analyzer for SAS in order to generate optimized R code."
                                 "Wrote additional R functions to support particular SAS features"])
                       
                        
             )
             )
    )
  )
   

