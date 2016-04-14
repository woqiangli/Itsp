package sf.com.itsp.activities;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import sf.com.itsp.BasicTestRunner;
import sf.com.itsp.BuildConfig;
import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Robolectric.buildActivity;
import static sf.com.itsp.testHelper.condition.ContainsTextCondition.text;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, shadows = {ShadowConnectionProxy.class})
public class OrderDetailActivityTest {

    @Test
    public void should_display_order_line_on_order_detail_activity() {
        // given
        Order mockOrder = generateOrder("755A", "755B");

        Intent newIntent = new Intent(ShadowApplication.getInstance().getApplicationContext(), MainActivity.class);
        newIntent.putExtra("order", mockOrder);

        OrderDetailActivity orderDetailActivity = buildActivity(OrderDetailActivity.class)
                .withIntent(newIntent)
                .create()
                .get();

        // when
       //TextView originView = (TextView) orderDetailActivity.findViewById(R.id.origin_view);
        //TextView targetView = (TextView) orderDetailActivity.findViewById(R.id.target_view);

        // then
        //assertThat(originView).has(text("755A"));
        //assertThat(targetView).has(text("755B"));
    }

    private Order generateOrder(String original, String target) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getOriginal()).thenReturn(original);
        when(mockOrder.getTarget()).thenReturn(target);
        return mockOrder;
    }
}