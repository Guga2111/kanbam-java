package com.example.kanbam.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.example.kanbam.entity.deserializer.StatusDeserializer;

@JsonDeserialize(using = StatusDeserializer.class)
public enum Status {
    TODO,
    IN_PROGRESS,
    DONE;

}
