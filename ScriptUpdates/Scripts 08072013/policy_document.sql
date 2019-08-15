BEGIN
    Insert into TQC_SYS_RPT_TEMPLATES
       (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
        RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
     Values
       (3475, 999, 'glaPolDocApollo_temp.rtf', 'GLA_POLDOC_APOLLO_TMP', 'Group Life Policy Document', 
        'glaPolDocApollo_temp.xsl', NULL, 'A');    
     COMMIT; 
    END;