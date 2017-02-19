/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declaracion.jurada.vehiculo.controller;

import com.declaracion.jurada.vehiculo.entities.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author RENSO
 */
@Controller()
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap mm) {
        System.out.println("se ejecuto este codigo");
        mm.put("account", new Account());
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "account") Account account, ModelMap mm) {
        if(account.getUsername().equals("rvalencia") && account.getPassword().equals("123456")) {
            mm.put("userName", account.getUsername());
            return "welcome";
        } else {
            mm.put("message", "Account is invalid");
        }
        return "login";
    }
    
}
