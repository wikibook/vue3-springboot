create table order_items (
    id       int auto_increment comment '아이디' primary key,
    order_id int                                  not null comment '주문 아이디',
    item_id  int                                  not null comment '주문 상품 아이디',
    created  datetime default current_timestamp() not null comment '생성 일시'
) comment '주문 상품';