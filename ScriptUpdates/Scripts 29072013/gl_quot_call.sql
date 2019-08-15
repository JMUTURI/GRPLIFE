BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2180, 27, 'GL_CALL_RPT', 'Grou quotation call rpt', 'gl_quot_call.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3518, 2180, 'gl_quot_call_temp.rtf', 'JOINT_AGN_SCH_RPT', 'Group  quotation Life Call Template', 
    'gl_quot_call_temp.xsl', NULL, 'A');
COMMIT;
END;