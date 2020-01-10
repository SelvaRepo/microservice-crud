package com.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bank_customers")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@customer_id")
@Setter
@Getter
@ToString
public class CustomerEntity {

    public CustomerEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "customer_email_id")
    private String customerEmailId;

    @Column(name = "customer_mobile_no")
    private String customerMobileNo;

    @Column(name = "customer_home_address")
    private String customerHomeaddress;
    
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

    //@JsonIgnore
    //@JsonBackReference
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerEntity")
    private Set<CustomersAccountsEntity> custAccountSet = new HashSet<CustomersAccountsEntity>(0);
}
