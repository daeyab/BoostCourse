# BoostCourse

### 2021/02/19   
### 1장   
#### 데이터베이스   

데이터베이스의 기본개념   
데이터의 집합 (a Set of Data)   
여러 응용 시스템(프로그램)들의 통합된 정보들을 저장하여 운영할 수 있는 공용(share) 데이터의 집합
효율적으로 저장, 검색, 갱신할 수 있도록 데이터 집합들끼리 연관시키고 조직화되어야 한다.

데이터베이스의 특성
실시간 접근성(Real-time Accessability)
- 사용자의 요구를 즉시 처리할 수 있다.

계속적인 변화(Continuous Evolution)
- 정확한 값을 유지하려고 삽입·삭제·수정 작업 등을 이용해 데이터를 지속적으로 갱신할 수 있다.

동시 공유성(Concurrent Sharing)
- 사용자마다 서로 다른 목적으로 사용하므로 동시에 여러 사람이 동일한 데이터에 접근하고 이용할 수 있다.

내용 참조(Content Reference)
- 저장한 데이터 레코드의 위치나 주소가 아닌 사용자가 요구하는 데이터의 내용, 즉 데이터 값에 따라 참조할 수 있어야 한다.

데이터베이스 관리 시스템 (Database Management System = DBMS)
데이터베이스를 관리하는 소프트웨어
여러 응용 소프트웨어(프로그램) 또는 시스템이 동시에 데이터베이스에 접근하여 사용할 수 있게 한다.

필수 3기능
- 정의기능 :  데이터 베이스의 논리적, 물리적 구조를 정의
- 조작기능 : 데이터를 검색, 삭제, 갱신, 삽입, 삭제하는 기능
- 제어기능 :  데이터베이스의 내용 정확성과 안전성을 유지하도록 제어하는 기능

Oracle, SQL Server, MySQL, DB2 등의 상용 또는 공개 DBMS가 있다.
    
데이터베이스 관리 시스템의 장/단점

장점
- 데이터 중복이 최소화
- 데이터의 일관성 및 무결성 유지 
- 데이터 보안 보장

단점
- 운영비가 비싸다
- 백업 및 복구에 대한 관리가 복잡
- 부분적 데이터베이스 손실이 전체 시스템을 정지

명령어 모음
- MySQL 설치 : brew install mysql
- MySQL 서버 실행 : mysql.server start
- MySQL을 데몬으로 실행 : brew services start mysql
- 서비스 재시작도 : brew services restart mysql
- 데몬으로 실행되고 있는 프로그램 확인 : rew services list
- mysql 종료 : brew services stop mysql

SQL (Structured Query Language)
영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.
SQL(Structured Query Language)
SQL은 데이터를 보다 쉽게 검색하고 추가, 삭제, 수정 같은 조작을 할 수 있도록 고안된 컴퓨터 언어입니다.
관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단입니다.
DML (Data Manipulation Language): 데이터를 조작하기 위해 사용합니다. (조작어)

INSERT, UPDATE, DELETE, SELECT 등이 여기에 해당합니다.

DDL (Data Definition Language): 데이터베이스의 스키마를 정의하거나 조작하기 위해 사용합니다.(정의어)

Database 생성하기   
`mysql –uroot  -p`   
Database 생성하기
`mysql> create database DB이름;`
 
아래와 같은 명령을 이용해서 사용자 생성과 권한을 줄 수 있습니다.   
db이름 뒤의 * 는 모든 권한을 의미한다.   
@’%’는 어떤 클라이언트에서든 접근 가능하다는 의미이고, @’localhost’는 해당 컴퓨터에서만 접근 가능하다는 의미입니다.   
flush privileges는 DBMS에게 적용을 하라는 의미입니다.   
해당 명령을 반드시 실행해줘야 합니다.   
```grant all privileges on db이름.* to 계정이름 @'%' identified by ＇암호’; -> 모든 권한을 주겠다  % -> 전부
grant all privileges on db이름.* to 계정이름 @'localhost' identified by ＇암호’; localhost -> 해당 컴
flush privileges;
```
MySQL 버전과 현재 날짜 구하기   
`mysql> SELECT VERSION(), CURRENT_DATE;`   
키워드는 대소문자를 구별하지 않는다.   
 
DBMS에 존재하는 데이터베이스 확인하기   
```mysql> show databases;
-----------------------+
| Database               |
+-----------------------+
| information_schema |
| connectdb              |
+-----------------------+
2 rows in set (0.00 sec)
``` 
사용중인 데이터베이스 전환하기    
`mysql> use mydb;`   
데이터베이스를 전환하려면, 이미 데이터베이스가 존재해야 하며 현재 접속 중인 계정이 해당 데이터베이스를 사용할 수 있는 권한이 있어야 합니다.

테이블 확인   
'show tables'
