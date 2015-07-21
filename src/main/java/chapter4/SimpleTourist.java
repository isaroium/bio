package chapter4;

/**
 * Created by mihai.isaroiu on 7/21/15.
 */
public class SimpleTourist {


    private int[][] right;
    private int[][] down;
    private int n, m;

    public void setRight(int[][] left) {
        this.right = left;
    }

    public void setDown(int[][] down) {
        this.down = down;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int tour() {
        int[][] s = new int[n + 1][m + 1];
        s[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i][0] = s[i - 1][0] + down[i - 1][0];
        }
        for (int j = 1; j <= m; j++) {
            s[0][j] = s[0][j - 1] + right[0][j - 1];
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                s[i][j] = Math.max(s[i - 1][j] + down[i - 1][j], s[i][j - 1] + right[i][j - 1]);
            }
        return s[n][m];
    }


}
