public class Battery implements Fillable, Recyclable {
    private int percentage; // Ganzzahl, maximal 100
    private double capacity; // in mAh
    private int countFillUps;

    public Battery(int percentage, double capacity) {
        this.percentage = percentage;
        this.capacity = capacity;
        this.countFillUps = 0;
    }

    @Override // vom Fillable interface
    public void fillUp() {
        if (countFillUps < MAX_REFILLS && percentage < 100) {
            int increase = (100 - percentage) / 2; // Ganzzahl-Division
            if (increase > 0) {
                percentage += increase;
                countFillUps += 1;
            }
        }
        System.out.println("Neuer Ladestand der Batterie: " + percentage + "%");
    }

    @Override // vom Fillable interface
    public void empty() {
        percentage = 0;
        System.out.println("Jetzt ist die Batterie leer");
    }

    @Override // vom Fillable interface
    public boolean isEmpty() {
        return percentage == 0;
    }

    public double getBatteryCurrent() {
        return capacity * (double) percentage / 100.0;
    }

    @Override // vom Recycable interface
    public void recycle() {
        this.capacity *= .9;
        this.percentage = 0;
        this.countFillUps = 0;
        System.out.println("Batterie wird recycled. Die neue Kapazität ist noch " + this.capacity + "mAh");
    }
}
