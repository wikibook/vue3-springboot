ALTER TABLE members ADD login_pw_salt char(16) NOT NULL comment '로그인 패스워드 솔트' after login_pw;