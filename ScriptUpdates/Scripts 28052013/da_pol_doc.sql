begin
        Insert into TQC_SYSTEM_REPORTS
           (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
            RPT_APPLCTN_LEVEL, RPT_ACTIVE)
         Values
           (2093, 27, 'GDAPOLICYDOCUMENT', 'DA Policy Document', 'gdapoldocAIICO.xml', 
            NULL, 'A');
        Insert into TQC_SYS_RPT_TEMPLATES
           (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
            RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
         Values
           (3413, 2093, 'gdapoldocAIICO_temp.rtf', 'GDAPOLICYDOCUMENT', 'DA Policy Document Template', 
            'gdapoldocAIICO_temp.xsl', NULL, 'A');
        COMMIT;

            
    end;
    /