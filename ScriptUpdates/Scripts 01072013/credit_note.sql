BEGIN
 INSERT INTO TQC_SYS_RPT_TEMPLATES ( RPT_TMPL_CODE, RPT_TMPL_RPT_CODE, RPT_TMPL_FILE, RPT_TMPL_NAME,
        RPT_TMPL_DESCRIPTION, RPT_TMPL_STYLE_FILE ) VALUES (
        3458,1458, 'creditnote_Apollo_temp.rtf', 'CREDIT_NOTE_RPT',
       'Apollo credit note', 'creditnote_Apollo_temp.xsl');      
commit;      

END;