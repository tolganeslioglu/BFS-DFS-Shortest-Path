public class DFS{
    static String shortestPath = null;
    static int shortestDistance = Integer.MAX_VALUE;
    static LinkedStack<String> citiesStack = new LinkedStack<String>();
    static SinglyLinkedList<Integer> distances = new SinglyLinkedList<Integer>();
    static LinkedStack<String> visited = new LinkedStack<String>();

    /**
     * This method attempts to find the shortest path using a DFS with backtracking.
     * Time Complexity Notes:
     * - In the worst case, this DFS explores a large number of paths, potentially factorial in nature (O(n!)),
     *   because it tries many permutations of nodes before pruning.
     * - Each recursive call may involve O(n) operations (e.g., checking visited and summing distances).
     * - Combined, the worst-case complexity can be approximated as O(n! * n^2).
     * - If an effective shortest path is found early, pruning reduces the search space drastically,
     *   leading to much better performance in practice.
     */

    //O(n!)
    public static void shortestPathDFS(int start, int arrival, String[] citiesHeader, int[][] distancesArray) {
        // Add the current city to the stack
        citiesStack.push(citiesHeader[start]);
        visited.push(citiesHeader[start]);
    
        // Calculate the current total distance
        // This summation is O(n) in the size of the current path
        int totalDistance = 0;
        Node<Integer> currentDistance = distances.head;
        while (currentDistance != null) {
            totalDistance += currentDistance.element;
            currentDistance = currentDistance.next;
        }
        
        // Pruning:
        // If the current path lenght is longer than the shortest, stop going eny futher in this path and backtrack.
        if (totalDistance >= shortestDistance) {
            visited.pop();
            citiesStack.pop();
            return;
        }

        // If we've reached the destination, backtrack
        if (start == arrival) {
            //System.out.println();
            //displayTravel(citiesStack, distances);
            //System.out.println("\nTotal travel distance in this path is " + totalDistance + " kilometers.");
            if (totalDistance < shortestDistance) {
                shortestDistance = totalDistance;
                shortestPath = citiesStack.toString();
            }

            // Backtrack visited nodes
            visited.pop();
            citiesStack.pop();
            return;
        }
    
        // Explore all neighbors
        // Each neighbor check involves isForbidden(), which can take O(n) time
        for (int i = 0; i < citiesHeader.length; i++) {
            if (isForbidden(citiesHeader[i], visited)) // Skip visited nodes // O(n)
                continue;
            
            //Check if there is a valid path
            if (0 < (distancesArray[start][i]) && (distancesArray[start][i]) < 99999) {
                distances.addLast(distancesArray[start][i]); // Record the distance //O(1)
                shortestPathDFS(i, arrival, citiesHeader, distancesArray);   // Recurse
                distances.removeLast(); // Backtrack
            }
        }
        // Backtrack visited and current stack elements
        visited.pop();
        citiesStack.pop();
        return;
    }

    // isForbidden checks if a city is already visited
    // O(n) per check due to linked list traversal
    public static boolean isForbidden(String city, LinkedStack<String> stack) {
        Node<String> current = stack.list.head;
        while (current != null) {
            if (current.element.equals(city)) {
                return true;
            }
            current = current.next;
        } 
        return false;
    }
}