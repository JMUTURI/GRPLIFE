    
BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (1987, 27, 'STMT_OF_ACCOUNT', 'Statement of Account', 'stmtOfAccount.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3315, 1987, 'stmtOfAccount_temp.rtf', 'JOINT_AGN_SCH_RPT', 'Statement of AccountTemplate', 
    'stmtOfAccount_temp.xsl', NULL, 'A');
COMMIT;
END;
/