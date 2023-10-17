package Pages;

import Model.Lead;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LeadPage {

    private String apiKey;


    public LeadPage(String apiKey) {
        this.apiKey = apiKey;


    }

    public Response getAllLeads() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("e040aff85b261d19dc422d83de5f7faa7e4a78d4", apiKey)
                .get("/leads");

    }

    public Response getLeadById(int leadId) {

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("e040aff85b261d19dc422d83de5f7faa7e4a78d4", apiKey)
                .get("/leads/" + leadId);

    }

    public Response createLead(Lead lead) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("e040aff85b261d19dc422d83de5f7faa7e4a78d4", apiKey)
                .body(lead)
                .post(",/leads");

    }

    public Response updateLead(int leadId, Lead lead) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("e040aff85b261d19dc422d83de5f7faa7e4a78d4", apiKey)
                .body(lead)
                .put(",/leads" + leadId);
    }

    public Response DeleteLead(int leadId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("e040aff85b261d19dc422d83de5f7faa7e4a78d4", apiKey)
                .delete("/leads" + leadId);

    }
}