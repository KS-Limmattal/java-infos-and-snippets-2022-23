public class SportsCar extends Car {
    private int racesWon;

    public SportsCar(long speed, String name, String manufacturer, int racesWon) {
        super(speed, name, manufacturer);
        this.racesWon = racesWon;
    }

    public int getRacesWon() {
        return this.racesWon;
    }

    public void registerRaceWon() {
        this.racesWon += 1;
    }
}
