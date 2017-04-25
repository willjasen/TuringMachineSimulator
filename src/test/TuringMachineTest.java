package test;

import main.Instruction;
import main.TuringMachine;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Tests TuringMachine on the machine from homework 9
 *
 * Created by Pep on 4/24/2017.
 */
public class TuringMachineTest {
    static private TuringMachine tm = getH9TuringMachine();

    @Test
    public void testAccept1(){
        String computed = tm.computeString("abacaba");
        assertEquals("1abacaba", tm.removeBlanks(computed));
    }

    @Test
    public void testAccept2(){
        String computed = tm.computeString("aca");
        assertEquals("1aca", tm.removeBlanks(computed));
    }

    @Test
    public void testRejectNoC(){
        String computed = tm.computeString("abab");
        assertEquals("0abab", tm.removeBlanks(computed));
    }

    @Test
    public void testRejectMultipleC(){
        String computed = tm.computeString("abacacaba");
        assertEquals("0abacacaba", tm.removeBlanks(computed));
    }

    @Test
    public void testRejectUnequalPrePost(){
        String computed = tm.computeString("abacabb");
        assertEquals("0abacabb", tm.removeBlanks(computed));
    }

    @Test
    public void testRejectPreIsPrefix(){
        String computed = tm.computeString("abcaba");
        assertEquals("0abcaba", tm.removeBlanks(computed));
    }

    @Test
    public void testRejectPostIsPrefix(){
        String computed = tm.computeString("bbbacbb");
        assertEquals("0bbbacbb", tm.removeBlanks(computed));
    }

    /**
     * @return the Turing Machine used for homework 9 question B4
     */
    static private TuringMachine getH9TuringMachine(){
        char blank = '-';
        Instruction.Direction r = Instruction.Direction.R;
        Instruction.Direction l = Instruction.Direction.L;
        Set<Instruction> trans = new HashSet<>();
        trans.add(new Instruction(0, 'a', 'A', r, 1));
        trans.add(new Instruction(0, 'b', 'B', r, 2));
        trans.add(new Instruction(0, 'c', 'c', r, 0));
        trans.add(new Instruction(0, 'A', 'A', r, 0));
        trans.add(new Instruction(0, 'B', 'B', r, 0));
        trans.add(new Instruction(0, blank, blank, l, 7));
        trans.add(new Instruction(1, 'a', 'a', r, 1));
        trans.add(new Instruction(1, 'b', 'b', r, 1));
        trans.add(new Instruction(1, 'c', 'c', r, 3));
        trans.add(new Instruction(1, blank, blank, l, 6));
        trans.add(new Instruction(2, 'a', 'a', r, 2));
        trans.add(new Instruction(2, 'b', 'b', r, 2));
        trans.add(new Instruction(2, 'c', 'c', r, 4));
        trans.add(new Instruction(2, blank, blank, l, 6));
        trans.add(new Instruction(3, 'a', 'A', l, 5));
        trans.add(new Instruction(3, 'b', 'b', l, 6));
        trans.add(new Instruction(3, 'c', 'c', l, 6));
        trans.add(new Instruction(3, 'A', 'A', r, 3));
        trans.add(new Instruction(3, 'B', 'B', r, 3));
        trans.add(new Instruction(3, blank, blank, l, 6));
        trans.add(new Instruction(4, 'a', 'a', l, 6));
        trans.add(new Instruction(4, 'b', 'B', l, 5));
        trans.add(new Instruction(4, 'c', 'c', l, 6));
        trans.add(new Instruction(4, 'A', 'A', r, 4));
        trans.add(new Instruction(4, 'B', 'B', r, 4));
        trans.add(new Instruction(4, blank, blank, l, 6));
        trans.add(new Instruction(5, 'a', 'a', l, 5));
        trans.add(new Instruction(5, 'b', 'b', l, 5));
        trans.add(new Instruction(5, 'c', 'c', l, 5));
        trans.add(new Instruction(5, 'A', 'A', l, 5));
        trans.add(new Instruction(5, 'B', 'B', l, 5));
        trans.add(new Instruction(5, blank, blank, r, 0));
        trans.add(new Instruction(6, 'a', 'a', l, 6));
        trans.add(new Instruction(6, 'b', 'b', l, 6));
        trans.add(new Instruction(6, 'c', 'c', l, 6));
        trans.add(new Instruction(6, 'A', 'a', l, 6));
        trans.add(new Instruction(6, 'B', 'b', l, 6));
        trans.add(new Instruction(6, blank, '0', r, 6));
        trans.add(new Instruction(7, 'a', 'a', l, 7));
        trans.add(new Instruction(7, 'b', 'b', l, 7));
        trans.add(new Instruction(7, 'c', 'c', l, 7));
        trans.add(new Instruction(7, 'A', 'a', l, 7));
        trans.add(new Instruction(7, 'B', 'b', l, 7));
        trans.add(new Instruction(7, blank, '1', r, 7));

        outputInstructions(trans);
        return new TuringMachine(8, trans, blank, '|');
    }

    /**
     * Prints the instructions of given transition function
     */
    static private void outputInstructions(Set<Instruction> trans){
        System.out.println("===== INSTRUCTIONS =====");
        for (Instruction instr: trans){
            System.out.println(instr);
        }
        System.out.println();
    }
}