package edu.plotter.legacy;

import java.util.List;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class DecoratorAttendance extends DecoratorAbstract {
	
	private String date;
	private float minutes;

	public DecoratorAttendance(String date, float minutes) {
		this.date = date;
		this.minutes = minutes;
	}
	
	@Override
	public void add(Decorator student) {
		super.add(student);
	}

	@Override
	public List<DecoratorSingleGrade> getGrades() {
		return super.getGrades();
	}

	@Override
	public List<DecoratorSingleAttendance> getAttendance() {
		List<DecoratorSingleAttendance> list = super.getAttendance();
		list.add(new DecoratorSingleAttendance(date, minutes));
		return list;
	}

}
