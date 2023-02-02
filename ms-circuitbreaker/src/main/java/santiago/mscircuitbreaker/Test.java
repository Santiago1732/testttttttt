package santiago.mscircuitbreaker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class Test {
	
	@Value("${test.valor}") 
	private int valor;

	public int getValor() {
		return valor;
	}

	public Test(int valor) {
		super();
		this.valor = valor;
	}

	
	
}

