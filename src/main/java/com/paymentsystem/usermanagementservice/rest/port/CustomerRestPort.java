package com.paymentsystem.usermanagementservice.rest.port;

import com.paymentsystem.usermanagementservice.domain.services.CustomerDomainService;
import com.paymentsystem.usermanagementservice.domain.value.VCustomerData;
import com.paymentsystem.usermanagementservice.rest.adapter.RestAdapter;
import com.paymentsystem.usermanagementservice.rest.dto.Customer;
import com.paymentsystem.usermanagementservice.rest.dto.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerRestPort {

    @Autowired
    private RestAdapter restAdapter;

    @Autowired
    private CustomerDomainService customerDomainService;

    public Customer createCustomer(CustomerData dataDto) throws Exception {
        VCustomerData vData = restAdapter.convertDtoToValue(dataDto);
        return restAdapter.convertValueToDto(customerDomainService.createCustomer(vData));
    }

    public Customer getCustomer(Long id) throws Exception {
        return restAdapter.convertValueToDto(customerDomainService.getCustomer(id));
    }

    public List<Customer> getAllCustomers() {
        return customerDomainService.getAllCustomers().stream()
                .map(this.restAdapter::convertValueToDto)
                .collect(Collectors.toList());
    }

    public Customer updateCustomer(CustomerData dataDto) throws Exception {
        VCustomerData vData = restAdapter.convertDtoToValue(dataDto);
        return restAdapter.convertValueToDto(customerDomainService.updateCustomer(vData));
    }

    public void deleteCustomer(Long id) {
        customerDomainService.deleteCustomer(id);
    }

}
