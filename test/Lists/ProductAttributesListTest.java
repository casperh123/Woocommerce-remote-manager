package Lists;

import Components.ProductAttribute.ProductAttribute;
import Exceptions.BadHTTPResponseException;
import REST.RESTConnection;
import REST.RESTEndpoints;
import Website.APICredentials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ProductAttributesListTest {
    @Test
    public void customerQueryListTest() {
        SingleRequestList<ProductAttribute> customers = null;
        try {
            customers = new SingleRequestList<>(
                    new RESTConnection("https://staging-skadedyrsexpertendk-test.kinsta.cloud/",
                            new APICredentials("Casper",
                                    "ck_1a62e360c9cfdfe4d4438f35155c6816e872b558",
                                    "cs_ac785b31f21fe1835e2dd6adb3e0c6a474d56357")), RESTEndpoints.getProductAttributesEndpoint(),
                    ProductAttribute.class);
        } catch (BadHTTPResponseException e) {
            fail(e.getMessage());
        }

        customers.forEach(System.out::println);

        assert(customers.size() != 0);
    }
}
