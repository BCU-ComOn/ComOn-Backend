# ComOn-Backend

## 사용 버전

- JDK 11 (Amazon Corretto)
- Spring Boot 2.1.9


## Package Structure
```
kr.ac.bc.comon.springboot/
├── comon/
|   ├── domain/
|   ├── pk/
|   └── repository/
├── config/
├── endpoint/
|   └── DOMAIN/
|       ├── dto/
|       ├── service/
|       └── DOMAINContoller.java
|   └── DOMAIN/
|       ├── dto/
|       ├── service/
|       └── DOMAINContoller.java
|   ...
├── handler/
└── Application.java
```
* comon: 데이터베이스 관련
  * comon.domain: JPA Entity 클래스들
  * comon.pk: 복합 기본키 클래스들
  * comon.repository: JPA Repository 클래스들

* config: Spring Config

* endpoint: RESTful API 관련
  * endpoint.DOMAIN: 각 도메인 별 패키지 (예: user, project 등)
  * endpoint.DOMAIN.dto: 도메인의 DTO 클래스들
  * endpoint.DOMAIN.service: 도메인의 Service 클래스들
  * endpoint.DOMAIN.DOMAINController.java: 도메인에 대한 메인 Controller

* handler: Login/Session 관련 클래스들