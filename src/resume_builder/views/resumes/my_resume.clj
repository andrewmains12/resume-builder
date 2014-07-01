(ns resume-builder.views.resumes.my_resume
  (:require [resume-builder.views.resume :as resume])
  (:use resume-builder.views.resume
        resume-builder.views.base-elements
        noir.core
        )
  )


(defpartial the-resume []
  (resume
   (header "Andrew R. Mains"
           (contact (array-map
                     :number "510-730-9376"
                     :email "amains12@gmail.com"
                     :portfolio "github.com/andrewmains12"
                     ))
           )

   ;;Sections
   (section ::resume/Education "EDUCATION"
            (school (array-map
                     :institution "UC Berkeley, December 2012"
                     :location "Berkeley, CA"
                     :degree "B.A., Computer Science, Cognitive Science"
                     :gpa "GPA: 3.75"
                     :honors "Upsilon Pi Epsilon CS Honors Society, 2012-2013"
                     )
                    )
            )
   (section ::resume/Skills "SKILLS AND TECHNOLOGIES"
            "Languages: Java, Python, C/C++, Ruby, Clojure, SQL, Scheme, R"
            "Technologies: Hadoop, Hive, HBase, HCatalog, Salt, ANTLR, Bison/Flex, MySQL, Django, Jersey, Rails"
            )
   (section ::resume/Experience "EXPERIENCE"
            (position (array-map
                       :company "Upsight (Kontagent)"
                       :location "San Francisco, CA"
                       :title "Software Engineer, Data Team"
                       :dates "February 2013-present")
                      (project "Tesseract: OLAP over HBase (Java, HBase, Jersey)"
                               ["Implemented a query system for multidimensional data on top of HBase with support for rollups, grouping and filtering"
                                "Architected and implemented a REST API on top of the underlying query layer"
                                ])
                      (project "Vagrant Mini-Cluster (Vagrant, Salt, Hadoop)"
                               ["Implemented a Salt orchestration to bring up a fully provisioned hadoop cluster automatically"
                                "Successfully pushed for adoption of the local development environment across backend teams"])
                      (project "Datamine Hardening (Django, Hive, HCatalog)"
                               ["Led a team of 4 in redesigning and implementing an asynchronous REST API for Kontagent's multitenant hive service, focusing on reliability"
                                "Patched Apache's WebHCat to support asynchronous submission of jobs to Hadoop's JobTracker"])
            (position (array-map
                       :company "Oracle"
                       :location "Redwood Shores"
                       :title "Software Engineering Intern"
                       :dates "Summer 2012")

                      (project "SAS to R Compiler (ANTLR, Java)"
                               [
                                "Architected and implemented a translator from SAS to R from the ground"
                                "Created a static analyzer for SAS in order to generate optimized R code."
                                ])
                      )

            (position (array-map
                       :company "Kontagent"
                       :location "San Francisco, CA"
                       :title "Software Engineering Intern"
                       :dates "Summer 2011")
                      (project "Hive Interface (Python, Hive)"
                               ["Wrote the server side of a REST interface for Hive, using the Thrift API provided by Cloudera's Beeswax"
                                "Wrote a UDF to calculate session times for users in games"]))
            )

                      ;; (project "ETL Testing (Python)"
                      ;;          ["Created a regression testing framework for Kontagent's ETL system in Python"

                      ;;           ]))
            )

   (section ::resume/ClassProjects "CLASS PROJECTS"
            (project "Python to C Compiler (Bison, Flex, C++)"
                     ["Led a team of four in implementing a 3-stage compiler and runtime environment for a statically typed Python subset"
                      "Implemented support for type inference, lexical closures and first class functions."
                      ])
            (project "Distributed Key Value Store (Java)"
                     ["Implemented the client and networking logic"
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
