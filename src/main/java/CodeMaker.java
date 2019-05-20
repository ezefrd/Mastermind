import java.util.ArrayList;

public class CodeMaker {

    private Pegs pegs;

    public CodeMaker(Peg... pegs){
        this.pegs = new Pegs(pegs);
    }

    public String evaluates(CodeBreakerPlay codeBreakerPlay) {
        Integer rightColourAndPosition = codeBreakerPlay.evaluatesColourAndPosition(this.pegs);

        return String.format("[%d,%d]",rightColourAndPosition, 0);
    }
}