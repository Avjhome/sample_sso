package sample_sso;

public interface SecurityService {

    String createtoken(String subject, long ttlMillis);
    String getSubject(String token);

}
