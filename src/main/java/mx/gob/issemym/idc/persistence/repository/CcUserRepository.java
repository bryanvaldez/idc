/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.persistence.repository;

import java.math.BigDecimal;
import mx.gob.issemym.idc.persistence.model.CcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface CcUserRepository extends JpaRepository<CcUser, BigDecimal> {

    CcUser findBySMail(String email);
}
