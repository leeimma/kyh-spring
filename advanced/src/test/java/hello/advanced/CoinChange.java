package hello.advanced;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CoinChange {
    public static int countWays(int[] coins, int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];
        
        // 초기값: 합계가 0인 경우, 방법의 수는 1입니다 (동전을 사용하지 않는 경우).
        dp[0] = 1;
        
        // 각 동전에 대해 DP 배열을 업데이트합니다.
        for (int coin : coins) {
            System.out.println("coin "+coin);
            for (int j = coin; j <= sum; j++) {
                System.out.println("dp["+ j +"-"+ coin +"] "+dp[j - coin] );
                System.out.println("dp["+j+"] "+dp[j] );
                dp[j] += dp[j - coin];
                System.out.println("dp["+j+"] +=" +" dp["+ (j - coin) +"] " +dp[j] );
            }
            System.out.println("dp " + Arrays.toString(dp));
        }

        
        return dp[sum];
    }

    @Test
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 3};
        int sum1 = 4;
        System.out.println("Number of ways to make sum " + sum1 + " with coins " + Arrays.toString(coins1) + " is " + countWays(coins1, sum1));
        
        int[] coins2 = {2, 5, 3, 6};
        int sum2 = 10;
        System.out.println("Number of ways to make sum " + sum2 + " with coins " + Arrays.toString(coins2) + " is " + countWays(coins2, sum2));
    }
}