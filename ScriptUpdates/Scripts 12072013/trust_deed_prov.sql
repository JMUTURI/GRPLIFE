begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2143, 27, 'PROV_FUND_TRUST_DEED', 'Provident Fund report', 'trust_deed_prov.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3478, 2143, 'trust_deed_prov_temp.rtf', 'PROV_FUND_TRUST_DEED', 'Provident Fund report Template', 
    'trust_deed_prov_temp.xsl', NULL, 'A');
COMMIT;
/
