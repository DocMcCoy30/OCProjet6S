package org.dmc30.OCprojet6.model.exception;

public enum OCP6Error {
    OCP_6_100,
    OCP_6_200,
    OCP_6_300,
    OCP_6_400,
    OCP_6_500;

    private MessagesError messagesError;

    public MessagesError getMessagesError() {
        return messagesError;
    }

    public void setMessagesError(MessagesError messagesError) {
        this.messagesError = messagesError;
    }
}
