package main;

/**
 * An Instruction instance acts as an element of the transition
 * function of a Turing Machine.
 *
 * Created by Pep on 4/20/2017.
 */
public class Instruction {
    int p;
    char a;
    char b;
    Direction m;
    int q;

    public enum Direction {L, R}

    /**
     * Creates a new instruction of the form: p, a -> b, m, q
     * @param p start state
     * @param a start symbol
     * @param b ending symbol (what "a" is changed to)
     * @param m direction to move the read/write head
     * @param q ending state
     */
    public Instruction(int p, char a, char b, Direction m, int q) {
        this.p = p;
        this.a = a;
        this.b = b;
        this.m = m;
        this.q = q;
    }

    /**
     * @return a string of the form '(p, a, b, m, q)'
     */
    public String toString(){
        String ret = "(" + p + ", " + a + ", " + b + ", ";
        switch (m) {
            case L: return ret + "L, " + q + ")";
            case R: return ret + "R, " + q + ")";
        }
     }
}
