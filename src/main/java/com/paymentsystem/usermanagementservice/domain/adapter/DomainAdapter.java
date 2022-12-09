package com.paymentsystem.usermanagementservice.domain.adapter;

import com.paymentsystem.usermanagementservice.domain.entity.Customer;
import com.paymentsystem.usermanagementservice.domain.value.VCustomer;
import com.paymentsystem.usermanagementservice.domain.value.VCustomerData;
import org.springframework.stereotype.Component;

@Component
public class DomainAdapter {

    public VCustomer convertEntityToValue(Customer customer) {

        VCustomer vCustomer = new VCustomer();
        VCustomerData vData = new VCustomerData();

        vData.setFirstName(customer.getFirstName());
        vData.setLastName(customer.getLastName());
        vData.setAge(customer.getAge());
        vData.setGender(customer.getGender());
        vData.setCountry(customer.getAddress().getCountry());
        vData.setCity(customer.getAddress().getCity());
        vData.setNameOfStreet(customer.getAddress().getNameOfStreet());
        vData.setNumberOfBuilding(customer.getAddress().getNumberOfBuilding());
        vData.setPostCode(customer.getAddress().getPostCode());
        vData.setTelephone(customer.getTelephone());
        vData.setEmail(customer.getEmail());

        vCustomer.setId(customer.getId());
        vCustomer.setData(vData);

        return vCustomer;
    }
}
