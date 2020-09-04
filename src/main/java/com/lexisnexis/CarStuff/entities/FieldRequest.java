package com.lexisnexis.CarStuff.entities;

public class FieldRequest {
    private String fieldName;
    private String value;

    public String getFieldName(){
        return fieldName;
    }

    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

}
