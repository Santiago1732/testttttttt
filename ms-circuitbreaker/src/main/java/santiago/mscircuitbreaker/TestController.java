package santiago.mscircuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private Resilience4JCircuitBreakerFactory cbFactory;
	
//	 @Autowired
	 private Test test;	
	
	@PostMapping(value = "testCB")
//	@CircuitBreaker(name = "backendA")
	public String testCB(@RequestBody String stringTest) {
		
		String mensaje = "Error";
		
		return cbFactory.create("backendA").run(() -> lista(stringTest));
//		return cbFactory.create("backendA").run(() -> testCB(stringTest));
	}
	
//	@CircuitBreaker(name= "backendA")
	@GetMapping(value = "testGET")
	public String lista(String nombre) {
		
		
		if(nombre.equals("Santi")) {
			throw new IllegalStateException();
		}else {
			System.out.println(nombre);
		}
		
		return "test";
	}
	
	@GetMapping(value="getTest")
	public String getTest(){
		
		System.out.println("Hola getTest()");
		System.out.println("test: "+test.getValor());
		
		return "test";
	}
	
	
}
