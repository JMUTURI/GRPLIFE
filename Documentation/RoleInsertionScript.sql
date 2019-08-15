/************************************************************************/
--PROCEDURE TO ADD PROCESSES AND PROCESS AREAS TO A ROLE.
--PARAMETERS:

-- 1. V_ROLE_SHT_DESC - ROLE SHORT DESCRIPTION.
-- 2. V_PROCESS_SHT_DESC - PROCESS SHORT DESCRIPTION.

/**********************************************************************/

DECLARE
CURSOR SubProcesses(v_proc NUMBER) IS
        SELECT *
        FROM TQC_SYS_PROCESS_SUB_AREAS
        WHERE sprsa_sprc_code = v_proc;

v_role_process    NUMBER;
v_curr_role       NUMBER;
v_curr_process    NUMBER;

v_cr_prole     BOOLEAN := FALSE;

BEGIN

 --IF PROCESS HAS NO PROCESS ROLE, CREATE ONE.
 SELECT srls_code INTO v_curr_role FROM TQC_SYS_ROLES WHERE srls_sht_desc = :V_ROLE_SHT_DESC AND srls_sys_code = 27;
 SELECT sprc_code INTO v_curr_process FROM TQC_SYS_PROCESSES WHERE sprc_sht_desc = :V_PROCESS_SHT_DESC AND sprc_sys_code = 27;
 
 BEGIN
  SELECT srprc_code
   INTO  v_role_process
  FROM TQC_SYS_ROLES_PROCESSES
  WHERE srprc_srls_code = v_curr_role
    AND srprc_sprc_code = v_curr_process;
 EXCEPTION
    WHEN NO_DATA_FOUND THEN
     v_cr_prole := TRUE;
    WHEN OTHERS THEN
        RAISE;
 END;
 
 IF v_cr_prole = TRUE
  THEN
   BEGIN
     TQC_ROLES_CURSOR.grantProcessRole(v_curr_process, v_curr_role, 'Y');
     COMMIT;
    
   EXCEPTION
    WHEN OTHERS THEN
     RAISE;
   END;
 END IF;
 
 --ASSIGN TO SUB-AREAS
 FOR I IN SubProcesses(v_curr_process)
  LOOP
      BEGIN
        TQC_ROLES_CURSOR.Grant_Role_Process_SubArea(I.sprsa_code,
                                                    v_curr_role,
                                                    9999999999999,
                                                    9999999999999);
        COMMIT;
      EXCEPTION
       WHEN OTHERS THEN
            RAISE;
      END;
  END LOOP;

END;

