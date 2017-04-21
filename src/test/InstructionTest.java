package test;

import main.Instruction;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Pep on 4/21/2017.
 */
public class InstructionTest {
    @Test
    public void oString() {
        Instruction instr = new Instruction(2, 'a', 'b', Instruction.Direction.R, 3);
        assertEquals("(2, a, b, R, 3)", instr.toString());
    }
}