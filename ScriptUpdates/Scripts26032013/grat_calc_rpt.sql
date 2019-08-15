begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2003, 27, 'GRAT_CALC_RPT', 'Gratuity Calculation Report', 'GratCalc.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3330, 2003, 'GratCalc_temp.rtf', 'GRAT_CALC_RPT', 'Gratuity Calculation Report Template', 
    'GratCalc_temp.xsl', NULL, 'A');
COMMIT;
end;
/