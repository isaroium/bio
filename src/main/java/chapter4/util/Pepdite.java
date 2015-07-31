package chapter4.util;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public enum Pepdite {
    A('A'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I('I'), K('K'), L('L'), M('M'), N('N'), P('P'), Q('Q'), R('R'), S('S'), T('T'), V('V'), W('W'), Y('Y'), NO('-');
    private char val;

    Pepdite(char d) {
        val = d;
    }

    public char getVal() {
        return val;
    }
}
