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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Bryan Luis Valdez Jara <ibryan.valdez@gmail.com>
 */
public class JwtUtil {
    
    //Algoritmo encrypt
    private static final Algorithm algorithm = Algorithm.HMAC512("secrect"); 
    
    public static void addAuthentication(HttpServletResponse response , String username){
                  
        try {         
            //Firma Usuario
            String token = JWT.create().withIssuer(username).sign(algorithm);
            response.addHeader("Authorization","Bearer " +  token);
        } catch (JWTCreationException e) {
            System.out.println("JWT: " +e);
        }        
        
    }
    
    public static Authentication getAuthentication(HttpServletRequest request){
    
        try {
            //Obtenemos el token del encabezado 
            String token = request.getHeader("Authorization");
            
            if(token != null){
                String user = JWT.require(algorithm).build().verify(token.replace("Bearer ", "")).getIssuer();
                
//                JWTVerifier verifier = JWT.require(algorithm).withIssuer("admin").build();                                
//                DecodedJWT jwt = verifier.verify(token.replace("Bearer ", ""));    
//                String user = jwt.getIssuer();

//https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
                
                
                if(user != null){  
                    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                }                
                return null;
                
            }
            
        } catch (JWTCreationException e) {
        }
        return null;
    }
    
}
