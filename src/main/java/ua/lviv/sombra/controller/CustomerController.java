package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.lviv.sombra.dto.CustomerDto;
import ua.lviv.sombra.entity.Customer;
import ua.lviv.sombra.service.CustomerService;

/**
 * Created by Apple on 05.04.2017.
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/registrationPage",method = RequestMethod.GET)
    public String login(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registration(@RequestBody CustomerDto customerDto){
        Customer customer = new Customer(customerDto.getSurname(), customerDto.getName(), customerDto.getAddress(), customerDto.getPhone(), customerDto.getEmail(), customerDto.getLogin(), customerDto.getPassword());
        customerService.add(customer);
    }

    @RequestMapping(value = "/loginpage", method= RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
}
