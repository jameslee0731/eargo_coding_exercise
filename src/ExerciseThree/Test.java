package ExerciseThree;

/**
 * User:   bl
 * Package ExerciseThree
 * File    Test
 */
public class Test {
    public static void main(String[] args) {
        int[] prices = new int[] {
                3, 8, 8, 55, 38, 1, 7, 42, 54, 53
        };

        Solution exercise03 = new Solution();
        Type rst = exercise03.buyStock(prices);
        print(rst);
    }

    static void print(Type type) {
        if (type == null) {
            System.out.println("Invalid input");
        } else {
            System.out.println(type);
        }
    }
}
