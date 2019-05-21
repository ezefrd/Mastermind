public class ColourResultPresenter implements CodeMakerResultPresenter {
    @Override public String render(CodeMakerResult codeMakerResult) {
        return String.format("%d %s, %d %s.",
                codeMakerResult.getRightColourAndPosition(),
                getBlackText(codeMakerResult.getRightColourAndPosition()),
                codeMakerResult.getRightColourAndNotPosition(),
                getWhiteText(codeMakerResult.getRightColourAndNotPosition()));
    }

    private String getBlackText(Integer rightColourAndPosition) {
        return rightColourAndPosition.equals(1) ? "black" : "blacks";
    }

    private String getWhiteText(Integer rightColourAndPosition) {
        return rightColourAndPosition.equals(1) ? "white" : "whites";
    }
}
