package dtos;

import java.util.ArrayList;
import java.util.Objects;

public class CodeMakerDto {
    public ArrayList<String> codeMakerPegs;
    public ArrayList<String> codeBreakerPegs;

    public CodeMakerDto(){
        this.codeMakerPegs = new ArrayList<>();
        this.codeBreakerPegs = new ArrayList<>();
    }

    public CodeMakerDto addPegToCodeBreaker(String pegColour){
        this.codeBreakerPegs.add(pegColour);
        return this;
    }

    public CodeMakerDto addPegsToCodeMaker(String pegColour){
        this.codeMakerPegs.add(pegColour);
        return this;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CodeMakerDto that = (CodeMakerDto) o;
        return Objects.equals(codeMakerPegs, that.codeMakerPegs) && Objects
                .equals(codeBreakerPegs, that.codeBreakerPegs);
    }

    @Override public int hashCode() {
        return Objects.hash(codeMakerPegs, codeBreakerPegs);
    }
}
