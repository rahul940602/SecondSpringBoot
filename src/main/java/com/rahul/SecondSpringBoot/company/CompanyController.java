package com.rahul.SecondSpringBoot.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/company")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){

        return new ResponseEntity<>(companyService.createCompany(companyDto), HttpStatus.CREATED);
    }
    @GetMapping("/company")
    public ResponseEntity<List<CompanyDto>> findAll(){
        return new ResponseEntity<>(companyService.findAll(),HttpStatus.OK);
    }

}
