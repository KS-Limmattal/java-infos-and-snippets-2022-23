public class House extends Building {
    private int numInhabitants;
    private int numBedrooms;

    public House(double height, int year, int numInhabitants, int numBedrooms) {
        super(height, year);
        this.numInhabitants = numInhabitants;
        this.numBedrooms = numBedrooms;
    }

    public double inhabitantsPerBedroom() {
        return (double) this.numInhabitants / (double) this.numBedrooms;
    }
}
