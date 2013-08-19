(ns resume-builder.views.resumes.my_resume
  (:require [resume-builder.views.resume :as resume])
  (:use resume-builder.views.resume
        resume-builder.views.base-elements
        noir.core
   )
  )


(defpartial the-resume []
  (resume
   (header "Andrew Robert Mains"
           (contact (array-map
                     :number "408-710-2521"
                     :email "amains12@gmail.com"
                     :portfolio "github.com/andrewmains12"
                     ))
           )

   ;;Sections
    (section ::resume/Objective "OBJECTIVE"
             "A full time software engineering position, ideally with a focus on distributed systems."
             )

    (section ::resume/Education "EDUCATION"
             (school (array-map
                      :institution "UC Berkeley, December 2012"
                      :location "Berkeley, CA"
                      :degree "B.A., Computer Science, Cognitive Science"
                      :gpa "GPA: 3.75"
                      )
                     )
             )

    (section ::resume/Skills "SKILLS AND TECHNOLOGIES"
             "Languages: Python, Java, C/C++, Ruby, Clojure, SQL, Scheme, R"
             "Technologies: Hadoop, Hive, HCatalog, ANTLR, Bison/Flex, OpenMP, MySQL, Django, Rails, Noir"
             )
    (section ::resume/Experience "EXPERIENCE"
             (position (array-map
                        :company "Kontagent"
                        :location "San Francisco, CA"
                        :title "Software Engineer, Datastore Team"
                        :dates "February 2013-present")
                       (project "Datamine Hardening"
                                ["Redesigned and implemented Kontagent's multitenant hive service, with a focus on fault tolerance"
                                 "Implemented an asynchronous REST API for query execution using Django"
                                 "Implemented a rate limiting system for queries"
                                ]
                                )
                       ;; (project "Scenario Toolkit"
                       ;;          ["Maintained and extended Kontagent's full stack testing framework"
                       ;;           "Added ability to impose a delay between the sending of messages"
                       ;;           ]
                       ;;          )
                       )
             (position (array-map
                        :company "Oracle"
                        :location "Redwood Shores"
                        :title "Software Engineering Intern"
                        :dates "Summer 2012")

                       (project "Project: SAS to R Compiler"
                                [
                                 "Architected and implemented a translator from SAS to R from the ground up using ANTLR and Java"
                                 "Created a static analyzer for SAS in order to generate optimized R code."
                                 ])
                       )

             (position (array-map
                        :company "Kontagent"
                        :location "San Francisco, CA"
                        :title "Software Engineering Intern"
                        :dates "Summer 2011")
                       (project "Project: Hive Interface"
                                ["Wrote the Python server side of a REST interface for Hive, using the Thrift API provided by Cloudera's Beeswax"                                                     "Wrote a UDF to calculate session times for users in games"])
                       (project "Project: ETL Testing"
                                ["Created a regression testing framework for Kontagent's ETL system in Python"

                                 ]))
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
             )

    (section ::resume/CourseWork "SELECTED COURSES"
             "CS162: Operating Systems"
             "CS164: Compilers"
             "CS170: Algorithms"
             "CS188: Artificial Intelligence"
             "CS186: Databases"
             "CS169: Software Engineering"
             )
    )
  )
