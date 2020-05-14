package com.qualityhouse.springdi.repositories;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findByName(String name);

}
