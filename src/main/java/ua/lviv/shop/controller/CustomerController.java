package ua.lviv.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.shop.dto.CustomerDto;
import ua.lviv.shop.entity.Customer;
import ua.lviv.shop.service.CustomerService;

/**
 * Created by Apple on 05.04.2017.
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registrationCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getSurname(), customerDto.getName(), customerDto.getAddress(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getLogin(), customerDto.getPassword());
        customerService.add(customer);
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }
}
