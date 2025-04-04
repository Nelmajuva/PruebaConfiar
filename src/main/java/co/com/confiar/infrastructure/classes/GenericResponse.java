package co.com.confiar.infrastructure.classes;

public class GenericResponse<TEntity> {
    private final int statusCode;

    private final TEntity message;

    public GenericResponse(int statusCode, TEntity message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public TEntity getMessage() {
        return this.message;
    }
}
