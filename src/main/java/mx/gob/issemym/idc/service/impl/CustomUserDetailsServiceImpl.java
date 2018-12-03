/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.service.impl;

import java.util.ArrayList;
import java.util.List;
import mx.gob.issemym.idc.constant.Message;
import mx.gob.issemym.idc.persistence.model.CcUser;
import mx.gob.issemym.idc.persistence.repository.CcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan Valdez Jara <Bryan at bryanvaldez.com>
 */
@Service("CustomUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private CcUserRepository ccUserRepository;       
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        CcUser user  = ccUserRepository.findBySMail(userName);
        
        if(user == null){
            throw new UsernameNotFoundException(Message.USER_NO_FOUND);
        }
        
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("role_admin"));
        return new User(userName, user.getSPwd(), roles);
    }
    
}
