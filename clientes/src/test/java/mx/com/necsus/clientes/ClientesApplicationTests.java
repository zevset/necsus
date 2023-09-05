package mx.com.necsus.clientes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
class ClientesApplicationTests {

	@Test
	void contextLoads() {
		boolean response = true;
		Assert.notNull(response);
	}

}
