package com.example.automate.response;

import lombok.Builder;

@Builder
public class ChooseAutoResponse {
    private Integer autoId;

    public ChooseAutoResponse(Integer autoId) {
        this.autoId = autoId;
    }

    public Integer getAutoId() {
        return autoId;
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }
}
