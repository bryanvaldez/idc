/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.service;

import mx.gob.issemym.idc.persistence.model.CcUser;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UserService{    
    CcUser findBySMail(String email);     
    void saveCourse(CcUser user);  
}
