package com.margub.problems;

import com.margub.Graph;
import com.margub.Node;
import com.margub.State;

import java.util.LinkedList;
import java.util.Queue;

public class Sol4_1_RouteBetweenNodes {

    public boolean search(Graph graph, Node start, Node end) {

        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();

        for (Node node : graph.getNodes()) {
            node.setState(State.Unvisited);
        }
        start.setState(State.Visited);
        queue.add(start);

        Node u;
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            if (u == null) {
                continue;
            }


            for (Node v : graph.getAdjacent(u)) {

                if (isAlreadyInQueue(v)) {
                    continue;
                }

                if (v == end) {
                    return true;
                }
                v.setState(State.Visiting);
                queue.add(v);
            }

            u.setState(State.Visited);


        }
        return false;
    }

    private boolean isAlreadyInQueue(Node v) {
        return v.getState() == State.Visited || v.getState() == State.Visiting;
    }

}
