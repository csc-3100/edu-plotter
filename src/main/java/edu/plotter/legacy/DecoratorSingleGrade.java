package edu.plotter.legacy;


/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class DecoratorSingleGrade {
    private String assignmentName;
    private float grade;

    public DecoratorSingleGrade(String assignmentName, float grade) {
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "assignmentName='" + assignmentName + '\'' +
                ", grade=" + grade +
                '}';
    }
}