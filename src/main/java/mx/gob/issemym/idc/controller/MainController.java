/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Bryan Luis Valdez Jara <ibryan.valdez@gmail.com>
 */
@Controller
public class MainController {
    
    @GetMapping("/")
    public String getRoot(){

        return "/main";
    }
    
    @GetMapping("/popup/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return "popup/"+page;   
    }      
}
