/**
 *
 *   you can just do things
 *
 */

package main;

import java.util.*;

/**
 * A Turing Machine simulator that can be used to compute strings
 * States of the machine are represented as ints in the range 0...k-1, where k is the number of states.
 * 0 is the start state
 *
 * Created by Pep on 4/21/2017.
 */
public class TuringMachine {
    private List<Map<Character, Instruction>> transition;
    private char blank;
    private char spacer;

    /**
     * @param k the number of states
     * @param transition the transition function
     * @param blank the symbol to use as the blank
     * @param spacer a character that separates the state from the tape symbols in an ID
     *               (this character should not be in the alphabet)
     */
    public TuringMachine (int k, Set<Instruction> transition, char blank, char spacer){
        this.blank = blank;
        this.spacer = spacer;
        this.transition = new ArrayList<>(k);
        for (int i = 0; i < k; i++){
            this.transition.add(new HashMap<>());
        }
        for (Instruction instr: transition){
            checkInstruction(instr);
            this.transition.get(instr.p).put(instr.a, instr);
        }
    }

    /**
     * Computes the input string. Outputs each instantaneous description in the form 'uspsav', where 'u' and 'v' are
     * strings in the tape alphabet with 'uav' being the contents of the tape, 'a' is the current symbol of the
     * read/write head, 'p' is the current state, and 's' is the spacer character
     *
     * @param w the input string
     * @return the ID (in String form) computed by this TM on the input string
     */
    public String computeString(String w){
        ID id = new ID(w);
        System.out.println(id);
        Instruction nextInstr = getInstruction(id);
        while (nextInstr != null) {
            id.applyInstruction(nextInstr);
            System.out.println(id);
            nextInstr = getInstruction(id);
        }
        System.out.println();
        return id.contents.toString();
    }

    /**
     * @return the input string, with blanks omitted
     */
    public String removeBlanks(String str){
        return str.replaceAll(String.valueOf(blank), "");
    }

    /**
     * @throws IllegalArgumentException if the given instruction contains invalid
     * states, symbols, or directions
     * @param instr the instruction to check
     */
    private void checkInstruction(Instruction instr) {
        if (!isState(instr.p) || !isState(instr.q)){
            throw new IllegalArgumentException("Instruction's symbol does not exist");
        }
    }

    private boolean isState(int p){
        return (0 <= p && p < transition.size());
    }

    /**
     * @param id the ID
     * @return the next instruction to compute on the ID, null if none exists (i.e., this is a halting ID)
     */
    private Instruction getInstruction(ID id){
        return transition.get(id.state).get(id.getSymbol());
    }

    /**
     * An ID instance represents an instantaneous description of a Turing Machine
     *
     * Created by Pep on 4/21/2017.
     */
    private class ID {
        private StringBuilder contents; // the string contents of the tape
        private int state; // the current state of the tape
        private int position; // the current position of the read/write head

        /**
         * Creates an ID from the tape string, with the state set to start state 0, and the read/write
         * head pointing to the first symbol
         *
         * @param contents the current
         */
        ID(String contents){
            this.contents = new StringBuilder(contents);
            this.state = 0;
            this.position = 0;
        }

        /**
         * Applies the given instruction to the ID
         * @param instr the instruction to apply
         */
        void applyInstruction(Instruction instr){
            state = instr.q;
            contents.setCharAt(position, instr.b);
            if (instr.m == Instruction.Direction.L){
                if (position == 0){
                    contents.insert(0, blank);
                }
                else{
                    position--;
                }
            }
            else{
                if (position == contents.length() - 1){
                    contents.append(blank);
                }
                position++;
            }
        }

        /**
         * @return the symbol to which the read/write head is currently pointing
         */
        char getSymbol(){
            return contents.charAt(position);
        }

        /**
         * @return a string demonstrating the current state of the tape, with the current state
         * to the left of the symbol to which it points
         */
        public String toString(){
            return contents.substring(0, position) + spacer + state + spacer + contents.substring(position);
        }
    }
}
