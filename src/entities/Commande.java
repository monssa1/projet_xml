/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author mdroot
 */
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idCommande;
    private Date dateCommande;
    private Pharmacien idPharmacien;
    private Fournisseur idFournisseur;

    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, Date dateCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Pharmacien getIdPharmacien() {
        return idPharmacien;
    }

    public void setIdPharmacien(Pharmacien idPharmacien) {
        this.idPharmacien = idPharmacien;
    }

    public Fournisseur getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Fournisseur idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    public Commande(Integer idCommande, Date dateCommande, Pharmacien idPharmacien, Fournisseur idFournisseur) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.idPharmacien = idPharmacien;
        this.idFournisseur = idFournisseur;
    }

    @Override
    public String toString() {
        return "entities.Commande[ idCommande=" + idCommande + " ]";
    }
    public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("commande.xml"));
        Element racine = doc.getRootElement();
        List commande = racine.getChildren();
        Iterator i = commande.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id :" + el.getAttributeValue("idCommande"));
            System.out.println("date Commande  :" + el.getAttributeValue("dateCommande"));
            System.out.println("Id Pharmacien  :" + el.getAttributeValue("idPharmacien"));
        }
        return commande;
    }

    public void ajouter(Commande c) throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("commande.xml"));
        Element racine = doc.getRootElement();
        Element el = new Element("etudiant");
        racine.addContent(el);
        el.setAttribute("idCommande", Integer.toString(c.idCommande));
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateCommandeString = df.format(c.dateCommande);
        el.setAttribute("dateCommande", dateCommandeString);
        el.setAttribute("idFournisseur", Integer.toString(c.idFournisseur.getIdFournisseur()));
        el.setAttribute("idPharmacien", Integer.toString(c.idPharmacien.getIdPharmacien()));
        
        doc.setContent(racine);
        try {
            FileWriter writer = new FileWriter("commande.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception exception) {
        }

    }

    public void supprimer(String id_r) throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("commande.xml"));
        Element racine = doc.getRootElement();
        List commande = racine.getChildren();
        Iterator i = commande.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idCommande");
            if (id.equals(id_r)) {
                boolean b = el.getParentElement().removeContent(el);
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("commande.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }

    public void modifier(Integer idCommande, Date dateCommande, Pharmacien idPharmacien, Fournisseur idFournisseur)
            throws JDOMException, IOException {

                String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("commande.xml"));
        Element racine = doc.getRootElement();
        List commande = racine.getChildren();
        Iterator i = commande.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idCommande");
            if (id.equals(idCommande)) {
                el.setAttribute("dateCommande", df.format(dateCommande));
                el.setAttribute("idPharmacien", Integer.toString(idPharmacien.getIdPharmacien()));
                el.setAttribute("idFournisseur", Integer.toString(idFournisseur.getIdFournisseur()));
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("commande.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }
    /** public Commande recherche(Integer idPharmacien_r)
            throws JDOMException, IOException {

                String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("commande.xml"));
        Element racine = doc.getRootElement();
        List commande = racine.getChildren();
        Iterator i = commande.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idPharmacien");
            if (id.equals(idPharmacien_r)) {
                Commande c = new Commande();
                c.idCommande = Integer.parseInt(el.getAttributeValue("idPharmacien"));
                c.idFournisseur = el.getAttributeValue("idFournisseur");
                
              return commande 
            }
        }
    }**/
    
}
