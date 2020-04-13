package com.margub;

import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Node, List<Node>> map = new HashMap<>();

    public List<Node> getNodes() {
        return null;
    }

    public List<Node> getAdjacent(Node u) {
        return map.get(u);
    }
}
