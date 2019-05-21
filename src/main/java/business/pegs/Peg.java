package business.pegs;

public abstract class Peg {
    protected String colour;

    @Override
    public boolean equals(Object o) {
        Peg otherPeg = (Peg) o;
        return this.colour.equals(otherPeg.colour);
    }
}
