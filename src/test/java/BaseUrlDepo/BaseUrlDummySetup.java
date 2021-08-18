package BaseUrlDepo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlDummySetup {

   public RequestSpecification specDummyRestApi;

    @Before
    public void setUp(){
        specDummyRestApi = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/").build();



    }










}
