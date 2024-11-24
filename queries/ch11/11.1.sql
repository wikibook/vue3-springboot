create table blocks (
    id      int auto_increment comment '아이디' primary key,
    token   varchar(250)                         not null comment '차단 토큰',
    created datetime default current_timestamp() not null comment '생성 일시'
) comment '토큰 차단';