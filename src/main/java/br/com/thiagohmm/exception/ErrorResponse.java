package br.com.thiagohmm.exception;

public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;

    // Construtores, getters e setters
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
