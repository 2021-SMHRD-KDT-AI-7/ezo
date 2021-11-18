--t_member Table Create SQL
CREATE TABLE t_member
(
    m_seq         NUMBER(12,0)    NOT NULL,
    m_id          VARCHAR2(20)    NOT NULL,
    m_pwd         VARCHAR2(20)    NOT NULL,
    m_nickname    VARCHAR2(20)    NOT NULL,
    m_email       VARCHAR2(50)    NOT NULL,
    m_phone       VARCHAR2(20)    NOT NULL,
    m_joindate    DATE            DEFAULT SYSDATE NOT NULL,
    admin_yn      VARCHAR2(1)     NOT NULL,
    m_status      VARCHAR2(1)     NOT NULL,
     PRIMARY KEY (m_seq)
)
/
CREATE SEQUENCE t_member_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_member_seq_ai_trg
BEFORE INSERT ON t_member
FOR EACH ROW
BEGIN 
	IF INSERTING then 
    SELECT t_member_seq.NEXTVAL
    INTO :NEW.m_seq
    FROM DUAL;
END;

/

COMMENT ON TABLE t_member IS '회원 정보'
/

COMMENT ON COLUMN t_member.m_seq IS '회원 고유 번호'
/

COMMENT ON COLUMN t_member.m_id IS '회원 아이디'
/

COMMENT ON COLUMN t_member.m_pwd IS '회원 비밀번호'
/

COMMENT ON COLUMN t_member.m_nickname IS '회원 닉네임'
/

COMMENT ON COLUMN t_member.m_email IS '회원 이메일'
/

COMMENT ON COLUMN t_member.m_phone IS '회원 연락처'
/

COMMENT ON COLUMN t_member.m_joindate IS '회원 가입일'
/

COMMENT ON COLUMN t_member.admin_yn IS '관리자 여부'
/

COMMENT ON COLUMN t_member.m_status IS '회원 상태'
/


CREATE TABLE t_web_site(
    web_seq    NUMBER (12, 0) NOT NULL,
    web_name   VARCHAR2(50)   NOT NULL,
    web_url    VARCHAR2(150)  NOT NULL,
        PRIMARY KEY (web_seq)
)
/

CREATE SEQUENCE t_web_site_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_web_site_seq_ai_trg
BEFORE INSERT ON t_web_site
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
    SELECT t_web_site_seq.NEXTVAL
    INTO :NEW.web_seq
    FROM DUAL;
END;
/

COMMENT ON TABLE t_web_site IS '웹 정보'
/

COMMENT ON COLUMN t_web_site.web_seq IS '웹 고유 번호'
/

COMMENT ON COLUMN t_web_site.web_name IS '웹 이름'
/

COMMENT ON COLUMN t_web_site.web_url IS '웹 url'
/



-- t_product Table Create SQL
CREATE TABLE t_product
(
    p_seq          NUMBER(12, 0)    NOT NULL,
    p_name         VARCHAR2(150)    NOT NULL,
    p_price        NUMBER(12, 0)    NOT NULL,
    web_seq        NUMBER(12, 0)    NOT NULL,
    p_category     VARCHAR2(50)     NOT NULL,
    p_view_cnt          NUMBER(12, 0)    DEFAULT 0 NOT NULL,
    p_maker        VARCHAR2(50)     NOT NULL,
    p_weight       NUMBER(12, 1)    NOT NULL,
    p_made_date    DATE             DEFAULT SYSDATE NOT NULL,
    reg_date       DATE             DEFAULT SYSDATE NOT NULL,
    m_seq          NUMBER(12, 0)    NOT NULL,
    p_pic1         VARCHAR2(150)    NULL,
    p_pic2         VARCHAR2(150)    NULL,
    p_pic3         VARCHAR2(150)    NULL,
    p_pic4         VARCHAR2(150)    NULL,
    p_pic5         VARCHAR2(150)    NULL,
     PRIMARY KEY (p_seq)
)

/
CREATE SEQUENCE t_product_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_product_ai_trg
BEFORE INSERT ON t_product
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_product_seq.NEXTVAL
    INTO :NEW.p_seq
    FROM DUAL;
END;
/

COMMENT ON TABLE t_product IS '상품 정보'
/

COMMENT ON COLUMN t_product.p_seq IS '상품 고유 번호'
/

COMMENT ON COLUMN t_product.p_name IS '상품 명'
/

COMMENT ON COLUMN t_product.p_price IS '상품 가격'
/

COMMENT ON COLUMN t_product.web_seq IS '상품 출처 웹 고유 번호'
/

COMMENT ON COLUMN t_product.p_category IS '상품 카테고리'
/

COMMENT ON COLUMN t_product.p_view_cnt IS '상품 조회수'
/

COMMENT ON COLUMN t_product.p_maker IS '상품 제조사'
/

COMMENT ON COLUMN t_product.p_weight IS '상품 무게'
/

COMMENT ON COLUMN t_product.p_made_date IS '상품 제조일자'
/

COMMENT ON COLUMN t_product.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_product.m_seq IS '등록자 고유 번호'
/

COMMENT ON COLUMN t_product.p_pic1 IS '상품 사진1'
/

COMMENT ON COLUMN t_product.p_pic2 IS '상품 사진2'
/

COMMENT ON COLUMN t_product.p_pic3 IS '상품 사진3'
/

COMMENT ON COLUMN t_product.p_pic4 IS '상품 사진4'
/

COMMENT ON COLUMN t_product.p_pic5 IS '상품 사진5'
/

ALTER TABLE t_product
    ADD CONSTRAINT FK_t_product_m_key FOREIGN KEY (m_seq)
        REFERENCES t_member (m_seq)
/

ALTER TABLE t_product
    ADD CONSTRAINT FK_t_product_web_seq FOREIGN KEY (web_seq)
        REFERENCES t_web_site (web_seq)
/

-- t_community Table Create SQL
CREATE TABLE t_community
(
    article_seq        NUMBER(12, 0)     NOT NULL,
    article_subject    VARCHAR2(150)     NOT NULL,
    article_content    VARCHAR2(4000)    NOT NULL,
    reg_date           DATE              NOT NULL,
    m_seq              NUMBER(12, 0)     NOT NULL,
    article_cnt        NUMBER(12, 0)     DEFAULT 0 NOT NULL,
    article_file1      VARCHAR2(150)     NULL,
    article_file2      VARCHAR2(150)     NULL,
     PRIMARY KEY (article_seq)
)
/

CREATE SEQUENCE t_community_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_community_ai_trg
BEFORE INSERT ON t_community
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_community_seq.NEXTVAL
    INTO :NEW.article_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_community_AI_TRG;
/

--DROP SEQUENCE t_community_SEQ;
/

COMMENT ON TABLE t_community IS '소통 게시판'
/

COMMENT ON COLUMN t_community.article_seq IS '게시글 고유 번호'
/

COMMENT ON COLUMN t_community.article_subject IS '게시글 제목'
/

COMMENT ON COLUMN t_community.article_content IS '게시글 내용'
/

COMMENT ON COLUMN t_community.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_community.m_seq IS '작성자 고유 번호'
/

COMMENT ON COLUMN t_community.article_cnt IS '조회 수'
/

COMMENT ON COLUMN t_community.article_file1 IS '게시글 첨부파일1'
/

COMMENT ON COLUMN t_community.article_file2 IS '게시글 첨부파일2'
/

ALTER TABLE t_community
    ADD CONSTRAINT FK_t_community_m_seq FOREIGN KEY (m_seq)
        REFERENCES t_member (m_seq)
/

--상품의 가격 변동 알고리즘 고민 1) DB내 함수로 계산, 2)Eclipse 계산
CREATE TABLE t_changed_product_price
(
    cp_seq      NUMBER(12, 0)    NOT NULL,
    p_seq       NUMBER(12, 0)    NOT NULL,
    cp_price    NUMBER(12, 0)    NOT NULL,
    reg_date    DATE             NOT NULL,
    web_seq     NUMBER(12, 0)    NOT NULL,
     PRIMARY KEY (cp_seq)
)
/

CREATE SEQUENCE t_changed_product_price_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_changed_product_price_ai_trg
BEFORE INSERT ON t_changed_product_price
REFERENCING NEW AS NEW FOR EACH ROW
BEGI
    SELECT t_changed_product_price_seq.NEXTVAL
    INTO :NEW.cp_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_product_price_AI_TRG;
/

--DROP SEQUENCE t_product_price_SEQ;
/

COMMENT ON TABLE t_changed_product_price IS '상품 가격 변동'
/

COMMENT ON COLUMN t_changed_product_price.cp_seq IS '가격 변동 순번'
/

COMMENT ON COLUMN t_changed_product_price.p_seq IS '상품 순번'
/

COMMENT ON COLUMN t_changed_product_price.cp_price IS '상품 현재 가격'
/

COMMENT ON COLUMN t_changed_product_price.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_changed_product_price.web_seq IS '판매 사이트 고유 번호'
/


ALTER TABLE t_changed_product_price
    ADD CONSTRAINT FK_t_changed_pro_p_seq FOREIGN KEY (p_seq)
        REFERENCES t_product (p_seq)
/

ALTER TABLE t_changed_product_price
    ADD CONSTRAINT FK_t_changed_pro_web_seq FOREIGN KEY (web_seq)
        REFERENCES t_web_site (web_seq)
/


-- t_producet_alarm Table Create SQL
CREATE TABLE t_producet_alarm
(
    alarm_seq        NUMBER(12, 0)     NOT NULL,
    p_seq            NUMBER(12, 0)     NOT NULL,
    reg_date         DATE              NOT NULL,
    alarm_message    VARCHAR2(4000)    NOT NULL,
    r_m_seq          NUMBER(12, 0)     NOT NULL,
     PRIMARY KEY (alarm_seq)
)
/

CREATE SEQUENCE t_producet_alarm_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_producet_alarm_ai_trg
BEFORE INSERT ON t_producet_alarm
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_producet_alarm_seq.NEXTVAL
    INTO :NEW.alarm_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_producet_alarm_AI_TRG;
/

--DROP SEQUENCE t_producet_alarm_SEQ;
/

COMMENT ON TABLE t_producet_alarm IS '희망 상품 알림'
/

COMMENT ON COLUMN t_producet_alarm.alarm_seq IS '알림 순번'
/

COMMENT ON COLUMN t_producet_alarm.p_seq IS '상품 순번'
/

COMMENT ON COLUMN t_producet_alarm.reg_date IS '등록 일자'
/

COMMENT ON COLUMN t_producet_alarm.alarm_message IS '알림 메시지'
/

COMMENT ON COLUMN t_producet_alarm.r_m_seq IS '수신자 고유 번호'
/

ALTER TABLE t_producet_alarm
    ADD CONSTRAINT FK_t_pro_alarm_p_seq FOREIGN KEY (p_seq)
        REFERENCES t_product (p_seq)
/

ALTER TABLE t_producet_alarm
    ADD CONSTRAINT FK_t_pro_alarm_r_m_seq FOREIGN KEY (r_m_seq)
        REFERENCES t_member (m_seq)
/

-- t_comment Table Create SQL
CREATE TABLE t_comment
(
    c_seq          NUMBER(12, 0)     NOT NULL,
    article_seq    NUMBER(12, 0)     NOT NULL,
    c_content      VARCHAR2(4000)    NOT NULL,
    reg_date       DATE              NOT NULL,
    m_seq          NUMBER(12, 0)      NOT NULL,
     PRIMARY KEY (c_seq)
)
/

CREATE SEQUENCE t_comment_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_comment_ai_trg
BEFORE INSERT ON t_comment
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_comment_seq.NEXTVAL
    INTO :NEW.c_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_comment_AI_TRG;
/

--DROP SEQUENCE t_comment_SEQ;
/

COMMENT ON TABLE t_comment IS '댓글 게시판'
/

COMMENT ON COLUMN t_comment.c_seq IS '댓글 고유 번호'
/

COMMENT ON COLUMN t_comment.article_seq IS '원글 고유 번호'
/

COMMENT ON COLUMN t_comment.c_content IS '댓글 내용'
/

COMMENT ON COLUMN t_comment.reg_date IS '작성 일자'
/

COMMENT ON COLUMN t_comment.m_seq IS '작성자 고유 번호'
/

ALTER TABLE t_comment
    ADD CONSTRAINT FK_t_comment_t_m_seq FOREIGN KEY (m_seq)
        REFERENCES t_member (m_seq)
/

ALTER TABLE t_comment
    ADD CONSTRAINT FK_t_comment_article_seq FOREIGN KEY (article_seq)
        REFERENCES t_community (article_seq)
/


-- t_recent_product Table Create SQL
CREATE TABLE t_recent_product
(
    recent_seq    NUMBER(12, 0)    NOT NULL,
    p_seq         NUMBER(12, 0)    NOT NULL,
    reg_date      DATE             NOT NULL,
    m_seq         NUMBER(12, 0)    NOT NULL,
     PRIMARY KEY (recent_seq)
)
/

CREATE SEQUENCE t_recent_product_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_recent_product_ai_trg
BEFORE INSERT ON t_recent_product
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_recent_product_seq.NEXTVAL
    INTO :NEW.recent_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_recent_product_AI_TRG;
/

--DROP SEQUENCE t_recent_product_SEQ;
/

COMMENT ON TABLE t_recent_product IS '최근에 본 상품'
/

COMMENT ON COLUMN t_recent_product.recent_seq IS '최근 본 횟수 고유 번호'
/

COMMENT ON COLUMN t_recent_product.p_seq IS '상품 순번'
/

COMMENT ON COLUMN t_recent_product.reg_date IS '최근에 본 일자'
/

COMMENT ON COLUMN t_recent_product.m_seq IS '작성자 고유 번호'
/

ALTER TABLE t_recent_product
    ADD CONSTRAINT FK_t_recent_p_seq FOREIGN KEY (p_seq)
        REFERENCES t_product (p_seq)
/

ALTER TABLE t_recent_product
    ADD CONSTRAINT FK_t_recent_m_seq FOREIGN KEY (m_seq)
        REFERENCES t_member (m_seq)
/

--
CREATE TABLE t_direct_purchase_seller(
    seller_seq     NUMBER(12, 0) NOT NULL,
    seller_name    VARCHAR2(20)  NOT NULL,
    seller_web_seq NUMBER(12, 0) NOT NULL,
    PRIMARY KEY (seller_seq)
)
/

CREATE SEQUENCE t_direct_purchase_seller_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_direct_purchase_seller_ai_trg
BEFORE INSERT ON t_direct_purchase_seller
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_direct_purchase_seller_seq.NEXTVAL
    INTO :NEW.seller_seq
    FROM DUAL;
END;
/

COMMENT ON TABLE t_direct_purchase_seller IS '직구 판매자'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_seq IS '직구 판매자 고유 번호'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_name IS '직구 판매자 이름'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_web_seq IS '직구 판매자 사이트 고유 번호'
/

CREATE TABLE t_direct_purchase_item(
    seller_seq    NUMBER(12, 0)  NOT NULL,
    item_seq      NUMBER(12, 0)  NOT NULL,
    item_name     VARCHAR2(50)   NOT NULL,
    item_content  VARCHAR2(4000) NOT NULL,
    item_price    NUMBER(12, 0)  NOT NULL,
    reg_date DATE           NOT NULL,
    web_seq  NUMBER(12, 0)  NOT NULL,
    sell_yn       VARCHAR2(1)    NOT NULL,
          PRIMARY KEY (item_seq)
)
/

CREATE SEQUENCE t_direct_purchase_item_seq
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_direct_purchase_item_ai_trg
BEFORE INSERT ON t_direct_purchase_item
REFERENCING NEW AS NEW FOR EACH ROW
BEGIN
    SELECT t_direct_purchase_item_seq.NEXTVAL
    INTO :NEW.item_seq
    FROM DUAL;
END;
/

COMMENT ON TABLE t_direct_purchase_item IS '직구 판매 아이템'
/

COMMENT ON COLUMN t_direct_purchase_item.seller_seq IS '직구 판매자 고유 번호'
/

COMMENT ON COLUMN t_direct_purchase_item.item_seq IS '직구 판매 아아템 고유 번호'
/

COMMENT ON COLUMN t_direct_purchase_item.item_name IS '직구 아이템 이름'
/

COMMENT ON COLUMN t_direct_purchase_item.item_content IS '직구 아이템 내용'
/

COMMENT ON COLUMN t_direct_purchase_item.item_price IS '직구 아이템 가격'
/

COMMENT ON COLUMN t_direct_purchase_item.reg_date IS '직구 아이템 등록일'
/

COMMENT ON COLUMN t_direct_purchase_item.web_seq IS '직구 웹 고유 번호'
/

COMMENT ON COLUMN t_direct_purchase_item.sell_yn IS '판매 여부'
/

ALTER TABLE t_direct_purchase_item
    ADD CONSTRAINT FK_t_d_p_item_seller_seq FOREIGN KEY (seller_seq)
        REFERENCES t_direct_purchase_seller (seller_seq)
/

ALTER TABLE t_direct_purchase_item
    ADD CONSTRAINT FK_t_d_p_item_web_seq FOREIGN KEY (web_seq)
        REFERENCES  t_web_site(web_seq)
/
commit

