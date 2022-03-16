package dtos;

import java.sql.Date;

public class Sinistre {

    private Date dateDeclaration;
    private double pourcentageRemboursement;
    private double noteS1;
    private double noteS2;
    private double indemnite;

    public Sinistre() {
    }

    public Sinistre(Date dateDeclaration, double pourcentageRemboursement, double noteS1, double noteS2, double indemnite) {
        this.dateDeclaration = dateDeclaration;
        this.pourcentageRemboursement = pourcentageRemboursement;
        this.noteS1 = noteS1;
        this.noteS2 = noteS2;
        this.indemnite = indemnite;
    }

    public Date getDateDeclaration() {
        return dateDeclaration;
    }

    public void setDateDeclaration(Date dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public double getPourcentageRemboursement() {
        return pourcentageRemboursement;
    }

    public void setPourcentageRemboursement(double pourcentageRemboursement) {
        this.pourcentageRemboursement = pourcentageRemboursement;
    }

    public double getNoteS1() {
        return noteS1;
    }

    public void setNoteS1(double noteS1) {
        this.noteS1 = noteS1;
    }

    public double getNoteS2() {
        return noteS2;
    }

    public void setNoteS2(double noteS2) {
        this.noteS2 = noteS2;
    }

    public double getIndemnite() {
        return indemnite;
    }

    public void setIndemnité(double indemnite) {
        this.indemnite = indemnite;
    }
}
