package oauth2.vo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

public class ResponseData<T> extends ResponseEntity implements Serializable {
    private T data;
    private String msg = "";

    public ResponseData(HttpStatus status) {
        super(status);
    }

    public ResponseData(T body, String msg, HttpStatus status) {
        super(body, status);
        this.msg = msg;
    }

    public ResponseData(String msg, HttpStatus status) {
        super(msg, status);
        this.msg = msg;
    }

    public ResponseData(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public ResponseData(T body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }
}
