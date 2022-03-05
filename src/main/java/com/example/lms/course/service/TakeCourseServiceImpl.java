package com.example.lms.course.service;

import com.example.lms.course.dto.CourseDto;
import com.example.lms.course.dto.TakeCourseDto;
import com.example.lms.course.entity.Course;
import com.example.lms.course.entity.TakeCourse;
import com.example.lms.course.mapper.CourseMapper;
import com.example.lms.course.mapper.TakeCourseMapper;
import com.example.lms.course.model.*;
import com.example.lms.course.repository.CourseRepository;
import com.example.lms.course.repository.TakeCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TakeCourseServiceImpl implements TakeCourseService {

    private final TakeCourseRepository takeCourseRepository;
    private final TakeCourseMapper takeCourseMapper;

    @Override
    public List<TakeCourseDto> list(TakeCourseParam parameter) {

            long totalCount = takeCourseMapper.selectListCount(parameter);

            List<TakeCourseDto> list = takeCourseMapper.selectList(parameter);
            if (!CollectionUtils.isEmpty(list)) {
                int i = 0;
                for (TakeCourseDto x : list) {
                    x.setTotalCount(totalCount);
                    x.setSeq(totalCount - parameter.getPageStart() - 1);
                    i++;
                }
            }

        return null;
    }

    @Override
    public ServiceResult updateStatus(long id, String status) {

        Optional<TakeCourse> optionalTakeCourse = takeCourseRepository.findById(id);
        if (!optionalTakeCourse.isPresent()) {
            return new ServiceResult(false, "수강 정보가 존재하지 않습니다.");
        }

        TakeCourse takeCourse = optionalTakeCourse.get();

        takeCourse.setStatus(status);
        takeCourseRepository.save(takeCourse);

        return new ServiceResult(true);
    }
}

