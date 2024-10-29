package br.com.desafio.automacaoweb.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade Sign Up")
public class SauceDemoTests {
    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testeRegistrarUmNovoUsuarioComDadosValidos(){
        // Vou abrir o navegador chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(("--start-maximized"));
        WebDriver navegador = new ChromeDriver(options);

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Abrir Página Saucedemo
        navegador.get("https://www.saucedemo.com/");
        System.out.println("Abrir Página Saucedemo");

        // FLUXO-LOGIN
        // Valida titulo Página login
        String title_login = navegador.getTitle();
        Assertions.assertEquals("Swag Labs",title_login);
        System.out.println("validar titulo");

        // Digitar nome do usuário
        navegador.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Digitar nome do usuário");

        // Digitar senha do usuário
        navegador.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Digitar senha do usuário");

        // Clicar no botão login
        navegador.findElement(By.id("login-button")).click();
        System.out.println("Clicar no botão login");

        //FLUXO CARRINHO
        // Valida titulo Página Produtos
        String titleProdutos = navegador.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assertions.assertEquals("Products", titleProdutos);
        System.out.println("Valida titulo Página Produtos");

        // Clica em filtro
        navegador.findElement(By.className("product_sort_container")).click();
        System.out.println("Clica em filtro");

        // Seleciona filtro
        navegador.findElement(By.xpath("//span[@class='active_option']/following-sibling::select[1]")).click();
        System.out.println("Seleciona filtro");

        // Clica no produto
        navegador.findElement(By.id("item_4_title_link")).click();
        System.out.println("Clica no produto");

        // Valida descrição Produtos
        String item_product = navegador.findElement(By.xpath("//div[@class='inventory_details_desc large_size']")).getText();
        Assertions.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", item_product);
        System.out.println("Valida descrição Produtos");

        // Adicionar ao Carrinho
        navegador.findElement(By.id("add-to-cart")).click();
        System.out.println("Adicionar ao Carrinho");

        // valida quantidade de item no carrinho
        String qtd_item = navegador.findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).getText();
        int quantidade = Integer.parseInt(qtd_item); // Converte para inteiro
        if (quantidade != 0) {
            System.out.printf("O Carrinho tem " + quantidade + " item");
        } else {
            System.out.println("O Carrinho está vazio");
        }

        // Clica no Carrinho
        navegador.findElement(By.className("shopping_cart_link")).click();
        System.out.println("\nClica no Carrinho");

        // Finalizar pagamento

        // Valida titulo carrinho
        String titleCart = navegador.findElement(By.className("title")).getText();
        Assertions.assertEquals("Your Cart", titleCart);
        System.out.println("Valida titulo carrinho");

        // Clica em Checkout
        navegador.findElement(By.id("checkout")).click();
        System.out.println("Clica em Checkout");


        // Valida titulo checkout
        String titleCheckout = navegador.findElement(By.className("title")).getText();
        Assertions.assertEquals("Checkout: Your Information", titleCheckout);
        System.out.println("Valida titulo checkout");

        // Digitar Nome do usuário
        navegador.findElement(By.id("first-name")).sendKeys("Thiago");
        System.out.println("Digitar Nome do usuário");

        // Digitar Sobrenome do usuário
        navegador.findElement(By.id("last-name")).sendKeys("Carvalho de Mello");
        System.out.println("Digitar Sobrenome do usuário");

        // Digitar Endereço do usuário
        navegador.findElement(By.id("postal-code")).sendKeys("91249210");
        System.out.println("Digitar Endereço do usuário");

        // Clica em Continuar
        navegador.findElement(By.id("continue")).click();
        System.out.println("Clica em Continuar");

        // Valida titulo checkout Overview
        String titleOverview = navegador.findElement(By.className("title")).getText();
        Assertions.assertEquals("Checkout: Overview", titleOverview);
        System.out.println("Valida titulo checkout Overview");

        // Clica em finalizar
        navegador.findElement(By.id("finish")).click();
        System.out.println("Clica em finalizar");

        navegador.quit();
    }
}
