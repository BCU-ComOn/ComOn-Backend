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
|   ├── project/
|   ├── post/
|   └── user/
|       ├── dto/
|       ├── service/
|       └── UserContoller.java
├── handler/
└── Application.java
```
* comon: 데이터베이스 관련
  * comon.domain: JPA Entity 클래스들
  * comon.pk: 복합 기본키 클래스들
  * comon.repository: JPA Repository 클래스들

* config: Spring Config정

* endpoint: RESTful API 관련
  * endpoint.DOMAIN: 각 도메인 이름 별 패키지
  * endpoint.DOMAIN.dto: 도메인의 DTO 클래스들
  * endpoint.DOMAIN.service: 도메인의 Service 클래스들
  * endpoint.DOMAIN.DOMAINController.java: 도메인에 대한 메인 컨트롤러