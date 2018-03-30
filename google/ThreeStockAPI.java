/**
 * Input是一个list,里面的Object包含timestamp和price两个信息. 正常情况下Object是按timestamp排列的，也就是说这个list基本表示了一天的股价走势图。
 * 但是有一种情况会有逆时间顺序的Object出现，也就是在list后面出现的object会带一个比之前object小的timestamp. 
 * 这种object表示之前timestamp出现的object价格信息有误，需要删掉这个价格。同时考虑这个删除操作对最大最小值和当前股价这三个数据的影响。
 * 再详细一点。我们有{timestamp: 90, price: 10}{timestamp: 92, price: 11}{timestamp: 95, price 14}{timestamp: 90, price: anyvalue}
 * 这样一个数组。最后一个元素的ts90小于之前的95,所以这是一个逆时间顺序object,需要把之前ts=90所提供的价格删掉。
 */
import java.util.*;
public class ThreeStockAPI {
    private class StockInfo {
        int time;
        int price;
        public StockInfo(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }  
    Map<Integer, StockInfo> map = new HashMap<>();
    PriorityQueue<StockInfo> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));
    PriorityQueue<StockInfo> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.price, a.price));
    public void update(List<StockInfo> stocks) {
        for (StockInfo s : stocks) {
            if (map.containsKey(s.time)) {
                StockInfo cur = map.get(s.time);
                minHeap.remove(cur);
                maxHeap.remove(cur);
            }
            map.put(s.time, s);
            minHeap.add(s);
            maxHeap.add(s);
        }
    }
    public int current(int time) {
        StockInfo s = map.get(time);
        return s.price;
    }
    public int max() {
        return maxHeap.peek().price;
    }
    public int min() {
        return minHeap.peek().price;
    }
}