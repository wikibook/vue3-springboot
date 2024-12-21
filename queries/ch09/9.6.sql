create table orders (
    id          int auto_increment comment '아이디' primary key,
    member_id   int                                 not null comment '주문자 회원 아이디',
    name        varchar(50)                         not null comment '주문자명',
    address     varchar(500)                        not null comment '배송 주소',
    payment     varchar(10)                         not null comment '결제 수단',
    card_number varchar(16)                         null comment '카드 번호',
    amount      bigint                              not null comment '최종 결제 금액',
    created     datetime default current_timestamp() not null comment '생성 일시'
) comment '주문';