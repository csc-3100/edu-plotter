package edu.plotter.legacy;

import java.util.List;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class DecoratorAbstract extends Decorator {
	
	protected Decorator student;
	
	public void add(Decorator student) {
		this.student = student;
	}

	@Override
	public String getID() {
		return student.getID();
	}

	@Override
	public String getFirstName() {
		return student.getFirstName();
	}

	@Override
	public String getLastName() {
		return student.getLastName();
	}

	@Override
	public String getProgram() {
		return student.getProgram();
	}

	@Override
	public String getLevel() {
		return student.getLevel();
	}

	@Override
	public String getAsurite() {
		return student.getAsurite();
	}

	@Override
	public List<DecoratorSingleGrade> getGrades() {
		return student.getGrades();
	}

	@Override
	public List<DecoratorSingleAttendance> getAttendance() {
		return student.getAttendance();
	}

	@Override
	public String toString() {
		String data = super.toString();
		return data + "\n" + getGrades() + "\n" + getAttendance().toString();
	}

}
