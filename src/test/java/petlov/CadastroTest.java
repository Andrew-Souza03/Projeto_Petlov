package petlov;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import massa.PontoDoacao;
import pages.CadastroPage;

public class CadastroTest extends CadastroPage {

	@Test
	@DisplayName("Deve poder cadastrar um ponto de doação")
	public void cadastroDePonto() {

		PontoDoacao ponto = new PontoDoacao(
				"PetLandia",
				"petlandia@gmail.com.br",
				"04534011",
				"345",
				"Ao lado do Mercado",
				"Gatos");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

		$("#success-page p").shouldHave(text(target));
	}
	
	@Test
	@DisplayName("Não deve cadastrar sem preencher o nome")
	public void nomeEmBranco() {

		PontoDoacao ponto = new PontoDoacao(
				"",
				"lifePets@hotmail.com.br",
				"04534011",
				"345",
				"Ao lado do Mercado",
				"Cachorros");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe o seu nome completo";
		$(".alert-error").shouldHave(text(target));
	}

	@Test
	@DisplayName("Não deve cadastrar com email inválido")
	public void emailInvalido() {

		PontoDoacao ponto = new PontoDoacao(
				"Lar Pets",
				"larpets&larpets.com.br",
				"04534011",
				"345",
				"Ao lado do Mercado",
				"Cachorros");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe um email válido";
		$(".alert-error").shouldHave(text(target));
	}
	
	@Test
	@DisplayName("Não deve cadastrar sem preencher o email")
	public void emailEmBranco() {

		PontoDoacao ponto = new PontoDoacao(
				"4 Patas",
				"",
				"04534011",
				"76",
				"Ao lado da ponte azul",
				"Cachorros e Gatos");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe o seu melhor email";
		$(".alert-error").shouldHave(text(target));
	}
	
	@Test
	@DisplayName("Não deve cadastrar com CEP inválido")
	public void cepInvalido() {

		PontoDoacao ponto = new PontoDoacao(
				"Ração Vida",
				"racaovida@gmail.com.br",
				"12sd3",
				"345",
				"Ao lado do Mercado",
				"Cachorros");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe um CEP válido";
		$(".alert-error").shouldHave(text(target));
	}
	
	@Test
	@DisplayName("Não deve cadastrar sem preencher o CEP")
	public void cepEmBranco() {

		PontoDoacao ponto = new PontoDoacao(
				"Vida Animal",
				"vidaAnimal@hotmail.com.br",
				"04534011",
				"29",
				"Em frente a quadra",
				"Cachorros");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe o seu CEP";
		$(".alert-error").shouldHave(text(target));
	}
	
	@Test
	@DisplayName("Não deve cadastrar sem preencher o numero")
	public void numeroEmBranco() {

		PontoDoacao ponto = new PontoDoacao(
				"Animal Planet",
				"animalplanet@hotmail.com.br",
				"04534011",
				"",
				"Ao lado da Escola",
				"Gatos");

		acessarFormulario();

		submeterFormulario(ponto);

		String target = "Informe um número maior que zero";
		$(".alert-error").shouldHave(text(target));
	}
}
