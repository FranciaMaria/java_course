package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@Profile("RS")
public class CompanyServiceRsMoc implements CompanyService {

    @Override
    public List<Company> getAll() {

        ArrayList arrayList = new ArrayList();

        arrayList.add(new Company(1, "Nordeus"));
        arrayList.add(new Company(2, "QualityHouse"));
        arrayList.add(new Company(3, "Inforce"));
        return arrayList;
    }
}
