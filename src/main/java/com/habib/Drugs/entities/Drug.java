package com.habib.Drugs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrug;
    private String name;
    private Double dosage;
    private Date dateCreation;
    public Drug() {
        super();
    }
    public Drug(String name, Double dosage, Date dateCreation) {
        super();
        this.name = name;
        this.dosage = dosage;
        this.dateCreation = dateCreation;
    }
    public Long getIdDrug() {
        return idDrug;
    }
    public void setIdDrug(Long idDrug) {
        this.idDrug = idDrug;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getDosage() {
        return dosage;
    }
    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    @Override
    public String toString() {
        return "Drug [idDrug=" + idDrug + ", name=" + name + ", dosage=" + dosage
                + ", dateCreation=" + dateCreation + "]";
    }

}
