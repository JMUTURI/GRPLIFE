
CREATE TABLE lms_quotation_taxes_bak
AS SELECT * FROM lms_quotation_taxes;

ALTER TABLE lms_quotation_taxes
DISABLE CONSTRAINT SYS_C0060534;

UPDATE lms_quotation_taxes
SET QTAX_QUO_NO=NULL;

ALTER TABLE lms_quotation_taxes
MODIFY(QTAX_QUO_NO VARCHAR2(50));

DECLARE 
CURSOR CUR
IS 
SELECT * 
   FROM lms_quotation_taxes_bak;
   
BEGIN
    FOR C IN CUR
    LOOP
        UPDATE lms_quotation_taxes
        SET qtax_quo_no=TO_CHAR(C.qtax_quo_no)
        WHERE qtax_code=C.qtax_code;
    END LOOP;
COMMIT;
END;
/

ALTER TABLE lms_quotation_taxes
ENABLE CONSTRAINT SYS_C0060534;

DROP TABLE lms_quotation_taxes_bak;





