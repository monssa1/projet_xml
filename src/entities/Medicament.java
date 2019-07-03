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
public class Medicament implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idMedicament;
    private String libelle;
    private String categorie;
    private int prixAchat;
    private int prixVente;
    private int qteStock;
    // private Date datePeremption;

    public Medicament() {
    }

    public Medicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    public Medicament(Integer idMedicament, String libelle, String categorie, int prixAchat, int prixVente, int qteStock) {
        this.idMedicament = idMedicament;
        this.libelle = libelle;
        this.categorie = categorie;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qteStock = qteStock;
        // this.datePeremption = datePeremption;
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

    /**
     * public Date getDatePeremption() { return datePeremption; }
     *
     * public void setDatePeremption(Date datePeremption) { this.datePeremption
     * = datePeremption;
    }*
     */
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

    public void ajouter(Medicament m) throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("medicament.xml"));
        Element racine = doc.getRootElement();
        Element el = new Element("medicament");
        racine.addContent(el);
        el.setAttribute("idMedicament", Integer.toString(m.idMedicament));
        el.setAttribute("libelle", m.libelle);
        el.setAttribute("categorie", m.categorie);
        el.setAttribute("qteStock", Integer.toString(m.qteStock));
        el.setAttribute("prixAchat", Integer.toString(m.prixAchat));
        el.setAttribute("prixVente", Integer.toString(m.prixVente));
        /**
         * String pattern = "MM/dd/yyyy"; DateFormat df = new
         * SimpleDateFormat(pattern); String datePString =
         * df.format(m.datePeremption); el.setAttribute("datePeremption", datePString);*
         */

        doc.setContent(racine);
        try {
            FileWriter writer = new FileWriter("medicament.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception exception) {
        }

    }

    public void modifier(String idM, String libelle, String categorie, int prixAchat, int prixVente, int qteStock)
            throws JDOMException, IOException {

        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("medicament.xml"));
        Element racine = doc.getRootElement();
        List medicament = racine.getChildren();
        Iterator i = medicament.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idMedicament");
            if (id.equals(idM)) {
                el.setAttribute("libelle", libelle);
                el.setAttribute("categorie", categorie);
                /**
                 * String pattern = "MM/dd/yyyy HH:mm:ss"; DateFormat df = new
                 * SimpleDateFormat(pattern); String datePString2 =
                 * df.format(datePeremption); el.setAttribute("datePeremption", datePString2);*
                 */
                el.setAttribute("qteStock", Integer.toString(qteStock));
                el.setAttribute("prixAchat", Integer.toString(prixAchat));
                el.setAttribute("prixVente", Integer.toString(prixVente));

            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("medicament.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }
     public void supprimer(String id_r) throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("medicament.xml"));
        Element racine = doc.getRootElement();
        List medicament = racine.getChildren();
        Iterator i = medicament.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idMedicament");
            if (id.equals(id_r)) {
                boolean b = el.getParentElement().removeContent(el);
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("medicament.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }
}
