/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author mdroot
 */
public class Pharmacien implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPharmacien;
    private String nom;
    private String prenom;
    private Date datenais;
    private boolean admin;
    private String motdepasse;
    private Collection<Livraison> livraisonCollection;
    private Collection<Commande> commandeCollection;
    private Collection<Vente> venteCollection;

    public Pharmacien() {
    }

    public Pharmacien(Integer idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    public Pharmacien(Integer idPharmacien, String nom, String prenom, Date datenais, boolean admin, String motdepasse) {
        this.idPharmacien = idPharmacien;
        this.nom = nom;
        this.prenom = prenom;
        this.datenais = datenais;
        this.admin = admin;
        this.motdepasse = motdepasse;
    }

    public Integer getIdPharmacien() {
        return idPharmacien;
    }

    public void setIdPharmacien(Integer idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenais() {
        return datenais;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @XmlTransient
    public Collection<Livraison> getLivraisonCollection() {
        return livraisonCollection;
    }

    public void setLivraisonCollection(Collection<Livraison> livraisonCollection) {
        this.livraisonCollection = livraisonCollection;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @XmlTransient
    public Collection<Vente> getVenteCollection() {
        return venteCollection;
    }

    public void setVenteCollection(Collection<Vente> venteCollection) {
        this.venteCollection = venteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPharmacien != null ? idPharmacien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pharmacien)) {
            return false;
        }
        Pharmacien other = (Pharmacien) object;
        if ((this.idPharmacien == null && other.idPharmacien != null) || (this.idPharmacien != null && !this.idPharmacien.equals(other.idPharmacien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pharmacien[ idPharmacien=" + idPharmacien + " ]";
    }
     public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Pharmacien.xml"));
        Element racine = doc.getRootElement();
        List pharmaciens = racine.getChildren();
        Iterator i = pharmaciens.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id Pharmacien :" + el.getAttributeValue("idPharmacien"));
            System.out.println("nom Pharmacien :" + el.getAttributeValue("nom"));
            System.out.println("prenom Pharmacien :" + el.getAttributeValue("prenom"));
        }
        return pharmaciens;
    }
     public Pharmacien recherche(Integer idPharmacien_r)
            throws JDOMException, IOException {
          Pharmacien p = new Pharmacien();
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Pharmacien.xml"));
        Element racine = doc.getRootElement();
        List pharmacien = racine.getChildren();
        Iterator i = pharmacien.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idPharmacien");
            if (id.equals(idPharmacien_r)) {
               
                p.idPharmacien = Integer.parseInt(el.getAttributeValue("idPharmacien"));
                p.nom = el.getAttributeValue("nom");
                p.prenom = el.getAttributeValue("prenom");
                
           
            }
        }
        return p;
    }
}
