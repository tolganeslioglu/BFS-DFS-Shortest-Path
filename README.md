# ShortestPathFinder
*COMP201 – Data Structures & Algorithms, MEF University, Fall 2024*

A Java application that compares **Breadth-First Search (BFS)** and **Depth-First Search (DFS)**—both **adapted for weighted graphs**—to solve the shortest-path problem on Turkish-city distance data. The project includes a minimal GUI, an executable JAR, custom data-structure implementations, and an empirical performance study.

---

## ✨ Key Features
- **Weighted-Graph Support** – Both algorithms were modified to respect edge weights while still guaranteeing a shortest path.
- **Pruning Optimisation** – Paths longer than the best-so-far distance are cut early, reducing search time from minutes to *milliseconds*.
- **From-Scratch Data Structures** – Custom `SinglyLinkedList`, `LinkedStack`, and `LinkedQueue` instead of java.util to highlight course 
- **CSV Import Utility** – `CreateArray` reads the provided *Turkish cities.csv* into a 2-D adjacency matrix.
- **Swing GUI** – `MyGUI` lets users pick start/goal cities and view the resulting path & length. (Command-line mode also available.)  
- **Single-click Run** – Launch `ShortestPathFinder.jar`; no install scripts or extra libraries required.

---

## 📂 Project Layout
| Package / Class        | Responsibility |
|------------------------|----------------|
| `util/CreateArray`     | Parse CSV, populate `citiesHeader[]` & `distances[][]`. |
| `ds/Node`              | List node for custom collections. |
| `ds/SinglyLinkedList`  | Core list operations used by stack & queue. |
| `ds/LinkedStack`       | LIFO stack for DFS recursion tracking. |
| `ds/LinkedQueue`       | FIFO queue for BFS path expansion. |
| `algo/DFS`             | Recursive DFS + backtracking & pruning. |
| `algo/BFS`             | Iterative BFS with path-length pruning. |
| `ui/MyGUI`             | Swing front-end; builds an executable JAR. |
| `Main`                 | CLI entry point and runtime orchestrator. |

(For a full method-by-method description, see the *Project Report.pdf*.)
---

## 🚀 Getting Started
1. **Prerequisites**  
   - JDK 17 or higher (no external dependencies).

2. **Run the pre-built JAR**  
   ```bash
   java -jar ShortestPathFinder.jar
    ```