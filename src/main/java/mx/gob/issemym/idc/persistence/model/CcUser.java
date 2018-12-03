/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.persistence.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author User
 */
@Entity
@NamedQuery(name = "CcUser.findBySMail",  query = "select u from CcUser u where u.SMail = :email")
@Table(name = "CC_User", schema = "dbo", catalog = "issemym", uniqueConstraints = @UniqueConstraint(columnNames = "S_Pwd"))
public class CcUser implements java.io.Serializable {

	private BigDecimal NUserId;
	private CcPerfiles ccPerfiles;
	private String SMail;
	private String SPwd;
	private String SApaterno;
	private String SAmaterno;
	private String SNombres;
	private String SDireccion;
	private String STmovil;
	private String STelefono;
	private Boolean BNuevoPwd;
	private Boolean BActiva;
	private BigDecimal NCaccountId;
	private Date DCfechaHora;
	private BigDecimal NMaccountId;
	private Date DMfechaHora;

	public CcUser() {
	}

	public CcUser(CcPerfiles ccPerfiles, String SMail, String SPwd, String SApaterno, String SAmaterno, String SNombres,
			String SDireccion, String STmovil, String STelefono, Boolean BNuevoPwd, Boolean BActiva,
			BigDecimal NCaccountId, Date DCfechaHora, BigDecimal NMaccountId, Date DMfechaHora) {
		this.ccPerfiles = ccPerfiles;
		this.SMail = SMail;
		this.SPwd = SPwd;
		this.SApaterno = SApaterno;
		this.SAmaterno = SAmaterno;
		this.SNombres = SNombres;
		this.SDireccion = SDireccion;
		this.STmovil = STmovil;
		this.STelefono = STelefono;
		this.BNuevoPwd = BNuevoPwd;
		this.BActiva = BActiva;
		this.NCaccountId = NCaccountId;
		this.DCfechaHora = DCfechaHora;
		this.NMaccountId = NMaccountId;
		this.DMfechaHora = DMfechaHora;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "N_UserID", unique = true, nullable = false, scale = 0)
	public BigDecimal getNUserId() {
		return this.NUserId;
	}

	public void setNUserId(BigDecimal NUserId) {
		this.NUserId = NUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_PerfilesID")
	public CcPerfiles getCcPerfiles() {
		return this.ccPerfiles;
	}

	public void setCcPerfiles(CcPerfiles ccPerfiles) {
		this.ccPerfiles = ccPerfiles;
	}

	@Column(name = "S_Mail", length = 110)
	public String getSMail() {
		return this.SMail;
	}

	public void setSMail(String SMail) {
		this.SMail = SMail;
	}

	@Column(name = "S_Pwd", unique = true, length = 50)
	public String getSPwd() {
		return this.SPwd;
	}

	public void setSPwd(String SPwd) {
		this.SPwd = SPwd;
	}

	@Column(name = "S_Apaterno", length = 80)
	public String getSApaterno() {
		return this.SApaterno;
	}

	public void setSApaterno(String SApaterno) {
		this.SApaterno = SApaterno;
	}

	@Column(name = "S_Amaterno", length = 80)
	public String getSAmaterno() {
		return this.SAmaterno;
	}

	public void setSAmaterno(String SAmaterno) {
		this.SAmaterno = SAmaterno;
	}

	@Column(name = "S_Nombres", length = 80)
	public String getSNombres() {
		return this.SNombres;
	}

	public void setSNombres(String SNombres) {
		this.SNombres = SNombres;
	}

	@Column(name = "S_Direccion", length = 100)
	public String getSDireccion() {
		return this.SDireccion;
	}

	public void setSDireccion(String SDireccion) {
		this.SDireccion = SDireccion;
	}

	@Column(name = "S_TMovil", length = 20)
	public String getSTmovil() {
		return this.STmovil;
	}

	public void setSTmovil(String STmovil) {
		this.STmovil = STmovil;
	}

	@Column(name = "S_Telefono", length = 20)
	public String getSTelefono() {
		return this.STelefono;
	}

	public void setSTelefono(String STelefono) {
		this.STelefono = STelefono;
	}

	@Column(name = "B_NuevoPwd")
	public Boolean getBNuevoPwd() {
		return this.BNuevoPwd;
	}

	public void setBNuevoPwd(Boolean BNuevoPwd) {
		this.BNuevoPwd = BNuevoPwd;
	}

	@Column(name = "B_Activa")
	public Boolean getBActiva() {
		return this.BActiva;
	}

	public void setBActiva(Boolean BActiva) {
		this.BActiva = BActiva;
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

}