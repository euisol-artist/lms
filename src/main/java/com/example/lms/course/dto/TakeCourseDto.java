package com.example.lms.course.dto;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Data
public class TakeCourseDto {

    long id;
    long courseId;
    String userId;

    long payPrice; //결재금액
    String status; //상태(수강신청, 결재완료, 수강취소)

    LocalDateTime regDt; //신청일

    //Join
    String userName;
    String phone;
    String subject;

    //추가컬럼
    long totalCount;
    long seq;

    public String getRegDtText() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm");
        return regDt != null ? regDt.format(formatter) : "";

    }

}
