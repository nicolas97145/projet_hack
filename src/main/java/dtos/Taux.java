package dtos;

public class Taux {
    private int min;
    private int max;
    private float tranche;

    public Taux(int min, int max, float tranche) {
        this.min = min;
        this.max = max;
        this.tranche = tranche;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getTranche() {
        return tranche;
    }

    public void setTranche(float tranche) {
        this.tranche = tranche;
    }
}