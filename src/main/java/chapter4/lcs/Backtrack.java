package chapter4.lcs;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class Backtrack {

    public static String compute(String v, String w) {
        Backtrack b = new Backtrack();
        StringBuffer sb = new StringBuffer();
        b.output(b.backtrack(v, w), v, v.length() - 1, w.length() - 1, sb);
        return sb.toString();
    }

    private Pointers[][] backtrack(String v, String w) {
        int[][] s = new int[v.length() + 1][w.length() + 1];
        Pointers[][] backtrack = new Pointers[v.length() + 1][w.length() + 1];
        for (int i = 0; i <= v.length(); i++) {
            backtrack[i][0] = Pointers.d;
        }
        for (int i = 0; i <= w.length(); i++) {
            backtrack[0][i] = Pointers.r;
        }
        for (int i = 1; i <= v.length(); i++)
            for (int j = 1; j <= w.length(); j++) {
                s[i][j] = Math.max(s[i - 1][j], Math.max(s[i][j - 1], v.charAt(i - 1) == w.charAt(j - 1) ? s[i - 1][j - 1] + 1 : Integer.MIN_VALUE));
                if (s[i][j] == s[i - 1][j]) {
                    backtrack[i][j] = Pointers.d;
                } else if (s[i][j] == s[i][j - 1]) {
                    backtrack[i][j] = Pointers.r;
                } else if (s[i][j] == s[i - 1][j - 1] + 1 && v.charAt(i - 1) == w.charAt(j - 1)) {
                    backtrack[i][j] = Pointers.m;
                }

            }
        return backtrack;
    }

    private void output(Pointers[][] backtrack, String v, int i, int j, StringBuffer out) {
        if (i == 0 || j == 0) {
            return;
        } else
            switch (backtrack[i][j]) {
                case d:
                    output(backtrack, v, i - 1, j, out);
                    break;
                case r:
                    output(backtrack, v, i, j - 1, out);
                    break;
                case m:
                    output(backtrack, v, i - 1, j - 1, out);
                    out.append(v.charAt(i - 1));
                    break;
            }
    }

    protected enum Pointers {
        d, r, m
    }
}
