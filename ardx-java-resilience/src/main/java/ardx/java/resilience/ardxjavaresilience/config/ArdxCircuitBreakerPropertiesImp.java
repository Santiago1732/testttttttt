package ardx.java.resilience.ardxjavaresilience.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class ArdxCircuitBreakerPropertiesImp implements ArdxCircuitBreakerPropertiesService {
	

	@Bean
	public ArdxCircuitBreakerPropertiesImp cbProperties(int slidingWindowSize, int failureRateThreshold, int waitDurationInOpenState,
			int permittedNumberOfCallsInHalfOpenState, int slowCallRateThreshold, int slowCallDurationThreshold) {
		
		this.slidingWindowSize = slidingWindowSize;
		this.failureRateThreshold = failureRateThreshold;
		this.waitDurationInOpenState = waitDurationInOpenState;
		this.permittedNumberOfCallsInHalfOpenState = permittedNumberOfCallsInHalfOpenState;
		this.slowCallRateThreshold = slowCallRateThreshold;
		this.slowCallDurationThreshold = slowCallDurationThreshold;
		
		return cbProperties(slowCallDurationThreshold, slowCallDurationThreshold, slowCallDurationThreshold, slowCallDurationThreshold, slowCallDurationThreshold, slowCallDurationThreshold);
	}
	
	@Value("${cb.sliding-window-size}")
	private int slidingWindowSize;

	@Value("${failure-rate-threshold}")
	private int failureRateThreshold;

	@Value("${wait.duration.in.open.state}")
	private int waitDurationInOpenState;

	@Value("${permitted.number.of.calls.in.half.open.state}")
	private int permittedNumberOfCallsInHalfOpenState;

	@Value("${call.rate.threshold}")
	private int slowCallDurationThreshold;

	@Value("${slow.call.duration.threshold}")
	private int slowCallRateThreshold;
	
	public int getSlidingWindowSize() {
		return slidingWindowSize;
	}

	public void setSlidingWindowSize(int slidingWindowSize) {
		this.slidingWindowSize = slidingWindowSize;
	}

	public int getFailureRateThreshold() {
		return failureRateThreshold;
	}

	public void setFailureRateThreshold(int failureRateThreshold) {
		this.failureRateThreshold = failureRateThreshold;
	}

	public int getWaitDurationInOpenState() {
		return waitDurationInOpenState;
	}

	public void setWaitDurationInOpenState(int waitDurationInOpenState) {
		this.waitDurationInOpenState = waitDurationInOpenState;
	}

	public int getPermittedNumberOfCallsInHalfOpenState() {
		return permittedNumberOfCallsInHalfOpenState;
	}

	public void setPermittedNumberOfCallsInHalfOpenState(int permittedNumberOfCallsInHalfOpenState) {
		this.permittedNumberOfCallsInHalfOpenState = permittedNumberOfCallsInHalfOpenState;
	}

	public int getSlowCallDurationThreshold() {
		return slowCallDurationThreshold;
	}

	public void setSlowCallDurationThreshold(int slowCallDurationThreshold) {
		this.slowCallDurationThreshold = slowCallDurationThreshold;
	}

	public int getSlowCallRateThreshold() {
		return slowCallRateThreshold;
	}

	public void setSlowCallRateThreshold(int slowCallRateThreshold) {
		this.slowCallRateThreshold = slowCallRateThreshold;
	}

}
