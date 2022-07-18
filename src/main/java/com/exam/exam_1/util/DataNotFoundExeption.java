package com.exam.exam_1.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundExeption extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundExeption(String message) {
        super(message);
    }
}
