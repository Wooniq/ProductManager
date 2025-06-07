# 🔐 웹프레임워크2 과제2: Spring Security 기반 Product 관리 시스템

이 저장소는 **웹프레임워크2** 교과목의 **과제 2**를 위한 Spring Boot 기반 프로젝트입니다.

<p align="center">
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/Spring_Boot-6DB33F.svg?style=flat-square&logo=spring&logoColor=white"/>
  </a>
  <a href="https://www.mysql.com/">
    <img src="https://img.shields.io/badge/MySQL-4479A1.svg?style=flat-square&logo=mysql&logoColor=white"/>
  </a>
  <a href="https://www.thymeleaf.org/">
    <img src="https://img.shields.io/badge/Thymeleaf-005F0F.svg?style=flat-square&logo=thymeleaf&logoColor=white"/>
  </a>
</p>

## 🛠️ 기술 스택
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Thymeleaf
- Java 21
- MySQL

## 📂 프로젝트 개요
Spring Security를 활용하여 인증 및 권한(Role) 기반 기능을 구현한 **Product 관리 웹 애플리케이션**입니다.  
사용자는 **회원가입/로그인**, **상품 CRUD** 및 **권한에 따른 접근 제어**를 수행할 수 있습니다.

## ✅ 주요 기능
- 사용자 인증 및 권한 부여
- 권한(Role)에 따른 기능 제한 (USER / ADMIN)
- 상품 등록/조회/수정/삭제
- 관리자 전용 페이지
- 입력 유효성 검사

<p align="center">
    <img src="https://img.shields.io/github/stars/Wooniq/ProductManager" alt="GitHub stars">
    <img src="https://img.shields.io/github/license/Wooniq/ProductManager" alt="GitHub license">
</p>

## 📄 과제 제출 정보
- **과목명**: 웹프레임워크2
- **담당 교수님**: 김남윤
- **제출자**: 한지운 / 2291001
- **과제명**: 과제 2 - Spring Security 기반 Product 관리 애플리케이션

---

### ✅ 시스템 주요 화면 예시

| 기능 | 구현 결과 |
|------|--------|
| 로그인 페이지 | ![image](https://github.com/user-attachments/assets/f2e50ab9-eb3b-461f-a58c-53acf8a0d9a6) |
| 회원가입 페이지 | ![image](https://github.com/user-attachments/assets/0c2040e2-fd25-4d09-83f5-0e4e7e209d90) |
| 상품 목록 조회 (USER/ADMIN 공통) | [USER]<br> ![image](https://github.com/user-attachments/assets/cca03894-dc1a-4eeb-86da-ba7f3adfd46b) <br>[ADMIN]<br> ![image](https://github.com/user-attachments/assets/1602611f-d209-420a-9a95-092b51c34522) |
| 상품 등록/수정/삭제 (ADMIN 전용) | ![image](https://github.com/user-attachments/assets/a5673935-a11b-466c-abeb-3b78b1402792) |
| 관리자 전용 페이지 | ![image](https://github.com/user-attachments/assets/bf585555-e4de-427b-8ab5-db10e61684e6) |

---

## ✨ 주요 기능 ✨

- **① 사용자 인증 기능**
  - 회원가입 및 로그인 구현
  - Spring Security 로그인/로그아웃 설정 적용
  - BCryptPasswordEncoder를 사용한 비밀번호 암호화

- **② 권한(Role) 기반 인가 기능**
  - 기본 권한: `ROLE_USER`, `ROLE_ADMIN`
  - ROLE_USER: 상품 목록 조회만 가능
  - ROLE_ADMIN: 상품 등록/수정/삭제 가능
  - **Thymeleaf에서 권한에 따라 UI 요소 표시/비표시 처리**

- **③ 추가 기능**
  - 로그인 성공/실패 시 메시지 출력
  - 상품 등록/수정 시 유효성 검사(가격은 0 이상 등)
  - 관리자 페이지: 전체 사용자 목록 확인 가능

---

## 📚 기술 스택 상세 📚

- **Spring Boot 3.x**: 웹 애플리케이션 프레임워크
- **Spring Security**: 인증/인가 처리
- **Spring Data JPA**: DB 접근 및 CRUD 처리
- **Thymeleaf**: 서버 사이드 HTML 렌더링
- **MySQL**: 관계형 데이터베이스
- **BCryptPasswordEncoder**: 보안 비밀번호 해싱

---

## 📂 프로젝트 구조 📂
```
ProductManager/
├── src/
│   └── main/
│       ├── java/com/example/productmanager/
│       │   ├── config/              # Spring Security 설정
│       │   ├── controller/          # 컨트롤러 계층
│       │   ├── domain/              # 엔티티 클래스
│       │   ├── dto/                 # DTO 클래스
│       │   ├── repository/          # JPA 레포지토리
│       │   └── service/             # 서비스 계층
│       ├── resources/
│       │   ├── templates/           # Thymeleaf HTML 파일
│       │   ├── static/              # 정적 자원 (CSS, JS 등)
│       │   └── application.yml      # 설정 파일
├── pom.xml                          # Maven 빌드 설정 파일
```

---

## 🚀 시작하기 🚀

1. **레포지토리 클론하기:**  
   ```bash
   git clone https://github.com/Wooniq/ProductManager.git
   ```

2. **프로젝트 디렉토리로 이동:**  
   ```bash
   cd ProductManager
   ```

3. **MySQL 설정 및 실행:**  
   application.yml의 DB 설정 수정 후 실행

4. **실행:**  
   ```bash
   ./mvnw spring-boot:run
   ```

5. **접속:**  
   `http://localhost:8080`

---

## 💡 로그인 및 권한 제어 예시

- 로그인 페이지: `/login`
- 관리자 페이지: `/admin`
- 상품 목록: `/products`
- 상품 등록/수정/삭제: `/products/new`, `/products/edit/{id}` (ADMIN만 가능)

---

## 📌 유효성 검사 예시
```java
@NotBlank
private String name;

@Min(0)
private int price;
```

---

## ✅ 자기 평가
- [x] 사용자 인증 기능 구현
- [x] ROLE 기반 접근 제어 및 UI 처리
- [x] 추가 기능 및 관리자 페이지 구현 완료  

---

