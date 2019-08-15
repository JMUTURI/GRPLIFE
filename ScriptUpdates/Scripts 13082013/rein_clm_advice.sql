begin
Insert into TQC_SYSTEM_REPORTS
   (RPT_CODE, RPT_SYS_CODE, RPT_NAME, RPT_DESCRIPTION, RPT_DATA_FILE, 
    RPT_APPLCTN_LEVEL, RPT_ACTIVE)
 Values
   (2240, 27, 'REINSURANCE_CLAIM_ADVICE', 'Reinsurance Claim advice', 'rein_clm_advice.xml', 
    NULL, 'A');
Insert into TQC_SYS_RPT_TEMPLATES
   (RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME, RPT_TMPL_DESCRIPTION, 
    RPT_TMPL_STYLE_FILE, RPT_TMPL_ORG_CODE, RPT_TMPL_ACTIVE)
 Values
   (3583, 2240, 'rein_clm_advice_temp.rtf', 'REINSURANCE_CLAIM_ADVICE', 'Reinsurance Claim advice Template', 
    'rein_clm_advice_temp.xsl', NULL, 'A');
COMMIT;
end;
/