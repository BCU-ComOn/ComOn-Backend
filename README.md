# ComOn-Backend

## 사용 버전

- JDK 11 (Amazon Corretto)
- Spring Boot 2.1.9


## Package Structure
```

src/
└── main /
    └── java/
        └── kr.ac.bc.comon.springboot/
            ├── common/
            |   ├── domain/
            |   |   └── UserEntity.java
            |   ├── pk/
            |   └── repository/
            |       └── UserRepository.java
            ├── config/
            |   └── JpaConfig.java
            └── endpoint/
            |   ├── project/
            |   ├── post/
            |   └── user/             
            |       ├── dto/
            |       |   └── UserResponseDto.java
            |       ├── service/
            |       |   └── UserService.java
            |       └── UserContoller.java
            ├── handler/
            └── Application.java
                   
```
