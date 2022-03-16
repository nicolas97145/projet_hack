package dtos;

public class Etude {

    private int année;
    private String cursus;
    private double prix;
    private String cycle;

    public Etude(){}

    public Etude(int année, String cycle, String cursus, double prix) {
        this.année = année;
        this.cursus = cursus;
        this.cycle = cycle;
        this.prix = prix;
    }

    public int getAnnée() {
        return année;
    }

    public void setAnnée(int année) {
        this.année = année;
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
