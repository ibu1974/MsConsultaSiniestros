/**
 * 
 */
package mx.com.gnp.plus.consultasinies.exception;

/**
 * @author jsetien
 *
 */
public class InvalidNameException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Excepción de otp validado previamente.
     * 
     * @param invalidName
     *            El nombre inválido
     */
    public InvalidNameException(final String invalidName) {
        super("El nombre recibido -> " + invalidName + " no es un nombre válido");
    }

}