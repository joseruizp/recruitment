package com.recruitment.dto.result;

import lombok.Data;
import lombok.Getter;

@Getter
public class KeyValueResult {
    private long id;
    private String description;

    public KeyValueResult(long id, String description) {
        this.id = id;
        this.description = description;
    }
}
