package com.rahul.SecondSpringBoot.company.impl;

import com.rahul.SecondSpringBoot.company.Company;
import com.rahul.SecondSpringBoot.company.CompanyDto;
import com.rahul.SecondSpringBoot.company.CompanyRepository;
import com.rahul.SecondSpringBoot.company.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

        private CompanyRepository companyRepository;
        private ModelMapper model;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper model) {
        this.companyRepository = companyRepository;
        this.model = model;
    }

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {

        Company company = model.map(companyDto,Company.class);
        Company savedCompany = companyRepository.save(company);
        return model.map(savedCompany, CompanyDto.class);

    }
}
