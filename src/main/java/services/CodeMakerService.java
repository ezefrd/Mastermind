package services;

import dtos.CodeMakerDto;
import persistance.repositories.CodeMakerFirebaseRepository;
import persistance.repositories.CodeMakerRepository;

import java.io.IOException;

public class CodeMakerService {
    private CodeMakerRepository codeMakerRepository;

    public CodeMakerService() throws IOException {
        this.codeMakerRepository = new CodeMakerFirebaseRepository();
    }

    public CodeMakerService(CodeMakerRepository codeMakerRepository){
        this.codeMakerRepository = codeMakerRepository;
    }

    public boolean createCodeMakerGame(CodeMakerDto codeMakerDto){
        return codeMakerRepository.insertCodemakerGame(codeMakerDto);
    }

    public CodeMakerDto retrieveGame(){
        return codeMakerRepository.getCodeMakerGame();
    }
}
