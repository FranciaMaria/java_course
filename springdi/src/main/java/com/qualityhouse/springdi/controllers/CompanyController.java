package com.qualityhouse.springdi.controllers;

import com.qualityhouse.springdi.domain.Company;
import com.qualityhouse.springdi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    private Company ResponseEntity;

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

    @GetMapping("/{companyId}")
    public Optional<Company>  findCompany(@PathVariable Integer companyId) {
        return this.companyService.findById(companyId);
    }

    @PostMapping
    public ResponseEntity<Company> insertCompany(@RequestBody Company company) {
        if (companyService.exists(company.getId())) {
            return new ResponseEntity<Company>(HttpStatus.CONFLICT);
        } else {
            Company inserted = companyService.insertCompany(company);
            return new ResponseEntity<Company>(inserted, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Integer companyId) {
        Optional<Company> company = companyService.findById(companyId);
        if (company == null) {
            throw new RuntimeException("id = " + companyId + " does not exist");
        }
        companyService.deleteCompany(companyId);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable Integer companyId){
        if (companyService.exists(companyId)) {
            Company updated = companyService.updateCompany(company, companyId);
            return new ResponseEntity<Company>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
    }
}
