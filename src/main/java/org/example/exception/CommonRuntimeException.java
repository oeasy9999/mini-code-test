package org.example.exception;

/**
 *  Common Exception Class
 */
public class CommonRuntimeException extends RuntimeException {
    private String code;
    private String message;
    private Throwable throwable;

    public CommonRuntimeException() {
    }

    public CommonRuntimeException(String code, String message, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }

    public CommonRuntimeException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonRuntimeException(String code, Throwable e) {
        this(code, "", e);
    }

    public CommonRuntimeException(String code) {
        this(code, "");
    }

    public CommonRuntimeException(Throwable e) {
        super(e);
        this.throwable = e;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String toString() {
        String s = this.getClass().getName();
        String message = this.getMessage();
        return message != null ? s + ": " + message : s;
    }

    public Object[] getParameters() {
        return new Object[]{this.code, this.message};
    }
}
