package Lists;

import Components.Coupon.Coupon;
import Exceptions.BadHTTPResponseException;
import REST.RESTConnection;
import REST.RESTEndpoints;
import Website.APICredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class CouponListTest {
    @Test
    public void couponQueryListTest() {
        SingleRequestList<Coupon> customers = null;
        try {
            customers = new SingleRequestList<>(
                    new RESTConnection("https://staging-skadedyrsexpertendk-test.kinsta.cloud/",
                            new APICredentials("Casper",
                                    "ck_1a62e360c9cfdfe4d4438f35155c6816e872b558",
                                    "cs_ac785b31f21fe1835e2dd6adb3e0c6a474d56357")), RESTEndpoints.getCouponsEndpoint(),
                    Coupon.class);
        } catch (BadHTTPResponseException e) {
            fail(e.getMessage());
        }

        customers.forEach(System.out::println);

        assert(customers.size() != 0);
    }
}
