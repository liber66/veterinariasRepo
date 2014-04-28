package veterinarias.interfaces.utils;

public final class InvalidCalendarioFormatException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidCalendarioFormatException() {
    }

    public InvalidCalendarioFormatException(String s) {
        super(s);
    }
}
