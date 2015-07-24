package chapter4;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

/**
 * Created by mihai.isaroiu on 7/21/15.
 */
public class SimpleTouristTest {
    int output = 0;

    public SimpleTourist getInstance(String filename) throws IOException {
        SimpleTourist instance = new SimpleTourist();
        if (filename != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename)));
            String s = br.readLine();
            if ("Input:".equalsIgnoreCase(s))
                s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            int[][] down = new int[n][m + 1];
            int[][] left = new int[n + 1][m];
            int i = 0;
            while ((s = br.readLine()) != "-" && s.split(" ").length > 1) {
                int j = 0;
                for (String st : s.split(" "))
                    down[i][j++] = Integer.parseInt(st);
                i++;

            }
            if ("-".equals(s)) {

            }
            i = 0;
            while ((s = br.readLine()) != null && s.split(" ").length > 1) {
                int j = 0;
                for (String st : s.split(" "))
                    left[i][j++] = Integer.parseInt(st);
                i++;
            }

            while ((s = br.readLine()) != null) {
                try {
                    output = Integer.parseInt(s);
                } catch (Exception e) {
                    //DO Nothing
                }
            }
            instance.setDown(down);
            instance.setM(m);
            instance.setN(n);
            instance.setRight(left);
        }
        return instance;
    }

    @Test
    public void testTour() throws Exception {
        SimpleTourist st = getInstance(null);
        st.setM(4);
        st.setN(4);
        st.setDown(new int[][]{{1, 0, 2, 4, 3}, {4, 6, 5, 2, 1}, {4, 4, 5, 2, 1}, {5, 6, 8, 5, 3}});
        st.setRight(new int[][]{{3, 2, 4, 0}, {3, 2, 4, 2}, {0, 7, 3, 3}, {3, 3, 0, 2}, {1, 3, 2, 2}});
        assertEquals(34, st.tour());

    }

    @Test
    public void testTourExtra() throws Exception {
        SimpleTourist st = getInstance("/home/mihai.isaroiu/Downloads/longest_path_1.txt");
        assertEquals(output, st.tour());
    }

    @Test
    public void testTourProblem() throws Exception {
        SimpleTourist st = getInstance("/home/mihai.isaroiu/Downloads/dataset_261_9.txt");
        System.out.println(st.tour());
    }
}