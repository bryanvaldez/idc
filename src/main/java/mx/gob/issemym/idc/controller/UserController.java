/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.controller;

import java.security.Principal;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import mx.gob.issemym.idc.controller.message.UserMessageResponse;
import mx.gob.issemym.idc.persistence.model.CcUser;
import mx.gob.issemym.idc.persistence.model.User;
import mx.gob.issemym.idc.service.UserService;
import mx.gob.issemym.idc.service.dto.CcUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan Luis Valdez Jara <ibryan.valdez@gmail.com>
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/user/create")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//    }

    @PostMapping(value="/user/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserMessageResponse saveCourse(@RequestBody CcUserDTO user){
        UserMessageResponse message = new UserMessageResponse();
        try {
            //userService.saveCourse(user);
            message.setCode(1);
            message.setMessage("The user was saved successfully");
        } catch (Exception e) {
            message.setCode(-1);
            message.setMessage("There was as error");
            message.setError(e.getMessage());
        }
        return message;        
    }    
    
}
