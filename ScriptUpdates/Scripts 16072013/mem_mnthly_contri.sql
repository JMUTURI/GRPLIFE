BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2153, 27, 'MEM_MONTHLY_CONTRI', 'Member Monthly contribution', 'mem_mnthly_contri.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3490, 2153, 'mem_mnthly_contri_temp.rtf', 'MEM_MONTHLY_CONTRI', 'Member Monthly contribution', 
    'mem_mnthly_contri_temp.xsl', NULL, 'A');
COMMIT;
END;
/