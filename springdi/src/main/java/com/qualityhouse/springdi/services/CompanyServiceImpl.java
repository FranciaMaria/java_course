package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Company;
import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CompanyServiceImpl implements CompanyService, CompanyRepository {

    @Autowired
    private CompanyRepository companyRepository;
    private ArrayList arrayList = new ArrayList();
    private CompanyService companyService;

    @Override
    public List<Company> getAll() {
        return arrayList;
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Page<Company> getPaged(Pageable pageable) {
        return this.companyRepository.findAll(pageable);
    }

    @Override
    public List<Company> getByName(String name) {
        return this.companyRepository.findByName(name);
    }

    @PostMapping
    public Company insertCompany(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public Optional<Company> findById(Integer companyId) {
        Optional <Company> ret = this.companyRepository.findById(companyId);
        if (ret.isPresent()) {
            return ret;
        } else {
            return null;
        }
    }

    @Override
    public List<Company> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return this.companyRepository.findAll(pageable);
    }

    @Override
    public List<Company> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public List<Company> findByName(String name) {
        return this.companyRepository.findByName(name);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public void deleteAll(Iterable<? extends Company> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Company> S save(S s) {
        return null;
    }

    @Override
    public <S extends Company> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteCompany(Integer companyId) {
        this.companyRepository.deleteById(companyId);
    }

    @Override
    public Company updateCompany(Company company, Integer companyId) {
        if (companyRepository.existsById(companyId)) {
            return this.companyRepository.save(company);
        } else {
            return null;
        }
    }

    @Override
    public boolean exists(int id) {
        if(companyRepository.existsById(id)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Company> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Company> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Company getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Company> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Company> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Company> boolean exists(Example<S> example) {
        return false;
    }
}
