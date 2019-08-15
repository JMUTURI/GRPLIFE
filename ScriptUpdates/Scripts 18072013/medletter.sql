BEGIN
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3491, 1048, 'medletterApollo_temp.rtf', 'MED_LTR_RPT', 'Medical Letter Apollo Template', 
    'medletterApollo_temp.xsl', NULL, 'A');
COMMIT;
END;
/
