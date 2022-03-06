package com.example.lms.member.controller;

import com.example.lms.common.model.ResponseResult;
import com.example.lms.course.dto.TakeCourseDto;
import com.example.lms.course.model.ServiceResult;
import com.example.lms.course.model.TakeCourseInput;
import com.example.lms.course.service.TakeCourseService;
import com.example.lms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ApiMemberController {

    private final TakeCourseService takeCourseService;


    @PostMapping("/api/member/course/cancel.api")
    public ResponseEntity<?> cancelCourse(Model model,
                                              @RequestBody TakeCourseInput parameter,
                                              Principal principal) {

        String userId = principal.getName();

        //내 강좌인지 확인
        TakeCourseDto detail = takeCourseService.detail(parameter.getTakeCourseId());
        if (detail == null) {
            ResponseResult responseResult = new ResponseResult(false, "수강 신청 정보가 존재하지 않습니다.");
            return ResponseEntity.ok().body(responseResult);
        }

        if (userId == null || !userId.equals(detail.getUserId())) {
            //내 신청정보 정보가 아님
            ResponseResult responseResult = new ResponseResult(false, "본인의 수강 신청 정보만 취소할 수 있습니다.");
            return ResponseEntity.ok().body(responseResult);
        }

        ServiceResult result = takeCourseService.cancel(parameter.getTakeCourseId());
        if (!result.isResult()) {
            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
}
