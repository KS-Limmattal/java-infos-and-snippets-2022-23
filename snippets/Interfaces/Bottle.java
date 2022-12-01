public class Bottle implements Fillable {
    private double fillStand; // in mililiter
    private int countFillUps;
    public String vendor;

    public static final double FILL_PER_FILLUP = 50.0;

    public Bottle(double fillStand, String vendor) {
        this.fillStand = fillStand;
        this.vendor = vendor;
        this.countFillUps = 0;
    }

    @Override
    public void fillUp() {
        if (countFillUps < MAX_REFILLS) {
            fillStand += FILL_PER_FILLUP;
            countFillUps++;
            System.out.println("Habe " + FILL_PER_FILLUP + " ml " + " in die Flasche von " + vendor + " eingefüllt. ");
            System.out.println("Neuer Füllstand: " + fillStand + " ml");
        }
    }

    @Override
    public void empty() {
        System.out.println("Giesse Flascheninhalt aus!");
        fillStand = 0.;
    }

    @Override
    public boolean isEmpty() {
        return this.fillStand < 0.1;
    }
}
