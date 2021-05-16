import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int A[] = new int[n];
        Set<Integer> divisors = new HashSet<>();
        A[0] = in.nextInt();
        getDivisors(divisors, A[0]);
        for(int A_i = 1; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            for (int divisor : new HashSet<>(divisors)) {
                if (A[A_i] % divisor != 0) {
                    divisors.remove(divisor);
                }
            }
        }
        int maxValue = 0;
        for (int divisor : divisors) {
            int value = (k / divisor) * divisor;
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.println(maxValue);
    }
    
    public static void getDivisors(Set<Integer> divisors, int a) {
        if (a != 1) {
            divisors.add(a);
        }
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
                divisors.add(a / i);
            }
        }
    }
}
