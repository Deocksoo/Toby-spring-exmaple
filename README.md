# 토비의 스프링 학습 예제

## 실행 환경
토비의 스프링 예제를 gradle 빌드도구를 사용하도록 porting 하였습니다.
porting 작업과 테스트는 모두 IntellJ IDEA 2019.2.3 Ultimate Edition을 통해 진행하였습니다.
테스트 환경은 아래와 같습니다.
```
1. jdk 1.8
2. MySQL 5.7
3. MySQL-connector-java 5.1.48
```

## MySQL server 설치 및 실행 가이드
docker 디렉토리로 이동해서 docker-compose.yml 설정에 따라 mysql을 설치합니다.
```
cd docker
docker-compose up -d
```
현재 docker-compose.yml 설정에서 프로젝트 진행에 필요한 mysql user와 database를 
모두 생성해주고 있습니다. 따라서 본 프로젝트에서 제공하는 yml 설정을 사용하는 경우
`/sql/create_mysql_database.sql`과 `/sql/create_mysql_user.sql`은 따로 실행하지 않아도 괜찮습니다.
