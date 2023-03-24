# MVC 프레임워크 만들기
### 1. 리플렉션 API 개념 소개 및 실습
##### Reflection
* 힙 영역에 로드돼 있는 클래스 타입의 객체를 통해 필드/메소드/생성자를 접근 제어자와 상관없이
  사용할 수 있도록 지원하는 API
* 컴파일 시점이 아닌 런타임 시점에 동적으로 특정 클래스의 정보를 추출해낼 수 있는 프로그래밍 기법
* 주로 프레임워크 또는 라이브러리 개발 시 사용됨.
##### Reflection 사용하는 프레임워크/라이브러리 소개
* Spring 프레임워크(ex. DI)
* Test 프레임워크(ex. JUnit)
* JSON Serialization/Deserialization 라이브러리(ex.Jackson)
* 등등