package business.codemaker;

//This class works as DTO. It must have no business logic
public class CodeMakerResult {
    private Integer rightColourAndPosition;
    private Integer rightColourAndNotPosition;
    public CodeMakerResult(Integer rightColourAndPosition,
            Integer rightColourAndNotPosition) {
        this.rightColourAndPosition = rightColourAndPosition;
        this.rightColourAndNotPosition = rightColourAndNotPosition;
    }

    public Integer getRightColourAndPosition() {
        return rightColourAndPosition;
    }

    public Integer getRightColourAndNotPosition() {
        return rightColourAndNotPosition;
    }
}
