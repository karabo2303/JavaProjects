import java.util.*;

public class BasketballTest {
    public static void main(String[] args) {
        Random rand = new Random();
        BasketballPlayer[] players = new BasketballPlayer[10];

        // Generate random players
        for (int i = 0; i < players.length; i++) {
            if (rand.nextBoolean()) {
                players[i] = new PointGuard("PG" + i, rand.nextInt(15) + 20, 
                    1.70 + rand.nextDouble() * 0.3, 
                    5 + rand.nextDouble() * 5);
            } else {
                players[i] = new Center("C" + i, rand.nextInt(15) + 20, 
                    2.00 + rand.nextDouble() * 0.3, 
                    0.5 + rand.nextDouble() * 3);
            }
        }

        // Print unsorted players
        System.out.println("Unsorted Players:");
        for (BasketballPlayer player : players) {
            player.playStyle();
            System.out.println(player.toString());
            System.out.println(player);           
        }

        // Sort players by age
        Arrays.sort(players);

        // Print sorted players
        System.out.println("\nSorted Players (by Age):");
        for (BasketballPlayer player : players) {
            System.out.println(player);
        }

        // Complexity Analysis
        printComplexityAnalysis(players.length);
    }

    public static void printComplexityAnalysis(int n) {
        System.out.println("\n--- Time Complexity Analysis ---");

        System.out.println("Detailed Method (τ-notation): T(n) = c1*n*log(n) + c2*n + c3");
        System.out.println("Simplified Method: T(n) = n*log(n)");
        System.out.println("Big-O Notation: O(n log n)");
    }
}
