package com.margub.problems.Sol4_7_BuildOrder.edgeremoval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuildOrder {


    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}
        };

        List<String> buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

    private static List<String> buildOrderWrapper(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return Objects.requireNonNull(buildOrder(graph)).stream().map(Project::getName).collect(Collectors.toList());
    }

    private static Graph buildGraph(String[] projects, String[][] dependencies) {

        Graph graph = new Graph();

        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }

        return graph;
    }

    private static List<Project> buildOrder(Graph graph) {
        List<Project> order = new ArrayList<>();

        List<Project> projects = graph.getNodes();

        /**
         * Add root elements or project which does not have any incoming to order
         */

        addNonDependent(order, projects);

        int toBeProcessed = 0;
        while (toBeProcessed < order.size()) {
            Project current = order.get(toBeProcessed);
            /* We have a circular dependency since there are no remaining
             * projects with zero dependencies. */
            if (current == null) {
                return null;
            }

            /**
             * Remove myself as dependency
             */
            List<Project> neighbours = current.getNeighbours();

            neighbours.forEach(Project::decrementDependencies);

            addNonDependent(order, projects);

            toBeProcessed++;
        }
        return order;
    }

    private static void addNonDependent(List<Project> order, List<Project> projects) {
        for (Project project : projects) {
            if (project.getNumberOfDependencies() == 0) {
                if (order.contains(project)) continue;
                order.add(project);
            }
        }
    }
}
