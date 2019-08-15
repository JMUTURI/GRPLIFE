 BEGIN
    
    Insert into TQC_SYSTEM_REPORTS
       (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
        RPT_APPLCTN_LEVEL, RPT_ACTIVE)
     Values
       (2269, 27, 'REIN_PREM_BOUDREAUX_GL', 'Reinsurance Premium Boudreax Group Life', 'rein_prem_boudreax.xml', 
        NULL, 'A');
    Insert into TQC_SYS_RPT_TEMPLATES
       (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
        RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
     Values
       (3607, 2269, 'rein_prem_boudreax_temp.rtf', 'REIN_PREM_BOUDREAUX_GL', 'Reinsurance Premium Boudreax Group Life', 
        'rein_prem_boudreax_temp.xsl', NULL, 'A');
        
        Insert into TQC_SYS_RPT_PARAMETERS
       (RPTP_CODE, RPTP_RPT_CODE, RPTP_PARAM_NAME, RPTP_PARAM_DESC, RPTP_PARAM_PROMPT, 
        RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY, RPTP_PARAM_CLAUSE, RPTP_USER_REQUIRED, 
        RPTP_CHILD_CODE, RPTP_PARAM_ACTIVE)
     Values
       (25191, 2269, 'V_DATE_FROM', 'DATE FROM', 'Date From', 
        'DATE', NULL, NULL, NULL, NULL, 
        NULL, 'A');
    Insert into TQC_SYS_RPT_PARAMETERS
       (RPTP_CODE, RPTP_RPT_CODE, RPTP_PARAM_NAME, RPTP_PARAM_DESC, RPTP_PARAM_PROMPT, 
        RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY, RPTP_PARAM_CLAUSE, RPTP_USER_REQUIRED, 
        RPTP_CHILD_CODE, RPTP_PARAM_ACTIVE)
     Values
       (25192, 2269, 'V_DATE_TO', 'DATE TO', 'Date To', 
        'DATE', NULL, NULL, NULL, NULL, 
        NULL, 'A');
    COMMIT;
        
    END;
    /