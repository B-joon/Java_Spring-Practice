# DI 프레임워크 만들기
## 1. DI 개념 소개 및 장점
##### DI(Dependency Injection)
* 의존성 주입
  * 한 객체가 다른 객체를 사용할 때 의존성이 있다고 함.
  * ![DI개념](https://user-images.githubusercontent.com/75296934/228734885-640b7240-ed4f-4bfd-9d94-2d851a2888f6.PNG)
* 런타임 시 의존 관계를 맺는 대상을 외부에서 결정하고 주입해 주는 것
* 스프링 프레임워크는 DI를 지원해주는 프레임워크
##### DI 장점
* 의존성 주입을 인터페이스 기반으로 설계하면, 코드가 유연해짐
  * 느슨한 결합도(loose coupling)
* 변경에 유연해짐
  * 결합도가 늦은 객체끼리 부품을 쉽게 갈아끼울 수 있음
##### DI 프레임워크 만들기
![DI프레임워크만들기](https://user-images.githubusercontent.com/75296934/228737474-416087e2-6a7a-4203-a79c-193a159135ca.PNG)