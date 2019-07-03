/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_xml;

import entities.Commande;
import entities.Fournisseur;
import entities.Livraison;
import entities.Medicament;
import entities.Pharmacien;
import entities.Vente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.jdom2.JDOMException;

/**
 *
 * @author mdroot
 */
public class Projet_xml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException, ParseException {
        //-Etudiant et1 = new Etudiant();
        //et1.affiche();
        //-Etudiant et2 = new Etudiant(3, "dia", "lamine", "tiv", "rechO2");
        //et2.ajouter(et2);
        //-Etudiant etudiant = new Etudiant();
        //etudiant.supprimer("5");
        //-Etudiant etm = new Etudiant();
        //etm.modifier("0", "test1", "test2", "test3", "test4");

        //-Fournisseur f = new Fournisseur();
        //f.affiche();
        //Medicament c = new Medicament();
        //c.affiche();
        System.out.println("***** Application de gestion de stock d'une pharmacie **********");
        System.out.println("**\t\t     Menu Général    \t\t       **");
        System.out.println("**\t\t 1 : Gestion des commandes \t\t**");
        System.out.println("**\t\t 2 : Gestion des fournisseurs \t\t**");
        System.out.println("**\t\t 3 : Gestion des livraisons \t\t**");
        System.out.println("**\t\t 4 : Gestion des médicaments \t\t**");
        System.out.println("**\t\t 5 : Gestion des pharmacients \t\t**");
        System.out.println("**\t\t 6 : Gestion des Ventes    \t\t**");
        System.out.println("**\t\t Entrer une valeur :    \t\t**");
        Commande c = new Commande();
        Fournisseur f = new Fournisseur();
        Livraison l = new Livraison();
        Medicament m = new Medicament();
        Pharmacien p = new Pharmacien();
        Vente v = new Vente();
        Scanner scan = new Scanner(System.in);
        int choix = scan.nextInt();
        switch (choix) {
            case 1:
                System.out.println("**\t\t   : Gestion des commandes \t\t**");
                System.out.println("**\t\t 1 : Lister les commandes \t\t**");
                System.out.println("**\t\t 2 : Ajouter une commande \t\t**");
                System.out.println("**\t\t 3 : Modifier une commande \t\t**");
                System.out.println("**\t\t 4 : Supprimer une commandes \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix1 = scan.nextInt();
                switch (choix1) {
                    case 1:
                        c.affiche();
                        break;
                    case 2:
                        c.ajouter(c);
                        break;
                    case 3:
                        System.out.println("Saisir l'id de l'élément à modifier :");
                        int id_m = scan.nextInt();
                        System.out.println("Saisir date Commande :");
                        String dateCommande = scan.nextLine();
                        //String t = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                        SimpleDateFormat simpledate = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = simpledate.parse(dateCommande);
                        System.out.println("Saisir Id Pharmacien :");
                        int idPharmacien = scan.nextInt();
                        Pharmacien p2 = new Pharmacien();
                        p2.recherche(idPharmacien);
                        System.out.println("Saisir Id Fournisseur :");
                        int idFournisseur = scan.nextInt();
                        Fournisseur f2 = new Fournisseur();
                        f2.recherche(idFournisseur);
                        c.modifier(id_m, date, p2, f2);
                        break;
                    case 4:
                        System.out.println("Saisir l'id de l'élément à supprimer :");
                        c.supprimer(scan.nextLine());
                        break;
                }
                break;
            case 2:
                System.out.println("**\t\t   : Gestion des fournisseurs \t\t**");
                System.out.println("**\t\t 1 : Lister les fournisseurs \t\t**");
                System.out.println("**\t\t 2 : Ajouter un fournisseur \t\t**");
                System.out.println("**\t\t 3 : Modifier un fournisseur \t\t**");
                System.out.println("**\t\t 4 : Supprimer un fournisseur \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix2 = scan.nextInt();
                switch (choix2) {
                    case 1:
                        f.affiche();
                        break;
                    case 2:
                       // f.ajouter(f);
                        break;
                    case 3:/**
                        System.out.println("Saisir l'id de l'élément à modifier :");
                        int id_m = scan.nextInt();
                        System.out.println("Saisir date Commande :");
                        String dateCommande = scan.nextLine();
                        //String t = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                        SimpleDateFormat simpledate = new SimpleDateFormat("MM/dd/yyyy");
                        Date date = simpledate.parse(dateCommande);
                        System.out.println("Saisir Id Pharmacien :");
                        int idPharmacien = scan.nextInt();
                        Pharmacien p = new Pharmacien();
                        p.recherche(idPharmacien);
                        System.out.println("Saisir Id Fournisseur :");
                        int idFournisseur = scan.nextInt();
                        Fournisseur f = new Fournisseur();
                        f.recherche(idFournisseur);
                        c.modifier(id_m, date, p, f);
                        break;**/
                    case 4:
                        System.out.println("Saisir l'id de l'élément à supprimer :");
                       // c.supprimer(scan.nextLine());
                        break;
                }
                break;
            case 3:
                System.out.println("**\t\t   : Gestion des livraisons \t\t**");
                System.out.println("**\t\t 1 : Lister les livraisons \t\t**");
                System.out.println("**\t\t 2 : Ajouter une livraison \t\t**");
                System.out.println("**\t\t 3 : Modifier une livraisons \t\t**");
                System.out.println("**\t\t 4 : Supprimer une livraisons \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix3 = scan.nextInt();
                switch (choix3) {
                    case 1:
                        l.affiche();
                        break;
                    case 2:
                       // l.ajouter(f);              
                        break;
                }
            case 4:
                System.out.println("**\t\t   : Gestion des médicaments \t\t**");
                System.out.println("**\t\t 1 : Lister les médicaments \t\t**");
                System.out.println("**\t\t 2 : Ajouter un médicament \t\t**");
                System.out.println("**\t\t 3 : Modifier un médicament \t\t**");
                System.out.println("**\t\t 4 : Supprimer un médicament \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix4 = scan.nextInt();
                switch (choix4) {
                    case 1:
                        m.affiche();
                        break;
                    case 2:
                        System.out.println("Saisir id du médicament :");
                        int id_m = scan.nextInt();
                        System.out.println("Saisir libelle du médicament :");
                        String libelle = scan.nextLine();
                        libelle = scan.nextLine();
                        System.out.println("Saisir categorie du médicament :");
                        String cat = scan.nextLine();
                        //System.out.println("Saisir date de Peremption");
                        
                        System.out.println("Saisir quantité en stock :");
                        int qtsk = scan.nextInt();
                        System.out.println("Saisir prix d'achat :");
                        int pa = scan.nextInt();
                        System.out.println("Saisir prix de vente :");
                        int pv = scan.nextInt();
                        m.setCategorie(cat);
                        m.setIdMedicament(id_m);
                        m.setLibelle(libelle);
                        m.setPrixAchat(pa);
                        m.setPrixVente(pv);
                        m.setQteStock(qtsk);
                        m.ajouter(m);
                        System.out.println("Ajoutée succes ");
                        //m.affiche();
                        break;
                    case 3:
                        m.affiche();
                        System.out.println("Saisir id du médicament :");
                        String id_mod = scan.nextLine();
                        id_mod = scan.nextLine();
                        System.out.println("Saisir libelle du médicament :");
                        String libelle_m = scan.nextLine();
                        libelle_m = scan.nextLine();
                        System.out.println("Saisir categorie du médicament :");
                        String categorie = scan.nextLine();
                        //System.out.println("Saisir date de Peremption");
                        
                        System.out.println("Saisir quantité en stock :");
                        int qtstock = scan.nextInt();
                        System.out.println("Saisir prix d'achat :");
                        int pachat = scan.nextInt();
                        System.out.println("Saisir prix de vente :");
                        int pvente = scan.nextInt();
                        
                       m.modifier(id_mod, libelle_m, categorie, pachat, pvente, qtstock);
                        break;
                    case 4:
                        
                        break;
                }
                break;
            case 5:
                System.out.println("**\t\t   : Gestion des pharmaciens \t\t**");
                System.out.println("**\t\t 1 : Lister les pharmaciens \t\t**");
                System.out.println("**\t\t 2 : Ajouter un pharmacien \t\t**");
                System.out.println("**\t\t 3 : Modifier un pharmacien \t\t**");
                System.out.println("**\t\t 4 : Supprimer un pharmacien \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix5 = scan.nextInt();
                switch (choix5) {
                    case 1:
                        p.affiche();
                        break;
                    case 2:
                       // p.ajouter(f);
                }
                break;
            case 6:
                System.out.println("**\t\t   : Gestion des vendeurs \t\t**");
                System.out.println("**\t\t 1 : Lister les vendeurs \t\t**");
                System.out.println("**\t\t 2 : Ajouter un vendeur \t\t**");
                System.out.println("**\t\t 3 : Modifier un vendeur \t\t**");
                System.out.println("**\t\t 4 : Supprimer un vendeur \t\t**");
                System.out.println("**\t\t Entrer une valeur :    \t\t**");
                int choix6 = scan.nextInt();
                switch (choix6) {
                    case 1:
                        v.affiche();
                        break;
                    case 2:
                       // v.ajouter(f);
                break;
        }
    }
                
}
}
