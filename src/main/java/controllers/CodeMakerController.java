package controllers;

import business.codemaker.CodeBreakerPlay;
import business.codemaker.CodeMaker;
import business.pegs.Blue;
import business.pegs.Peg;
import business.pegs.Pegs;
import business.pegs.Red;
import dtos.CodeMakerDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import presenters.ColourResultPresenter;

import java.util.ArrayList;

@RestController("/")
public class CodeMakerController {

    @PostMapping(value = "/codemaker/mocked")
    public String mockedGame(@RequestBody CodeMakerDto codeMakerDto) {
        CodeMaker mockedCodeMaker = new CodeMaker(new Red(),new Red(),new Red(),new Red());

        ArrayList<Peg> codeBreakerPegs = new ArrayList<Peg>();
        for(String pegColour : codeMakerDto.codeBreakerPegs){
            codeBreakerPegs.add(pegColour.equals("red") ? new Red() : new Blue());
        }
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Pegs(codeBreakerPegs));

        return mockedCodeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
    }
}
