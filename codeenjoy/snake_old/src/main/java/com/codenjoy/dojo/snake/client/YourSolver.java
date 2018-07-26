package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Point;

import java.util.LinkedList;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "antkott";
    private Board board;

    @Override
    public String get(Board board) {
        this.board = board;

        Point head = board.getSnakeHead();
        Point apple = board.getApples().get(0);

        return getDirection(head, apple).toString();
    }

    private Direction getDirection(Point head, Point apple) {
        int dx = head.getX() - apple.getX();
        int dy = head.getY() - apple.getY();

        LinkedList directions = getDirections(dx, dy);

        Direction direction = (Direction)directions.getFirst();

        if (!board.isTailOn(head, direction) &&
            !board.isStoneOn(head, direction))
        {
            return direction;
        }

        if (directions.size() == 1) {
            return board.getSnakeDirection().clockwise();
        }

        return (Direction) directions.getLast();
    }

    private LinkedList getDirections(int dx, int dy) {
        LinkedList result = new LinkedList();
        if (dx < 0) {
            result.add(Direction.UP);
        }
        if (dx > 0) {
            result.add(Direction.UP);
        }
        if (dy < 0) {
            result.add(Direction.UP);
        }
        if (dy > 0) {
            result.add(Direction.UP);
        }
        return result;
    }

    public static void main(String[] args) {
        start(USER_NAME, WebSocketRunner.Host.LOCAL);
    }

    public static void start(String name, WebSocketRunner.Host server) {
        try {
            WebSocketRunner.run(server, name,
                    new YourSolver(),
                    new Board());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
