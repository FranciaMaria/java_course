package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getAll();
    List<Company> findAll();

    Page<Company> getPaged(Pageable pageable);

    List<Company> getByName(String name);

    // Company insert(Company company);

    Optional<Company> findById(Integer companyId);

    Company insertCompany(Company company);

    void deleteCompany(Integer companyId);

    Company updateCompany(Company company, Integer companyId);

    ResponseBody update(Company company, Integer companyId);

    ResponseBody insert(Company company);

    boolean exists(int id);
}