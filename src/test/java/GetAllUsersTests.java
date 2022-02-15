import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetAllUsersTests {

    @Test
    public void shouldGetAllUsers()
    {
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log().body()
                .body("id", Matchers.hasSize(20))
                .body("gender",Matchers.hasItem("male"))
        ;
    }

    
}
