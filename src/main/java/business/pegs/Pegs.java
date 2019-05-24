package business.pegs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pegs {

    private ArrayList<Peg> pegs;

    public Pegs(Peg... pegs){
        this.pegs = new ArrayList<>(Arrays.asList(pegs));
    }

    public Pegs(ArrayList<Peg> pegs){
        this.pegs = pegs;
    }

    public Integer evaluatesColourAndPosition(Pegs pegs) {
        Integer rightColourAndPosition = 0;

        for(int ix = 0; ix < this.pegs.size(); ix++){
            Peg currentPeg = this.obtainInPosition(ix);
            Peg pegToCompare = pegs.obtainInPosition(ix);

            if(currentPeg.equals(pegToCompare)){
                rightColourAndPosition++;
            }
        }

        return rightColourAndPosition;
    }

    private Peg obtainInPosition(int ix) {
        return this.pegs.get(ix);
    }

    public Integer evaluatesColourAndNotPosition(Pegs pegs) {
        Integer rightColourAndNotPosition = 0;
        for (int ix = 0; ix < this.pegs.size(); ix++) {
            Peg pegToCompare = pegs.obtainInPosition(ix);

            if (this.isPartiallyOk(ix, pegToCompare)) {
                rightColourAndNotPosition++;
            }
        }

        return rightColourAndNotPosition;
    }

    private boolean isPartiallyOk(int position, Peg pegToCompare) {
        Peg currentPeg = this.obtainInPosition(position);

        if (currentPeg.equals(pegToCompare)) return false;

        for (int ix = 0; ix < this.pegs.size(); ix++) {
            if (!new Integer(ix).equals(position) && this.obtainInPosition(ix).equals(pegToCompare))
                return true;
        }

        return false;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pegs pegs1 = (Pegs) o;
        return Objects.equals(pegs, pegs1.pegs);
    }

    @Override public int hashCode() {
        return Objects.hash(pegs);
    }
}
