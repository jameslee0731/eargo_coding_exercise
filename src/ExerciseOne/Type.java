package ExerciseOne;

/**
 * User:   bl
 * Package ExerciseOne
 * File    Type
 * Description
 */
public class Type {
    String coin;
    int nums;

    public Type(String val, int nums) {
        this.coin = val;
        this.nums = nums;
    }

    public String toString() {
        String s = coin + " : " + nums;
        return s;
    }
}
