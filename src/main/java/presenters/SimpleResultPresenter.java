package presenters;

import business.codemaker.CodeMakerResult;

public class SimpleResultPresenter implements CodeMakerResultPresenter {
    @Override public String render(CodeMakerResult codeMakerResult) {
        return String.format("[%d,%d]",
                codeMakerResult.getRightColourAndPosition(),
                codeMakerResult.getRightColourAndNotPosition());
    }
}
