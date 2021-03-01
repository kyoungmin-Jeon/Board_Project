
--게시판 정보테이블 
--게시판 이름과 게시판 번호 
create table board_info_table(
	board_info_idx number constraint BOARD_INFO_PK primary key,
	board_info_name varchar2(500) not null
);

--유저 테이블
--유저번호, 유저이름, 유저 주소, 아이디, 비밀번호
create table user_table(
	user_idx number constraint USER_PK primary key,
	user_name varchar2(50) not null,
    user_add1 varchar2(100),
	user_add2 varchar2(100),
    user_add3 varchar2(100),
    user_id varchar2(100) not null,
	user_pw varchar2(100) not null
);

--게시글 테이블
--게시글 번호, 제목, 내용, 파일, 작성자번호, 글번호, 날짜
create table content_table(
	content_idx number constraint CONTENT_PK primary key,
	content_subject varchar2(500) not null,
	content_text long not null,
	content_file varchar2(500),
	content_writer_idx number not null
	                   constraint CONTENT_FK1 references user_table(user_idx) on delete cascade,
	content_board_idx number not null
	                  constraint CONTENT_FK2 references board_info_table(board_info_idx) on delete cascade,
	content_date date not null
);

--댓글 테이블
--게시글 번호, 댓글번호, 내용, 작성자, 날짜 
create table board_reply(
    board_info_idx number,
    content_idx number not null,
    rno number not null,
    content varchar2(1000) not null,
    writer varchar2(50) not null,
    regDate date default sysdate,
    primary key (content_idx,rno)
);

alter table board_reply add foreign key(board_info_idx) references board_info_table(board_info_idx);

--댓글 시퀀스
--댓글 작성시 rno가 1씩 증가한다.
create sequence board_reply_seq
start with 0
increment by 1
minvalue 0;

--게시글 시퀀스
--게시글 작성시 content_idx가 1씩 증가한다.
create sequence content_seq
start with 0
increment by 1
minvalue 0;

--유저 시퀀스
--회원가입시 user_idx가 1씩 증가한다.
create sequence user_seq
start with 0
increment by 1
minvalue 0;
