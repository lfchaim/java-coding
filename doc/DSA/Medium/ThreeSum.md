# Algoritmo Three Sum

O **Three Sum** é um clássico problema de algoritmos e estruturas de dados. Ele consiste em, dado um array de números inteiros, encontrar todas as trincas `(a, b, c)` no array tal que `a + b + c = 0`.

O desafio inclui:

- Não pode conter trincas duplicadas na resposta.
- O array pode ter valores negativos, zero ou positivos.

A seguir, apresento as principais abordagens para resolver esse problema, evoluindo até a de melhor desempenho.

---

## 1. Solução Ingênua (Fuerça Bruta)

### Descrição

Percorre todos os trios possíveis usando três loops aninhados. Verifica se a soma resulta em zero.

### Complexidade

- **Tempo:** O(n³)
- **Espaço:** O(1) (desconsiderando espaço de saída)

### Exemplo em Java

```java
import java.util.*;

public class ThreeSumNaive {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>(); // Para evitar duplicados
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // Ordena o trio para evitar duplicatas
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
``` 

2. Solução Melhorada (Com HashSet)
Descrição
Para cada elemento, utiliza um HashSet para buscar os dois números restantes que formam a soma zero. Ainda assim, pode gerar duplicatas e tem desempenho intermediário.

Complexidade
Tempo: O(n²)
Espaço: O(n)
Exemplo em Java
```java
import java.util.*;

public class ThreeSumHashSet {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -nums[i] - nums[j];
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
}
```

3. Solução Ótima (Two Pointers após Sort)
Descrição
Ordena o array e, para cada elemento, utiliza o método de dois ponteiros para encontrar as outras duas parcelas, evitando duplicatas de forma eficiente.

Complexidade
Tempo: O(n²)
Espaço: O(1) (desconsiderando espaço de saída)
Exemplo em Java

```java
import java.util.*;

public class ThreeSumOptimal {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Ordena o array
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Evita duplicatas
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Avança ponteiros evitando duplicatas
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Precisa de números maiores
                } else {
                    right--; // Precisa de números menores
                }
            }
        }
        return result;
    }
}
```

Exemplo de Uso
```java
public class Main {
    public static void main(String[] args) {
        ThreeSumOptimal solver = new ThreeSumOptimal();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solver.threeSum(nums)); // Saída: [[-1, -1, 2], [-1, 0, 1]]
    }
}
```

Resumo das Soluções
|SOLUÇÃO|COMPLEXIDADE DE TEMPO|COMPLEXIDADE DE ESPAÇO|COMENTÁRIO|
|-------|---------------------|----------------------|----------|
|Fuerça Bruta|	O(n³)|	O(1)|	Muito lenta para grandes n|
|HashSet|	O(n²)|	O(n)|	Mais rápida, mas ainda alta|
|Two Pointers|	O(n²)|	O(1)|	Mais eficiente, amplamente usada|


Conclusão
A solução ótima utiliza ordenação e ponteiros, sendo a abordagem recomendada para casos práticos, pois mantém ótima eficiência e permite evitar resultados duplicados de maneira natural.