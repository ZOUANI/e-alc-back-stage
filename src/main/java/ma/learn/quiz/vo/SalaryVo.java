package ma.learn.quiz.vo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Month;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import ma.learn.quiz.bean.Prof;
@Entity
public class SalaryVo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
@ManyToOne
private Prof prof;
@JsonFormat(pattern = "yyyy")
private Date annee;
@JsonFormat(pattern = "MM")
private Date mois;
private BigDecimal nbrSessionMensuel;
private BigDecimal nbrSessionGlobale; 
private BigDecimal montantMensuel;
private BigDecimal montantGlobale;
public Prof getProf() {
	return prof;
}
public void setProf(Prof prof) {
	this.prof = prof;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getAnnee() {
	return annee;
}
public void setAnnee(Date annee) {
	this.annee = annee;
}
public Date getMois() {
	return mois;
}
public void setMois(Date mois) {
	this.mois = mois;
}
public BigDecimal getNbrSessionMensuel() {
	return nbrSessionMensuel;
}
public void setNbrSessionMensuel(BigDecimal nbrSessionMensuel) {
	this.nbrSessionMensuel = nbrSessionMensuel;
}
public BigDecimal getNbrSessionGlobale() {
	return nbrSessionGlobale;
}
public void setNbrSessionGlobale(BigDecimal nbrSessionGlobale) {
	this.nbrSessionGlobale = nbrSessionGlobale;
}
public BigDecimal getMontantMensuel() {
	return montantMensuel;
}
public void setMontantMensuel(BigDecimal montantMensuel) {
	this.montantMensuel = montantMensuel;
}
public BigDecimal getMontantGlobale() {
	return montantGlobale;
}
public void setMontantGlobale(BigDecimal montantGlobale) {
	this.montantGlobale = montantGlobale;
}

}
