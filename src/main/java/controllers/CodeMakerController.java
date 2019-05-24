package controllers;

import business.codemaker.CodeBreakerPlay;
import business.codemaker.CodeMaker;
import business.pegs.*;
import dtos.CodeMakerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import presenters.ColourResultPresenter;

import java.util.ArrayList;

@RestController("/")
public class CodeMakerController {

    PegsFactory pegsFactory = new PegsFactory();

    @PostMapping(value = "/codemaker/mocked")
    public String mockedGame(@RequestBody CodeMakerDto codeMakerDto)
            throws InstantiationException, IllegalAccessException {
        CodeMaker mockedCodeMaker = new CodeMaker(new Red(),new Red(),new Red(),new Red());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(pegsFactory.createPegs(codeMakerDto.codeBreakerPegs));

        return mockedCodeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
    }
}
