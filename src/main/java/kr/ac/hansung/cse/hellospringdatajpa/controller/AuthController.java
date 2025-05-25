package kr.ac.hansung.cse.hellospringdatajpa.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.cse.hellospringdatajpa.entity.Role;
import kr.ac.hansung.cse.hellospringdatajpa.entity.User;
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 로그인 페이지 GET 요청
     * - Spring Security에서 기본적으로 "/login" URL을 사용함
     * - 인증 실패/성공 여부는 URL 파라미터로 처리됨 (?error, ?logout 등)
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 회원가입 페이지 GET 요청
     * - 비어 있는 User 객체를 모델에 담아 폼과 바인딩
     */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * 회원가입 처리 POST 요청
     * - 입력값 검증 + 이메일 중복 체크 + 비밀번호 암호화 + DB 저장
     *
     * @param user   입력된 사용자 정보 (Thymeleaf 폼 바인딩)
     * @param result 유효성 검사 결과
     * @param model  에러 메시지 출력을 위한 모델
     */
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        // 1. 유효성 검사 실패 시
        if (result.hasErrors()) {
            return "register";
        }

        // 2. 이메일 중복 확인
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "이미 존재하는 이메일입니다.");
            return "register";
        }

        // 3. 저장 및 리다이렉트
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
