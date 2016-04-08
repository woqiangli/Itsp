package sf.com.itsp.utils;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ConnectionProxyTest {

    @Test
    public void should_is_singleton() {
        // given

        // when
        ConnectionProxy firstProxy = ConnectionProxy.getInstance();
        ConnectionProxy secondProxy = ConnectionProxy.getInstance();

        // then
        assertThat(firstProxy).isEqualTo(secondProxy);
    }
}