package services;

import dtos.CodeMakerDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import persistance.repositories.CodeMakerFirebaseRepository;

public class CodeMakerServiceTest {

    @Test
    public void test_create_code_maker_game(){
        //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        CodeMakerFirebaseRepository codeMakerFirebaseRepository =
                Mockito.mock(CodeMakerFirebaseRepository.class);
        Mockito.when(codeMakerFirebaseRepository.insertCodemakerGame(codeMakerDto)).thenReturn(true);
        CodeMakerService codeMakerService = new CodeMakerService(codeMakerFirebaseRepository);
        //when:
        boolean response = codeMakerService.createCodeMakerGame(codeMakerDto);
        //then:
        Assert.assertTrue(response);
    }

    @Test
    public void test_retrieve_code_maker_game(){
       //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        CodeMakerFirebaseRepository codeMakerFirebaseRepository =
                Mockito.mock(CodeMakerFirebaseRepository.class);
        Mockito.when(codeMakerFirebaseRepository.getCodeMakerGame()).thenReturn(codeMakerDto);
        CodeMakerService codeMakerService = new CodeMakerService(codeMakerFirebaseRepository);
        //when:
        CodeMakerDto response = codeMakerService.retrieveGame();
        //then:
        Assert.assertEquals(codeMakerDto, response);
    }

}