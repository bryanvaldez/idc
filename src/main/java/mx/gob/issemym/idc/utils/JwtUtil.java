/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.gob.issemym.idc.constant.SecurityConstants;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Bryan Luis Valdez Jara <ibryan.valdez@gmail.com>
 */
public class JwtUtil {
    
    private static final Algorithm algorithm = Algorithm.HMAC512(SecurityConstants.SECRET); 
    
    public static void addAuthentication(HttpServletResponse response , String username){
                  
        try {         
            String token = JWT.create().withIssuer(username).sign(algorithm);
            response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX +  token);
        } catch (JWTCreationException e) {
            System.out.println("JWT: " +e);
        }        
        
    }
    
    public static Authentication getAuthentication(HttpServletRequest request){
    
        try { 
            String token = request.getHeader(SecurityConstants.HEADER_STRING);            
            if(token != null){
                String user = JWT.require(algorithm).build().verify(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getIssuer();
                
                if(user != null){  
                    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                }                
                return null;                
            }
            
        } catch (JWTCreationException e) {
            System.out.println("JWT: " +e);
        }
        return null;
    }
    
}
