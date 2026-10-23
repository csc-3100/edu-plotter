package edu.plotter.legacy;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public interface RepositoryIterator {

	public boolean hasNext();
	public Decorator next();
}
