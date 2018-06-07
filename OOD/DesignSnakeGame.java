/**
 * Date: 06/07/2018
 * Created By: Shuai Liu
 * 
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you 
 * are not familiar with the game.
 * 
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * 
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the 
 * game's score both increase by 1.
 * 
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food 
 * was eaten by the snake.
 * 
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * 
 * Example:
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 * Snake snake = new Snake(width, height, food);
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * |S| | |
 * | | |F|
 * snake.move("R"); -> Returns 0
 * | |S| |
 * | | |F|
 * snake.move("D"); -> Returns 0
 * | | | |
 * | |S|F|
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * | |F| |
 * | |S|S|
 * snake.move("U"); -> Returns 1
 * | |F|S|
 * | | |S|
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * | |S|S|
 * | | |S|
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
import java.util.*;
public class DesignSnakeGame {

    Set<Integer> set;
    Deque<Integer> snake;
    int foodIndex;
    int score;
    int[][] food;
    int width;
    int height;

/** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        set = new HashSet<>();
        snake = new ArrayDeque<>();
        set.add(0);
        snake.add(0);
        this.width = width;
        this.height = height;
        this.food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) return -1;
        int rowHead = snake.peekFirst() / width;
        int colHead = snake.peekFirst() % width;
        if (direction.equals("U")) rowHead--;
        else if (direction.equals("L")) colHead--;
        else if (direction.equals("R")) colHead++;
        else if (direction.equals("D")) rowHead++;
        int head = rowHead * width + colHead;
        set.remove(snake.peekLast()); // new head is legal to be in old tail's position, remove from set temporarily
        // case 1: if snake out of boarder or eat itself
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) return score = -1;
        set.add(head);
        snake.offerFirst(head);
        // case 2: eat food, keep tail
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(snake.peekLast());
            foodIndex++;
            score++;
            return score;
        }
        // case 3: normal move
        snake.pollLast();
        return score;
    }
}