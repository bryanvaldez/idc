/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.persistence.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CC_Perfiles", schema = "dbo", catalog = "issemym")
public class CcPerfiles implements java.io.Serializable {

	private BigDecimal NPerfilesId;
	private String SPerfilDes;
	private BigDecimal NCaccountId;
	private Date DCfechaHora;
	private BigDecimal NMaccountId;
	private Date DMfechaHora;
	private Set<CcValidacion> ccValidacions = new HashSet<CcValidacion>(0);
	private Set<CcTipo> ccTipos = new HashSet<CcTipo>(0);
	private Set<CcUser> ccUsers = new HashSet<CcUser>(0);

	public CcPerfiles() {
	}

	public CcPerfiles(String SPerfilDes, BigDecimal NCaccountId, Date DCfechaHora, BigDecimal NMaccountId,
			Date DMfechaHora, Set<CcValidacion> ccValidacions, Set<CcTipo> ccTipos, Set<CcUser> ccUsers) {
		this.SPerfilDes = SPerfilDes;
		this.NCaccountId = NCaccountId;
		this.DCfechaHora = DCfechaHora;
		this.NMaccountId = NMaccountId;
		this.DMfechaHora = DMfechaHora;
		this.ccValidacions = ccValidacions;
		this.ccTipos = ccTipos;
		this.ccUsers = ccUsers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "N_PerfilesID", unique = true, nullable = false, scale = 0)
	public BigDecimal getNPerfilesId() {
		return this.NPerfilesId;
	}

	public void setNPerfilesId(BigDecimal NPerfilesId) {
		this.NPerfilesId = NPerfilesId;
	}

	@Column(name = "S_PerfilDes", length = 60)
	public String getSPerfilDes() {
		return this.SPerfilDes;
	}

	public void setSPerfilDes(String SPerfilDes) {
		this.SPerfilDes = SPerfilDes;
	}

	@Column(name = "N_CAccountID", scale = 0)
	public BigDecimal getNCaccountId() {
		return this.NCaccountId;
	}

	public void setNCaccountId(BigDecimal NCaccountId) {
		this.NCaccountId = NCaccountId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_CFechaHora", length = 23)
	public Date getDCfechaHora() {
		return this.DCfechaHora;
	}

	public void setDCfechaHora(Date DCfechaHora) {
		this.DCfechaHora = DCfechaHora;
	}

	@Column(name = "N_MAccountID", scale = 0)
	public BigDecimal getNMaccountId() {
		return this.NMaccountId;
	}

	public void setNMaccountId(BigDecimal NMaccountId) {
		this.NMaccountId = NMaccountId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_MFechaHora", length = 23)
	public Date getDMfechaHora() {
		return this.DMfechaHora;
	}

	public void setDMfechaHora(Date DMfechaHora) {
		this.DMfechaHora = DMfechaHora;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ccPerfiles")
	public Set<CcValidacion> getCcValidacions() {
		return this.ccValidacions;
	}

	public void setCcValidacions(Set<CcValidacion> ccValidacions) {
		this.ccValidacions = ccValidacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ccPerfiles")
	public Set<CcTipo> getCcTipos() {
		return this.ccTipos;
	}

	public void setCcTipos(Set<CcTipo> ccTipos) {
		this.ccTipos = ccTipos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ccPerfiles")
	public Set<CcUser> getCcUsers() {
		return this.ccUsers;
	}

	public void setCcUsers(Set<CcUser> ccUsers) {
		this.ccUsers = ccUsers;
	}

}