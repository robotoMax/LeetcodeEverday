/**
 * At the first station, the tank is empty. Every mile, the car will need v unit fuel. The car has a maxSizeTank unit tank.
 */
import java.util.*;
public class MinimalCostsToFuelGasStation {
    public int solution(int v, int maxSizeTank, int[] stations, int[] costs) {
        Stack<Integer> stack = new Stack<>();
        int len = stations.length;
        int[] nextLowerPrice = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && costs[i] <= costs[stack.peek()]) stack.pop();
            nextLowerPrice[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int curGas = 0;
        int cost = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            if (curGas < 0) return -1;
            int gas = nextLowerPrice[i] == -1 ? Integer.MAX_VALUE : (stations[nextLowerPrice[i]] - stations[i]) * v;
            int gasNeeded = Math.min(maxSizeTank, gas);
            if (curGas < gasNeeded) {
                cost += (gasNeeded - curGas) * costs[i];
                curGas = gasNeeded;
            }
            curGas -= (stations[i + 1] - stations[i]) * v;
        }
        return cost;
    }
    public static void main(String[] args) {
        MinimalCostsToFuelGasStation m = new MinimalCostsToFuelGasStation();
        int v = 1;
        int maxSizeTank = 60;
        int[] stations = {0, 50, 100, 150};
        int[] costs = {4,3,2,1};
        System.out.println(m.solution(v, maxSizeTank, stations, costs));        
    }
}