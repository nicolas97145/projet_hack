package dtos;

public class Etude {

    private int annee;
    private String cursus;
    private double prix;
    private String cycle;

    public Etude(){}

    public Etude(int annee, String cycle, String cursus, double prix) {
        this.annee = annee;
        this.cursus = cursus;
        this.cycle = cycle;
        this.prix = prix;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
