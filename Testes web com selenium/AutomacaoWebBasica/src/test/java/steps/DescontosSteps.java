package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;


import pages.HomePage;
import runner.RunCucumberTest;


public class DescontosSteps extends RunCucumberTest {
    HomePage homePage = new HomePage(driver);

    @Dado("^que estou no site da qazando$")
    public void que_estou_no_site_da_qazando() {
        homePage.Acessaraplicacao();
    }


    @Quando("^preencho meu email$")
    public void preencho_meu_email() throws InterruptedException {
        homePage.scrollDown();
        homePage.preencherEmail();


    }

    @Quando("^clico no ganhar cupom$")
    public void clico_no_ganhar_cupom() {
        homePage.ClicarganharDesconto();

    }


    @Entao("^vejo o codigo de desconto$")
    public void vejo_o_codigo_de_desconto() {
        homePage.ObtercupomDeDesconto();


    }

}