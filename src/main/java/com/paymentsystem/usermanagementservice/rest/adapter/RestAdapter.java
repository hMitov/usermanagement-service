package com.paymentsystem.usermanagementservice.rest.adapter;

import com.paymentsystem.usermanagementservice.domain.value.VCustomer;
import com.paymentsystem.usermanagementservice.domain.value.VCustomerData;
import com.paymentsystem.usermanagementservice.rest.dto.Customer;
import com.paymentsystem.usermanagementservice.rest.dto.CustomerData;
import org.springframework.stereotype.Component;

@Component
public class RestAdapter {
    public VCustomerData convertDtoToValue(CustomerData data) {

        VCustomerData vData = new VCustomerData();

        vData.setFirstName(data.getFirstName());
        vData.setLastName(data.getLastName());
        vData.setAge(data.getAge());
        vData.setGender(data.getGender());
        vData.setCountry(data.getCountry());
        vData.setCity(data.getCity());
        vData.setNameOfStreet(data.getNameOfStreet());
        vData.setNumberOfBuilding(data.getNumberOfBuilding());
        vData.setPostCode(data.getPostCode());
        vData.setTelephone(data.getTelephone());
        vData.setEmail(data.getEmail());

        return vData;
    }

    public Customer convertValueToDto(VCustomer vCustomer) {

        Customer customer = new Customer();
        CustomerData customerData = new CustomerData();

        customerData.setFirstName(vCustomer.getData().getFirstName());
        customerData.setLastName(vCustomer.getData().getLastName());
        customerData.setAge(vCustomer.getData().getAge());
        customerData.setGender(vCustomer.getData().getGender());
        customerData.setCountry(vCustomer.getData().getCountry());
        customerData.setCity(vCustomer.getData().getCity());
        customerData.setNameOfStreet(vCustomer.getData().getNameOfStreet());
        customerData.setNumberOfBuilding(vCustomer.getData().getNumberOfBuilding());
        customerData.setPostCode(vCustomer.getData().getPostCode());
        customerData.setTelephone(vCustomer.getData().getTelephone());
        customerData.setEmail(vCustomer.getData().getEmail());

        customer.setId(vCustomer.getId());
        customer.setData(customerData);

        return customer;
    }
}
