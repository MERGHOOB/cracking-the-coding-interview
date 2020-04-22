package com.margub.problems.Sol4_7_BuildOrder.edgeremoval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    private final String name;

    private Map<String, Project> map = new HashMap<>();
    private final List<Project> neighbours = new ArrayList<>();

    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNeighbour(Project neighbour) {
        if(map.containsKey(neighbour.name)) {
            return;
        }
        map.put(neighbour.name, neighbour);
        neighbours.add(neighbour);
        neighbour.incrementDependencies();
    }

    private void incrementDependencies() {
        dependencies++;
    }

    public List<Project> getNeighbours() {
        return neighbours;
    }

    public int getNumberOfDependencies() {
        return dependencies;
    }

//    public int getDependencies() {
//        return dependencies;
//    }

    public void setDependencies(int dependencies) {
        this.dependencies = dependencies;
    }

    public void decrementDependencies() {
        dependencies--;
    }
}
