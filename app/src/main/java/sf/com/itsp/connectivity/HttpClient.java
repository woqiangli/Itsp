package sf.com.itsp.connectivity;

import java.util.Arrays;
import java.util.List;

import sf.com.itsp.domain.Order;

public class HttpClient {

    public List<Order> requestOrder() {
        return xxxxxxxxxxxxxxxxxxxxxxxxx1();
    }

    private List<Order> xxxxxxxxxxxxxxxxxxxxxxxxx1() {
        Order orderFirst = xxxxxxxxxxxxxxxxxxxxxxxxxxxx2("aaa111", "20160401 -- 20160501", "shenzhen", "guangzhuo", "5");
        Order orderSecond = xxxxxxxxxxxxxxxxxxxxxxxxxxxx2("aaa112", "20160402 -- 20160502", "shenzhen2", "guangzhuo2", "2");

        return Arrays.asList(orderFirst, orderSecond);
    }

    private static Order xxxxxxxxxxxxxxxxxxxxxxxxxxxx2(String aaa111, String startTime, String shenzhen, String
            guangzhuo, String vehicleAge) {
        Order order = new Order();
//        order.setNumber(aaa111);
//        order.setStartTime(startTime);
        order.setOriginal(shenzhen);
        order.setTarget(guangzhuo);
//        order.setVehicleAge(vehicleAge);
        order.setWeight(2);
        return order;
    }

}
