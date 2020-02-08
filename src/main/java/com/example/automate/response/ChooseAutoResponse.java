package com.example.automate.response;

import lombok.Builder;

@Builder
public class ChooseAutoResponse {
    private Integer autoId;

    public Integer getId() {
        return autoId;
    }

    public void setId(Integer id) {
        this.autoId = id;
    }
}
