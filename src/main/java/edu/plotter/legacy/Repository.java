package edu.plotter.legacy;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Original CSC308 grade plotter class, preserved for UML and refactoring practice.
 * <p>Legacy design and behavior are intentionally retained.</p>
 */
public class Repository extends Observable implements RepositoryContainer {

    private static Repository INSTANCE;
    public Map<String, Decorator> studentList = new HashMap<>();

    private Repository() { }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public void updateStudent(String key, Decorator newStudent) {
        studentList.put(key, newStudent);
        setChanged();
        notifyObservers();
    }


    public void loadRoster(String filePath) {
        this.studentList = RepositoryFileHelper.readCSV(filePath);
        setChanged();
        notifyObservers();
    }

    @Override
    public RepositoryIterator getIterator() {
        return new RepositoryStudentIterator(studentList);
    }

}

