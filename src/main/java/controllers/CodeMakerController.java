package controllers;

import business.codemaker.CodeBreakerPlay;
import business.codemaker.CodeMaker;
import business.pegs.PegsFactory;
import business.pegs.Red;
import dtos.CodeMakerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import presenters.ColourResultPresenter;
import services.CodeMakerService;

import java.io.IOException;

@RestController("/")
public class CodeMakerController {

    @Autowired
    private PegsFactory pegsFactory;

    @Autowired
    private CodeMakerService codeMakerService;

    @PostMapping(value = "/codemaker/mocked")
    public String mockedGame(@RequestBody CodeMakerDto codeMakerDto)
            throws InstantiationException, IllegalAccessException {
        CodeMaker mockedCodeMaker = new CodeMaker(new Red(),new Red(),new Red(),new Red());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(pegsFactory.createPegs(codeMakerDto.codeBreakerPegs));

        return mockedCodeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
    }

    @PostMapping(value = "/codemaker")
    public String commonGame(@RequestBody CodeMakerDto codeMakerDto)
            throws InstantiationException, IllegalAccessException {
        CodeMaker codeMaker = new CodeMaker(pegsFactory.createPegs(codeMakerDto.codeMakerPegs));
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(pegsFactory.createPegs(codeMakerDto.codeBreakerPegs));

        return codeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
    }

    @PostMapping(value = "/codemaker/play")
    public String play(@RequestBody CodeMakerDto codeMakerDto)
            throws InstantiationException, IllegalAccessException, IOException {

        CodeMakerDto savedGame = codeMakerService.retrieveGame();
        CodeMaker codeMaker = new CodeMaker(pegsFactory.createPegs(savedGame.codeMakerPegs));
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(pegsFactory.createPegs(codeMakerDto.codeBreakerPegs));

        return codeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
    }

    @PostMapping(value = "/codemaker/create")
    public ResponseEntity<?> createGame(@RequestBody CodeMakerDto codeMakerDto) {
        codeMakerService.createCodeMakerGame(codeMakerDto);

        //It seems that something could be wrong.. but honestly I don't know
        //what kind of errors firebase could throw, so I'm not able to catch them at this moment
        return new ResponseEntity<>("Everything ok!", HttpStatus.CREATED);
    }
}
