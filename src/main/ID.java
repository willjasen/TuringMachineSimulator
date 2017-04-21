package main;

/**
 * Created by Pep on 4/21/2017.
 */
public class ID {
    private String preHead; // the string to the left of the current read/write head
    private String postHead; // the string to the right of the current read/write head
    private int state; // the current state of the tape

    /**
     *
     * @param preHead the portion of the tape to the left of the current read/write head
     * @param state the current state of the tape
     * @param postHead the portion of the tape to the right of the current read/write head
     */
    public ID(String preHead, int state, String postHead){
        this.preHead = preHead;
        this.state = state;
        this.postHead = postHead;
    }

    /**
     * Applies the given instruction to the ID
     * @param instr the instruction to apply
     */
    public void applyInstruction(Instruction instr){

    }

    /**
     * @return the current state of the tape
     */
    public int getState(){
        return state;
    }

    /**
     * @return the symbol to which the read/write head is currently pointing
     */
    public char getSymbol(){
        return postHead.charAt(0);
    }

}
