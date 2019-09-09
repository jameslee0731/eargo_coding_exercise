package ExerciseThree;

/**
 * User:   bl
 * Package ExerciseThree
 * File    Solution
 * Analyze
 *              1. how to approach problem
 *                  this problem is equivalent to that, find a pair of bottom point and peak point such that
 *                  1.1 bottom point is on the left of peak point
 *                  1.2 the difference between peak and bottom is maximized
 *                  so, we could scan the input, prices array and update the bottom point(local min) and difference
 *
 *                  if current price(at position i) is larger than min, then, we compare the previous total gain and current gain if we sell at i
 *                      if previous gain is larger, we do not update anything
 *                      if selling at current position i gains more, we update the total gain and update the sell day
 *                  if current price(at position i) is smaller than min, then, we update the bottom point(local min) and update the buy day
 *
 *              2. efficient analysis
 *                  time complexity
 *                      we have to linearly scan the whole input, but the input size is fixed, 10, so
 *                      time complexity is O(1)
 *                  Space complexity
 *                      space complexity is O(1)
 *              3. Comment
 *                  comment below
 */
public class Solution {
    public Type buyStock(int[] prices) {
        if (prices == null || prices.length == 0) {
            return null;
        }

        //  start from position 0, min is prices[0], gain is 0
        int min = prices[0];
        int gain = 0;
        //  buy and sell record the buying day and selling day
        //  because local min may appear after peak and no corresponding peak exists in the end, so, we use prevBuy to record the local min day which occurs before a peak point if this senario exists,
        int sell = 0, buy = 0, prevBuy = -1;

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            if (p > min) {     //  current price is larger than min, check condition to see whether we need update the gain and sell day or not
                if (p - min > gain) {
                    gain = p - min;
                    sell = i;
                }
            } else {            //  current price is smaller than min, we update min price and buy day.
                min = p;
                if (prevBuy == -1) {    //  update buy and prevBuy the first time
                    buy = i;
                    prevBuy = i;
                } else {
                    if (buy <= sell) {  //  if previous recorded buy day is smaller sell day, we update prevBuy and buy
                        prevBuy = buy;
                        buy = i;
                    } else {            //  previous recorded buy day is larger than sell day, previous buy day is not a valid record, only update buy day
                        buy = i;
                    }
                }
            }
        }

        //  construct result by checking "buy first" rule is meet
        Type type = null;
        if (buy <= sell) {  // buy first rule is met, construct result
            type = new Type(buy + 1, sell + 1, gain);
        } else {            //  buy first rule is not met, use prevBuy and sell day to construct result
            gain = prices[sell] - prices[prevBuy];
            type = new Type(prevBuy + 1, sell + 1, gain);
        }


        return type;
    }
}
