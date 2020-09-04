package com.lexisnexis.CarStuff.entities;

public class Mix {
    private GenericMultipleFieldRequest<String, String> exactFields;
    private GenericMultipleFieldRequest<String, String> containsString;

    public GenericMultipleFieldRequest<String, String> getExactFields(){
        return exactFields;
    }

    public void setExactFields(GenericMultipleFieldRequest<String, String> exactFields){ this.exactFields = exactFields; }

    public GenericMultipleFieldRequest<String, String> getContainsString() {
        return containsString;
    }

    public void setContainsString(GenericMultipleFieldRequest<String, String> containsString) { this.containsString = containsString; }
}
