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

    @Test
    public void test_code_maker_checks_a_solution_that_is_all_fine_for_four_peg(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red(), new Blue(), new Green(), new Yellow());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay);
        //then:
        Assert.assertEquals("[4,0]", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_is_all_wrong_for_four_peg(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Pink(), new Pink(), new Pink(), new Pink());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay);
        //then:
        Assert.assertEquals("[0,0]", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_has_two_pegs_full_ok_and_two_partially_ok(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red(), new Blue(), new Yellow(), new Green());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay);
        //then:
        Assert.assertEquals("[2,2]", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_has_two_pegs_full_ok_and_two_partially_ok_using_simple_presenter(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red(), new Blue(), new Yellow(), new Green());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay, new SimpleResultPresenter());
        //then:
        Assert.assertEquals("[2,2]", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_has_two_pegs_full_ok_and_two_partially_ok_using_colour_presenter(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red(), new Blue(), new Yellow(), new Green());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
        //then:
        Assert.assertEquals("2 blacks, 2 whites.", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_has_one_peg_full_ok_and_zero_partially_ok_using_colour_presenter(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Red(), new Pink(), new Pink(), new Pink());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
        //then:
        Assert.assertEquals("1 black, 0 whites.", checkResultAsString);
    }

    @Test
    public void test_code_maker_checks_a_solution_that_has_zero_peg_full_ok_and_one_partially_ok_using_colour_presenter(){
        //setup:
        CodeMaker codeMaker = new CodeMaker(new Red(), new Blue(), new Green(), new Yellow());
        CodeBreakerPlay codeBreakerPlay = new CodeBreakerPlay(new Pink(), new Red(), new Pink(), new Pink());
        //when
        String checkResultAsString = codeMaker.evaluates(codeBreakerPlay, new ColourResultPresenter());
        //then:
        Assert.assertEquals("0 blacks, 1 white.", checkResultAsString);
    }
}
