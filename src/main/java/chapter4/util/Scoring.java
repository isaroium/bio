package chapter4.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class Scoring {

    private static final Object sink = new Object();
    public static Scoring scoringSingleton;
    private int[][] scoreMatrix;
    private String nameArray;

    private Scoring(int length) {
        scoreMatrix = new int[length][length];

    }

    public static Scoring getScoreClass() throws IOException {
        if (scoringSingleton == null)
            synchronized (sink) {
                if (scoringSingleton == null) {
                    BufferedReader br = new BufferedReader((new InputStreamReader(Scoring.class.getClassLoader().getResourceAsStream("BLOSUM62.txt"))));
                    String s = br.readLine();
                    scoringSingleton = new Scoring(s.replaceAll(" ", "").length());
                    scoringSingleton.setNameArray(s.replaceAll(" ", ""));
                    int j = 0;
                    while ((s = br.readLine()) != null) {
                        String[] array = Stream.of(s.split(" ")).filter(st -> st.length() > 0).toArray(size -> new String[size]);
                        for (int i = 1; i < array.length; i++) {
                            scoringSingleton.getScoreMatrix()[i - 1][j] = Integer.parseInt(array[i]);

                        }
                        j++;
                    }
                }

            }
        return scoringSingleton;
    }

    private void setNameArray(String s) {
        nameArray = s;
    }

    private int[][] getScoreMatrix() {
        return scoreMatrix;
    }

    public int getScore(char a, char b) {
        return (nameArray.indexOf(a) > -1 && nameArray.indexOf(b) > -1) ? scoreMatrix[nameArray.indexOf(a)][nameArray.indexOf(b)] : Integer.MIN_VALUE;
    }

}
