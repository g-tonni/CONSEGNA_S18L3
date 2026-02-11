package giadatonni.CONSEGNA_S18L3.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con id " + id + " non è stata trovata");
    }
}
