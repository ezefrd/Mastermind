package business.codemaker;

import business.pegs.Peg;
import business.pegs.Pegs;
import presenters.CodeMakerResultPresenter;

public class CodeMaker {

    private Pegs pegs;

    public CodeMaker(Peg... pegs){
        this.pegs = new Pegs(pegs);
    }

    public String evaluates(CodeBreakerPlay codeBreakerPlay) {
        Integer rightColourAndPosition = codeBreakerPlay.evaluatesColourAndPosition(this.pegs);
        Integer rightColourAndNotPosition = codeBreakerPlay.evaluatesColourAndNotPosition(this.pegs);

        return String.format("[%d,%d]",rightColourAndPosition, rightColourAndNotPosition);
    }

    public String evaluates(CodeBreakerPlay codeBreakerPlay, CodeMakerResultPresenter codeMakerResultPresenter) {
        Integer rightColourAndPosition = codeBreakerPlay.evaluatesColourAndPosition(this.pegs);
        Integer rightColourAndNotPosition = codeBreakerPlay.evaluatesColourAndNotPosition(this.pegs);

        CodeMakerResult codeMakerResult = new CodeMakerResult(rightColourAndPosition, rightColourAndNotPosition);

        return codeMakerResultPresenter.render(codeMakerResult);
    }
}
