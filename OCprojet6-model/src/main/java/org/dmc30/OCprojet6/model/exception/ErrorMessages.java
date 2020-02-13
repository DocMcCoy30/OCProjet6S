package org.dmc30.OCprojet6.model.exception;

public enum ErrorMessages {
    SQL_ERROR(100, "Une erreur de type SQL est survenue lors de la création du compte.", "Vérifier la requète SQL ou la structure de la table"),
    TX_ERROR(101, "Une erreur technique est survenue lors de la création du compte.", "Une erreur est survenue lors de l'execution de la transaction"),

    OCP_6_200(200, "Erreur 200", "Description de l'erreur 200"),

    OCP_6_300(300, "Erreur 300", "Description de l'erreur 300");

    private Integer errorCode;
    private String errorMessage;
    private String errorDescription;

    ErrorMessages(int errorCode, String errorMessage, String errorDescription) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

}
