/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author mdroot
 */
public class Medicament implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idMedicament;
    private String libelle;
    private String categorie;
    private int prixAchat;
    private int prixVente;
    private int qteStock;
    private Date datePeremption;

    public Medicament() {
    }

    public Medicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    public Medicament(Integer idMedicament, String libelle, String categorie, int prixAchat, int prixVente, int qteStock, Date datePeremption) {
        this.idMedicament = idMedicament;
        this.libelle = libelle;
        this.categorie = categorie;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qteStock = qteStock;
        this.datePeremption = datePeremption;
    }

    public Integer getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicament != null ? idMedicament.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if ((this.idMedicament == null && other.idMedicament != null) || (this.idMedicament != null && !this.idMedicament.equals(other.idMedicament))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medicament[ idMedicament=" + idMedicament + " ]";
    }
     public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("medicament.xml"));
        Element racine = doc.getRootElement();
        List medicaments = racine.getChildren();
        Iterator i = medicaments.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id Medicament :" + el.getAttributeValue("idMedicament"));
            System.out.println("labelle :" + el.getAttributeValue("labelle"));
            System.out.println("categorie  :" + el.getAttributeValue("categorie"));
            System.out.println("qteStock  :" + el.getAttributeValue("qteStock"));
            System.out.println("prix Achat  :" + el.getAttributeValue("prixAchat"));
            System.out.println("prix Vente  :" + el.getAttributeValue("prixVente"));
        }
        return medicaments;
    }
}
