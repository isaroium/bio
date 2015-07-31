package chapter4.util;

import junit.framework.TestCase;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class ScoringTest extends TestCase {

    public void testGetScore() throws Exception {
        assertEquals(Scoring.getScoreClass().getScore('A', 'A'), 4);
        assertEquals(Scoring.getScoreClass().getScore('A', 'C'), 0);
        assertEquals(Scoring.getScoreClass().getScore('H', 'W'), -2);
        assertEquals(Scoring.getScoreClass().getScore('W', 'H'), -2);
        assertEquals(Scoring.getScoreClass().getScore('W', 'W'), 11);
        assertEquals(Scoring.getScoreClass().getScore('P', 'Y'), -3);
        assertEquals(Scoring.getScoreClass().getScore('Y', 'P'), -3);
    }
}