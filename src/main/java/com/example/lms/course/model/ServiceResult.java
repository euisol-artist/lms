package com.example.lms.course.model;

import com.example.lms.admin.model.CommonParam;
import lombok.Data;

@Data
public class ServiceResult {

    boolean result;
    String message;

    public ServiceResult() {
        result = true;
    }

    public ServiceResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ServiceResult(boolean result) {
        this.result = result;
    }
}
