# Prompt
Agir como especialista em Test Coding e desenvolver amplo conteúdo, com exemplos em Java, dos seguintes Coding Patterns:
- Sliding Window
- Islands (Matrix Traversal)
- Two Pointers
- Fast & Slow Pointers
- Merge Intervals
- Cyclic Sort
- In-place Reversal of a LinkedList
- Tree Breadth-First Search
- Tree Depth First Search
- Two Heaps
- Subsets
- Modified Binary Search
- Bitwise XOR
- Top 'K' Elements
- K-way Merge
- Topological Sort
- 0/1 Knapsack
- Fibonacci Numbers
- Palindromic Subsequence
- Longest Common Substring

# ChatGPT
Claro! Vamos abordar cada um desses padrões de codificação ("Coding Patterns") com explicações detalhadas e exemplos em Java. Isso pode ajudar tanto para entrevistas quanto para aprimorar suas habilidades de resolução de problemas.

---

### 📌 **1. Sliding Window**

**Descrição:**  
Útil para problemas envolvendo subarrays ou substrings contínuas.

**Exemplo:**  
Encontrar a soma máxima de qualquer subarray de tamanho `k`.

```java
public class SlidingWindow {
    public static int maxSubArraySum(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // adicionar o próximo elemento
            
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // remover o elemento que sai da janela
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSubArraySum(arr, 3)); // Output: 9
    }
}
```

---

### 📌 **2. Islands (Matrix Traversal)**

**Descrição:**  
Encontrar o número de ilhas (conjuntos de 1s adjacentes) em uma matriz binária.

**Exemplo:**

```java
public class Islands {
    private static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int countIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        for (int[] dir : directions) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        System.out.println(countIslands(grid)); // Output: 3
    }
}
```

---

### 📌 **3. Two Pointers**

**Descrição:**  
Utilizado em arrays ordenados para problemas de soma de pares, remoção de duplicados, etc.

**Exemplo:**  
Encontrar se existe um par de números que soma a um alvo.

```java
import java.util.Arrays;

public class TwoPointers {
    public static boolean pairWithTargetSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println(pairWithTargetSum(arr, 6)); // Output: true (2 + 4)
    }
}
```

---

### 📌 **4. Fast & Slow Pointers**

**Descrição:**  
Detectar ciclos em listas ou encontrar ponto médio.

**Exemplo:**  
Detectar ciclo em uma LinkedList.

```java
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class FastSlowPointers {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // cria ciclo

        System.out.println(hasCycle(head)); // Output: true
    }
}
```

---

### 📌 **5. Merge Intervals**

**Descrição:**  
Mesclar intervalos sobrepostos.

**Exemplo:**

```java
import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
        // Output: [1, 6], [8, 10], [15, 18]
    }
}
```

---

### 📌 **6. Cyclic Sort**

**Descrição:**  
Ordenação eficiente para arrays contendo números em um intervalo específico (ex: 1 a n).

**Exemplo:**

```java
public class CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 4, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4, 5]
    }
}
```

---

Ótimo! Vamos continuar com os próximos padrões de codificação, seguindo o mesmo estilo com explicação + exemplo em Java:

---

### 📌 **7. In-place Reversal of a LinkedList**

**Descrição:**  
Reverter uma lista ligada sem usar espaço extra.

**Exemplo:**

```java
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = reverse(head);
        printList(head); // Output: 3 -> 2 -> 1 -> null
    }
}
```

---

### 📌 **8. Tree Breadth-First Search (BFS)**

**Descrição:**  
Visita os nós da árvore nível por nível (fila).

**Exemplo:**

```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeBFS {
    public static void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        bfs(root); // Output: 1 2 3 4 5
    }
}
```

---

### 📌 **9. Tree Depth-First Search (DFS)**

**Descrição:**  
Visita os nós profundamente, pré-ordem/in-ordem/pós-ordem.

**Exemplo (Pré-ordem):**

```java
public class TreeDFS {
    public static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        dfs(root); // Output: 1 2 4 5 3
    }
}
```

---

### 📌 **10. Two Heaps**

**Descrição:**  
Usado para problemas de medianas em tempo real ou balanceamento.

**Exemplo:**  
Manter a mediana de um fluxo de números.

```java
import java.util.*;

public class TwoHeapsMedian {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        // balancear heaps
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        TwoHeapsMedian medianFinder = new TwoHeapsMedian();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2
    }
}
```

---

Perfeito! Vamos seguir com os padrões restantes:

---

### 📌 **11. Subsets**

**Descrição:**  
Geração de todos os subconjuntos de um conjunto (potência do conjunto). Essencial para problemas de backtracking.

**Exemplo:**

```java
import java.util.*;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsets(new int[]{1, 2, 3}));
        // Output: [[], [1], [1, 2], [1, 2, 3], ...]
    }
}
```

---

### 📌 **12. Modified Binary Search**

**Descrição:**  
Busca binária adaptada para encontrar condições específicas.

**Exemplo:**  
Buscar o primeiro número maior ou igual a `target`.

```java
public class ModifiedBinarySearch {
    public static int searchCeiling(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        System.out.println(searchCeiling(arr, 9)); // Output: 3 (10)
    }
}
```

---

### 📌 **13. Bitwise XOR**

**Descrição:**  
XOR é útil para problemas de paridade ou onde os números aparecem uma vez.

**Exemplo:**  
Encontrar o número que aparece apenas uma vez quando os outros aparecem duas vezes.

```java
public class BitwiseXOR {
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 1, 2};
        System.out.println(findSingleNumber(nums)); // Output: 4
    }
}
```

---

### 📌 **14. Top 'K' Elements**

**Descrição:**  
Encontrar os `K` maiores/menores elementos usando heap (priority queue).

**Exemplo:**  
Top 3 maiores números.

```java
import java.util.*;

public class TopKElements {
    public static List<Integer> findTopK(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11};
        System.out.println(findTopK(nums, 3)); // Output: [5, 11, 12]
    }
}
```

---

### 📌 **15. K-way Merge**

**Descrição:**  
Mesclar `K` arrays ordenados. Usado em algoritmos como merge sort externo ou streaming.

**Exemplo:**

```java
import java.util.*;

class Element {
    int value, arrayIndex, elementIndex;
    Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class KWayMerge {
    public static List<Integer> merge(int[][] arrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Element(arrays[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
                minHeap.add(new Element(
                        arrays[current.arrayIndex][current.elementIndex + 1],
                        current.arrayIndex,
                        current.elementIndex + 1
                ));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 5},
            {1, 3, 4},
            {2, 6}
        };
        System.out.println(merge(arrays)); // Output: [1, 1, 2, 3, 4, 4, 5, 6]
    }
}
```

---

Vamos finalizar com os últimos padrões:

---

### 📌 **16. Topological Sort**

**Descrição:**  
Ordenação de tarefas com dependências (DAG). Usado em agendamento de tarefas, compilação, etc.

**Exemplo:**

```java
import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedOrder.add(vertex);
            for (int neighbor : graph.get(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return sortedOrder.size() == vertices ? sortedOrder : new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] edges = {{3,2},{3,1},{2,0},{1,0}};
        System.out.println(sort(4, edges)); // Output: [3, 2, 1, 0]
    }
}
```

---

### 📌 **17. 0/1 Knapsack**

**Descrição:**  
Clássico problema de programação dinâmica onde cada item pode ser incluído ou não.

**Exemplo:**

```java
public class Knapsack01 {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = dp[i - 1][c];
                if (weights[i - 1] <= c) {
                    profit1 = profits[i - 1] + dp[i - 1][c - weights[i - 1]];
                }
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(solveKnapsack(profits, weights, 7)); // Output: 22
    }
}
```

---

### 📌 **18. Fibonacci Numbers (DP + Recursão com Memoization)**

**Descrição:**  
Problema clássico de recorrência.

**Exemplo com Memoization:**

```java
import java.util.*;

public class Fibonacci {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n < 2) return n;
        if (!memo.containsKey(n)) {
            memo.put(n, fib(n - 1) + fib(n - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // Output: 55
    }
}
```

---

### 📌 **19. Palindromic Subsequence**

**Descrição:**  
Encontra o tamanho da maior subsequência palindrômica.

**Exemplo:**

```java
public class PalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbabcbcab")); // Output: 7 (babcbab)
    }
}
```

---

### 📌 **20. Longest Common Substring**

**Descrição:**  
Problema clássico de DP para encontrar substrings idênticas entre duas strings.

**Exemplo:**

```java
public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int maxLength = 0;
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcde", "abfce")); // Output: 2 ("ab")
    }
}
```

---

✅ **Conclusão:**
Esses 20 padrões cobrem as bases mais frequentes em entrevistas técnicas e resolução de algoritmos em Java, com abordagens eficientes.
