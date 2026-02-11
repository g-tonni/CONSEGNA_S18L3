package giadatonni.CONSEGNA_S18L3.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BlogPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoLettura;
    private String utenteId;
}
