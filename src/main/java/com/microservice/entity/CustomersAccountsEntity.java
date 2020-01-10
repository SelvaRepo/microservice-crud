/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author SSundaramoorthy
 */
@Entity
@Table(name = "bank_customers_accounts")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@cust_acc_id")
@Setter
@Getter
@ToString
public class CustomersAccountsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_acc_id")
    private long custAccId;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private CustomerEntity customerEntity;    
    
    @Column(name = "customer_account_no")
    private String accountNo;
    
    @Column(name = "customer_account_balance")
    private String accountBalance;    
    
    @Column(name = "create_user", length = 45)
    private String createUser="SYS_USER";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 19)
    private Date createDate = new Date();

    @Column(name = "last_update_user", length = 45)
    private String lastUpdateUser="SYS_USER";

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 19)
    private Date lastUpdateDate = new Date();   
}
