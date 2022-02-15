import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class SampleTest {

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

    @Test
    public void shouldCreateUser()
    {
        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer 72c04051e13a737af16869169867c00064b1515c8ed9c1578ebfca8946c116fe")
                    .body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.krishaniyer3@gmail.com\", \"status\":\"active\"}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201)
                .body("id",Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.krishaniyer3@gmail.com"));
    }
}
