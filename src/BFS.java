public class BFS {
    private int[][] adjMatrix; // Adjacency matrix of the Graph
    private String[] vertices; // Array to store the vertices of the Graph
    final int INF = 99999; // A very large number to represent infinity
    public String path = "";

    // Variables to store the shortest path and its length
    private int shortestPathLength = INF; // INF means there is no path
    private ArrayList<Integer> shortestPath = null; // To stote the shortest path

    // Constructor to initialize the adjacency matrix and vertices
    public BFS(int[][] adjMatrix, String[] vertices) {
        this.adjMatrix = adjMatrix;
        this.vertices = vertices;
    }

    // Getter methods
    public int getShortestDistance() {
        return shortestPathLength;
    }

    public ArrayList<Integer> getShortestPath() {
        return shortestPath;
    }

    /** Theoretical Time Complexity
     * Our BFS algorithm is a brute-force search algorithm that explores all possible paths from the source to the destination,
     * but with some optimizations to prune the search space.
     *
     * In the worst case, it may end up exploring a huge number of paths (potentially factorial in nature if the graph is dense).
     * Each step involves:
     *   - Dequeuing a path: O(1)
     *   - Checking neighbors: O(n) per vertex since adjacency is given by a matrix
     *   - For each neighbor, creating a new path is O(n) (copying path and checking membership)
     * Worst case complexity would be O(n!) due to the potentially enormous number of paths and O(n) checks/copies each time.
     * 
     * In practice, the pruning works and the algorithm is much faster than if it were to explore all paths.
     */
    public void shortestPathBFS(int start, int destination) {
        // Creating queue to store the entire paths and not just the vertices
        // Each element in the queue is an ArrayList of Integers
        LinkedQueue<ArrayList<Integer>> open = new LinkedQueue<>();
        ArrayList<Integer> startingPath = new ArrayList<>();

        startingPath.add(start); // add the source vertex to the starting path
        open.enqueue(startingPath); // add the starting path to the queue

        // While there are still paths to explore
        while (!open.isEmpty()) {
            ArrayList<Integer> currentPath = open.dequeue(); // O(1) dequeue.
            // Last vertex in the current path
            int currentVertex = currentPath.get(currentPath.size() - 1);

            // Get the current path length, O(n) in worst case.
            int currentPathLength = pathLength(currentPath);

            /** Optimization: 
            * If the current path is already longer than or equal to
            * the shortest path we have found we skip exploring further.
            *
            * Time complexity:
            * In the worst case, we will still explore all the paths. So, worts time complexity
            * is O(n!) where n is the number of vertices in the graph. In practice this is never
            * the case and the time it takes to find the shortest path is much less.
            */ 
            if (currentPathLength >= shortestPathLength) {
                continue;
            }

            // If the destination is reached, update the shortest path
            if (currentVertex == destination) {
                shortestPathLength = currentPathLength;
                shortestPath = new ArrayList<>(currentPath); // O(n) copy
                continue;
            }

            // Explore the neighbors, O(n) in worst case due to adjacency matrix structure.
            for (int i = 0; i < adjMatrix[currentVertex].length; i++) {
                if (adjMatrix[currentVertex][i] != INF && !currentPath.contains(i)) {
                    ArrayList<Integer> newPath = new ArrayList<>(currentPath); // O(n) copy
                    newPath.add(i);
                    open.enqueue(newPath); // O(1) enqueue
                }
            }
        }
        // Convert the shortest path to a string
        path = shortestPath.toString(vertices);
    }

    // Method to calculate the length of a path
    // O(n) time complexity where n is the number of vertices in the path
    public int pathLength(ArrayList<Integer> path) {
        int length = 0;
        // Calculate the length of the path by adding the weights of the edges
        for (int i = 0; i < path.size() - 1; i++) {
            length += adjMatrix[path.get(i)][path.get(i + 1)];
        }
        return length;
    }
}