-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

-- t_web Table Create SQL
CREATE TABLE t_web
(
    web_key     NUMBER          NOT NULL, 
    web_name    VARCHAR2(20)    NOT NULL, 
    web_url     VARCHAR2(50)    NOT NULL, 
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

COMMENT ON TABLE t_web IS '�� ��ó'
/

COMMENT ON COLUMN t_web.web_key IS '�� Ű'
/

COMMENT ON COLUMN t_web.web_name IS '�� �̸�'
/

COMMENT ON COLUMN t_web.web_url IS '�� URL'
/


-- t_member Table Create SQL
CREATE TABLE t_member
(
    m_key         NUMBER          NOT NULL, 
    m_id          VARCHAR2(20)    NOT NULL, 
    m_pw          VARCHAR2(20)    NOT NULL, 
    m_email       VARCHAR2(50)    NULL, 
    m_phone       VARCHAR2(20)    NULL, 
    m_joindate    DATE            NOT NULL, 
    m_status      VARCHAR2(1)     NOT NULL, 
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

COMMENT ON TABLE t_member IS 'ȸ������'
/

COMMENT ON COLUMN t_member.m_key IS 'ȸ�� Ű'
/

COMMENT ON COLUMN t_member.m_id IS 'ȸ�� ���̵�'
/

COMMENT ON COLUMN t_member.m_pw IS 'ȸ�� �����ȣ'
/

COMMENT ON COLUMN t_member.m_email IS 'ȸ�� �̸���'
/

COMMENT ON COLUMN t_member.m_phone IS 'ȸ�� ��ȭ��ȣ'
/

COMMENT ON COLUMN t_member.m_joindate IS 'ȸ��������'
/

COMMENT ON COLUMN t_member.m_status IS 'ȸ������'
/

COMMENT ON COLUMN t_member.admin_yn IS '������ ����'
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

COMMENT ON TABLE t_seller IS '�ؿ� ���� �Ǹ���'
/

COMMENT ON COLUMN t_seller.seller_key IS '�ؿ� ���� �Ǹ���'
/

COMMENT ON COLUMN t_seller.seller_name IS '�Ǹ��� �̸�'
/

COMMENT ON COLUMN t_seller.web_key IS '������ ��ó Ű'
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
    p_pic1        VARCHAR2(100)    NULL, 
    p_pic2        VARCHAR2(100)    NULL, 
    p_pic3        VARCHAR2(100)    NULL, 
    p_pic4        VARCHAR2(100)    NULL, 
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

COMMENT ON TABLE t_product IS '��ǰ����'
/

COMMENT ON COLUMN t_product.p_key IS '��ǰ Ű'
/

COMMENT ON COLUMN t_product.p_name IS '��ǰ �̸�'
/

COMMENT ON COLUMN t_product.p_price IS '��ǰ ����'
/

COMMENT ON COLUMN t_product.p_view_cnt IS '��ǰ ��ȸ��'
/

COMMENT ON COLUMN t_product.web_key IS '��ǰ ��ó Ű'
/

COMMENT ON COLUMN t_product.sold_yn IS '�Ǹ� ����'
/

COMMENT ON COLUMN t_product.reg_date IS '��ǰ �����'
/

COMMENT ON COLUMN t_product.p_pic1 IS '��ǰ �׸�1'
/

COMMENT ON COLUMN t_product.p_pic2 IS '��ǰ �׸�2'
/

COMMENT ON COLUMN t_product.p_pic3 IS '��ǰ �׸�3'
/

COMMENT ON COLUMN t_product.p_pic4 IS '��ǰ �׸�4'
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
    item_buyer      NUMBER            NOT NULL, 
    item_title      VARCHAR2(20)      NOT NULL, 
    item_content    VARCHAR2(4000)    NULL, 
    item_price      NUMBER            NOT NULL, 
    sold_yn         VARCHAR2(1)       NOT NULL, 
    reg_date        DATE              NOT NULL, 
     PRIMARY KEY (item_key)
)


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

COMMENT ON TABLE t_item IS '�ؿ� ���� ��ǰ'
/

COMMENT ON COLUMN t_item.item_key IS '������ Ű'
/

COMMENT ON COLUMN t_item.seller_key IS '�ؿ� ���� �Ǹ���'
/

COMMENT ON COLUMN t_item.web_key IS '������ ��ó Ű'
/

COMMENT ON COLUMN t_item.item_buyer IS '������ ������'
/

COMMENT ON COLUMN t_item.item_title IS '������ ����'
/

COMMENT ON COLUMN t_item.item_content IS '������ ����'
/

COMMENT ON COLUMN t_item.item_price IS '������ ����'
/

COMMENT ON COLUMN t_item.sold_yn IS '�Ǹ� ����'
/

COMMENT ON COLUMN t_item.reg_date IS '������ �����'
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_web_key_t_web_web_ke FOREIGN KEY (web_key)
        REFERENCES t_web (web_key)
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_item_buyer_t_member_ FOREIGN KEY (item_buyer)
        REFERENCES t_member (m_key)
/

ALTER TABLE t_item
    ADD CONSTRAINT FK_t_item_seller_key_t_seller_ FOREIGN KEY (seller_key)
        REFERENCES t_seller (seller_key)
/


-- t_reserved Table Create SQL
CREATE TABLE t_reserved
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

CREATE SEQUENCE t_reserved_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_reserved_AI_TRG
BEFORE INSERT ON t_reserved 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_reserved_SEQ.NEXTVAL
    INTO :NEW.r_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_reserved_AI_TRG;
/

--DROP SEQUENCE t_reserved_SEQ;
/

COMMENT ON TABLE t_reserved IS '����'
/

COMMENT ON COLUMN t_reserved.r_key IS '���� Ű'
/

COMMENT ON COLUMN t_reserved.m_key IS '������ Ű'
/

COMMENT ON COLUMN t_reserved.p_key IS '���� ��ǰ Ű'
/

COMMENT ON COLUMN t_reserved.item_key IS '���� ������ Ű'
/

COMMENT ON COLUMN t_reserved.r_price IS '���� ����'
/

COMMENT ON COLUMN t_reserved.reg_date IS '���� �����'
/

ALTER TABLE t_reserved
    ADD CONSTRAINT FK_t_reserved_m_key_t_member_m FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/

ALTER TABLE t_reserved
    ADD CONSTRAINT FK_t_reserved_p_key_t_product_ FOREIGN KEY (p_key)
        REFERENCES t_product (p_key)
/

ALTER TABLE t_reserved
    ADD CONSTRAINT FK_t_reserved_item_key_t_item_ FOREIGN KEY (item_key)
        REFERENCES t_item (item_key)
/


-- t_writerboard Table Create SQL
CREATE TABLE t_writerboard
(
    w_key        NUMBER            NOT NULL, 
    w_title      VARCHAR2(50)      NOT NULL, 
    w_content    VARCHAR2(4000)    NULL, 
    m_key        NUMBER            NULL, 
    w_cnt        NUMBER            NULL, 
    reg_date     DATE              NULL, 
    w_file1      VARCHAR2(150)     NULL, 
    w_file2      VARCHAR2(150)     NULL, 
     PRIMARY KEY (w_key)
)
/

CREATE SEQUENCE t_writerboard_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_writerboard_AI_TRG
BEFORE INSERT ON t_writerboard 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_writerboard_SEQ.NEXTVAL
    INTO :NEW.w_key
    FROM DUAL;
END;
/

--DROP TRIGGER t_writerboard_AI_TRG;
/

--DROP SEQUENCE t_writerboard_SEQ;
/

COMMENT ON TABLE t_writerboard IS '�Խ���'
/

COMMENT ON COLUMN t_writerboard.w_key IS '�Խñ� Ű'
/

COMMENT ON COLUMN t_writerboard.w_title IS '�Խñ� ����'
/

COMMENT ON COLUMN t_writerboard.w_content IS '�Խñ� ����'
/

COMMENT ON COLUMN t_writerboard.m_key IS '�Խñ� �ۼ���'
/

COMMENT ON COLUMN t_writerboard.w_cnt IS '�Խñ� ��ȸ��'
/

COMMENT ON COLUMN t_writerboard.reg_date IS '�Խñ� �����'
/

COMMENT ON COLUMN t_writerboard.w_file1 IS '÷�� ����1'
/

COMMENT ON COLUMN t_writerboard.w_file2 IS '÷�� ����2'
/

ALTER TABLE t_writerboard
    ADD CONSTRAINT FK_t_writerboard_m_key_t_membe FOREIGN KEY (m_key)
        REFERENCES t_member (m_key)
/


-- products Table Create SQL
CREATE TABLE products
(
    p_key      NUMBER          NOT NULL, 
    p_name     VARCHAR2(20)    NOT NULL, 
    p_price    NUMBER          NOT NULL, 
    web_key    NUMBER          NOT NULL, 
     PRIMARY KEY (p_key)
)
/

CREATE SEQUENCE products_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER products_AI_TRG
BEFORE INSERT ON products 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT products_SEQ.NEXTVAL
    INTO :NEW.p_key
    FROM DUAL;
END;
/

--DROP TRIGGER products_AI_TRG;
/

--DROP SEQUENCE products_SEQ;
/

COMMENT ON TABLE products IS '������ ��ǰ ����'
/

COMMENT ON COLUMN products.p_key IS '��ǰ Ű'
/

COMMENT ON COLUMN products.p_name IS '��ǰ �̸�'
/

COMMENT ON COLUMN products.p_price IS '��ǰ ����'
/

COMMENT ON COLUMN products.web_key IS '��ǰ ��ó Ű'
/

ALTER TABLE products
    ADD CONSTRAINT FK_products_p_key_t_product_p_ FOREIGN KEY (p_key)
        REFERENCES t_product (p_key)
/

ALTER TABLE products
    ADD CONSTRAINT FK_products_web_key_t_web_web_ FOREIGN KEY (web_key)
        REFERENCES t_web (web_key)
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

COMMENT ON TABLE t_comment IS '���'
/

COMMENT ON COLUMN t_comment.c_key IS '��� Ű'
/

COMMENT ON COLUMN t_comment.w_key IS '���� Ű'
/

COMMENT ON COLUMN t_comment.m_key IS '��� �ۼ���'
/

COMMENT ON COLUMN t_comment.c_content IS '��� ����'
/

COMMENT ON COLUMN t_comment.reg_date IS '��� �ۼ���'
/

ALTER TABLE t_comment
    ADD CONSTRAINT FK_t_comment_w_key_t_writerboa FOREIGN KEY (w_key)
        REFERENCES t_writerboard (w_key)
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

COMMENT ON TABLE t_ch_price IS '���� ����'
/

COMMENT ON COLUMN t_ch_price.cp_key IS '���� ���� Ű'
/

COMMENT ON COLUMN t_ch_price.p_key IS '��ǰ Ű'
/

COMMENT ON COLUMN t_ch_price.item_key IS '������ Ű'
/

COMMENT ON COLUMN t_ch_price.p_price IS '��ǰ ���� �� ����'
/

COMMENT ON COLUMN t_ch_price.item_price IS '������ ���� �� ����'
/

COMMENT ON COLUMN t_ch_price.ch_difference IS '���� ������'
/

COMMENT ON COLUMN t_ch_price.reg_date IS '���� ������'
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
    a_content    VARCHAR2(300)    NOT NULL, 
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

COMMENT ON TABLE t_alarm IS '�˶�'
/

COMMENT ON COLUMN t_alarm.a_key IS '�˸� Ű'
/

COMMENT ON COLUMN t_alarm.r_key IS '���� Ű'
/

COMMENT ON COLUMN t_alarm.a_content IS '�˸� ����'
/

ALTER TABLE t_alarm
    ADD CONSTRAINT FK_t_alarm_r_key_t_reserved_r_ FOREIGN KEY (r_key)
        REFERENCES t_reserved (r_key)
/

commit
