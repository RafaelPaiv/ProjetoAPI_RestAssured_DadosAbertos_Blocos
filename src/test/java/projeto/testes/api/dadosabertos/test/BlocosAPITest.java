package projeto.testes.api.dadosabertos.test;

import org.junit.Test;

import projeto.testes.api.dadosabertos.apiobjects.BlocosObjects;
import projeto.testes.api.dadosabertos.client.APIClient;

public class BlocosAPITest extends APIClient {

	BlocosObjects bo = new BlocosObjects();

	@Test
	public void teste() {

		bo.validarBlocoID(0);

	}

}
