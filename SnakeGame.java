import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private static final int GRID_SIZE = 10;
    private static final char EMPTY_CELL = '.';
    private static final char FOOD_CELL = '*';
    private static final char HEAD_CELL = 'H';
    private static final char BODY_CELL = 'b';

    private MyArrayListHM<Point> snake;
    private Point food;
    private int score;
    private int dx, dy; // Movement direction
    private Random rand;
    private Scanner input;

    public SnakeGame() {
        rand = new Random();
        input = new Scanner(System.in);
    }

    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            initializeGame();
            boolean running = true;

            while (running) {
                drawGrid();
                System.out.println("Score: " + score);
                System.out.print("Enter direction (WASD): ");
                char dir = input.next().toUpperCase().charAt(0);
                updateDirection(dir);

                running = moveSnake();
                if (!running) {
                    System.out.println("Game Over! Final Length: " + snake.getSize() + ", Score: " + score);
                    System.out.print("Play again? (Y/N): ");
                    char again = input.next().toUpperCase().charAt(0);
                    playAgain = (again == 'Y');
                }
            }
        }
    }

    private void initializeGame() {
        snake = new MyArrayListHM<>();
        snake.add(0, new Point(GRID_SIZE / 2, GRID_SIZE / 2)); // start in center
        dx = 0;
        dy = 0; // not moving until input
        score = 0;
        placeFood();
    }

    private void placeFood() {
        while (true) {
            int fx = rand.nextInt(GRID_SIZE);
            int fy = rand.nextInt(GRID_SIZE);
            Point candidate = new Point(fx, fy);
            if (!snakeContains(candidate)) {
                food = candidate;
                break;
            }
        }
    }

    private boolean snakeContains(Point p) {
        for (int i = 0; i < snake.getSize(); i++) {
            if (snake.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }

    private void drawGrid() {
        char[][] grid = new char[GRID_SIZE][GRID_SIZE];
        // Fill with empty cells
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }
        // Place food
        grid[food.y][food.x] = FOOD_CELL;
        // Place snake
        for (int i = 0; i < snake.getSize(); i++) {
            Point seg = snake.get(i);
            if (i == 0) {
                grid[seg.y][seg.x] = HEAD_CELL;
            } else {
                grid[seg.y][seg.x] = BODY_CELL;
            }
        }
        // Print grid
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }

    private void updateDirection(char dir) {
        switch (dir) {
            case 'W': dx = 0; dy = -1; break;
            case 'S': dx = 0; dy = 1; break;
            case 'A': dx = -1; dy = 0; break;
            case 'D': dx = 1; dy = 0; break;
        }
    }

    private boolean moveSnake() {
        if (dx == 0 && dy == 0) return true; // no movement yet

        Point head = snake.get(0);
        int newX = (head.x + dx + GRID_SIZE) % GRID_SIZE; // wrapping
        int newY = (head.y + dy + GRID_SIZE) % GRID_SIZE;
        Point newHead = new Point(newX, newY);

        // Check self-collision
        for (int i = 0; i < snake.getSize(); i++) {
            if (snake.get(i).equals(newHead)) {
                return false; // Game over
            }
        }

        // Add new head
        snake.add(0, newHead);

        // Check food
        if (newHead.equals(food)) {
            score++;
            placeFood();
        } else {
            // Remove tail
            snake.remove(snake.getSize() - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        new SnakeGame().start();
    }
}
