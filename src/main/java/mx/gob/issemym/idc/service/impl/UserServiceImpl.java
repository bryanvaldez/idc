/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.service.impl;

import mx.gob.issemym.idc.persistence.model.CcUser;
import mx.gob.issemym.idc.persistence.repository.CcUserRepository;
import mx.gob.issemym.idc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private CcUserRepository ccUserRepository;    
    
    @Override
    public CcUser findBySMail(String email) {
        return ccUserRepository.findBySMail(email);
    }

    @Override
    public void saveCourse(CcUser user) {
        ccUserRepository.save(user);
    }
    
}
