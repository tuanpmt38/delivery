package shippo.vn.delivery.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus status;
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ErrorMessage() {
        super();
    }

    public ErrorMessage(final HttpStatus status, final String name, final String message) {
        super();
        this.status = status;
        this.name = name;

        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
