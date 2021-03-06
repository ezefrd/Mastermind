package business.codemaker;

import business.pegs.Peg;
import business.pegs.Pegs;

public class CodeBreakerPlay {
    private Pegs pegs;

    public CodeBreakerPlay(Peg... pegs){
        this.pegs = new Pegs(pegs);
    }

    public CodeBreakerPlay(Pegs  pegs){
        this.pegs = pegs;
    }

    public Integer evaluatesColourAndPosition(Pegs pegs) {
        return pegs.evaluatesColourAndPosition(this.pegs);
    }

    public Integer evaluatesColourAndNotPosition(Pegs pegs) {
        return pegs.evaluatesColourAndNotPosition(this.pegs);
    }
}
