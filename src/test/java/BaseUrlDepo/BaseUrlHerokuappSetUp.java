package BaseUrlDepo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuappSetUp {



    protected RequestSpecification specHerokuapp;

    @Before
    public void abuzer1(){

        specHerokuapp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").
                build();


    }







}
