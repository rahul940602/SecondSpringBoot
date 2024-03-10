# SecondSpringBoot

Monolathic Practice  Job Portal in BackEnd

1)Job Module
    @PostRequest   :- localhost:8080/jobs
    @GetRequest    :- localhost:8080/jobs,
                      localhost:8080/jobs/{id}
    @PutRequest    :- localhost:8080/jobs/{id}
    @DeleteRequest :- localhost:8080/jobs/{id}
    
 
2) Company
       @PostRequest   :- localhost:8080/company
    @GetRequest    :- localhost:8080/company,
                      localhost:8080/company/{id}
    @PutRequest    :- localhost:8080/company/{id}
    @DeleteRequest :- localhost:8080/company/{id}
   Note :- If you delete company {id} delete all the job on {id}
4) Review
       @PostRequest   :- localhost:8080/company/{companyId}/review
    @GetRequest    :- localhost:8080/company/{companyId}/review,
                      localhost:8080/company/{id}/review/{id}
    @PutRequest    :- localhost:8080/company/{id}/review/{id}
    @DeleteRequest :- localhost:8080/company/{id}/review/{id}

