create table items (
    id           int auto_increment comment '아이디' primary key,
    name         varchar(50)                          not null comment '상품 이름',
    img_path     varchar(100)                         not null comment '상품 사진 경로',
    price        int                                  not null comment '상품 가격',
    discount_per int                                  not null comment '상품 할인율',
    created      datetime default current_timestamp() not null comment '생성 일시'
) comment '상품';