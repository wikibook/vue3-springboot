create table carts (
    id        int auto_increment comment '아이디' primary key,
    member_id int                                  not null comment '회원 아이디',
    item_id   int                                  not null comment '상품 아이디',
    created   datetime default current_timestamp() not null comment '생성 일시'
) comment '장바구니';