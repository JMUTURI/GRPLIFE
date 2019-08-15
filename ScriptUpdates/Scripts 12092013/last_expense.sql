UPDATE LMS_GRP_RIDER_DATA
SET LGRA_BEN_CODE='GLE'
WHERE LGRA_BEN_CODE='LE'


----
---DELETE EXISTING RECORDS-----
BEGIN

delete from LMS_MASTER_TRANSACTIONS
where MTRAN_LTR_TRANS_NO in (select LTR_TRANS_NO from LMS_TRANSACTIONS where LTR_POL_POLICY_NO='GL/2012/88');

delete from LMS_TRANSACTIONS
where LTR_POL_POLICY_NO='GL/2012/74';

delete from LMS_POLICY_MEMBER_COVERS
where pcm_pol_policy_no='GL/2012/74';

delete from LMS_POLICY_MEMBERS_ANB
where polma_polm_code in (select polm_code from lms_policy_members where polm_pol_policy_no='GL/2012/74');

delete from LMS_POLICY_COVER_TYPES
where pcvt_pol_policy_no='GL/2012/74';

DELETE FROM LMS_POLICY_MEMBERS
WHERE POLM_POL_POLICY_NO='GL/2012/74';

delete from LMS_POLICY_CATEGORIES
where pca_pol_policy_no='GL/2012/74';

DELETE FROM LMS_POL_DEPENDENT_LIMITS
WHERE PDL_POL_POLICY_NO='GL/2012/74';

delete from lms_policy_endorsements
where endr_pol_policy_no='GL/2012/74';

delete from lms_policies
where pol_policy_no='GL/2012/74';

COMMIT;

END;
/