/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * Given a robot cleaner in a room modeled as a grid. Each cell in the grid can be empty or blocked. 
 * The robot cleaner can move forward, turn left or turn right. When it tries to move into a blocked cell, its 
 * bumper sensor detects the obstacle and it stays on the current cell.
 * The control API:
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean Move();
 * 
 *   // Robot will stay on the same cell after calling Turn*. k indicates how
 *   // many turns to perform.
 *   void TurnLeft(int k);
 *   void TurnRight(int k);
 * 
 *   // Clean the current cell.
 *   void Clean();
 * 
 *   boolean Move(Direction d);
 * }
 * 
 * sample input
 * ++++++++++
 * +........+
 * +...^....+
 * +.+......+
 * ++++.+++++
 * +.....+
 * +++++++
 */
import java.util.*;
public class CleaningRobot {

    public void move() {}
    public void TurnRight(int k){}
    public void clean() {}

    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    Set<String> memo = new HashSet<>();
    public void dfsClean(int x, int y, int d, Set<String> memo){
        // x,y: position, d: direction
        String hcode = x+":"+y;
        this.Clean();
        memo.add(hcode);
        for(int i=0; i<4; i++){
            this.TurnRight(i>0?1:0); // first go ahead, then each time one turn.1
            int nd = (d+i)%4;
            int nx = x+dirs[nd][0];
            int ny = y+dirs[nd][1];
            String ncode = nx+":"+ny;
            if(!memo.contains(ncode)){
                if(this.Move()){
                    dfsClean(nx, ny, nd, memo);// take care to orient to oposite direction of nd
                    // move back and turn to nd
                    // reset to direction before
                    this.TurnRight(2);
                    this.Move();
                }else{
                    // obstacle found, remember it
                    memo.add(ncode);
                }
            }
        }
        // orient robot to oposite direction of d. 
        this.TurnRight(3);
    }
}