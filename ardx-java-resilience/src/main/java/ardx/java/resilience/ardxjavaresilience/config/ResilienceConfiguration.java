package ardx.java.resilience.ardxjavaresilience.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

@Configuration
public class ResilienceConfiguration {

	@Autowired
	ArdxCircuitBreakerPropertiesImp ardxCircuitBreakerProperties;

//	@Bean
//	public Customizer<Resilience4JCircuitBreakerFactory> tuvieja() {
//	    return factory -> factory.create("backendA",builder -> builder = new Resilience4JConfigBuilder(id))
//	            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
//	            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//	            .build());
//	}
	
	@Bean
	public CircuitBreakerConfigCustomizer circuitBreakerCustomizer() {
		return CircuitBreakerConfigCustomizer.of("backendA", builder -> builder
				.slidingWindowSize(ardxCircuitBreakerProperties.getSlidingWindowSize())
				.permittedNumberOfCallsInHalfOpenState(ardxCircuitBreakerProperties.getPermittedNumberOfCallsInHalfOpenState())
				.waitDurationInOpenState(Duration.ofSeconds(ardxCircuitBreakerProperties.getWaitDurationInOpenState()))
				.failureRateThreshold(ardxCircuitBreakerProperties.getFailureRateThreshold())
				.slowCallDurationThreshold(Duration.ofSeconds(ardxCircuitBreakerProperties.getSlowCallDurationThreshold()))
				.slowCallRateThreshold(ardxCircuitBreakerProperties.getSlowCallRateThreshold())
				.slidingWindowType(SlidingWindowType.TIME_BASED)
		);
	}
	

}

