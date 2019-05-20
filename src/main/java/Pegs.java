import java.util.ArrayList;
import java.util.Arrays;

public class Pegs {

    private ArrayList<Peg> pegs;

    public Pegs(Peg... pegs){
        this.pegs = new ArrayList<>(Arrays.asList(pegs));
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
}
