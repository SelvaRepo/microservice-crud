package com.microservice.repository;

import com.microservice.entity.CustomersAccountsEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository("customerAccountRepository")
@Qualifier(value = "customerAccountRepository")
public interface CustomerAccountRepository
        extends JpaRepository<CustomersAccountsEntity, Long> {
 
}
