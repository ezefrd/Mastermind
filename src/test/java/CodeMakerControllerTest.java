import dtos.CodeMakerDto;
import controllers.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import services.CodeMakerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class CodeMakerControllerTest extends ControllersAbstractTest{

    @Autowired
    private MockMvc mvc;

    @MockBean
    CodeMakerService mockedCodeMakerService;

    @Test
    public void test_make_guest_over_mocked_board_gives_all_colours_are_fine() throws Exception {
        //setup:
        String uri = "/codemaker/mocked";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("red");

        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("4 blacks, 0 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_make_guest_over_mocked_board_gives_all_colours_are_wrong() throws Exception {
        //setup:
        String uri = "/codemaker/mocked";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("blue");

        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("0 blacks, 0 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_make_guest_over_board_gives_all_colours_are_fine() throws Exception {
        //setup:
        String uri = "/codemaker";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("pink");
        codeMakerDto.addPegToCodeBreaker("blue");

        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("4 blacks, 0 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_make_guest_over_board_gives_all_colours_are_wrong() throws Exception {
        //setup:
        String uri = "/codemaker";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("pink");
        codeMakerDto.addPegToCodeBreaker("blue");

        codeMakerDto.addPegsToCodeMaker("yellow");
        codeMakerDto.addPegsToCodeMaker("yellow");
        codeMakerDto.addPegsToCodeMaker("yellow");
        codeMakerDto.addPegsToCodeMaker("yellow");

        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("0 blacks, 0 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_make_guest_over_board_gives_some_ok_and_some_wrong() throws Exception {
        //setup:
        String uri = "/codemaker";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("pink");
        codeMakerDto.addPegToCodeBreaker("blue");

        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("yellow");

        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("1 black, 2 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_play_over_saved_game() throws Exception {
        //setup:
        String uri = "/codemaker/play";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegToCodeBreaker("red");
        codeMakerDto.addPegToCodeBreaker("blue");
        codeMakerDto.addPegToCodeBreaker("pink");
        codeMakerDto.addPegToCodeBreaker("blue");

        Mockito.when(
                mockedCodeMakerService.retrieveGame()
        ).thenReturn(
                new CodeMakerDto()
                        .addPegsToCodeMaker("red")
                .addPegsToCodeMaker("blue")
                .addPegsToCodeMaker("pink")
                .addPegsToCodeMaker("blue")
        );
        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        Assert.assertEquals("4 blacks, 0 whites.", result.getResponse().getContentAsString());
    }

    @Test
    public void test_create_game_ok() throws Exception {
        //setup:
        String uri = "/codemaker/create";
        CodeMakerDto codeMakerDto = new CodeMakerDto();
        codeMakerDto.addPegsToCodeMaker("red");
        codeMakerDto.addPegsToCodeMaker("blue");
        codeMakerDto.addPegsToCodeMaker("pink");
        codeMakerDto.addPegsToCodeMaker("blue");

        Mockito.when(
                mockedCodeMakerService.createCodeMakerGame(codeMakerDto)).thenReturn(true);
        String inputJson = super.mapToJson(codeMakerDto);

        //when:
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson);
        MvcResult result = this.mvc.perform(builder).andReturn();

        //then:
        Assert.assertEquals(result.getResponse().getStatus(), 201);
        Assert.assertEquals("Everything ok!", result.getResponse().getContentAsString());
    }
}
