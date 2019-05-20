import org.junit.Assert;
import org.junit.Test;

public class CodeMakerTest {

    @Test
    public void test_code_maker_checks_a_solution_that_is_all_fine_for_one_peg(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay);
        //then:
        Assert.assertEquals("[1,0]", checkResultAsString);
    }
}
