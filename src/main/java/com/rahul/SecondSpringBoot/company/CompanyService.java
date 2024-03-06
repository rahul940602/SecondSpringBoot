package com.rahul.SecondSpringBoot.company;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto companyDto);

    List<CompanyDto> findAll();
}
