package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import com.qualityhouse.springdi.domain.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
// @Primary
@Profile("DEFAULT")
public class CompanyServiceMoc implements CompanyService {

    @Override
    public List<Company> getAll() {

        ArrayList arrayList = new ArrayList();

       arrayList.add(new Company(1, "Oracle"));
       arrayList.add(new Company(2, "Microsoft"));
       arrayList.add(new Company(3, "Apple"));

        return arrayList;
    }

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public Page<Company> getPaged(Pageable pageable) {
        return null;
    }

    @Override
    public List<Company> getByName(String name) {
        return null;
    }

    @Override
    public Optional<Company> findById(Integer companyId) {
        return null;
    }

    @Override
    public Company insertCompany(Company company) {
        return null;
    }

    @Override
    public void deleteCompany(Integer companyId) {

    }

    @Override
    public Company updateCompany(Company company, Integer companyId) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }
}
