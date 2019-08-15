DECLARE
CURSOR C1 IS
SELECT a.*
            FROM (SELECT tqc_bpm_tickets.tckt_code,
                         DECODE(tqc_bpm_tickets.tckt_sys_code,
                                37,
                                'GENERAL INSURANCE SYSTEM',
                                27,
                                'LIFE MANAGEMENT SYSTEM',
                                26, 
                                'LIFE MANAGEMENT SYSTEM-LIFE',
                                1,
                                'FINANCIAL MANAGEMENT SYSTEM',
                                0,
                                'CUSTOMER RELATIONSHIP MANAGEMENT SYSTEM') usrsystem,
                         DECODE(tqc_bpm_tickets.tckt_sys_module,
                                'Q',
                                'Quotation',
                                'P',
                                'Underwriting',
                                'C',
                                'Claims') sysmodule,
                         tqc_bpm_tickets.tckt_clnt_code,
                         (clnt_name || ' ' || clnt_other_names) client,
                         tqc_bpm_tickets.tckt_agn_code,
                         agn_name AGENT,
                         tqc_bpm_tickets.tckt_pol_code,
                         tqc_bpm_tickets.tckt_pol_no,
                         tqc_bpm_tickets.tckt_clm_no,
                         tqc_bpm_tickets.tckt_quot_code,
                         tqc_bpm_tickets.tckt_quo_no,
                         tqc_bpm_tickets.tckt_by,
                         tqc_bpm_tickets.tckt_date,
                         tqc_bpm_tickets.tckt_process_id,
                         tqc_bpm_tickets.tckt_sys_module sys_module_code,
                         tckt_endr_code,
                         tckt_prod_type,
                         tckt_to,
                         tckt_remarks,
                         name_ tckt_name,
                         duedate_ tckt_due_date,
                         tckt_endorsement,
                         tckt_transno,
                         DECODE(tckt_sys_module,
                                'Q',
                                tckt_quo_no,
                                'C',
                                tckt_clm_no,
                                tckt_pol_no) ref_no,
                         tckt_prp_code,
                         NULL pol_client_policy_number,
                         tckt_type,
                         NULL POLICY_STATUS,
                         TCKT_TRAN_EFF_DATE,
                         TCKT_GGT_NO,
                         NULL USR_TYPE
                    FROM tqc_bpm_tickets,
                         tqc_clients,
                         tqc_agencies,
                         jbpm4_task,
                         lms_policies
                   WHERE tqc_bpm_tickets.tckt_clnt_code = clnt_code(+)
                     AND tckt_pol_code = pol_code
                        --AND PRP_CLNT_CODE = CLNT_CODE(+)
                     AND agn_code(+) = tqc_bpm_tickets.tckt_agn_code
                     AND dbid_ = tqc_bpm_tickets.tckt_code
                     AND NAME_ ='Perform Reinsurance'
                     --AND tckt_pol_code = NVL(2012240432, tckt_pol_code)
                     AND tckt_active != 'N'
                     AND tckt_sys_code = NVL(27, 2013261601)
                   ORDER BY tqc_bpm_tickets.tckt_code DESC) a
           WHERE ref_no IS NOT NULL; 
           
   
BEGIN  

FOR  CUR IN C1
LOOP       
DELETE FROM jbpm4_task WHERE DBID_=CUR.TCKT_CODE;
DELETE FROM tqc_bpm_tickets WHERE TCKT_CODE=CUR.TCKT_CODE;
END LOOP;   
commit;      
END;  