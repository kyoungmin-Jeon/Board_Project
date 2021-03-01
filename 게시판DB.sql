
--�Խ��� �������̺� 
--�Խ��� �̸��� �Խ��� ��ȣ 
create table board_info_table(
	board_info_idx number constraint BOARD_INFO_PK primary key,
	board_info_name varchar2(500) not null
);

--���� ���̺�
--������ȣ, �����̸�, ���� �ּ�, ���̵�, ��й�ȣ
create table user_table(
	user_idx number constraint USER_PK primary key,
	user_name varchar2(50) not null,
    user_add1 varchar2(100),
	user_add2 varchar2(100),
    user_add3 varchar2(100),
    user_id varchar2(100) not null,
	user_pw varchar2(100) not null
);

--�Խñ� ���̺�
--�Խñ� ��ȣ, ����, ����, ����, �ۼ��ڹ�ȣ, �۹�ȣ, ��¥
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

--��� ���̺�
--�Խñ� ��ȣ, ��۹�ȣ, ����, �ۼ���, ��¥ 
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

--��� ������
--��� �ۼ��� rno�� 1�� �����Ѵ�.
create sequence board_reply_seq
start with 0
increment by 1
minvalue 0;

--�Խñ� ������
--�Խñ� �ۼ��� content_idx�� 1�� �����Ѵ�.
create sequence content_seq
start with 0
increment by 1
minvalue 0;

--���� ������
--ȸ�����Խ� user_idx�� 1�� �����Ѵ�.
create sequence user_seq
start with 0
increment by 1
minvalue 0;
