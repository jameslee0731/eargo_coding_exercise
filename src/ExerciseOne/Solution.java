package ExerciseOne;

import java.util.ArrayList;
import java.util.List;

/**
 * User:   bl
 * Package ExerciseOne
 * File    Solution
 * Analyze
 *          1. How approach this problem?
 *              this problem is a very similar to coin change (dp) problem, but the significant difference from that one is that
 *              this problem has optimal structure, which could solve it using greedy strategy that is generally faster than dynamical programming.
 *
 *              Let's denote total amount of money is total.
 *              1.1 first, let's consider 1 <= total <= 5, we denote remainder = total % 5, which gives 0 <= remainder <= 4
 *                  1.1.1 if remainder > 0, it means we have no choice but using penny to make this change
 *                  1.1.2 if remainder = 0, it means total = 5, we have two options,
 *                      option 1, using 5 pennies, option 2, using 1 nickel. apparently, options 2 is best because it uses smaller amount of coins to make this change
 *                  conclusion 1.1:
 *                      1. if remainder is not 0, we have to make this change using penny
 *                      2. if remainder is 0, it's always better to use 1 nickel rather than 5 pennies.
 *              1.2 second, let's consider 6 <= total <= 10. we denote remainder = total % 5, which gives 0 <= remainder <= 4
 *                  1.2.1 if remainder > 0, it means we have no choice but using penny to make this change
 *                  1.2.2 if remainder = 0, it means total = 10, from consultion 1.1, we have 2 options
 *                      option 1, using 2 nickels, option 2, using 1 dime
 *                  conslusion 1.2:
 *                      1. if total contains 1 nickel, it's always better to use 1 dime rather than 2 nickels
 *              we continue this analyze in interval
 *                  [11, 15]: if remainder > 0, have to use penny; else remainder = 0, using 1 nickel and 1 dime is better than 3 nickels
 *                  [16, 20]: if remainder > 0, have to use penny; else, using 2 dimes is always better
 *                  [21, 25]: if remainder > 0, have to use penny: else, using quarters is always better
 *              2.1 then, for any given number, we could greedily using quarters to make change first, then, dimes, next, using nickels, last, using penny to make this change
 *          2. efficient analysis
 *              time complexity
 *                  we only have 4 different type of coins, i.e. quarters, dimes, nickels and pennies,
 *                  thus, we only need to compute the amount we need using each coin.
 *                  So, the time complexity is O(1).
 *
 *              Space complexity
 *                  we stores the 4 numbers representing the amount of each coin needed respectively,
 *                  so, space complexity is O(1) as well.
 *          3. comment
 *              Solution code is in class Exercise01
 *
 *              change total in TestExercise01, you could test it.
 */
public class Solution {
    public List<Type> changeCoins(int total) {
        //  to record the remaining money we need to change
        int rmd = total;
        int[] money = new int[]{
                25, 10, 5, 1
        };

        /**
         *  store the amount of money we need to make this change,
         *      position 0 store the amount of money[0] we need, which is how many quarters we need.
         *      position 1, position 2 and position 3 represents amount of dime, nickel and penny respectively
         */
        int[] nums = new int[4];
        int p = 0;

        //  as long as the remaining money is larger than 0, we have to continue making change
        while (rmd > 0) {
            int coinNeeded = rmd / money[p];
            nums[p] = coinNeeded;
            rmd -= coinNeeded * money[p];
            p++;
        }

        //  build result and return it.
        Type t1 = new Type("Quarters", nums[0]);
        Type t2 = new Type("Dimes", nums[1]);
        Type t3 = new Type("Nickels", nums[2]);
        Type t4 = new Type("Pennies", nums[3]);

        List<Type> rst = new ArrayList<>();
        rst.add(t1);
        rst.add(t2);
        rst.add(t3);
        rst.add(t4);

        return rst;
    }
}
