begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (1989, 27, 'QUOT_GRATUITY_SCH', 'Quotation gratuity report', 'quot_grat.xml', 
    NULL, 'A');
    SET DEFINE OFF;
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3317, 1989, 'quot_grat_temp.rtf', 'QUOT_GRATUITY_RPT', 'Quotation gratuity report Template', 
    'quot_grat_temp.xsl', NULL, 'A');
 
COMMIT;

end;
/