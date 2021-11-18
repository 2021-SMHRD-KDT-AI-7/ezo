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

COMMENT ON TABLE t_member IS 'ȸ�� ����'
/

COMMENT ON COLUMN t_member.m_seq IS 'ȸ�� ���� ��ȣ'
/

COMMENT ON COLUMN t_member.m_id IS 'ȸ�� ���̵�'
/

COMMENT ON COLUMN t_member.m_pwd IS 'ȸ�� ��й�ȣ'
/

COMMENT ON COLUMN t_member.m_nickname IS 'ȸ�� �г���'
/

COMMENT ON COLUMN t_member.m_email IS 'ȸ�� �̸���'
/

COMMENT ON COLUMN t_member.m_phone IS 'ȸ�� ����ó'
/

COMMENT ON COLUMN t_member.m_joindate IS 'ȸ�� ������'
/

COMMENT ON COLUMN t_member.admin_yn IS '������ ����'
/

COMMENT ON COLUMN t_member.m_status IS 'ȸ�� ����'
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

COMMENT ON TABLE t_web_site IS '�� ����'
/

COMMENT ON COLUMN t_web_site.web_seq IS '�� ���� ��ȣ'
/

COMMENT ON COLUMN t_web_site.web_name IS '�� �̸�'
/

COMMENT ON COLUMN t_web_site.web_url IS '�� url'
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

COMMENT ON TABLE t_product IS '��ǰ ����'
/

COMMENT ON COLUMN t_product.p_seq IS '��ǰ ���� ��ȣ'
/

COMMENT ON COLUMN t_product.p_name IS '��ǰ ��'
/

COMMENT ON COLUMN t_product.p_price IS '��ǰ ����'
/

COMMENT ON COLUMN t_product.web_seq IS '��ǰ ��ó �� ���� ��ȣ'
/

COMMENT ON COLUMN t_product.p_category IS '��ǰ ī�װ�'
/

COMMENT ON COLUMN t_product.p_view_cnt IS '��ǰ ��ȸ��'
/

COMMENT ON COLUMN t_product.p_maker IS '��ǰ ������'
/

COMMENT ON COLUMN t_product.p_weight IS '��ǰ ����'
/

COMMENT ON COLUMN t_product.p_made_date IS '��ǰ ��������'
/

COMMENT ON COLUMN t_product.reg_date IS '��� ����'
/

COMMENT ON COLUMN t_product.m_seq IS '����� ���� ��ȣ'
/

COMMENT ON COLUMN t_product.p_pic1 IS '��ǰ ����1'
/

COMMENT ON COLUMN t_product.p_pic2 IS '��ǰ ����2'
/

COMMENT ON COLUMN t_product.p_pic3 IS '��ǰ ����3'
/

COMMENT ON COLUMN t_product.p_pic4 IS '��ǰ ����4'
/

COMMENT ON COLUMN t_product.p_pic5 IS '��ǰ ����5'
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

COMMENT ON TABLE t_community IS '���� �Խ���'
/

COMMENT ON COLUMN t_community.article_seq IS '�Խñ� ���� ��ȣ'
/

COMMENT ON COLUMN t_community.article_subject IS '�Խñ� ����'
/

COMMENT ON COLUMN t_community.article_content IS '�Խñ� ����'
/

COMMENT ON COLUMN t_community.reg_date IS '��� ����'
/

COMMENT ON COLUMN t_community.m_seq IS '�ۼ��� ���� ��ȣ'
/

COMMENT ON COLUMN t_community.article_cnt IS '��ȸ ��'
/

COMMENT ON COLUMN t_community.article_file1 IS '�Խñ� ÷������1'
/

COMMENT ON COLUMN t_community.article_file2 IS '�Խñ� ÷������2'
/

ALTER TABLE t_community
    ADD CONSTRAINT FK_t_community_m_seq FOREIGN KEY (m_seq)
        REFERENCES t_member (m_seq)
/

--��ǰ�� ���� ���� �˰��� ��� 1) DB�� �Լ��� ���, 2)Eclipse ���
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

COMMENT ON TABLE t_changed_product_price IS '��ǰ ���� ����'
/

COMMENT ON COLUMN t_changed_product_price.cp_seq IS '���� ���� ����'
/

COMMENT ON COLUMN t_changed_product_price.p_seq IS '��ǰ ����'
/

COMMENT ON COLUMN t_changed_product_price.cp_price IS '��ǰ ���� ����'
/

COMMENT ON COLUMN t_changed_product_price.reg_date IS '��� ����'
/

COMMENT ON COLUMN t_changed_product_price.web_seq IS '�Ǹ� ����Ʈ ���� ��ȣ'
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

COMMENT ON TABLE t_producet_alarm IS '��� ��ǰ �˸�'
/

COMMENT ON COLUMN t_producet_alarm.alarm_seq IS '�˸� ����'
/

COMMENT ON COLUMN t_producet_alarm.p_seq IS '��ǰ ����'
/

COMMENT ON COLUMN t_producet_alarm.reg_date IS '��� ����'
/

COMMENT ON COLUMN t_producet_alarm.alarm_message IS '�˸� �޽���'
/

COMMENT ON COLUMN t_producet_alarm.r_m_seq IS '������ ���� ��ȣ'
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

COMMENT ON TABLE t_comment IS '��� �Խ���'
/

COMMENT ON COLUMN t_comment.c_seq IS '��� ���� ��ȣ'
/

COMMENT ON COLUMN t_comment.article_seq IS '���� ���� ��ȣ'
/

COMMENT ON COLUMN t_comment.c_content IS '��� ����'
/

COMMENT ON COLUMN t_comment.reg_date IS '�ۼ� ����'
/

COMMENT ON COLUMN t_comment.m_seq IS '�ۼ��� ���� ��ȣ'
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

COMMENT ON TABLE t_recent_product IS '�ֱٿ� �� ��ǰ'
/

COMMENT ON COLUMN t_recent_product.recent_seq IS '�ֱ� �� Ƚ�� ���� ��ȣ'
/

COMMENT ON COLUMN t_recent_product.p_seq IS '��ǰ ����'
/

COMMENT ON COLUMN t_recent_product.reg_date IS '�ֱٿ� �� ����'
/

COMMENT ON COLUMN t_recent_product.m_seq IS '�ۼ��� ���� ��ȣ'
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

COMMENT ON TABLE t_direct_purchase_seller IS '���� �Ǹ���'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_seq IS '���� �Ǹ��� ���� ��ȣ'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_name IS '���� �Ǹ��� �̸�'
/

COMMENT ON COLUMN t_direct_purchase_seller.seller_web_seq IS '���� �Ǹ��� ����Ʈ ���� ��ȣ'
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

COMMENT ON TABLE t_direct_purchase_item IS '���� �Ǹ� ������'
/

COMMENT ON COLUMN t_direct_purchase_item.seller_seq IS '���� �Ǹ��� ���� ��ȣ'
/

COMMENT ON COLUMN t_direct_purchase_item.item_seq IS '���� �Ǹ� �ƾ��� ���� ��ȣ'
/

COMMENT ON COLUMN t_direct_purchase_item.item_name IS '���� ������ �̸�'
/

COMMENT ON COLUMN t_direct_purchase_item.item_content IS '���� ������ ����'
/

COMMENT ON COLUMN t_direct_purchase_item.item_price IS '���� ������ ����'
/

COMMENT ON COLUMN t_direct_purchase_item.reg_date IS '���� ������ �����'
/

COMMENT ON COLUMN t_direct_purchase_item.web_seq IS '���� �� ���� ��ȣ'
/

COMMENT ON COLUMN t_direct_purchase_item.sell_yn IS '�Ǹ� ����'
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

