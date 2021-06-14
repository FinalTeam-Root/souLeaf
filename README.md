# SouLeaf Project
------------
## 팀원 
김윤정(조장), 백승범, 신성진, 오우철, 이지애

------------
## 수행기간
2020년 4월 26일 ~ 6월 15일

------------
- 링크<br>
  + [개발일정](https://docs.google.com/spreadsheets/d/1bDzGJCF0Spa6vZufYcCb-m3DxLTwggkXBBEPUO_T0CU/edit#gid=435889482)<br>
  + [요구사항 정의서](https://docs.google.com/document/d/1sF4mHOC_YPGZTm9IHVcm4IhxcGY5H3lCzEhL59uKUpo/edit?ts=6092511d)<br>
  + [요구사항 리스트](https://docs.google.com/spreadsheets/d/1UeOXqifj5IiFxAGvvXP8U5nYzFb2V4Zrqg3sLE59nDo/edit#gid=946348933)<br>
  + [Slack](https://app.slack.com/client/T0203E7N5M5/C020JDZM6F5)<br>
  + [ERD](https://www.erdcloud.com/d/5WKYWXMC3ZtS5Emjn)

------------
## Contetns

1. [개요](#개요)
2. [설계의 주안점](#설계의-주안점)
3. [사용기술 및 개발환경](#사용기술-및-개발환경)
4. [프로젝트 기능 구현](#프로젝트-기능-구현)
5. [주요기능](#주요기능)
6. [Document](#Document)

------------

## 개요
+ 솔리프(souLeaf)는 소울(SOUL) + 리프(LEAF)의 합성어입니다. 반려식물을 키우고 싶지만 정보가 없어 힘들었던 사용자에게 맞춤 식물 정보를 제공합니다. 식물 찾기를 통해 내가 원하는 식물을 검색 하고 반려식물 등록 후 성장일기를 통해 해당 식물의 상세한 기록을 할 수 있습니다. 또한 식물자랑, 식물클리닉, 궁금해요 게시판을 활용하여 식물을 쉽고 재미있게 다가갈수 있도록 하였습니다.
------------

## 설계의 주안점
- 채팅 기능으로 사용자들의 소통이 원활하게 함
- 성장일기로 반려식물을 기르는 과정을 세세히 기록 가능
	등록한 반려식물의 물주는 날을 달력에 표시해주는 것이 관건
- 각 게시판 별로 특징을 주어 사용자들이 홈페이지 사용시 재미를 줌

------------
## 사용기술 및 개발환경


Category | Detail
---- | ----
Laguage & Library |  Java, Servlet, HTML5, CSS, Javascript, jQuery, Ajax, JSP
API | kakao login, fullcalendar, openWeather 
IDE | Eclpise
DataBase | Oracle 11g
Server | Tomcat(v8.5)
Framework | Spring, Bootstrap, MyBatis
Document | draw.io, google drive, ERDCloud, StarUML
CI | Github


------------
## 프로젝트 기능 구현


- 공통
    - 프로젝트 주제 선정 및 기획 
    - 플로우차트, 유스케이스 다이어그램 설계
    - DB & 클래스, 시퀸스 다이어그램 설계    
    - 프로젝트 문서 작업
<br><br>


  
  - 성장일기
    - FullCalendar를 활용한 반려 식물 물주기 관리 및 성장일기 
    - 사진첩
    - 방명록
  - 로그인
    - 로그인 유효성 검사 
    - KAKAO API 호출 권한을 부여하는 액세스 토큰(Access Token)을 활용한 카카오 로그인
  - 마이페이지
    - 내 게시글 관리
    - QnA관리
    - 비밀번호 변경       
    - 회원탈퇴
   

<br><br>

- 백승범
  - 메인페이지
    - 전체적인 CSS
    - 식물찾기,클리닉 검색
    - openWeather를 활용한 날씨 API
  - 로그인
    - 쿠키를 활용한 아이디 정보 저장
  - 식물찾기
    - 1차 2차 3차 분류를 통한 상세 검색
  - 식물자랑
    - 대댓글
    - 댓글 이모티콘   
  - 궁금해요
    - 게시글 CRUD
    - 댓글 해시태그
  - 클리닉
    - 댓글 채택
  - 마이페이지
    - 내 댓글 관리
  - 관리자
    - 도감관리
    - 회원관리
    - 게시글관리
    - QnA관리 
  

 <br><br>
   
- 신성진 
  - QnA
    - 게시글 CRUD 
  - 회원가입
    - SMTP 서버를 활용한 이메일 인증 회원가입
  - 계정찾기
    - 아이디 찾기
    - SMTP 서버를 활용한 비밀번호 찾기  
  - 마이페이지
    - 회원 정보 수정  
  
<br><br>  
   
- 오우철
  - 메인페이지
    - 웹소켓을 활용한 1:1 채팅 
    - 랭킹
  - 클리닉
    - 게시글 CRUD
    - 좋아요 기능 
  - 마이페이지
    - 반려식물 CRUD
  - 서버
    - 로그를 활용한 로그 기록
  
  
<br><br>

- 이지애  
  - 로그인
    - 세션을 활용한 로그인 정보 저장
  - 자랑하기
    - 게시글 CRUD  
 
  <br><br>
------------
## 주요 기능


------------ 
## Document
### 1. 유스케이스
- 유스케이스![total](https://user-images.githubusercontent.com/46438918/121833774-027b4e80-cd08-11eb-905d-be1a2d1283ea.jpg)

### 2. ERD
![souleaf_erd](https://user-images.githubusercontent.com/46438918/121833850-3a829180-cd08-11eb-9de9-cbe23ba7e803.JPG)
