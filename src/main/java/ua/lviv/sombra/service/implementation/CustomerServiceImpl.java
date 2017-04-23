package ua.lviv.sombra.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.sombra.dao.CustomerDao;
import ua.lviv.sombra.entity.Customer;
import ua.lviv.sombra.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 05.04.2017.
 */
@Service("userDetailService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    @Autowired
    CustomerDao customerDao;
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    public void edit(int id,String surname, String name, String address, String phone, String email, String login, String password) {
        Customer customer = customerDao.findById(id);
        if(surname!=null && !surname.equals(""))
        {
            customer.setSurname(surname);
        }
        if(name!=null && !name.equals(""))
        {
            customer.setName(name);
        }
        if(address!=null && !address.equals(""))
        {
            customer.setAddress(address);
        }
        if(phone!=null && !phone.equals(""))
        {
            customer.setPhone(phone);
        }
        if(email!=null && !email.equals(""))
        {
            customer.setEmail(email);
        }
        if(login!=null && !login.equals(""))
        {
            customer.setLogin(login);
        }
        if(password!=null && !password.equals(""))
        {
            customer.setPassword(password);
        }
        customerDao.edit(customer);
    }

    public void delete(int id) {
        customerDao.delete(customerDao.findById(id));
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    public Customer findByLogin(String login) {
        return customerDao.findByLogin(login);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = customerDao.findByLogin(login);
        List<SimpleGrantedAuthority> authorityList=new ArrayList<SimpleGrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(customer.getLogin(),customer.getPassword(),authorityList);
    }
}
