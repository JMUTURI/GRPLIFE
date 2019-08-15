BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (1873, 27, 'CLAIMS_ADVICE_RPT', 'Claims Payment Requisition Voucher Report', 'ClmReqVou.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3202, 1873, 'ClmReqVou_temp.rtf', 'CLAIMS_ADVICE_RPT', 'Claims Payment Requisition Voucher Template', 
    'ClmReqVou_temp.xsl', NULL, 'A');
COMMIT;
END;
/

--register the parameter below in the reports_parameters package----
 V_CLM_NO    VARCHAR2(20); 
