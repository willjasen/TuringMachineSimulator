package main;

/**
 * An Instruction instance acts as an element of the transition
 * function of a Turing Machine.
 *
 * Created by Pep on 4/20/2017.
 */
public class Instruction {

    private int p;
    private char a;
    private char b;
    private Direction m;
    private int q;

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
     * @return the start state of this instruction
     */
    public int getStartState(){
        return p;
    }

    /**
     * @return the start symbol(the symbol to be changed)
     */
    public char getStartSymbol(){
        return a;
    }

    /**
     * @return a string of the form '(p, a, b, m, q)'
     */
    public String toString(){
        String ret = "(" + p + ", " + a + ", " + b + ", ";
        switch (m) {
            case L: ret += "L, ";
            break;
            case R: ret += "R, ";
            break;
        }
        ret += q + ")";
        return ret;
     }
}