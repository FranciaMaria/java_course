package com.qualityhouse.springdi.services;

import com.qualityhouse.springdi.domain.Employee;
import com.qualityhouse.springdi.repositories.EmployeeRepository;
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
public class EmployeeServiceImpl implements EmployeeService, EmployeeRepository {

    @Autowired
    private EmployeeRepository employeeRepository;
    private ArrayList arrayList = new ArrayList();
    private EmployeeService employeeService;

    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return this.findAll();
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getPaged(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

//    @Override
//    public List<Employee> getByName(String name) {
//        return this.employeeRepository.findByName(name);
//    }

    @PostMapping
    public Employee insertEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Integer employeeId) {
        Optional <Employee> ret = this.employeeRepository.findById(employeeId);
        if (ret.isPresent()) {
            return ret;
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllById(Iterable<Integer> iterable) {
        return null;
    }

//    @Override
//    public List<Employee> findByName(String name) {
//        return this.employeeRepository.findByName(name);
//    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Employee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            return this.employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    @Override
    public boolean exists(int id) {
        if(employeeRepository.existsById(id)) {
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
    public <S extends Employee> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Employee> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }
}
