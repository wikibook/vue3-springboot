create table members (
    id       int auto_increment comment '아이디' primary key,
    name     varchar(50)                          not null comment '회원명',
    login_id varchar(50)                          not null comment '로그인 아이디',
    login_pw varchar(100)                         not null comment '로그인 패스워드',
    created  datetime default current_timestamp() not null comment '생성 일시',
    constraint members_uk unique (login_id)
) comment '회원';