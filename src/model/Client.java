package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	private final IntegerProperty idClient;
    private final StringProperty nomEnseigne;
    private final IntegerProperty nRue;
    private final StringProperty adresse;
    private final IntegerProperty codePostal;
    private final StringProperty ville;
    private final StringProperty pays;
    private final StringProperty mail;
    private final StringProperty tel;
    private final StringProperty siret;
    private final IntegerProperty idRepresentant;
    private final IntegerProperty nbCommande;
    private static  int compteur = 0;
    
    public Client() {
        this(null);
    }

    public Client(String nomEnseigne) {
    	compteur++;
    	this.idClient = new SimpleIntegerProperty(compteur);
        this.nomEnseigne = new SimpleStringProperty(nomEnseigne);
        // Some initial dummy data, just for convenient testing.
        this.nRue = new SimpleIntegerProperty(1);
        this.adresse = new SimpleStringProperty("une adresse");
        this.codePostal = new SimpleIntegerProperty(59630);
        this.ville = new SimpleStringProperty("une ville");
        this.pays = new SimpleStringProperty("un pays");
        this.mail = new SimpleStringProperty("un mail");
        this.tel = new SimpleStringProperty("un téléphone");
        this.siret = new SimpleStringProperty("un siret");
        this.nbCommande = new SimpleIntegerProperty(1);
        this.idRepresentant = new SimpleIntegerProperty(1);
    }
    //**********************************************************************

    public int getIdClient() {
        return idClient.get();
    }

    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
    }

    public IntegerProperty idClientProperty() {
        return idClient;
    }

             //***************

    public String getNomEnseigne() {
        return nomEnseigne.get();
    }

    public void setNomEnseigne(String nomEnseigne) {
        this.nomEnseigne.set(nomEnseigne);
    }

    public StringProperty nomEnseigneProperty() {
        return nomEnseigne;
    }
               //***********
   

             //***************

    public int getNRue() {
        return nRue.get();
    }

    public void setNRue(int nRue) {
        this.nRue.set(nRue);
    }

    public IntegerProperty nRueProperty() {
        return nRue;
    }

             //***************  
    public String getAdresse() {
        return nomEnseigne.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public StringProperty adresseProperty() {
        return adresse;
    }
               //***********

    public int getCodePostal() {
        return codePostal.get();
    }

    public void setCodePostal(int codePostal) {
        this.codePostal.set(codePostal);
    }

    public IntegerProperty codePostalProperty() {
        return codePostal;
    }

             //***************  
    public String getVille() {
        return ville.get();
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }

    public StringProperty villeProperty() {
        return ville;
    }
               //***********
    public String getPays() {
        return pays.get();
    }

    public void setPays(String pays) {
        this.pays.set(pays);
    }

    public StringProperty paysProperty() {
        return pays;
    }
               //***********
    public String getMail() {
        return mail.get();
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public StringProperty mailProperty() {
        return mail;
    }
               //***********
    public String getTel() {
        return tel.get();
    }
    
    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public StringProperty telProperty() {
        return tel;
    }
               //***********
    public String getSiret() {
        return siret.get();
    }
    
    public void setSiret(String siret) {
        this.siret.set(siret);
    }

    public StringProperty siretProperty() {
        return siret;
    }
               //***********
    public int getNbCommande() {
        return nbCommande.get();
    }

    public void setNbCommande(int nbCommande) {
        this.nbCommande.set(nbCommande);
    }

    public IntegerProperty nbCommandeProperty() {
        return nbCommande;
    }
    
    			//***********
    public int getIdRepresentant() {
        return idRepresentant.get();
    }

    public void setIdRepresentant(int idRepresentant) {
        this.idRepresentant.set(idRepresentant);
    }

    public IntegerProperty idRepresentantProperty() {
        return idRepresentant;
    }

}
