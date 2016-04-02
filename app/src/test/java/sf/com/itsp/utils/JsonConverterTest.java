package sf.com.itsp.utils;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class JsonConverterTest {

    @Test
    public void should_convert_json_to_object() {
        // given
        JsonObject jsonObject = new JsonObject();
        jsonObject.anyBoolean = false;
        jsonObject.integer = 1;
        jsonObject.string = "test";

        // when
        String json = JsonConverter.toJson(jsonObject);

        // then
        assertThat(json).isEqualTo("");
    }

    private class JsonObject {
        private String string;
        private int integer;
        private boolean anyBoolean;
    }

}