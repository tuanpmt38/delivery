package shippo.vn.delivery.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ErrorMessage {

    private HttpStatus httpCode;
    private String name;
    private String message;
    private List<String> failures;

    public ErrorMessage(HttpStatus httpCode, String name, String message) {
        this.httpCode = httpCode;
        this.name = name;
        this.message = message;
    }

    public ErrorMessage(HttpStatus httpCode, String name, String message, List<String> failures) {
        this.httpCode = httpCode;
        this.name = name;
        this.message = message;
        this.failures = failures;
    }

    public ErrorMessage(HttpStatus httpCode, String name, String message, String failure) {
        this.httpCode = httpCode;
        this.name = name;
        this.message = message;
        failures = Arrays.asList(failure);
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getFailures() {
        return failures;
    }

    public void setFailures(List<String> failuress) {
        this.failures = failuress;
    }

    public void setFailure(final String failure) {
        failures = Arrays.asList(failure);
    }
}
