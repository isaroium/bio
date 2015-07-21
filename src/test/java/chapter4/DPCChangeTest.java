package chapter4;

import static org.junit.Assert.assertEquals;

/**
 * Created by mihai.isaroiu on 7/21/15.
 */
public class DPCChangeTest {

    @org.junit.Test
    public void testRun() throws Exception {
        assertEquals(2, DPCChange.run(40, new Integer[]{50, 25, 20, 10, 5, 1}));

    }

    @org.junit.Test
    public void testExtraRun() throws Exception {
        assertEquals(338, DPCChange.run(8074, new Integer[]{24, 13, 12, 7, 5, 3, 1}));

    }

    @org.junit.Test
    public void testExtraProblem() throws Exception {
        System.out.println(DPCChange.run(18064, new Integer[]{23, 21, 11, 5, 3, 1}));

    }
}