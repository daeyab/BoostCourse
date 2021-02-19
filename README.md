# BoostCourse

## <b> 2021/02/19</b>

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
    mysql –uroot  -p
Database 생성하기   
    mysql> create database DB이름;
 
Database 생성하기2
Database 사용자 생성과 권한 주기
Database를 생성했다면, 해당 데이터베이스를 사용하는 계정을 생성해야 합니다.
또한, 해당 계정이 데이터베이스를 이용할 수 있는 권한을 줘야 합니다.
아래와 같은 명령을 이용해서 사용자 생성과 권한을 줄 수 있습니다.
db이름 뒤의 * 는 모든 권한을 의미한다.
@’%’는 어떤 클라이언트에서든 접근 가능하다는 의미이고, @’localhost’는 해당 컴퓨터에서만 접근 가능하다는 의미입니다.
flush privileges는 DBMS에게 적용을 하라는 의미입니다.
해당 명령을 반드시 실행해줘야 합니다.
grant all privileges on db이름.* to 계정이름@'%' identified by ＇암호’; -> 모든 권한을 주겠다
grant all privileges on db이름.* to 계정이름@'localhost' identified by ＇암호’;
flush privileges;
사용자 계정이름은 'connectuser', 암호는 'connect123!@#', 해당 사용자가 사용하는 데이터베이스는 'connectdb'로 계정을 생성하려면 다음과 같이 명령을 수행합니다.
grant all privileges on connectdb.* to connectuser@'%' identified by 'connect123!@#';

grant all privileges on connectdb.* to connectuser@'localhost' identified by 'connect123!@#';

flush privileges;


 
실행한 모습
 
다음과 같이 프롬프트가 보이면 성공
MySQL 연결끊기
프롬프트에서 quit혹은 exit라고 입력합니다.
mysql> QUIT
mysql> exit
 
다음과 같이 Bye라고 나오면 연결 끊기 성공
MySQL 버전과 현재 날짜 구하기
mysql> SELECT VERSION(), CURRENT_DATE;
+-----------+--------------+
| VERSION() | CURRENT_DATE |
+-----------+--------------+
| 5.1.67    | 2013-01-05   |
+-----------+--------------+
1 row in set (0.00 sec)
프롬프트에서는 SQL을 입력합니다.
SQL은 semicolon (;)으로 끝납니다.
SQL은 쿼리(Query)라고 읽습니다.
쿼리는 DBMS에게 명령을 내릴 때 사용하는 문장이라고 생각하면 쉽습니다.
SELECT는 어떤 내용을 조회할 때 사용하는 키워드입니다.
MySQL은 쿼리에 해당하는 결과의 전체 row를 출력하고 마지막에 전체 row 수와 쿼리실행에 걸린 시간을 표시합니다.
 
키워드는 대소문자를 구별하지 않는다.
다음 쿼리들은 모두 같습니다.
mysql> SELECT VERSION(), CURRENT_DATE;
mysql> select version(), current_date;
mysql> SeLeCt vErSiOn(), current_DATE;
 
쿼리를 이용해서 계산식의 결과도 구할 수 있다.
 함수 및 수식 사용 예제
mysql> SELECT SIN(PI()/4), (4+1)*5;
 
여러 문장을 한 줄에 연속으로 붙여서 실행가능하다.

각 문장에 semicolon(;)만 붙혀 주면 됩니다.

mysql> SELECT VERSION(); SELECT NOW();

하나의 SQL은 여러 줄로 입력가능하다.
MySQL은 문장의 끝을 라인으로 구분하는 것이 아니라 semicolon(;)으로 구분하기 때문에 여러 줄에 거쳐 문장을 쓰는 것도 가능합니다.
mysql> SELECT
    -> USER()
    -> ,
    -> CURRENT_DATE;
+--------------------+--------------+
| USER()             | CURRENT_DATE |
+--------------------+--------------+
| joesmith@localhost | 1999-03-18   |
+--------------------+--------------+
 
SQL을 입력하는 도중에 취소할 수 있다.
긴 쿼리를 작성하다가 중간에 취소해야 하는 경우에는 즉시 \c를 붙혀주면 됩니다.
mysql> SELECT

    -> USER()

    -> \c

mysql>
 
DBMS에 존재하는 데이터베이스 확인하기
작업하기 위한 데이터베이스를 선택하기 위해서는 어떤 데이터베이스가 존재하는지 알아보아야 합니다.
현재 서버에 존재하는 데이터베이스를 찾아보기 위해서 SHOW statement을 사용합니다.
mysql> show databases;
+-----------------------+
| Database               |
+-----------------------+
| information_schema |
| connectdb              |
+-----------------------+
2 rows in set (0.00 sec)
 
 
사용중인 데이터베이스 전환하기
Database을 선택하기 위해,  “use” command 사용합니다.
mysql> use mydb;
데이터베이스를 전환하려면, 이미 데이터베이스가 존재해야 하며 현재 접속 중인 계정이 해당 데이터베이스를 사용할 수 있는 권한이 있어야 합니다.
