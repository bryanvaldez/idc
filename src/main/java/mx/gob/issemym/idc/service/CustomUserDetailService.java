///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package mx.gob.issemym.idc.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import mx.gob.issemym.idc.constant.Message;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Bryan Valdez Jara <Bryan at ibryan.valdez@gmail.com>
// */
//@Service("customUserDetailsService")
//public class CustomUserDetailService implements UserDetailsService{
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        
//        if(userName == null){
//            throw new UsernameNotFoundException(Message.USER_NO_FOUND);
//        }
//        
//        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new User(userName, "ADMIN", roles);
//    }
//    
//}
