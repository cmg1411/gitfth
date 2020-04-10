--* 테이블 생성
create  table  friend(
name  varchar2(15)  not  null,
jumin1  varchar2(6),
jumin2  varchar2(7),
tel1  char(3),
tel2  char(4),
tel3  char(4),
gender  number,   --남자는 0, 여자는 1
read  number default  0,   --선택해제 0, 선택 1
movie  number default  0,
music  number default  0,
game  number default  0,
shopping  number default  0);

select * from tab;
select * from friend;