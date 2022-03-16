package dtos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe User a ici un usage limité : elle sert juste à faire transiter des infos.
 * On pourrait lui attribuer un rôle de stockage, et elle se retrouverait alors dans le modèle.
 * Cette dualité transfert / stockage est souvent utilisée mais elle n'a pas que des avantages...
 * Nous en reparlerons plus tard...
 */
public class User {
    private String mail;
    private String password;
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    private String Bac;
    private String mention;
    List<Contrat> contrats;

    public User(){}

    public User(String mail, String password, String nom, String prenom, String sexe) {
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        contrats = new ArrayList<>();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getBac() {
        return Bac;
    }

    public void setBac(String bac) {
        Bac = bac;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }
}
