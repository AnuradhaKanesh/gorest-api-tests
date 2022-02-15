import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsersTests {

    @Test
    public void shouldCreateMaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\",\"email\":\"tenali.krishaniyer6@gmail.com\", \"status\":\"active\"}";
        //Act
        createUser(body)
                .then()
                    .log().body()
                .statusCode(201)
        //Assert
                    .body("id", Matchers.notNullValue())
                    .body("email",Matchers.equalTo("tenali.krishaniyer6@gmail.com"))
                    .body("name",Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldCreateFemaleUser()
    {
        //Arrange
        String body = "{\"name\":\"Aditi Ramakrishna\", \"gender\":\"female\", \"email\":\"aditi.krishaniyer1@gmail.com\", \"status\":\"active\"}";

        //Act
        createUser(body)
                .then()
                    .log().body()
        //Assert
                    .statusCode(201)
                    .body("id",Matchers.notNullValue())
                    .body("email",Matchers.equalTo("aditi.krishaniyer1@gmail.com"))
                    .body("name",Matchers.equalTo("Aditi Ramakrishna"));
    }


    private Response createUser(String body) {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 72c04051e13a737af16869169867c00064b1515c8ed9c1578ebfca8946c116fe")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
