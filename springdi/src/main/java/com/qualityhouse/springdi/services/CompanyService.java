package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getAll();
    List<Company> findAll();

    Page<Company> getPaged(Pageable pageable);

    List<Company> getByName(String name);

    Optional<Company> findById(Integer companyId);

    Company insertCompany(Company company);

    void deleteCompany(Integer companyId);

    Company updateCompany(Company company, Integer companyId);

    boolean exists(int id);

}