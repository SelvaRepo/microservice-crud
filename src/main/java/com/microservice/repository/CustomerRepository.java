package com.microservice.repository;

import com.microservice.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository("customerRepository")
@Qualifier(value = "customerRepository")
public interface CustomerRepository
        extends JpaRepository<CustomerEntity, Long> {
 
}
