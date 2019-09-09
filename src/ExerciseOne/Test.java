package ExerciseOne;

import java.util.List;

/**
 * User:   bl
 * Package ExerciseOne
 * File    Test
 */
public class Test {
    public static void main(String[] args) {
        int total = 83;
        Solution exercise01 = new Solution();
        List<Type> rst = exercise01.changeCoins(total);
        System.out.println(rst);
    }
}
