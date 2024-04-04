package projeto.testes.api.dadosabertos.apiobjects;

import static org.junit.Assert.assertEquals;

import io.restassured.RestAssured;
import projeto.testes.api.dadosabertos.client.APIClient;
import projeto.testes.api.dadosabertos.utils.APIUtilsBaseURL;

public class BlocosObjects extends APIClient {

	APIUtilsBaseURL url = new APIUtilsBaseURL();

	
	
	/**
	 * Metodo para seleção e validacao de blocos partidarios na API Dados Abertos Camara, para selcionar basta preenceher uma das opcoes
	 * disponiveis: 0 (Federacao Brasil da Esperança - Fe Brasil), 1 (Federacao PSDB CIDADANIA), 2 (Federacao PSOL REDE), 3(MDB, PSD, REPUBLICANOS, PODE) e 4 (UNIAO, PP, Federacao PSDB CIDADANIA, PDT, AVANTE, SOLIDARIEDADE, PR)
	 */
	public void validarBlocoID(int posicao) {

		response = RestAssured.get(url.BaseURL + "/blocos?ordem=ASC&ordenarPor=nome");
		String id = response.jsonPath().getString("dados[" + posicao + "].id");
		String idLegislatura = response.jsonPath().getString("dados[" + posicao + "].idLegislatura");
		String nome = response.jsonPath().getString("dados[" + posicao + "].nome");

		response = RestAssured.get(url.BaseURL + "/blocos/" + id);
		String idVerificado = response.jsonPath().getString("dados.id");
		String idLegislaturaVerificado = response.jsonPath().getString("dados.idLegislatura");
		String nomeVerificado = response.jsonPath().getString("dados.nome");

		assertEquals(id, idVerificado);
		assertEquals(idLegislatura, idLegislaturaVerificado);
		assertEquals(nome, nomeVerificado);
		assertEquals(200, response.getStatusCode());
		

	}

}
