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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CC_Tipo", schema = "dbo", catalog = "issemym")
public class CcTipo implements java.io.Serializable {

	private BigDecimal NTipoId;
	private CcPerfiles ccPerfiles;
	private Boolean BTidentificador;
	private String STnombreE;
	private BigDecimal NCaccountId;
	private Date DCfechaHora;
	private BigDecimal NMaccountId;
	private Date DMfechaHora;

	public CcTipo() {
	}

	public CcTipo(CcPerfiles ccPerfiles, Boolean BTidentificador, String STnombreE, BigDecimal NCaccountId,
			Date DCfechaHora, BigDecimal NMaccountId, Date DMfechaHora) {
		this.ccPerfiles = ccPerfiles;
		this.BTidentificador = BTidentificador;
		this.STnombreE = STnombreE;
		this.NCaccountId = NCaccountId;
		this.DCfechaHora = DCfechaHora;
		this.NMaccountId = NMaccountId;
		this.DMfechaHora = DMfechaHora;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "N_TipoID", unique = true, nullable = false, scale = 0)
	public BigDecimal getNTipoId() {
		return this.NTipoId;
	}

	public void setNTipoId(BigDecimal NTipoId) {
		this.NTipoId = NTipoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "N_PerfilesID")
	public CcPerfiles getCcPerfiles() {
		return this.ccPerfiles;
	}

	public void setCcPerfiles(CcPerfiles ccPerfiles) {
		this.ccPerfiles = ccPerfiles;
	}

	@Column(name = "B_Tidentificador")
	public Boolean getBTidentificador() {
		return this.BTidentificador;
	}

	public void setBTidentificador(Boolean BTidentificador) {
		this.BTidentificador = BTidentificador;
	}

	@Column(name = "S_tNombreE", length = 150)
	public String getSTnombreE() {
		return this.STnombreE;
	}

	public void setSTnombreE(String STnombreE) {
		this.STnombreE = STnombreE;
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