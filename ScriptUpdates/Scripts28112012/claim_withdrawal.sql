begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (1874, 27, 'CLM_WITHDRAWAL', 'Claim Withdrawal', 'clmwith.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3203, 1874, 'clmwith_temp.rtf', 'CLM_WITHDRAWAL_RPT', 'Claim Withdrawal Template', 
    'clmwith_temp.xsl', NULL, 'A');
COMMIT;
end;
/