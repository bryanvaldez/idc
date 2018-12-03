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
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CC_Validacion", schema = "dbo", catalog = "issemym")
public class CcValidacion implements java.io.Serializable {

	private BigDecimal NValidaId;
	private CcPerfiles ccPerfiles;
	private String SVcodigo;
	private Boolean BVactivo;
	private BigDecimal NCaccountId;
	private Date DCfechaHora;
	private BigDecimal NMaccountId;
	private Date DMfechaHora;

	public CcValidacion() {
	}

	public CcValidacion(CcPerfiles ccPerfiles, String SVcodigo, Boolean BVactivo, BigDecimal NCaccountId,
			Date DCfechaHora, BigDecimal NMaccountId, Date DMfechaHora) {
		this.ccPerfiles = ccPerfiles;
		this.SVcodigo = SVcodigo;
		this.BVactivo = BVactivo;
		this.NCaccountId = NCaccountId;
		this.DCfechaHora = DCfechaHora;
		this.NMaccountId = NMaccountId;
		this.DMfechaHora = DMfechaHora;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "N_ValidaID", unique = true, nullable = false, scale = 0)
	public BigDecimal getNValidaId() {
		return this.NValidaId;
	}

	public void setNValidaId(BigDecimal NValidaId) {
		this.NValidaId = NValidaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_PerfilesID")
	public CcPerfiles getCcPerfiles() {
		return this.ccPerfiles;
	}

	public void setCcPerfiles(CcPerfiles ccPerfiles) {
		this.ccPerfiles = ccPerfiles;
	}

	@Column(name = "S_vCodigo", length = 5)
	public String getSVcodigo() {
		return this.SVcodigo;
	}

	public void setSVcodigo(String SVcodigo) {
		this.SVcodigo = SVcodigo;
	}

	@Column(name = "B_vActivo")
	public Boolean getBVactivo() {
		return this.BVactivo;
	}

	public void setBVactivo(Boolean BVactivo) {
		this.BVactivo = BVactivo;
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
