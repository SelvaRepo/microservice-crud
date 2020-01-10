package com.microservice.web;

import com.microservice.entity.CustomerEntity;
import com.microservice.exception.RecordNotFoundException;
import com.microservice.service.EmployeeService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@Log4j2
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllEmployees() {
        List<CustomerEntity> list = service.getAllEmployees();
        list.forEach((temp) -> {
            log.info("::::" + temp.getCustomerFirstName());
            
            temp.getCustAccountSet().forEach((account) -> {
                log.info("::::" + account.getAccountNo());
            });
        });
        
        return new ResponseEntity<List<CustomerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        CustomerEntity entity = service.getEmployeeById(id);

        return new ResponseEntity<CustomerEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createOrUpdateEmployee(@RequestBody CustomerEntity employee)
            throws RecordNotFoundException {
        //employee.setId(new Long(4));
        //employee.setFirstName("aaaa");
        //employee.setLastName("Siddhu1111");
        //employee.setEmail("Siddhu11111");
        
        log.info("createOrUpdateEmployee:" +employee);
        CustomerEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<CustomerEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
