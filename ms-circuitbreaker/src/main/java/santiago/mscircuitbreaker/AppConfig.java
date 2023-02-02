package santiago.mscircuitbreaker;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import ardx.java.resilience.ardxjavaresilience.config.ArdxCircuitBreakerPropertiesImp;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
	
@Configuration
public class AppConfig {
	
	private ArdxCircuitBreakerPropertiesImp ardxCircuitBreakerProperties;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
        
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Bean
	public Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory() {
		return new Resilience4JCircuitBreakerFactory();
	}
	
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
		return factory -> factory.configureDefault(id -> {
			return new Resilience4JConfigBuilder(id)
					.circuitBreakerConfig(CircuitBreakerConfig.custom()
							.slidingWindowSize(ardxCircuitBreakerProperties.getSlidingWindowSize())
							.failureRateThreshold(ardxCircuitBreakerProperties.getFailureRateThreshold())
							.waitDurationInOpenState(Duration.ofSeconds(10L))
							.build())
					.timeLimiterConfig(TimeLimiterConfig.ofDefaults())
					.build();
		});
	}
	
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