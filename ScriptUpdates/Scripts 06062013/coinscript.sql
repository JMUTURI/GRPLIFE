    DECLARE
                       v_pol_coin_agn_code number;  
                       v_pol_code  NUMBER;                      
                                         
                       CURSOR C2(v_pol_code number)
                        IS
                          SELECT * FROM LMS_POLICY_COINSURERS
                          WHERE POL_COIN_POL_CODE=v_pol_code;
                                               
                         BEGIN
                              begin
                                   select pol_code into v_pol_code
                                   from lms_policies
                                   where pol_policy_no='UACL/LGB/010';
                              end;
                               
                           FOR C IN C2(v_pol_code)
                           LOOP                                 
                              
                                                        
                               begin
                               select agn_code into
                               v_pol_coin_agn_code
                               from lms_agencies
                               where agn_sht_desc=to_char(C.pol_coin_agn_code);                           
                               end;
                               
                               update LMS_POLICY_COINSURERS
                               set pol_coin_agn_code=v_pol_coin_agn_code
                               where pol_coin_code=c.pol_coin_code;                              
                            
                           END LOOP;                           
                          END;
                          /