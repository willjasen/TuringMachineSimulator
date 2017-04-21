package main;

import java.util.*;

/**
 * Created by Pep on 4/21/2017.
 */
public class TuringMachine {
    private List<Map<Character, Instruction>> transition;

    public TuringMachine (int k, Set<Character> alphabet, Set<Instruction> transition){

        this.transition = new ArrayList<>(k);
        for (int i = 0; i < k; i++){
            this.transition.add(new HashMap<>());
        }
        // TODO: ensure that the transition list has size equal to k
        for (Instruction instr: transition){
            checkInstruction(instr);
            this.transition.get(instr.getStartState()).put(instr.getStartSymbol(), instr);
        }
    }

    /**
     *
     * @param w the input string
     * @return the ID (in String form) computed by this TM on the input string
     */
    public String computeString(String w){
        //TODO: Implement
        return null;
    }

    /**
     * @throws com.sun.javaws.exceptions.InvalidArgumentException if the given instruction contains invalid
     * states, symbols, or directions
     * @param instr the instruction to check
     */
    private void checkInstruction(Instruction instr) {
        //TODO: Implement
    }

    /**
     * @param id the ID
     * @return the next instruction to compute on the ID, null if none exists (i.e., this is a halting ID)
     */
    private Instruction getInstruction(ID id){
        return transition.get(id.getState()).get(id.getSymbol());
    }
}
