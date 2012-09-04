(ns resume-builder.views.my_resume
  (:require [resume-builder.views.resume :as resume])
  (:use resume-builder.views.resume
        resume-builder.views.base-elements
        noir.core
   )
  )


(defpartial the-resume []
  (resume
   (header (array-map :resume-name "Andrew Robert Mains"
            ;; :address (address {:street "1624 Milvia Apt 6"
            ;;                    :city "Berkeley" :state "CA" :zip "94709"
            ;;                    })
                      :number "408-710-2521"
                      :email "andrewmains12@berkeley.edu"
            )
           )

   ;;Sections   
    (section ::resume/Objective "OBJECTIVE"
             "A full time software engineering position, ideally with a focus on language implementation/analysis or distributed systems."
             )

    (section ::resume/Education "EDUCATION"
             (school (array-map
                      :institution "UC Berkeley, December 2012"
                      :location "Berkeley, CA"
                      :degree "B.A., Computer Science, Cognitive Science"
                      :gpa "GPA: 3.82"
                      )
                     )
             )

    (section ::resume/Skills "SKILLS AND TECHNOLOGIES"
             "Languages: Python, Java, C/C++, Ruby, SQL,  Scheme, R, Clojure (currently learning)"
              "Technologies: Hadoop, Hive, Rails, Django, Noir, ANTLR, Bison/Flex"     
              )
    (section ::resume/Experience "EXPERIENCE"
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
             (position (array-map
                        :company "Kontagent"
                        :location "San Francisco, CA"
                        :title "Software Engineering Intern"
                        :dates "Summer 2011")
                       (project "Hive"
                                ["Wrote the Python server side of a web interface for Hive, using the Thrift API provided by Cloudera's Beeswax"                                                     "Wrote a Java UDF to calculate session times for users in games"])
                       (project "Testing"
                                ["Created a blackbox testing framework for Kontagent's ETL system in Python"]))                                             
             )

    (section ::resume/ClassProjects "CLASS PROJECTS"
             (project "Python to C Compiler (Bison, Flex, C++)"
                      ["Led a team of four in implementing a 3-stage compiler and runtime environment for a statically typed Python subset"
                       "Implemented support for type inference, lexical closures and first class functions."
                       ])
             (project "Distributed Key Value Store (Java)"
                      ["Worked as part of a team of five implementing a multi-node key value store with two phase commit"            
                       "Implemented the client and networking logic"
                       "Helped implement two phase commit on the master server."
                       ]
                      )
             (project "Virtual Memory for NachOS (Java)"
                      ["Implemented process memory allocation and access"
                       "Prevented illegal memory accesses by processes"
                       ]
                      )
             )
                      
    (section ::resume/CourseWork "COURSEWORK"
             "CS162: Operating Systems"
             "CS164: Compilers"
             "CS188: Artificial Intelligence"
             "CS170: Algorithms"
             "CS186: Databases (in progress)"
             "CS169: Software Engineering (in progress)"
             "CS194: Parallel Software (in progress)"
    )
    
  
    )
  )

