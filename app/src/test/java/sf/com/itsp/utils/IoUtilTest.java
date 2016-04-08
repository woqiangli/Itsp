package sf.com.itsp.utils;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IoUtilTest {

    @Test
    public void should_close_input_stream() throws IOException {
        // given
        InputStream inputStream = mock(InputStream.class);

        // when
        IoUtil.closeInputStream(inputStream);

        // then
        verify(inputStream).close();
    }

    @Test
    public void should_no_exception_when_close_input_stream() throws IOException {
        // given

        // when
        IoUtil.closeInputStream(null);

        // then
        should_no_exception_occur();
    }

    @Test
    public void should_close_url_connection() {
        // given
        HttpURLConnection httpURLConnection = mock(HttpURLConnection.class);

        // when
        IoUtil.disconnectQuietly(httpURLConnection);

        // then
        verify(httpURLConnection).disconnect();
    }

    @Test
    public void should_not_invoke_disconnect_when_connection_is_null() {
        // given

        // when
        IoUtil.disconnectQuietly(null);

        // then
        should_no_exception_occur();
    }


    private void should_no_exception_occur() {

    }


}