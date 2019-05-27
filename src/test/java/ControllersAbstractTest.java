import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class ControllersAbstractTest {

    protected String mapToJson(Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}