package com.malinovskiy.controller;

import com.malinovskiy.model.Address;
import com.malinovskiy.model.ClientOrder;
import com.malinovskiy.model.ClientOrderRepository;
import com.malinovskiy.model.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Александр on 14.12.2014.
 */
//Done with credentials
@Controller
//@Secured("ROLE_ADMIN")
public class ClusterController {
    @Autowired
    private ClusterRepository clientOrderRepository;

    @RequestMapping(value = "/clusters", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Address> addresses() {
        return clientOrderRepository.findAll();
    }

    @RequestMapping(value = "/clusters", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Address createOrder(@RequestBody Address order){
       return clientOrderRepository.save(order);
    }

}
