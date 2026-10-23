package edu.plotter.legacy;

import java.util.List;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class DecoratorGrades extends DecoratorAbstract {
	
	private String assignmentName;
	private float score;
	private float maxScore;
	
	public DecoratorGrades(String assignmentName, float score, float maxScore) {
		this.assignmentName = assignmentName;
		this.maxScore = maxScore;
		this.score = score;
	}
	
	@Override
	public void add(Decorator student) {
		super.add(student);
	}

	@Override
	public List<DecoratorSingleGrade> getGrades() {
		List<DecoratorSingleGrade> list = super.getGrades();
		list.add(new DecoratorSingleGrade(assignmentName, (score/maxScore)*100));
		return list;
	}

	@Override
	public List<DecoratorSingleAttendance> getAttendance() {
		return super.getAttendance();
	}

}
