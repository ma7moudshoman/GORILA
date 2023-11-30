package com.example.gorilla.Controller;


import com.example.gorilla.DTO.CustomerDTO;
import com.example.gorilla.DTO.DateRange;
import com.example.gorilla.Model.Customer;
import com.example.gorilla.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

//       GET http://localhost:5050/api/home
    @GetMapping("/home")
    public String findAll(Model model){
        model.addAttribute("customers",customerService.findAllCustomer());
        model.addAttribute("DateRange",new DateRange());
        return "home";
    }
    public Customer findById(@PathVariable Long id){

        return customerService.findById(id).get();
    }
//       GET http://localhost:5050/api/addCustomer

    @GetMapping("/addCustomer")
    public String productGet(Model model){

     model.addAttribute("dto",new Customer());
    model.addAttribute("customers",customerService.findAllCustomer());
     return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute ("dto") CustomerDTO dto , Model model ){

        Customer c=new Customer();
        c.setId(dto.getId());
        c.setFirstName(dto.getFirstname());
        c.setLastName(dto.getLastname());
        c.setEmail(dto.getEmail());
        c.setPrice(dto.getPrice());
       c.setDate(dto.getDate());
        customerService.addcustomer(c);


        return "redirect:/api/home";
    }

    @GetMapping("/update")      //("/update/{id}")
    public  String updateCustomer(@PathVariable Long id ,Model model){


        Customer c=customerService.findById(id).get();
        CustomerDTO dto=new CustomerDTO();
        dto.setId(c.getId());
        dto.setFirstname(c.getFirstName());
        dto.setLastname(c.getLastName());
        dto.setEmail(c.getEmail());
        dto.setPrice(c.getPrice());
        dto.setDate(c.getDate());

        model.addAttribute("customers",customerService.findAllCustomer());
        model.addAttribute("dto" ,dto);

        return "addCustomer";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@PathVariable Long id){

        customerService.deleteById(id);
        return "redirect:/api/home";
    }

    @PostMapping("/GetCustomer")
    public String getCustomerByDate( Model model, @ModelAttribute DateRange dateRange) {



        System.out.println(dateRange.getStartDade());


        List<Customer> c=customerService.getCustomerByIDate(dateRange.getStartDade(),dateRange.getEndDate());

        model.addAttribute("customers",c);
        model.addAttribute("DateRange",new DateRange());
        return "home";

    }





}
