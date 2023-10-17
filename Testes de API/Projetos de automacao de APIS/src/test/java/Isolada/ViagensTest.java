package Isolada;

import Config.Configuracoes;

import Factory.ViagemDataFactory;
import Page.Viagensapi;

import Pojo.Viagem;

import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import org.junit.jupiter.api.*;


import java.io.IOException;

import static org.hamcrest.Matchers.notNullValue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ViagensTest {

    private Viagensapi viagensapi;


    @BeforeEach
    public void setup() {
        // configurações restassured
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);
        viagensapi = new Viagensapi
                (configuracoes.baseURI(), configuracoes.port(), configuracoes.basePath());


    }

    @Test
    public void testCadastroDeViagemValidaRtornaSucesso() throws IOException {
        Viagem viagemValida = ViagemDataFactory.Criarviagemvalida();
        Response response = viagensapi.cadastraViagem(viagemValida);
        viagensapi.assertStatusCode(response, 201);
        viagensapi.assertAcompanhante(response, "joao victor krumpos do carmo");


    }


    @Test
    public void testCadastroDeViagemInvalidaComcamposNulosRetornaErro() throws IOException {
        Viagem viageminvalida = ViagemDataFactory.CriarviagemInvalida();
        Response response = viagensapi.cadastraViagem(viageminvalida);
        viagensapi.assertStatusCode(response, 400);

    }


    @Test
    public void testCadastroDeViagemInvalidaSemEnviarCamposObrigatoriosRetornaErro() throws IOException {
        Viagem viageminvalidasemcamposobrigatórios = ViagemDataFactory.CriarviagemSemosCamposObrigatorios();
        Response response = viagensapi.cadastraViagem(viageminvalidasemcamposobrigatórios);
        viagensapi.assertStatusCode(response, 400);

    }


    @Test
    public void testCadastroDeViagemComTokenDeUsuarioRetornaerro() throws IOException {
        Viagem viagemcomtokendeusuario = ViagemDataFactory.Criarviagemvalida();
        Response response = viagensapi.cadastraViagemComTokenDeUsuario(viagemcomtokendeusuario);
        viagensapi.assertStatusCode(response, 403);

    }


    @Test
    public void testBuscarTodasAsViagensRetornaSucesso() {
        Response response = viagensapi.buscarTodasAsViagens();
        viagensapi.assertStatusCode(response, 200);


    }


}
