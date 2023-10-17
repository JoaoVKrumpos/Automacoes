package Page;

import Config.Configuracoes;
import Factory.UsuarioDataFactory;
import Pojo.Usuario;
import Pojo.Viagem;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;

public class Viagensapi {
    private String tokenAdministrador;
    private String tokenComun;

    public Viagensapi(String baseURI, int port, String basePath) {

        RestAssured.baseURI = baseURI;
        RestAssured.port = port;
        RestAssured.basePath = basePath;

        this.tokenAdministrador = autenticarAdmnistrador();
        this.tokenComun = autenticarUsuarioComum();
    }

    private String autenticarAdmnistrador() {
        Usuario usuarioAdministrador = UsuarioDataFactory.criarUsuarioAdministrador();
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(usuarioAdministrador)
                .when().post("/v1/auth")
                .then()
                .log()
                .all()
                .extract()
                .path("data.token");


    }

    private String autenticarUsuarioComum() {
        Usuario usuariocomum = UsuarioDataFactory.criarUsuarioComum();
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(usuariocomum)
                .when().post("/v1/auth")
                .then()
                .log()
                .all()
                .extract()
                .path("data.token");


    }


    public Response cadastraViagem(Viagem viagem) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(viagem)
                .header("Authorization", tokenAdministrador)
                .log().all()
                .when()
                .post("/v1/viagens");


    }

    public Response cadastraViagemComTokenDeUsuario(Viagem viagem) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(viagem)
                .header("Authorization", tokenComun)
                .log().all()
                .when()
                .post("/v1/viagens");
    }

    public Response buscarTodasAsViagens() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", tokenComun)
                .when()
                .get("/v1/viagens");
    }
    public void assertStatusCode(Response response, int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    public void assertLocalDeDestino(Response response, String expectedLocalDeDestino) {
        response.then().assertThat().body("data.localDeDestino", Matchers.equalTo(expectedLocalDeDestino));
    }

    public void assertAcompanhante(Response response, String expectedAcompanhante) {
        response.then().assertThat().body("data.acompanhante", Matchers.equalToIgnoringCase(expectedAcompanhante));
    }

        public String getTokenAdministrador () {
            return tokenAdministrador;


        }

        public String getTokenComun () {
            return tokenComun;

        }
    }