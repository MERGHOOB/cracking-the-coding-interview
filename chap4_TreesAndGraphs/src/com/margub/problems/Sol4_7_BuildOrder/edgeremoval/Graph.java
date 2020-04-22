package com.margub.problems.Sol4_7_BuildOrder.edgeremoval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public List<Project> nodes = new ArrayList<>();
    private Map<String, Project> dependencies = new HashMap<>();

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);

        start.addNeighbour(end);
    }

    public Project getOrCreateNode(String name) {
        if (!dependencies.containsKey(name)) {
            Project project = new Project(name);
            nodes.add(project);
            dependencies.put(name, project);
        }
        return dependencies.get(name);

    }

    public List<Project> getNodes() {
        return nodes;
    }
}
