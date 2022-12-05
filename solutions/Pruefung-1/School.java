public class School extends Building {
    private int schoolYear;

    public School(double height, int year, int schoolYear) {
        super(height, year);
        this.schoolYear = schoolYear;
    }

    public int yearsSinceStart() {
        return this.schoolYear - this.year;
    }
}
