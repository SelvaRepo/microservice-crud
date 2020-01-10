package com.microservice.service;

import com.microservice.entity.CustomerEntity;
import com.microservice.exception.RecordNotFoundException;
import com.microservice.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class EmployeeService {
     
    @Autowired
    CustomerRepository customerRepository;
     
    public List<CustomerEntity> getAllEmployees()
    {
        List<CustomerEntity> employeeList = customerRepository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<CustomerEntity>();
        }
    }
     
    public CustomerEntity getEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<CustomerEntity> employee = customerRepository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public CustomerEntity createOrUpdateEmployee(CustomerEntity entity) throws RecordNotFoundException
    {
        Optional<CustomerEntity> employee = customerRepository.findById(entity.getCustomerId());
         
        if(employee.isPresent())
        {
            CustomerEntity newEntity = employee.get();
            newEntity.setCustomerEmailId(entity.getCustomerEmailId());
            newEntity.setCustomerFirstName(entity.getCustomerFirstName());
            newEntity.setCustomerLastName(entity.getCustomerLastName());
 
            newEntity = customerRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = customerRepository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {
        Optional<CustomerEntity> employee = customerRepository.findById(id);
         
        if(employee.isPresent())
        {
            customerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}