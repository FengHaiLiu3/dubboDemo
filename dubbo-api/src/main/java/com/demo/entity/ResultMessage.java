package com.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMessage implements Serializable {
    String result;
    String message;
}
