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
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author mdroot
 */
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idFournisseur;
    private String nomfournisseur;
    private String adresse;
    private Collection<Commande> commandeCollection;

    public Fournisseur() {
    }

    public Fournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Fournisseur(Integer idFournisseur, String nomfournisseur, String adresse) {
        this.idFournisseur = idFournisseur;
        this.nomfournisseur = nomfournisseur;
        this.adresse = adresse;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Fournisseur(Integer idFournisseur, String nomfournisseur, String adresse, Collection<Commande> commandeCollection) {
        this.idFournisseur = idFournisseur;
        this.nomfournisseur = nomfournisseur;
        this.adresse = adresse;
        this.commandeCollection = commandeCollection;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFournisseur != null ? idFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idFournisseur == null && other.idFournisseur != null) || (this.idFournisseur != null && !this.idFournisseur.equals(other.idFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fournisseur[ idFournisseur=" + idFournisseur + " ]";
    }
     public List affiche() throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Fournisseur.xml"));
        Element racine = doc.getRootElement();
        List fournisseurs = racine.getChildren();
        Iterator i = fournisseurs.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            System.out.println("id fournisseur :" + el.getAttributeValue("idFournisseur"));
            System.out.println("nom Fournisseur :" + el.getAttributeValue("nomfournisseur"));
            System.out.println("adresse Fournisseur :" + el.getAttributeValue("adresse"));
        }
        return fournisseurs;
    }
 public Fournisseur recherche(int id_Fournissuer)
            throws JDOMException, IOException {
        Fournisseur f = new Fournisseur();
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Fournisseur.xml"));
        Element racine = doc.getRootElement();
        List fournisseurs = racine.getChildren();
        Iterator i = fournisseurs.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("idFournisseur");
            if (id.equals(id_Fournissuer)) {
                f.idFournisseur = Integer.parseInt(el.getAttributeValue("idFournisseur"));
                f.nomfournisseur = el.getAttributeValue("nomfournisseur");
            }
        }
        return f;
 }
    /**public void ajouter(Etudiant e) throws JDOMException, IOException {
        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Etudiant.xml"));
        Element racine = doc.getRootElement();
        Element el = new Element("etudiant");
        racine.addContent(el);
        el.setAttribute("id", Integer.toString(e.id));
        el.setAttribute("nom", e.nom);
        el.setAttribute("prenom", e.prenom);
        el.setAttribute("adresse", e.adresse);
        el.setAttribute("matricule", e.matricule);
        doc.setContent(racine);
        try {
            FileWriter writer = new FileWriter("Etudiant.xml");
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
        Document doc = (Document) sxb.build(new File("Etudiant.xml"));
        Element racine = doc.getRootElement();
        List etudiant = racine.getChildren();
        Iterator i = etudiant.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("id");
            if (id.equals(id_r)) {
                boolean b = el.getParentElement().removeContent(el);
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("Etudiant.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }

    public void modifier(String id_r, String nom, String prenom, String adresse, String matricule)
            throws JDOMException, IOException {

        SAXBuilder sxb = new SAXBuilder();
        Document doc = (Document) sxb.build(new File("Etudiant.xml"));
        Element racine = doc.getRootElement();
        List etudiant = racine.getChildren();
        Iterator i = etudiant.iterator();
        while (i.hasNext()) {
            Element el = (Element) i.next();
            String id = el.getAttributeValue("id");
            if (id.equals(id_r)) {
                el.setAttribute("nom", nom);
                el.setAttribute("prenom", prenom);
                el.setAttribute("adresse", adresse);
                el.setAttribute("matricule", matricule);
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter("Etudiant.xml");
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(doc, writer);
            outputter.output(doc, System.out);
            writer.close();

        } catch (Exception excption) {
        }
    }
    **/
}
