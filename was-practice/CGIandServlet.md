# 서블릿 프로그래밍
### 1. CGI 프로그램과 서블릿
##### CGI(Common Gateway Interface)
* 웹 서버와 애플리케이션 사이에 데이터를 주고받는 규약
* CGI 규칙에 따라서 만들어진 프로그램을 CGI 프로그램이라고 함
* CGI프로그램 종류로는 컴퍼일 방식(C, C++, Java 등)과 인터프리터 방식(PHP, Python 등)이 있음
##### 인터프리터 방식 CGI 프로그램
![인터프리터방식CGI](https://user-images.githubusercontent.com/75296934/226834541-ab428455-c6bb-4511-8d61-1e3d572771d3.PNG)
##### 서블릿과 서블릿 컨테이너
![서블릿과서블릿컨테이너](https://user-images.githubusercontent.com/75296934/226834606-f024d147-a97f-4a01-b7e7-bfc8a9644df9.PNG)

##### Servlet(Server + applet의 합성어)
* 자바에서 웹 애플리케이션을 만드는 기술
* 자바에서 동적인 웹 페이지를 구현하기 위한 표준

##### Servlet Container
* 서블릿의 생성부터 소멸까지의 라이프사이클을 관리하는 역할
* 서블릿 컨테이너는 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리해준다.  
  개발자는 비즈니스 로직에만 집중하면 된다.
* 서블릿 객체를 싱글톤으로 관리(인스턴스 하나만 생성하여 공유하는 방식)
  * 상태를 유지(stateful)하게 설계하면 안됨
  * Thread safety 하지 않음

##### WAS vs 서블릿 컨테이너
* WAS는 서블릿 컨테이너를 포함하는 개념
* WAS는 매 요청마다 스레드 풀에서 기존 스레드를 사용함
* WAS의 주요 튜닝 포인트는 max Thread 수
* 대표적인 WAS로는 톰캣이 있다.

![WebServiceArchitecture](https://user-images.githubusercontent.com/75296934/226836375-173faa53-7afd-458f-b200-312958d71ec5.PNG)

### 2. 계산기 서블릿 만들기
![계산기서블릿](https://user-images.githubusercontent.com/75296934/227069936-c2de3295-f368-4864-8806-ad3545c411f0.PNG)
##### Servlet 인터페이스(호출규약)
* 서블릿 컨테이너가 서블릿 인터페이스에 있는 메소드들을 호출함
* 서블릿 생명주기와 관련된 메소드
  * init()  
    서블릿 컨테이너가 서블릿 생성후 초기화 작업을 수행하기 위해 호출하는 메서드
  * service()  
    클라이언트 요청이 들어올 때마다 서블릿 컨테이너가 호출 하는 메서드
  * destroy()  
    서블릿 컨테이너가 종료될 때 호출 되는 메서드
* 서블릿 기타 메소드
  * getServletConfig()  
    서블릿 초기 설정 정보를 담고 있는 객체를 반환 하는 메서드  
    서블릿 이름과 서블릿 초기 메게변수 값 등을 얻을 수 있다.
  * getServletInfo()  
    서블릿에 관한 정보를 반환하는 메서드

##### Spring MVC Flow
![springMVCflow](https://user-images.githubusercontent.com/75296934/227072263-b408fd18-3e11-4b47-8367-dfa21ac204d9.PNG)

##### URL 인코딩(=퍼센트 인코딩)
* URL로 사용할 수 없는 문자(예약어, Non-ASCII 문자(한글) 등)를 사용할 수 있도록 인코딩하는 것
* 인코딩 된 문자는 triplet(세 개가 한 세트)로 인코딩 되며 각각을 % 다음에 두 개의 16진수로 표현함