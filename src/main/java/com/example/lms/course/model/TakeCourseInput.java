package com.example.lms.course.model;

import com.example.lms.admin.model.CommonParam;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Data;

@Data
public class TakeCourseInput {

    long courseId;
    String userId;

}
