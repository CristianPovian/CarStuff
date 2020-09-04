package com.lexisnexis.CarStuff.entities;

import java.util.List;

public class MultipleRequest {
    private List<String> ids;

    public List<String> getIds(){
        return ids;
    }

    public void setIds(List<String> ids){
        this.ids=ids;
    }
}
