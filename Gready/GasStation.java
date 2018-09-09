/**
 * Date: 08/21/0291
 * Created By: Shuai Liu
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with 
 * an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Note:
 * 1. If there exists a solution, it is guaranteed to be unique.
 * 2. Both input arrays are non-empty and have the same length.
 * 3. Each element in the input arrays is a non-negative integer.
 * 
 * Example 1:
 * 
 * Input: 
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * Output: 3
 * 
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * 
 * Example 2:
 * Input: 
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return sumGas < sumCost ? -1 : start;
    }
}
/**
∆ If there is only one gas station, it’s true.
∆ If there are two gas stations a and b, and gas(a) cannot afford cost(a), i.e., gas(a) < cost(a), then gas(b) must be greater than cost(b), i.e., gas(b) > cost(b), since gas(a) + gas(b) > cost(a) + cost(b); so there must be a way too.
∆ If there are three gas stations a, b, and c, where gas(a) < cost(a), i.e., we cannot travel from a to b directly, then:
∆ either if gas(b) < cost(b), i.e., we cannot travel from b to c directly, then cost(c) > cost(c), so we can start at c and travel to a; since gas(b) < cost(b), gas(c) + gas(a) must be greater than cost(c) + cost(a), so we can continue traveling from a to b. Key Point: this can be considered as there is one station at c’ with gas(c’) = gas(c) + gas(a) and the cost from c’ to b is cost(c’) = cost(c) + cost(a), and the problem reduces to a problem with two stations. This in turn becomes the problem with two stations above.
∆ or if gas(b) >= cost(b), we can travel from b to c directly. Similar to the case above, this problem can reduce to a problem with two stations b’ and a, where gas(b’) = gas(b) + gas(c) and cost(b’) = cost(b) + cost(c). Since gas(a) < cost(a), gas(b’) must be greater than cost(b’), so it’s solved too.
∆ For problems with more stations, we can reduce them in a similar way. In fact, as seen above for the example of three stations, the problem of two stations can also reduce to the initial problem with one station.
 */