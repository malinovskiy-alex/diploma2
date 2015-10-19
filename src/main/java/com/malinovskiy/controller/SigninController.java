package com.malinovskiy.controller;

import com.malinovskiy.model.User;
import com.malinovskiy.model.AccountRepository;
import com.malinovskiy.model.SignupForm;
import com.malinovskiy.model.UserService;
import com.malinovskiy.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class SigninController {

	@RequestMapping(value = "signin")
	public String signin() {
        return "signin/signin";
    }

    @Controller
    public static class SignupController {

        private static final String SIGNUP_VIEW_NAME = "signup/signup";

        @Autowired
        private AccountRepository accountRepository;

        @Autowired
        private UserService userService;

        @RequestMapping(value = "signup")
        public String signup(Model model) {
            model.addAttribute(new SignupForm());
            return SIGNUP_VIEW_NAME;
        }

        @RequestMapping(value = "signup", method = RequestMethod.POST)
        public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
            if (errors.hasErrors()) {
                return SIGNUP_VIEW_NAME;
            }
            User user = accountRepository.save(signupForm.createAccount());
            userService.signin(user);
            // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
            MessageHelper.addSuccessAttribute(ra, "signup.success");
            return "redirect:/";
        }
    }
}
