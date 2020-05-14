package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();
    List<Company> findAll();

    Page<Company> getPaged(Pageable pageable);

    List<Company> getByName(String name);
}
