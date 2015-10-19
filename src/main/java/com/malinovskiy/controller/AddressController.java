package com.malinovskiy.controller;

import com.malinovskiy.model.ClientOrder;
import com.malinovskiy.model.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Александр on 14.12.2014.
 */
//Done with credentials
@Controller
//@Secured("ROLE_ADMIN")
public class AddressController {
    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ClientOrder> addresses() {
        return clientOrderRepository.findAll();
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ClientOrder createOrder(@RequestBody ClientOrder order){
       return clientOrderRepository.save(order);
    }

}
