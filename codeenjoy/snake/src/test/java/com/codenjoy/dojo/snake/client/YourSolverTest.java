package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.RandomDice;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 01.12.2015.
 */
public class YourSolverTest {
    @Test
    public void testSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ▼  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼► ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ▲  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ◄☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");

    }

    @Test
    public void testNotSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼◄ ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ►☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");
    }

    @Test
    public void testEatMe_LEFT_DOWN_1() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼╘═► ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "DOWN");
    }

    @Test
    public void testEatMe_LEFT_DOWN_2() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼  ▲ ☼" +
                "☼ ☺║ ☼" +
                "☼  ╙ ☼" +
                "☼☼☼☼☼☼", "LEFT");
    }

    @Test
    public void testEatMe_RIGHT_DOWN_1() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼◄═╕ ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "DOWN");
    }

    @Test
    public void testEatMe_RIGHT_DOWN_2() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ▲  ☼" +
                "☼ ║☺ ☼" +
                "☼ ╙  ☼" +
                "☼☼☼☼☼☼", "RIGHT");
    }

    @Test
    public void testEatMe_RIGHT_UP_1() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼◄═╕ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "UP");
    }

    @Test
    public void testEatMe_RIGHT_UP_2() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ╓  ☼" +
                "☼ ║☺ ☼" +
                "☼ ▼  ☼" +
                "☼☼☼☼☼☼", "RIGHT");
    }

    @Test
    public void testEatMe_LEFT_UP_1() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼╘═► ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "UP");
    }

    @Test
    public void testEatMe_LEFT_UP_2() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼  ╓ ☼" +
                "☼ ☺║ ☼" +
                "☼  ▼ ☼" +
                "☼☼☼☼☼☼", "LEFT");
    }

    @Test
    public void testEatMe_DOWN() {
        assertB("☼☼☼☼☼☼" +
                "☼ ▲  ☼" +
                "☼ ║  ☼" +
                "☼ ╙  ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "RIGHT");
    }

    @Test
    public void testEatMe_UP() {
        assertB("☼☼☼☼☼☼" +
                "☼  ☺ ☼" +
                "☼  ╓ ☼" +
                "☼  ║ ☼" +
                "☼  ▼ ☼" +
                "☼☼☼☼☼☼", "LEFT");
    }

    @Test
    public void testEatMe_RIGHT() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺╘═►☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "DOWN");
    }

    @Test
    public void testEatMe_LEFT() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼◄═╕☺☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "UP");
    }

    @Test
    public void testDontEatStone_UP() {
        assertB("☼☼☼☼☼☼" +
                "☼ ☺  ☼" +
                "☼ ☻  ☼" +
                "☼ ▲  ☼" +
                "☼ ╙  ☼" +
                "☼☼☼☼☼☼", "RIGHT");
    }

    @Test
    public void testDontEatStone_DOWN() {
        assertB("☼☼☼☼☼☼" +
                "☼  ╓ ☼" +
                "☼  ▼ ☼" +
                "☼  ☻ ☼" +
                "☼  ☺ ☼" +
                "☼☼☼☼☼☼", "LEFT");
    }

    @Test
    public void testDontEatStone_RIGHT() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼╘►☻☺☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "DOWN");
    }

    @Test
    public void testDontEatStone_LEFT() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☺☻◄╕☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "UP");
    }

    private void assertB(String boardString, String expected) {
        // given
        YourSolver solver = new YourSolver();

        // when
        Board board = (Board) new Board().forString(boardString); // TODO испарвить engine

        String direction = solver.get(board);

        // then
        assertEquals(expected, direction);
    }
}
