package com.example.lms.member.service;

import com.example.lms.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    boolean register(MemberInput parameter);
    boolean emailAuth(String uuid);
}
