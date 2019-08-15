DECLARE
    CURSOR POLICIES IS
        SELECT DISTINCT PCM_POLM_CODE, PCM_POL_CODE, PCM_ENDR_CODE, POLM_ANB, ENDR_TYPE, POLM_MEM_STATUS
        FROM LMS_POLICY_MEMBER_COVERS, LMS_POLICY_ENDORSEMENTS, LMS_POLICY_MEMBERS
        WHERE PCM_ENDR_CODE = ENDR_CODE
            AND POLM_CODE = PCM_POLM_CODE
            AND POLM_ANB  IS NOT NULL
            AND POLM_CODE NOT IN (SELECT POLMA_POLM_CODE FROM LMS_POLICY_MEMBERS_ANB);
    
   v_cnt NUMBER;
BEGIN
    FOR I IN POLICIES LOOP
           v_cnt := 0;
           
           BEGIN
                SELECT COUNT(*)
                    INTO v_cnt
                  FROM LMS_POLICY_MEMBERS_ANB
                  WHERE POLMA_POLM_CODE = I.PCM_POLM_CODE
                      AND POLMA_ENDR_CODE = I.PCM_ENDR_CODE;
           EXCEPTION
                WHEN NO_DATA_FOUND THEN
                    v_cnt := 0;
                WHEN OTHERS THEN
                    RAISE;
           END;
           
           IF v_cnt = 0 THEN
               BEGIN
                  INSERT INTO LMS_POLICY_MEMBERS_ANB(POLMA_CODE, 
                                                       POLMA_POL_CODE, 
                                                       POLMA_ENDR_CODE, 
                                                       POLMA_POLM_CODE, 
                                                       POLMA_ANB,
                                                       POLMA_STATUS)
                                           VALUES(LMS_POLMA_CODE_SEQ.NEXTVAL, 
                                                       I.PCM_POL_CODE, 
                                                       I.PCM_ENDR_CODE,
                                                       I.PCM_POLM_CODE, 
                                                       I.POLM_ANB,
                                                       DECODE(I.POLM_MEM_STATUS, 'R', 'R', 'A'));
               EXCEPTION
                    WHEN OTHERS THEN
                       RAISE;
               END;
           END IF;
    END LOOP;
END;

DECLARE
    CURSOR POLICIES IS
            SELECT PCM_POLM_CODE, PCM_ENDR_CODE, PCA_SHT_DESC, PCM_CODE
            FROM LMS_POLICY_MEMBER_COVERS, LMS_POLICY_MEMBERS, LMS_POLICY_CATEGORIES
            WHERE POLM_CODE = PCM_POLM_CODE
                AND POLM_PCA_CODE = PCA_CODE
                AND PCM_PCA_CODE IS NULL
                AND POLM_PCA_CODE IS NOT NULL;
   
v_pca_code NUMBER;
BEGIN
    FOR I IN POLICIES LOOP
        
        v_pca_code := 0;
        
        BEGIN
            SELECT PCA_CODE
                INTO v_pca_code
              FROM LMS_POLICY_CATEGORIES
              WHERE PCA_ENDR_CODE = I.PCM_ENDR_CODE
                  AND PCA_SHT_DESC = I.PCA_SHT_DESC;
         EXCEPTION
            WHEN NO_DATA_FOUND THEN
                v_pca_code := 0;
            WHEN OTHERS THEN
                RAISE;
        END;
        
        IF NVL(v_pca_code,0) <> 0 THEN
            UPDATE LMS_POLICY_MEMBER_COVERS
                SET PCM_PCA_CODE = v_pca_code
            WHERE PCM_CODE = I.PCM_CODE;
        END IF;
    END LOOP;
END;

COMMIT;
  