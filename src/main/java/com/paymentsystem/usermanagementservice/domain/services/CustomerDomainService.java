package com.paymentsystem.usermanagementservice.domain.services;

import com.paymentsystem.usermanagementservice.domain.adapter.DomainAdapter;
import com.paymentsystem.usermanagementservice.domain.entity.Address;
import com.paymentsystem.usermanagementservice.domain.entity.Customer;
import com.paymentsystem.usermanagementservice.domain.repository.CustomerRepository;
import com.paymentsystem.usermanagementservice.domain.value.VCustomer;
import com.paymentsystem.usermanagementservice.domain.value.VCustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDomainService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DomainAdapter domainAdapter;

    public VCustomer createCustomer(VCustomerData data) throws Exception {

        Customer customer = customerRepository.findByEmail(data.getEmail());

        if (customer != null) {
            throw new Exception("Already exists in db");
        }


        Address address = new Address();
        address.setCountry(data.getCountry());
        address.setCity(data.getCity());
        address.setNameOfStreet(data.getNameOfStreet());
        address.setNumberOfBuilding(data.getNumberOfBuilding());
        address.setPostCode(data.getPostCode());

        customer = new Customer();

        customer.setFirstName(data.getFirstName());
        customer.setLastName(data.getLastName());
        customer.setAge(data.getAge());
        customer.setGender(data.getGender());
        customer.setAddress(address);
        customer.setTelephone(data.getTelephone());
        customer.setEmail(data.getEmail());

        return domainAdapter.convertEntityToValue(customerRepository.save(customer));
    }

    public List<VCustomer> getAllCustomers() {
        return customerRepository.findAll().stream().map(this.domainAdapter::convertEntityToValue).collect(Collectors.toList());
    }

    public VCustomer getCustomer(Long id) throws Exception {
        return domainAdapter.convertEntityToValue(customerRepository.findById(id).orElseThrow(() -> new Exception("Not such a customer")));
    }

    public VCustomer updateCustomer(VCustomerData data) throws Exception {

        Customer customer = customerRepository.findByEmail(data.getEmail());

        if (customer == null) {
            customer = new Customer();
        }

        Address address = new Address();
        address.setCountry(data.getCountry());
        address.setCity(data.getCity());
        address.setNameOfStreet(data.getNameOfStreet());
        address.setNumberOfBuilding(data.getNumberOfBuilding());
        address.setPostCode(data.getPostCode());

        customer.setFirstName(data.getFirstName());
        customer.setLastName(data.getLastName());
        customer.setAge(data.getAge());
        customer.setGender(data.getGender());
        customer.setAddress(address);
        customer.setTelephone(data.getTelephone());
        customer.setEmail(data.getEmail());

        return domainAdapter.convertEntityToValue(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}

