package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
