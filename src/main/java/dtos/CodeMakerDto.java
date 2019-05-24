package dtos;

import java.util.ArrayList;

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

}
