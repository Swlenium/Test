import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class postpest {
    @Test
    public void addPetWithSchema() {
        JSONObject request = new JSONObject();
        request.put("id", 1);
        request.put("name", "PetName");
        request.put("status", "available");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("api_key", "special-key").
                body(request.toString()).
                when().
                post("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).

                body("name", equalTo("PetName")).
                body("status", equalTo("available"));
    }

    public class GetPetTest {

        @Test
        public void getPet() {
            int petId = 1;
            given().
                    pathParam("petId", petId).
                    when().
                    get("https://petstore.swagger.io/v2/pet/{petId}").
                    then().
                    statusCode(200).
                    body("id", equalTo(petId)).
                    body("name", equalTo("PetName")).
                    body("status", equalTo("available"));
        }
    }
    @Test
    public void updatePet() {
        int petId = 1;
        String newPetName = "NewPetName";
        given().
                contentType("application/json").
                body("{\"id\": " + petId + ",\"name\": \"" + newPetName + "\",\"status\": \"available\"}").
                when().
                put("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("id", equalTo(petId)).
                body("name", equalTo(newPetName)).
                body("status", equalTo("available"));
    }


}
