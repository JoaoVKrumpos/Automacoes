package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Acessaraplicacao() {
        driver.get("https://qazando.com.br/curso.html");
        esperarElemento(10,By.id("btn-ver-cursos"));
        Assert.assertEquals("Não acesso xxxxx", true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);


    }

    public void preencherEmail() {
        driver.findElement(By.id("email")).sendKeys("joaokrumposcarmo@hotmail.com");

    }

    public void ClicarganharDesconto() {
        driver.findElement(By.cssSelector("#button")).click();

    }

    public void ObtercupomDeDesconto() {
        String Texto = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        System.out.println(Texto);
        Assert.assertEquals("QAZANDO15OFF", Texto);

    }
}