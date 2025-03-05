package com.example.kanbam.entity;

import com.example.kanbam.entity.deserializer.PriorityDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.example.kanbam.entity.deserializer.StatusDeserializer;

@JsonDeserialize(using = PriorityDeserializer.class)
public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

}
