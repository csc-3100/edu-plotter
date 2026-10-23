package edu.plotter.legacy;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class DecoratorSingleAttendance {

    private String date;
    private float minutes;

    public DecoratorSingleAttendance(String date, float minutes) {
        this.date = date;
        this.minutes = minutes;
    }

    public float getMinutes() {
        return minutes;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "Date = '" + date + '\'' +
                ", Minutes present = " + minutes +
                '}';
    }
}
