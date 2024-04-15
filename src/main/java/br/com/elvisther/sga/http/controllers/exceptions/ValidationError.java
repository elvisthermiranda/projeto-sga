package br.com.elvisther.sga.http.controllers.exceptions;

import java.util.List;
import java.util.ArrayList;

public class ValidationError extends StandartError
{
    private List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
