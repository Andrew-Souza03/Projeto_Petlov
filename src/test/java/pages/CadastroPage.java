package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;

import massa.PontoDoacao;

public class CadastroPage {

	String Pet;
	
	protected void acessarFormulario() {
		open("https://petlov.vercel.app/signup");
		$("h1").shouldHave(text("Cadastro de ponto de doação"));
	}
	
	protected void submeterFormulario(PontoDoacao ponto) {
		$("input[name=name]").setValue(ponto.nome);
		$("input[name=email]").setValue(ponto.email);
		$("input[name=cep]").setValue(ponto.cep);
		$("input[value='Buscar CEP']").click();
		$("input[name=addressNumber]").setValue(ponto.numero.toString());
		$("input[name=addressDetails]").setValue(ponto.complemento);
		if(ponto.pets.equalsIgnoreCase("Cachorros")) {
			$(By.xpath("//span[text()='Cachorros']/..")).click();
		}else if (ponto.pets.equalsIgnoreCase("Gatos")) {
			$(By.xpath("//span[text()='Gatos']/..")).click();
		}else if(ponto.pets.equalsIgnoreCase("Cachorros e Gatos") || ponto.pets.equalsIgnoreCase("cachorro gato")) {
			$(By.xpath("//span[text()='Cachorros']/..")).click();
			$(By.xpath("//span[text()='Gatos']/..")).click();
		}
		$(".button-register").click();
	}
}
