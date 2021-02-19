### BoostCourse

##<b> 2021/02/19</b>
#1장
데이터베이스
영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.
데이터베이스와 데이터베이스 관리 시스템
Q> 데이터베이스와 데이터베이스 관리 시스템을 어린이도 알 수 있을 정도로 설명해주세요.
A> 도서관에 있는 책들이 데이터베이스라고 한다면, 도서관 사서분들이나 도서 정보를 찾아주는 컴퓨터를 DBMS라고 볼 수 있습니다.

데이터베이스의 기본개념 (정의)
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
여러 응용 소프트웨어(프로그램) 또는 시스템이 동시에 데이터베이스에 접근하여 사용할 수 있게 한다
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

2. Mac

HomeBrew를 이용해서 MySQL을 설치했다면, 실행과 중지가 상당히 간편합니다.
환경 변수 설정 등이 모두 자동으로 이뤄지기 때문입니다.

MySQL 설치
brew install mysql
MySQL 서버 실행하기
mysql서버를 실행하려면 터미널을 실행해 주신 후 아래와 같이 명령을 실행해 주세요.
 mysql.server start
위의 명령을 내리면 아래와 같은 메시지가 실행됩니다.
Starting MySQL
.SUCCESS!
MySQL을 데몬으로 실행하기
운영체제의 백그라운드로 MySQL이 계속 실행되도록 하고 싶다면 HomeBrew가 제공하는 명령을 이용하면 됩니다.
HomeBrew로 다음과 같이 mysql 데몬을 실행합니다.
아래와 같이 명령을 수행하면 간단하게 mysql을 데몬형태로 실행할 수 있습니다.
brew services start mysql
 서비스 재시작도 HomeBrew가 제공하는 명령을 이용하면 됩니다.
아래와 같이 명령을 수행하세요.
brew services restart mysql
 데몬으로 실행되고 있는 프로그램들이 궁금하다면 아래와 같이 명령을 실행하면 됩니다.
brew services list
이상으로 윈도우와 맥에서 MySQL서버를 실행하는 방법을 알아보았습니다.

 

brew services list
