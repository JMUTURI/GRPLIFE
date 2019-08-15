begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2192, 27, 'SCHEME_PROJECTION_SCHEDULE', 'Scheme projection schedule', 'pens_proj_rpt.xml', 
    NULL, 'A');

Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3530, 2192, 'pens_proj_rpt_temp.rtf', 'SCHEME_PROJECTION_SCHEDULE', 'Scheme projection schedule template', 
    'pens_proj_rpt_temp.xsl', NULL, 'A');
COMMIT;
end;
/
