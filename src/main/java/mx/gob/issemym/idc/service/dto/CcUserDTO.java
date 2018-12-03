/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.service.dto;

import java.math.BigDecimal;
import mx.gob.issemym.idc.persistence.model.CcPerfiles;

/**
 *
 * @author Bryan Valdez Jara <iBryan.valdez@gmail.com>
 */
public class CcUserDTO {
    
    private BigDecimal id;
    private String email;
    private String password;
    private String appat;
    private String apmat;
    private String nombres; 

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

 
        
        
}
