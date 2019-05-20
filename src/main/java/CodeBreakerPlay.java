public class CodeBreakerPlay {
    private Pegs pegs;

    public CodeBreakerPlay(Peg... pegs){
        this.pegs = new Pegs(pegs);
    }

    public Integer evaluatesColourAndPosition(Pegs pegs) {
        return pegs.evaluatesColourAndPosition(this.pegs);
    }
}
