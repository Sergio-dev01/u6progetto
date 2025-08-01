package sergiomaselli.u6progetto.payloads;

public class LoginRespDTO {
    private String accessToken;

    public LoginRespDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
