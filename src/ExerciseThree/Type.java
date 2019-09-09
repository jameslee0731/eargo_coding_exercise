package ExerciseThree;

/**
 * User:   bl
 * Package ExerciseThree
 * File    Type
 */
public class Type {
    int buyDay;
    int sellday;
    int gain;

    public Type() {
        this.buyDay = -1;
        this.sellday = -1;
        this.gain = 0;
    }

    public Type(int b, int s, int g) {
        this.buyDay = b;
        this.sellday = s;
        this.gain = g;
    }

    public String toString() {
        String s = "Day " + this.buyDay + " as buying day and \n" + "Day " + this.sellday + " as selling day.\n" + "Total gain is $" + this.gain + ".";
        return s;
    }
}
