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
                     :institution "UC Berkeley"
                     :location "Berkeley, CA"
                     :degree "B.A. Computer Science & Cognitive Science"
                     :gpa "GPA: 3.75"
                     :honors "Upsilon Pi Epsilon CS Honors Society, 2012-2013"
                     :dates "December, 2012"
                     )
                    )
            )
   (section ::resume/Skills "SKILLS AND TECHNOLOGIES"
            "Languages: Java, Python, Scala, C/C++, Ruby, Clojure, SQL, Scheme, R"
            "Technologies: Hadoop, Hive, HBase, HCatalog, Saltstack, ANTLR, Bison/Flex, MySQL, Django, Jersey, Rails"
            )
   (section ::resume/Experience "EXPERIENCE"
            (position (array-map
                       :company "Uber"
                       :location "San Francisco, CA"
                       :title "Software Engineer II, Marketplace Continuity"
                       :dates "January 2016-present")
                      (project "Flipr: Dynamic Configuration"
                               ["Fullstack development on Uber's dynamic configuration service"]))
            (position (array-map
                       :company "Upsight (formerly Kontagent)"
                       :location "San Francisco, CA"
                       :roles [{:title "Senior Software Engineer, Data Team"
                                :dates "August 2014-December 2015"}
                               {:title "Software Engineer, Data Team"
                                :dates "February 2013-August 2014"}]
                       :dates "February 2013-December 2015"
                       )
                      (project "Tesseract: OLAP over HBase (Java, HBase, Jersey)"
                               ["Implemented a query system for multidimensional data on top of HBase with support for rollups, grouping and filtering"
                                "Implemented an HBase coprocessor to distribute query execution across regionservers"
                                "Architected and implemented a REST API on top of the underlying query layer"
                                ])
                      (project "Datamine Hardening (Django, Hive, HCatalog)"
                               ["Led a team of 4 in redesigning and implementing an asynchronous REST API for Kontagent's multitenant hive service, focusing on reliability"
                                "Patched Apache's WebHCat to support asynchronous submission of jobs to Hadoop's JobTracker"]))
            (position (array-map
                       :company "Oracle"
                       :location "Redwood Shores, CA"
                       :title "Software Engineering Intern"
                       :dates "Summer 2012")

                      (project "SAS to R Compiler (ANTLR, Java)"
                               [
                                "Architected and implemented a translator from SAS to R from the ground up"
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

   (section ::resume/ListSection "OPEN SOURCE CONTRIBUTIONS"
            (project "Mapreduce over multiple HBase snapshots (HBASE-13356, HBase 1.2.0)"
                     ["Implemented the ability to run mapreduce jobs over multiple scans on HBase snapshots"
                      "Allowed for more fine grained push down of predicates to HBase, and thus better performance"])
            (project "Hive predicate pushdown to multiple HBase scans (HIVE-7805)"
                     ["Modified Hive's HBase integration to push query predicates down to multiple scans"
                      "Significantly reduced the amount of data scanned for hive queries on Upsight's raw data store"])
)

   ;; (section ::resume/ClassProjects "CLASS PROJECTS"
   ;;          (project "Python to C Compiler (Bison, Flex, C++)"
   ;;                   ["Led a team of four in implementing a 3-stage compiler and runtime environment for a statically typed Python subset"
   ;;                    "Implemented support for type inference, lexical closures and first class functions."
   ;;                    ])
   ;;          (project "Distributed Key Value Store (Java)"
   ;;                   ["Implemented the client and networking logic"
   ;;                    "Helped implement two phase commit on the master server."
   ;;                    ]
   ;;                   ))

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
