# 웹 어플리케이션 이해
## 개념 다지기
### 1. HTTP 프로토콜 이해
##### HTTP
* 서버와 클라이언트가 웹에서 데이터를 주고받기 위한 프로토콜(규약)
* HTTP/1.1, HTTP/2는 TCP기반 위에서 동작
* HTTP/3는 UDP기반 위에서 동작
### 2. HTTP 요청/응답 메시지 구조
![HTTP 요청,응답 메시지 구조](https://user-images.githubusercontent.com/75296934/226777361-563971bb-6202-4daf-a75c-1992d5806e2d.PNG)
### 3, HTTP 특징
* 클라이언트-서버 모델
* 무상태 프로토콜(Stateless)
  * 서버가 클라이언트 살태를 유지하지 않음
  * 해결책 : Keep-Alive 속성 사용

TCP 기반에서 동작하는 구조라면 클라이언트가 서버에 요청을 보낼때마다 3way handshaking 연결을 맺은 다음 데이터를 주고 받는 과정을 거쳐야 한다.  
그림 오른쪽이 Keep-Alive 방식  
keep-alive기능이 켜져있는 상태에서 클라이언트의 요청이 많아지면 유지되는 커넥션도 많아지고 이로인해 신규 사용자를 받지 못할 수 있다.  
webserver thread가 부족해지는 현상 발생 
![HTTP특징](https://user-images.githubusercontent.com/75296934/226780443-e88ba9d6-6e6f-4c58-874b-7bff9c56d901.PNG)
* 비 연결성(Connectionless)
  * 서버가 클라이언트 요청에 대해 응답을 마치면 맺었던 연결을 끊어 버림
  * 해결책 : 쿠키(클라이언트에 정보 저장), 세션(서버에 정보 저장), JWT

HTTP는 기본적으로 웹 상에서 불특정 다수와 통신이 가능하도록 설계한 프로토콜이다.  
이러한 상황에서 서버가 다수의 클라이언트들의 상태 또는 연결을 계속 유지하게 된다면 리소스 낭비가 굉장히 심해진다.  
따라서 상태 또는 연결을 유지 하지 않는 대신 더 많은 연결을 할 수 있도록 설계 된 것이 HTTP 프로토콜이다.
### 4. 기타
1. HTTP 요청 메서드
   * GET, POST, PUT, DELETE 등
2. HTTP 응답 코드
   * 2XX(성공), 3XX(리다이렉션), 4XX(클라이언트 에러), 5XX(서버 에러)등
3. HTTP 헤더
   * Content-type, Accept, Cookie, Set-Cookie, Authorization 등

