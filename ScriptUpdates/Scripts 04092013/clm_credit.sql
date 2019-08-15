BEGIN
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2281, 27, 'CREDIT_CLAIM_REGISTER', 'Credit Claim Register', 'clm_credit.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3619, 2281, 'clm_credit_temp.rtf', 'CREDIT_CLAIM_REGISTER', 'Credit Claim Register Template', 
    'clm_credit_temp.xsl', NULL, 'A');
Insert into TQC_SYS_RPT_PARAMETERS
   (RPTP_CODE, RPTP_RPT_CODE, RPTP_PARAM_NAME, RPTP_PARAM_DESC, RPTP_PARAM_PROMPT, 
    RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY, RPTP_PARAM_CLAUSE, RPTP_USER_REQUIRED, 
    RPTP_CHILD_CODE, RPTP_PARAM_ACTIVE)
 Values
   (25214, 2281, 'GRP_CLIENT', 'Group Clients', 'Group Clients', 
    'LOV', NULL, 'SELECT prp_code, prp_surname || '' '' || prp_other_names client
FROM lms_proposers, lms_grp_class_occupations, lms_life_classes
WHERE gco_code(+) = prp_gco_code
AND gco_lc_code = lc_code(+)
AND prp_class_type = ''G''', NULL, NULL, 
    NULL, 'A');
COMMIT;

END;
/
