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
public class Livraison implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idLivraison;
    private Date dateLivraison;
    private Pharmacien idPharmacien;

    public Livraison() {
    }

    public Livraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Integer getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
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
        hash += (idLivraison != null ? idLivraison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idLivraison == null && other.idLivraison != null) || (this.idLivraison != null && !this.idLivraison.equals(other.idLivraison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Livraison[ idLivraison=" + idLivraison + " ]";
    }
   public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Vente.xml"));
        Element racine = doc.getRootElement();
        List livraisons = racine.getChildren();
        Iterator i = livraisons.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id Livraison :" + el.getAttributeValue("idLivraison"));
            System.out.println("date Livraison :" + el.getAttributeValue("dateLivraison"));
            System.out.println("id Pharmacien :" + el.getAttributeValue("idPharmacien"));
        }
        return livraisons;
     } 
}
