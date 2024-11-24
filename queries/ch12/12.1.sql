create table blocks (
    id      int auto_increment comment '아이디'  primary key,
    token   varchar(250)                         not null comment '차단 토큰',
    created datetime default current_timestamp() not null comment '생성 일시'
) comment '토큰 차단';

create table carts (
    id        int auto_increment comment '아이디'  primary key,
    member_id int                                  not null comment '회원 아이디',
    item_id   int                                  not null comment '상품 아이디',
    created   datetime default current_timestamp() not null comment '생성 일시'
) comment '장바구니';

create table items (
    id           int auto_increment comment '아이디' primary key,
    name         varchar(50)                          not null comment '상품 이름',
    img_path     varchar(100)                         not null comment '상품 사진 경로',
    price        int                                  not null comment '상품 가격',
    discount_per int                                  not null comment '상품 할인율',
    created      datetime default current_timestamp() not null comment '생성 일시'
) comment '상품';

create table members (
    id            int auto_increment comment '아이디'  primary key,
    name          varchar(50)                          not null comment '회원명',
    login_id      varchar(50)                          not null comment '로그인 아이디',
    login_pw      char(44)                             not null,
    login_pw_salt char(16)                             not null,
    created       datetime default current_timestamp() not null comment '생성 일시',
    constraint members_uk unique (login_id)
) comment '회원';

create table order_items (
    id       int auto_increment comment '아이디'  primary key,
    order_id int                                  not null comment '주문 아이디',
    item_id  int                                  not null comment '주문 상품 아이디',
    created  datetime default current_timestamp() not null comment '생성 일시'
) comment '주문 상품';

create table orders (
    id          int auto_increment comment '아이디'  primary key,
    member_id   int                                  not null comment '주문자 회원 아이디',
    name        varchar(50)                          not null comment '주문자명',
    address     varchar(500)                         not null comment '배송 주소',
    payment     varchar(10)                          not null comment '결제 수단',
    card_number varchar(50)                          null comment '카드 번호',
    amount      bigint                               not null comment '최종 결제 금액',
    created     datetime default current_timestamp() not null comment '생성 일시'
) comment '주문';