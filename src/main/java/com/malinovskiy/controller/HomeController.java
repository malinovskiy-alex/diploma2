package com.malinovskiy.controller;

import java.security.Principal;

import com.malinovskiy.model.AccountRepository;
import com.malinovskiy.model.ClusterRepository;
import com.malinovskiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@Autowired
	private ClusterRepository clientOrderRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		return principal!=null?"home/homeSignedIn":"home/homeNotSignedIn";
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "home/contact";
	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(HttpServletRequest request,
						HttpServletResponse response) {
		request.setAttribute("addrs",clientOrderRepository.findAll());
		return "home/about";
	}

}
