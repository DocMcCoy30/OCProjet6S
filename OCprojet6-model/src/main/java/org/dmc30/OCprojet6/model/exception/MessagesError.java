package org.dmc30.OCprojet6.model.exception;

import javax.inject.Named;

@Named
public class MessagesError {

    private String message101 = "Une erreur technique est survenue lors de la création du compte.";
    private String message401 = "Une erreur de type SQL est survenue lors de la création du compte.";
    private String message402 = "Ce User ou Email existe déjà.";

    public String getMessage402() {
        return message402;
    }

    public void setMessage402(String message402) {
        this.message402 = message402;
    }

    public String getMessage101() {
        return message101;
    }

    public void setMessage101(String message101) {
        this.message101 = message101;
    }

    public String getMessage401() {
        return message401;
    }

    public void setMessage401(String message401) {
        this.message401 = message401;
    }
}
