package santiago.mscircuitbreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ardx.java.resilience.ardxjavaresilience.config.ArdxCircuitBreakerPropertiesImp;

@SpringBootApplication
@EnableConfigurationProperties
public class MsCircuitbreakerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MsCircuitbreakerApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(MsCircuitbreakerApplication.class, args);
        LOGGER.info("LA APLICACION ESTA CORRIENDO.....");
        
    }
	


}
