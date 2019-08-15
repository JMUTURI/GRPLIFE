--quotation cover_type_loadings-----
CREATE TABLE LMS_QUO_COVER_TYPE_LOADINGS ( QOCTL_CODE NUMBER(20,5), 
                                            QOCTL_NAME VARCHAR2(50 BYTE), 
                                            QOCTL_RATE_TYPE VARCHAR2(10 BYTE),
                                             QOCTL_RATE NUMBER(20,5), 
                                             QOCTL_RATE_DIV_FACTOR NUMBER(20,5), 
                                             QOCTL_PCT_CODE NUMBER(20,5), 
                                             QOCTL_QCVT_CODE NUMBER,
                                              QOCTL_QUO_CODE NUMBER(20,5) );



--policy cover_type_loadings-----

CREATE TABLE LMS_POL_COVER_TYPE_LOADINGS ( POCTL_CODE NUMBER(20,5),
                                            POCTL_NAME VARCHAR2(50 BYTE),
                                            POCTL_RATE_TYPE VARCHAR2(10 BYTE), 
                                            POCTL_RATE NUMBER(20,5),
                                            POCTL_RATE_DIV_FACTOR NUMBER(20,5),
                                            POCTL_PCT_CODE NUMBER(20,5),
                                            POCTL_PCVT_CODE NUMBER,
                                            POCTL_ENDR_CODE NUMBER(20,5) );

-----
CREATE TABLE LMS_PROD_COVER_TYPE_LOADINGS ( PCTL_CODE NUMBER(20,5), 
                                            PCTL_NAME VARCHAR2(50 BYTE), 
                                            PCTL_RATE_TYPE VARCHAR2(10 BYTE), 
                                            PCTL_RATE NUMBER(20,5), 
                                            PCTL_RATE_DIV_FACTOR NUMBER(20,5), 
                                            PCTL_PCT_CODE NUMBER(20,5) ) ;
