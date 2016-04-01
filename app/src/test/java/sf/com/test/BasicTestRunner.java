
package sf.com.test;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

import sf.com.itsp.shadows.ShadowHttpClient;

public class BasicTestRunner extends RobolectricGradleTestRunner {
    public BasicTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();

        builder.addInstrumentedClass(ShadowHttpClient.class.getName());

        return builder.build();
    }
}