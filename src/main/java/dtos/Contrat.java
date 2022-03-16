package dtos;

import java.sql.Date;

public class Contrat {

    private String numeroContrat;
    private Date dateDébutContrat;
    private Date dateFinContrat;
    private double prixAnnuel;
    private Etude etude;
    private Sinistre sinistre;

    public Contrat() {
        
    }

    public Contrat(String numeroContrat, Date dateDébutContrat, Date dateFinContrat, double prixAnnuel) {
        this.numeroContrat = numeroContrat;
        this.dateDébutContrat = dateDébutContrat;
        this.dateFinContrat = dateFinContrat;
        this.prixAnnuel = prixAnnuel;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Date getDateDébutContrat() {
        return dateDébutContrat;
    }

    public void setDateDébutContrat(Date dateDébutContrat) {
        this.dateDébutContrat = dateDébutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public double getPrixAnnuel() {
        return prixAnnuel;
    }

    public void setPrixAnnuel(double prixAnnuel) {
        this.prixAnnuel = prixAnnuel;
    }

    public Etude getEtude() {
        return etude;
    }

    public void setEtude(Etude etude) {
        this.etude = etude;
    }

    public Sinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(Sinistre sinistre) {
        this.sinistre = sinistre;
    }
}
