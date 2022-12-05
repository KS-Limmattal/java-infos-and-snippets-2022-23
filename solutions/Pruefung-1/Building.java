public class Building {
    private double height; // in Metern
    protected int year; // wird in Klasse School verwendet

    public Building(double height, int year) {
        setHeight(height);
        this.year = year;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if (height >= 0) {
            this.height = height;
        } else {
            System.out.println("Höhe darf nicht negativ sein. Setze sie auf 0!");
            this.height = 0;
        }
    }

    public String toString() {
        return "Gebäude der Höhe " + this.height + " m von Baujahr " + this.year;
    }

}
