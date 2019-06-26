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
import javax.xml.bind.annotation.XmlRootElement;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author mdroot
 */
public class Vente implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idVente;
    private int montant;
    private Date dateVente;
    private Pharmacien idPharmacien;

    public Vente() {
    }

    public Vente(Integer idVente) {
        this.idVente = idVente;
    }

    public Vente(Integer idVente, int montant, Date dateVente) {
        this.idVente = idVente;
        this.montant = montant;
        this.dateVente = dateVente;
    }

    public Integer getIdVente() {
        return idVente;
    }

    public void setIdVente(Integer idVente) {
        this.idVente = idVente;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Pharmacien getIdPharmacien() {
        return idPharmacien;
    }

    public void setIdPharmacien(Pharmacien idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVente != null ? idVente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.idVente == null && other.idVente != null) || (this.idVente != null && !this.idVente.equals(other.idVente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vente[ idVente=" + idVente + " ]";
    }
     public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Vente.xml"));
        Element racine = doc.getRootElement();
        List ventes = racine.getChildren();
        Iterator i = ventes.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id vendeur :" + el.getAttributeValue("idVente"));
            System.out.println("montant :" + el.getAttributeValue("montant"));
            System.out.println("date Vente :" + el.getAttributeValue("dateVente"));
            System.out.println("id Pharmacien :" + el.getAttributeValue("idPharmacien"));
        }
        return ventes;
     }
}
