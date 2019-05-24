package business.pegs;

import dtos.CodeMakerDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PegsFactoryTest {

    PegsFactory pegsFactory;

    @Before
    public void setUp(){
        pegsFactory = new PegsFactory();
    }

    @Test
    public void test_given_a_codemakerdto_build_the_pegs_corresponding_to_codemaker()
            throws InstantiationException, IllegalAccessException {
        //setup:
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.codeMakerPegs.add("red");
        codeMakerDto.codeMakerPegs.add("blue");
        codeMakerDto.codeMakerPegs.add("green");
        codeMakerDto.codeMakerPegs.add("yellow");
        codeMakerDto.codeMakerPegs.add("pink");
        codeMakerDto.codeMakerPegs.add("bizon");

        //when:
        Pegs codeMakerPegs = pegsFactory.createPegs(codeMakerDto.codeMakerPegs);

        //then:
        Assert.assertEquals(getExpectedCodeMakerPegs(), codeMakerPegs);

    }

    private Pegs getExpectedCodeMakerPegs() {
        return new Pegs(new Red(),new Blue(), new Green(), new Yellow(), new Pink(), new UnknownColor());
    }

}