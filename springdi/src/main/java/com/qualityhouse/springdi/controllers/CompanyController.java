package com.qualityhouse.springdi.controllers;

import com.qualityhouse.springdi.domain.Company;
import com.qualityhouse.springdi.repositories.CompanyRepository;
import com.qualityhouse.springdi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAll() {
        return this.companyService.findAll();
    }

    @GetMapping("/paged")
    public Page<Company> getPage(Pageable pageable) {
        return this.companyService.getPaged(pageable);
    }

    @GetMapping("/byName/{name}")
    public List<Company> getByName(@PathVariable String name) {
        return this.companyService.getByName(name);
    }
}
