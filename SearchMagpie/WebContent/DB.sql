-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- t_web Table Create SQL
CREATE TABLE t_web
(
    web_key     NUMBER           NOT NULL, 
    web_name    VARCHAR2(20)     NOT NULL, 
    web_url     VARCHAR2(250)    NOT NULL, 
     PRIMARY KEY (web_key)
)
/

CREATE SEQUENCE t_web_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_web_AI_TRG
BEFORE INSERT ON t_web 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_web_SEQ.NEXTVAL
    INTO :NEW.web_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_web_AI_TRG;
/

--DROP SEQUENCE t_web_SEQ;
/

COMMENT ON TABLE t_web IS '웹 출처'
/

COMMENT ON COLUMN t_web.web_key IS '웹 키'
/

COMMENT ON COLUMN t_web.web_name IS '웹 이름'
/

COMMENT ON COLUMN t_web.web_url IS '웹 URL'
/


-- t_member Table Create SQL
CREATE TABLE t_member
(
    m_key         NUMBER          NOT NULL, 
    m_id          VARCHAR2(20)    NOT NULL, 
    m_pw          VARCHAR2(20)    NOT NULL, 
    m_name        VARCHAR2(20)    NULL, 
    m_nickname    VARCHAR2(20)    NULL, 
    m_email       VARCHAR2(50)    NULL, 
    m_phone       VARCHAR2(20)    NULL, 
    m_joindate    DATE            NOT NULL, 
    admin_yn      VARCHAR2(1)     NOT NULL, 
     PRIMARY KEY (m_key)
)
/

CREATE SEQUENCE t_member_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_member_AI_TRG
BEFORE INSERT ON t_member 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_member_SEQ.NEXTVAL
    INTO :NEW.m_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_member_AI_TRG;
/

--DROP SEQUENCE t_member_SEQ;
/

COMMENT ON TABLE t_member IS '회원정보'
/

COMMENT ON COLUMN t_member.m_key IS '회원 키'
/

COMMENT ON COLUMN t_member.m_id IS '회원 아이디'
/

COMMENT ON COLUMN t_member.m_pw IS '회원 비빌번호'
/

COMMENT ON COLUMN t_member.m_name IS '회원 이름'
/

COMMENT ON COLUMN t_member.m_nickname IS '회원 별명'
/

COMMENT ON COLUMN t_member.m_email IS '회원 이메일'
/

COMMENT ON COLUMN t_member.m_phone IS '회원 전화번호'
/

COMMENT ON COLUMN t_member.m_joindate IS '회원가입일'
/

COMMENT ON COLUMN t_member.admin_yn IS '관리자 여부'
/


-- t_seller Table Create SQL
CREATE TABLE t_seller
(
    seller_key     NUMBER          NOT NULL, 
    seller_name    VARCHAR2(20)    NOT NULL, 
    web_key        NUMBER          NOT NULL, 
     PRIMARY KEY (seller_key)
)
/

CREATE SEQUENCE t_seller_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_seller_AI_TRG
BEFORE INSERT ON t_seller 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_seller_SEQ.NEXTVAL
    INTO :NEW.seller_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_seller_AI_TRG;
/

--DROP SEQUENCE t_seller_SEQ;
/

COMMENT ON TABLE t_seller IS '해외 직구 판매자'
/

COMMENT ON COLUMN t_seller.seller_key IS '해외직구 판매자 키'
/

COMMENT ON COLUMN t_seller.seller_name IS '판매자 이름'
/

COMMENT ON COLUMN t_seller.web_key IS '아이템 출처 키'
/

ALTER TABLE t_seller
    ADD CONSTRAINT FK_t_seller_web_key_t_web_web_ FOREIGN KEY (web_key)
        REFERENCES t_web (web_key)
/


-- t_product Table Create SQL
CREATE TABLE t_product
(
    p_key         NUMBER           NOT NULL, 
    p_name        VARCHAR2(20)     NOT NULL, 
    p_price       NUMBER           NOT NULL, 
    p_view_cnt    NUMBER           NOT NULL, 
    web_key       NUMBER           NOT NULL, 
    sold_yn       VARCHAR2(1)      NOT NULL, 
    reg_date      DATE             NOT NULL, 
    p_file1       VARCHAR2(500)    NULL, 
    p_file2       VARCHAR2(500)    NULL, 
    p_file3       VARCHAR2(500)    NULL, 
    p_file4       VARCHAR2(500)    NULL, 
     PRIMARY KEY (p_key)
)
/

CREATE SEQUENCE t_product_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_product_AI_TRG
BEFORE INSERT ON t_product 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_product_SEQ.NEXTVAL
    INTO :NEW.p_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_product_AI_TRG;
/

--DROP SEQUENCE t_product_SEQ;
/

COMMENT ON TABLE t_product IS '상품정보'
/

COMMENT ON COLUMN t_product.p_key IS '상품 키'
/

COMMENT ON COLUMN t_product.p_name IS '상품 이름'
/

COMMENT ON COLUMN t_product.p_price IS '상품 가격'
/

COMMENT ON COLUMN t_product.p_view_cnt IS '상품 조회수'
/

COMMENT ON COLUMN t_product.web_key IS '상품 출처 키'
/

COMMENT ON COLUMN t_product.sold_yn IS '판매 여부'
/

COMMENT ON COLUMN t_product.reg_date IS '상품 등록일'
/

COMMENT ON COLUMN t_product.p_file1 IS '첨부 파일1'
/

COMMENT ON COLUMN t_product.p_file2 IS '첨부 파일2'
/

COMMENT ON COLUMN t_product.p_file3 IS '첨부 파일3'
/

COMMENT ON COLUMN t_product.p_file4 IS '첨부 파일4'
/

ALTER TABLE t_product
    ADD CONSTRAINT FK_t_product_web_key_t_web_web FOREIGN KEY (web_key)
        REFERENCES t_web (web_key)
/


-- t_item Table Create SQL
CREATE TABLE t_item
(
    item_key        NUMBER            NOT NULL, 
    seller_key      NUMBER            NOT NULL, 
    web_key         NUMBER            NOT NULL, 
    m_key           NUMBER            NOT NULL, 
    item_title      VARCHAR2(20)      NOT NULL, 
    item_content    VARCHAR2(4000)    NULL, 
    item_price      NUMBER            NOT NULL, 
    sold_yn         VARCHAR2(1)       NOT NULL, 
    reg_date        DATE              NOT NULL, 
    item_file1      VARCHAR(500)      NULL, 
    item_file2      VARCHAR2(500)     NULL, 
    item_file3      VARCHAR2(500)     NULL, 
    item_file4      VARCHAR2(500)     NULL, 
     PRIMARY KEY (item_key)
)
/

CREATE SEQUENCE t_item_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_item_AI_TRG
BEFORE INSERT ON t_item 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_item_SEQ.NEXTVAL
    INTO :NEW.item_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_item_AI_TRG;
/

--DROP SEQUENCE t_item_SEQ;
/

COMMENT ON TABLE t_item IS '해외 직구 상품'
/

COMMENT ON COLUMN t_item.item_key IS '아이템 키'
/

COMMENT ON COLUMN t_item.seller_key IS '해외 직구 판매자'
/

COMMENT ON COLUMN t_item.web_key IS '아이템 출처 키'
/

COMMENT ON COLUMN t_item.m_key IS '아이템 구매자'
/

COMMENT ON COLUMN t_item.item_title IS '아이템 제목'
/

COMMENT ON COLUMN t_item.item_content IS '아이템 내용'
/

COMMENT ON COLUMN t_item.item_price IS '아이템 가격'
/

COMMENT ON COLUMN t_item.sold_yn IS '판매 여부'
/

COMMENT ON COLUMN t_item.reg_date IS '아이템 등록일'
/

COMMENT ON COLUMN t_item.item_file1 IS '첨부 파일1'
/

COMMENT ON COLUMN t_item.item_file2 IS '첨부 파일2'
/

COMMENT ON COLUMN t_item.item_file3 IS '첨부 파일3'
/

COMMENT ON COLUMN t_item.item_file4 IS '첨부 파일4'
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_web_key_t_web_web_ke FOREIGN KEY (web_key)
        REFERENCES t_web (web_key)
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_m_key_t_member_m_key FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_seller_key_t_seller_ FOREIGN KEY (seller_key)
        REFERENCES t_seller (seller_key)
/


-- t_writeboard Table Create SQL
CREATE TABLE t_writeboard
(
    w_key        NUMBER            NOT NULL, 
    w_title      VARCHAR2(50)      NOT NULL, 
    w_content    VARCHAR2(4000)    NULL, 
    m_key        NUMBER            NULL, 
    w_cnt        NUMBER            NULL, 
    reg_date     DATE              NULL, 
    w_file1      VARCHAR2(4000)    NULL, 
    w_file2      VARCHAR2(4000)    NULL, 
     PRIMARY KEY (w_key)
)
/

CREATE SEQUENCE t_writeboard_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_writeboard_AI_TRG
BEFORE INSERT ON t_writeboard 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_writeboard_SEQ.NEXTVAL
    INTO :NEW.w_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_writeboard_AI_TRG;
/

--DROP SEQUENCE t_writeboard_SEQ;
/

COMMENT ON TABLE t_writeboard IS '게시판'
/

COMMENT ON COLUMN t_writeboard.w_key IS '게시글 키'
/

COMMENT ON COLUMN t_writeboard.w_title IS '게시글 제목'
/

COMMENT ON COLUMN t_writeboard.w_content IS '게시글 내용'
/

COMMENT ON COLUMN t_writeboard.m_key IS '게시글 작성자'
/

COMMENT ON COLUMN t_writeboard.w_cnt IS '게시글 조회수'
/

COMMENT ON COLUMN t_writeboard.reg_date IS '게시글 등록일'
/

COMMENT ON COLUMN t_writeboard.w_file1 IS '첨부 파일1'
/

COMMENT ON COLUMN t_writeboard.w_file2 IS '첨부 파일2'
/

ALTER TABLE t_writeboard
    ADD CONSTRAINT FK_t_writeboard_m_key_t_member FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/


-- t_reserve Table Create SQL
CREATE TABLE t_reserve
(
    r_key       NUMBER    NOT NULL, 
    m_key       NUMBER    NOT NULL, 
    p_key       NUMBER    NULL, 
    item_key    NUMBER    NULL, 
    r_price     NUMBER    NOT NULL, 
    reg_date    DATE      NOT NULL, 
     PRIMARY KEY (r_key)
)
/

CREATE SEQUENCE t_reserve_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_reserve_AI_TRG
BEFORE INSERT ON t_reserve 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_reserve_SEQ.NEXTVAL
    INTO :NEW.r_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_reserve_AI_TRG;
/

--DROP SEQUENCE t_reserve_SEQ;
/

COMMENT ON TABLE t_reserve IS '예약'
/

COMMENT ON COLUMN t_reserve.r_key IS '예약 키'
/

COMMENT ON COLUMN t_reserve.m_key IS '예약자 키'
/

COMMENT ON COLUMN t_reserve.p_key IS '예약 상품 키'
/

COMMENT ON COLUMN t_reserve.item_key IS '예약 아이템 키'
/

COMMENT ON COLUMN t_reserve.r_price IS '예약 가격'
/

COMMENT ON COLUMN t_reserve.reg_date IS '예약 등록일'
/

ALTER TABLE t_reserve
    ADD CONSTRAINT FK_t_reserve_m_key_t_member_m_ FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/

ALTER TABLE t_reserve
    ADD CONSTRAINT FK_t_reserve_p_key_t_product_p FOREIGN KEY (p_key)
        REFERENCES t_product (p_key)
/

ALTER TABLE t_reserve
    ADD CONSTRAINT FK_t_reserve_item_key_t_item_i FOREIGN KEY (item_key)
        REFERENCES t_item (item_key)
/


-- t_comment Table Create SQL
CREATE TABLE t_comment
(
    c_key        NUMBER           NOT NULL, 
    w_key        NUMBER           NOT NULL, 
    m_key        NUMBER           NOT NULL, 
    c_content    VARCHAR2(300)    NOT NULL, 
    reg_date     DATE             NOT NULL, 
     PRIMARY KEY (c_key)
)
/

CREATE SEQUENCE t_comment_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_comment_AI_TRG
BEFORE INSERT ON t_comment 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_comment_SEQ.NEXTVAL
    INTO :NEW.c_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_comment_AI_TRG;
/

--DROP SEQUENCE t_comment_SEQ;
/

COMMENT ON TABLE t_comment IS '댓글'
/

COMMENT ON COLUMN t_comment.c_key IS '댓글 키'
/

COMMENT ON COLUMN t_comment.w_key IS '원글 키'
/

COMMENT ON COLUMN t_comment.m_key IS '댓글 작성자'
/

COMMENT ON COLUMN t_comment.c_content IS '댓글 내용'
/

COMMENT ON COLUMN t_comment.reg_date IS '댓글 작성일'
/

ALTER TABLE t_comment
    ADD CONSTRAINT FK_t_comment_w_key_t_writeboar FOREIGN KEY (w_key)
        REFERENCES t_writeboard (w_key)
/

ALTER TABLE t_comment
    ADD CONSTRAINT FK_t_comment_m_key_t_member_m_ FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/


-- t_ch_price Table Create SQL
CREATE TABLE t_ch_price
(
    cp_key           NUMBER    NOT NULL, 
    p_key            NUMBER    NOT NULL, 
    item_key         NUMBER    NOT NULL, 
    p_price          NUMBER    NOT NULL, 
    item_price       NUMBER    NOT NULL, 
    ch_difference    NUMBER    NOT NULL, 
    reg_date         DATE      NOT NULL, 
     PRIMARY KEY (cp_key)
)
/

CREATE SEQUENCE t_ch_price_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_ch_price_AI_TRG
BEFORE INSERT ON t_ch_price 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_ch_price_SEQ.NEXTVAL
    INTO :NEW.cp_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_ch_price_AI_TRG;
/

--DROP SEQUENCE t_ch_price_SEQ;
/

COMMENT ON TABLE t_ch_price IS '가격 변동'
/

COMMENT ON COLUMN t_ch_price.cp_key IS '가격 변동 키'
/

COMMENT ON COLUMN t_ch_price.p_key IS '상품 키'
/

COMMENT ON COLUMN t_ch_price.item_key IS '아이템 키'
/

COMMENT ON COLUMN t_ch_price.p_price IS '상품 변동 후 가격'
/

COMMENT ON COLUMN t_ch_price.item_price IS '아이템 변동 후 가격'
/

COMMENT ON COLUMN t_ch_price.ch_difference IS '가격 변동량'
/

COMMENT ON COLUMN t_ch_price.reg_date IS '가격 변동일'
/

ALTER TABLE t_ch_price
    ADD CONSTRAINT FK_t_ch_price_p_key_t_product_ FOREIGN KEY (p_key)
        REFERENCES t_product (p_key)
/

ALTER TABLE t_ch_price
    ADD CONSTRAINT FK_t_ch_price_item_key_t_item_ FOREIGN KEY (item_key)
        REFERENCES t_item (item_key)
/


-- t_alarm Table Create SQL
CREATE TABLE t_alarm
(
    a_key        NUMBER           NOT NULL, 
    r_key        NUMBER           NOT NULL, 
    a_content    VARCHAR2(500)    NOT NULL, 
    reg_date     DATE             NOT NULL, 
     PRIMARY KEY (a_key)
)
/

CREATE SEQUENCE t_alarm_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_alarm_AI_TRG
BEFORE INSERT ON t_alarm 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_alarm_SEQ.NEXTVAL
    INTO :NEW.a_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_alarm_AI_TRG;
/

--DROP SEQUENCE t_alarm_SEQ;
/

COMMENT ON TABLE t_alarm IS '알람'
/

COMMENT ON COLUMN t_alarm.a_key IS '알림 키'
/

COMMENT ON COLUMN t_alarm.r_key IS '예약 키'
/

COMMENT ON COLUMN t_alarm.a_content IS '알림 내용'
/

COMMENT ON COLUMN t_alarm.reg_date IS '알림 날짜'
/

ALTER TABLE t_alarm
    ADD CONSTRAINT FK_t_alarm_r_key_t_reserve_r_k FOREIGN KEY (r_key)
        REFERENCES t_reserve (r_key)
/


-- login_recoed Table Create SQL
CREATE TABLE login_recoed
(
    login_key      NUMBER    NOT NULL, 
    m_key          NUMBER    NULL, 
    login_time     DATE      NULL, 
    logout_time    DATE      NULL, 
     PRIMARY KEY (login_key)
)
/

CREATE SEQUENCE login_recoed_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER login_recoed_AI_TRG
BEFORE INSERT ON login_recoed 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT login_recoed_SEQ.NEXTVAL
    INTO :NEW.login_key
    FROM DUAL;
END;
/

--DROP TRIGGER login_recoed_AI_TRG;
/

--DROP SEQUENCE login_recoed_SEQ;
/

COMMENT ON TABLE login_recoed IS '로그인 기록'
/

COMMENT ON COLUMN login_recoed.login_key IS '로그인 키'
/

COMMENT ON COLUMN login_recoed.m_key IS '회원 키'
/

COMMENT ON COLUMN login_recoed.login_time IS '로그인 시각'
/

COMMENT ON COLUMN login_recoed.logout_time IS '로그아웃 시각'
/

ALTER TABLE login_recoed
    ADD CONSTRAINT FK_login_recoed_m_key_t_member FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/

commit
