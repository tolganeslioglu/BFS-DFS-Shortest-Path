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

## 📊 Performance Snapshot

Route (sample)	DFS (ms)	BFS (ms)
Samsun → Istanbul	0.0076	0.0079
Batman → … → Bursa	0.32	0.38
In most test cases BFS edged out DFS, but results converge once pruning is enabled. On the original 18×18 matrix every experiment finished in <1 s on an 8 GB laptop. 

## ⚠️ Known Limitations

Memory Pressure in Un-pruned BFS – Removing pruning on dense graphs may exhaust heap space. 
Algorithmic Differences – BFS uses ArrayList, DFS uses LinkedList; a unified data-structure choice might yield fairer timing. 

## 📚 Dataset

Turkish cities.csv — 18 × 18 symmetric adjacency matrix; 99999 denotes no direct road. Feel free to swap in your own CSV with the same layout.

## 👥 Contributors

Name	ID	Role
Tolga Neslioğlu	042301100	DFS, CSV import, report

Cem Alp Özer	042301097	BFS, data structures, GUI

Efe Ersöz	042202008	Complexity analysis

Yağmur Kaykaç	041801112	Complexity analysis, presentation

Beyza Zerdalı	042201050	Complexity analysis


Task breakdown is detailed in the report’s labour table. 
