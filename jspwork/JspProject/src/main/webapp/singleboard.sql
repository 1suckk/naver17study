use study502;

create table singleboard (
	num smallint auto_increment primary key,
    writer varchar(20),
    subject varchar(1000),
    content varchar(2000),
    readcount smallint default 0,
    writeday datetime
);

create table simpleanswer
(
	idx smallint auto_increment primary key,
    num smallint,
    nickname varchar(30),
    content varchar(1000),
    writeday datetime,
    constraint fk_answer_num
		foreign key(num)
        references singleboard(num)
        on delete cascade
);