DECLARE

CURSOR pst_period IS
            SELECT endr_pol_code, count(*)
            FROM lms_policy_endorsements, lms_policies
            WHERE endr_pol_code IN (SELECT endr_pol_code from 
                                    lms_policy_endorsements
                                    WHERE endr_past_period = 'Y'
                                    AND endr_status = 'EN')
            AND endr_pol_code = pol_code
            AND pol_cla_sht_desc = 'GRP'
            AND endr_authorized = 'A'
            GROUP BY endr_pol_code
            HAVING count(*) = 1;
 
v_curr_endr NUMBER;
v_endr_type VARCHAR2(10);

BEGIN

 FOR I IN pst_period
 LOOP
  
  BEGIN
   SELECT endr_code, endr_type
    INTO v_curr_endr, v_endr_type
   FROM lms_policy_endorsements
   WHERE endr_pol_code= I.endr_pol_code;
  EXCEPTION
  WHEN OTHERS THEN
    RAISE;
  END;
  
  IF v_curr_endr IS NOT NULL AND v_endr_type = 'NB'
  THEN
   UPDATE lms_policy_endorsements
    SET endr_status = 'A'
   WHERE endr_code = v_curr_endr;
   
   UPDATE lms_policy_member_covers
    SET pcm_status = 'A'
   WHERE pcm_endr_code = v_curr_endr;
   
   UPDATE lms_policy_members_anb
    SET polma_status = 'A'
   WHERE polma_endr_code = v_curr_endr;
   
   UPDATE lms_policies
    SET pol_authorised = 'A'
   WHERE pol_code = I.endr_pol_code;
   

  END IF;
 
  COMMIT;
 END LOOP;
END;

UPDATE lms_policy_endorsements
 SET endr_status = 'A'
WHERE endr_code = 2012483306

UPDATE lms_policies
 SET pol_current_endr_code = 2012483306
WHERE pol_code = 2011101

COMMIT