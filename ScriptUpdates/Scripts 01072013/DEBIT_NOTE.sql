BEGIN
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3459, 1002, 'debtnoteNetApollo_temp.rtf', 'DEBIT_NOTE_NET', 'Apollo debit note report', 
    'debtnoteNetApollo_temp.xsl', NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3460, 1001, 'debtnoteApollo_temp.rtf', 'DEBIT_NOTE', 'Apollo debit note report', 
    'debtnoteApollo_temp.xsl', NULL, 'A');
COMMIT;
END;