/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.service;

import java.util.List;
import mx.gob.issemym.idc.persistence.model.CcUser;
import mx.gob.issemym.idc.service.dto.CcUserDTO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface UserService{    
    CcUser findBySMail(String email);     
    void save(CcUser user);  
    List<CcUser> findAllUsers();
}
