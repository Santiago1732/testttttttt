package ardx.java.resilience.ardxjavaresilience.config;

public interface ArdxCircuitBreakerPropertiesService {

    public int getFailureRateThreshold();
    public int getSlidingWindowSize();
    public int getPermittedNumberOfCallsInHalfOpenState();
    public int getSlowCallRateThreshold();
    public int getSlowCallDurationThreshold();

}
