DECLARE

CURSOR endorsements
IS
 SELECT * 
 FROM LMS_POLICY_ENDORSEMENTS,LMS_POLICIES
 WHERE ENDR_POL_CODE=POL_CODE
 AND POL_PROD_CODE=2013203
 AND ENDR_TYPE IN ('NB','RN')
 AND ENDR_STATUS='A';
 
CURSOR prodCoverType
IS 
SELECT * 
FROM LMS_PROD_COVER_TYPES,LMS_COVER_TYPES
WHERE  PCT_CVT_CODE=CVT_CODE
AND PCT_PROD_CODE=2013203
AND PCT_CODE=2014544;

CURSOR polMem(v_endr_code NUMBER)
IS 
SELECT * FROM LMS_POLICY_MEMBERS
WHERE POLM_ENDR_CODE=v_endr_code;

v_cvt_code NUMBER;
v_count    NUMBER    :=0;
v_cat_code NUMBER;
v_pcvt1_code  NUMBER;
v_cover_count NUMBER;

BEGIN

    FOR C IN endorsements
    LOOP
              
      BEGIN
        select COUNT(*),PCVT_CODE 
        into v_count,v_pcvt1_code
         from LMS_POLICY_COVER_TYPES
         where pcvt_endr_code=C.ENDR_CODE
         and pcvt_cvt_sht_desc='GLE2';         
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
          v_count :=0;
         WHEN OTHERS THEN
         v_count :=NULL;
           
      END;
      
       BEGIN
           
            SELECT PCA_CODE
            INTO v_cat_code
            FROM LMS_POLICY_CATEGORIES
            WHERE PCA_ENDR_CODE=C.ENDR_CODE;  
         EXCEPTION
         WHEN OTHERS THEN
         v_cat_code :=NULL;
         
        END;
        
         
               
            FOR C1 IN prodCoverType
             LOOP
             IF v_count=0 THEN
             
                  BEGIN
                          SELECT TO_NUMBER (TO_CHAR (SYSDATE, 'YYYY'))
                                 || lms_pcvt_code_seq.NEXTVAL
                            INTO v_pcvt1_code
                            FROM DUAL;

                          INSERT
                            INTO lms_policy_cover_types (pcvt_code,
                                                         pcvt_wef,
                                                         pcvt_endr_code,
                                                         pcvt_pol_code,
                                                         pcvt_pol_policy_no,
                                                         pcvt_pmas_code,
                                                         pcvt_pmas_sht_desc,
                                                         pcvt_cvt_code,
                                                         pcvt_cvt_sht_desc,
                                                         pcvt_main_rider,
                                                         pcvt_formular,
                                                         pcvt_pct_code,
                                                         pcvt_refund_formular,
                                                         pcvt_wet,
                                                         pcvt_duration_type,
                                                         pcvt_dty_code,
                                                         pcvt_disc_load_rate,
                                                         pcvt_load_disc,
                                                         pcvt_but_charge_premium,
                                                         pcvt_sa,
                                                         pcvt_avg_anb,
                                                         pcvt_avg_mem_earn,
                                                         pcvt_main_sa_perc,
                                                         pcvt_main_cover,
                                                         pcvt_accelerator,
                                                         pcvt_status
                                                         )
                          VALUES (v_pcvt1_code,
                                  C.endr_cover_from_date,
                                  C.ENDR_CODE,
                                  C.POL_CODE,
                                  C.POL_POLICY_NO,
                                  C.ENDR_PMAS_CODE,
                                  NULL,
                                  C1.cvt_code,
                                  C1.cvt_sht_desc,
                                  C1.cvt_main_cover,
                                  C1.pct_formular,
                                  C1.pct_code,
                                  C1.pct_refund_formular,
                                  C.endr_cover_to_date,
                                  C1.cvt_duration_type,
                                  NVL (NULL, 1000),
                                  NULL,
                                  'N',
                                  NULL,
                                  NVL (NULL, 0),
                                  NVL (NULL, 0),
                                  0,
                                  C1.PCT_MAIN_SA_PERC,
                                  C1.CVT_MAIN_COVER,
                                  C1.PCT_ACCELERATOR,
                                  'A');
                           
                     END; 
                     
               END IF;           
                                
                FOR  polMemRec IN polMem(C.ENDR_CODE)
                LOOP
                     BEGIN
               
                        SELECT COUNT(*)
                            INTO v_cover_count
                            FROM LMS_POLICY_MEMBER_COVERS
                            WHERE PCM_POLM_CODE=polMemRec.POLM_CODE
                            AND PCM_PCVT_CVT_CODE=2014260;  
                         EXCEPTION
                         WHEN OTHERS THEN
                         v_cover_count :=0;
                         
                        END;
                        
                    IF v_cat_code IS NOT NULL THEN
                     IF v_cover_count=0
                     THEN
                     BEGIN
                     INSERT INTO lms_policy_member_covers
                                                     (pcm_code,
                                                      pcm_endr_code,
                                                      pcm_endr_no,
                                                      pcm_pol_code,
                                                      pcm_pol_policy_no,
                                                      pcm_polm_code,
                                                      pcm_pcvt_code,
                                                      pcm_sa, pcm_premium,
                                                      pcm_loan_issue_date,
                                                      pcm_rate,
                                                      pcm_saving_amt,
                                                      pcm_nof_members, pcm_dty_code,
                                                      pcm_principal_mem_code,
                                                      pcm_dty_sht_desc,
                                                      pcm_pcvt_cvt_code,
                                                      pcm_original_loan_amt,
                                                      pcm_earnings,
                                                      pcm_mult_earnings_prd,
                                                      pcm_orig_loan_repayment_prd,
                                                      pcm_loan_int,
                                                      pcm_cover_wef_date,
                                                      pcm_cover_wet_date,
                                                      pcm_prev_pcm_code,
                                                      pcm_main_rider,
                                                      pcm_schedule_no,
                                                      pcm_calc_type, pcm_sa_b4_fcl,
                                                      pcm_basic_sal,
                                                      pcm_house_allow,
                                                      pcm_trans_allow,
                                                      pcm_other_allow,
                                                      pcm_pca_code,
                                                      pcm_prev_prem,
                                                      pcm_status
                                                     )
                                              VALUES (   TO_NUMBER (TO_CHAR (SYSDATE,
                                                                             'YYYY'
                                                                            )
                                                                   )
                                                      || lms_pcm_code_seq.NEXTVAL,
                                                      C.ENDR_CODE,
                                                      '001',
                                                      C.POL_CODE,
                                                      C.POL_POLICY_NO,
                                                      polMemRec.POLM_CODE,
                                                      v_pcvt1_code,
                                                      50000,
                                                      0,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      0, 1000,
                                                      polMemRec.POLM_MEM_CODE,
                                                      'SELF',
                                                      C1.CVT_CODE,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      C.endr_cover_from_date,
                                                      C.endr_cover_to_date,
                                                      NULL,
                                                      C1.CVT_MAIN_COVER,
                                                      C.ENDR_NO,
                                                      'N', 0,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      NULL,
                                                      v_cat_code,
                                                      NULL,
                                                      'A'
                                                     );
              
                     
                     END;
                    END IF;
                   END IF;
                END LOOP;
                          
             END LOOP;  


    END LOOP;
 COMMIT;    
END;
/