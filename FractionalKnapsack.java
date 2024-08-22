import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int value, weight;

    // Constructor
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Function to get the maximum value
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);  // Sort in descending order
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take the whole item
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the item
                totalValue += item.value * ((double) capacity / item.weight);
                break;  // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of items
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        // Input the capacity of the knapsack
        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        // Input values and weights for each item
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        // Calculate the maximum value we can carry
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
