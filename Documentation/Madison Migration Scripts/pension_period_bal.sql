DECLARE 
v_count  NUMBER :=0;
v_int_rate NUMBER := 0;

CURSOR CUR
IS 
SELECT lms_pension_balances.* 
FROM lms_pension_balances,lms_policies
WHERE pnbal_pol_code=pol_code
AND pol_cla_code=20022;

BEGIN
    FOR C IN CUR
    LOOP
        BEGIN
            SELECT COUNT(*)
            INTO v_count
            FROM lms_pension_balances_periods
            WHERE pnbalp_year=C.pnbal_year
            AND   pnbalp_pol_code=C.pnbal_pol_code;
        EXCEPTION
        WHEN NO_DATA_FOUND
        THEN
        v_count :=0;
        END;
        
        IF v_count=0
        THEN
        v_int_rate :=C.pnbal_interest_rate;
        
            BEGIN
            INSERT INTO lms_pension_balances_periods
            (pnbalp_code,pnbalp_empye_amt,pnbalp_empyr_amt,
             pnbalp_empye_bal_bf,pnbalp_empyr_bal_bf,
             pnbalp_empye_bal_cf,pnbalp_empyr_bal_cf,
             pnbalp_empye_bal_income,pnbalp_empyr_bal_income,
             pnbalp_empye_cntri_income,pnbalp_empyr_cntri_income,
             pnbalp_interest,pnbalp_interest_rate,
             pnbalp_status,pnbalp_tot_bal_cf,
             pnbalp_valua_date,pnbalp_year,pnbalp_pol_code,pnbalp_wef,pnbalp_wet)
            VALUES(lms_pnbalp_code_seq.NEXTVAL,C.pnbal_empye_amt,C.pnbal_empyr_amt,
                    C.pnbal_empye_bal_bf,C.pnbal_empyr_bal_bf,C.pnbal_empye_bal_cf,C.pnbal_empyr_bal_cf,
                    C.pnbal_empye_bal_income,C.pnbal_empyr_bal_income,
                    C.pnbal_empye_cntri_income,C.pnbal_empyr_cntri_income,C.pnbal_interest,
                    C.pnbal_interest_rate,'A',NVL(C.pnbal_empye_bal_cf,0)+NVL(C.pnbal_empyr_bal_cf,0),
                    C.pnbal_valua_date,C.pnbal_year,
                    C.pnbal_pol_code,TO_DATE('01/01/'||C.pnbal_year,'DD/MM/RRRR'),
                    NVL(C.pnbal_valua_date,TO_DATE('31/12/'||C.pnbal_year,'DD/MM/RRRR'))
                    );
            END;
                                               
        END IF;
      
       BEGIN
       UPDATE lms_pension_balances
       SET pnbal_status='A'
       WHERE pnbal_year=c.pnbal_year
       AND pnbal_pol_code=C.pnbal_pol_code;       
       END;  
        
    END LOOP; 
    COMMIT;
END;

