
import java.util.*;

class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        if (n >= 1) primes[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int total = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                if (total + i > s) {
                    break;
                }

                total += i;
                list.add(i);
            }
        }

        return list;
    }
}
