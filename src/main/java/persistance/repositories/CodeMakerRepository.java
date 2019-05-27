package persistance.repositories;

import dtos.CodeMakerDto;

public interface CodeMakerRepository {
    public boolean insertCodemakerGame(CodeMakerDto codeMakerDto);

    public CodeMakerDto getCodeMakerGame();
}
