BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2136, 27, 'AGGR_QUOT_PER_MEM', 'Aggregate Quot per mem', 'mortgage_quot_member.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3469, 2136, 'mortgage_quot_member_temp.rtf', 'AGGR_QUOT_PER_MEM', 'Mortgage Quotation Template', 
    'mortgage_quot_member_temp.xsl', NULL, 'A');
    
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2137, 27, 'GL_CALL_REPORT', 'Group Life Call Report', 'call_rpt.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3470, 2137, 'call_rpt_temp.rtf', 'JOINT_AGN_SCH_RPT', 'Group Life Call Report Template', 
    'call_rpt_temp.xsl', NULL, 'A');
COMMIT;
END;
/