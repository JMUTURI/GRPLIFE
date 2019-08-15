=========================================Quotation Process=======================================
--SET DEFINE OFF;
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (28059, 28057, 'testquote3', 'pdkey', 'testquote3', 
    NULL);
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (28060, 28057, 'testquote3', 'pdid', 'testquote3-1', 
    NULL);
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (28061, 28057, 'testquote3', 'pdversion', NULL, 
    1);
COMMIT;

--SET DEFINE OFF;
Insert into JBPM4_LOB
   (DBID_, DBVERSION_, BLOB_VALUE_, DEPLOYMENT_, NAME_)
 Values
   (28058, 0, NULL, 28057, 'testquote3.jpdl.xml');
COMMIT;

==========================================Underwriting Process==============================================
--SET DEFINE OFF;
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (29643, 29641, 'UnderwriteProcess', 'pdkey', 'UnderwriteProcess', 
    NULL);
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (29644, 29641, 'UnderwriteProcess', 'pdversion', NULL, 
    1);
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (29645, 29641, 'UnderwriteProcess', 'pdid', 'UnderwriteProcess-1', 
    NULL);
COMMIT;


--SET DEFINE OFF;
Insert into JBPM4_LOB
   (DBID_, DBVERSION_, BLOB_VALUE_, DEPLOYMENT_, NAME_)
 Values
   (29642, 0, NULL, 29641, 'UnderwriteProcess.jpdl.xml');
COMMIT;

==================================Endorsements Process======================================================
--SET DEFINE OFF;
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (33864, 33861, 'EndorsementsProcess', 'pdid', 'EndorsementsProcess-1', 
    NULL);
Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (33865, 33861, 'EndorsementsProcess', 'pdkey', 'EndorsementsProcess', 
    NULL);
COMMIT;

Insert into JBPM4_DEPLOYPROP
   (DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_, 
    LONGVAL_)
 Values
   (33863, 33861, 'EndorsementsProcess', 'pdversion', NULL, 
    1);
COMMIT;


--SET DEFINE OFF;
Insert into JBPM4_LOB
   (DBID_, DBVERSION_, BLOB_VALUE_, DEPLOYMENT_, NAME_)
 Values
   (33862, 0, NULL, 33861, 'EndorsementsProcess.jpdl.xml');
COMMIT;


===========================================Claims Process==========================================================

--SET DEFINE OFF;
Insert into JBPM4_DEPLOYMENT
(DBID_, NAME_, TIMESTAMP_, STATE_)
Values
(65444, NULL, 0, 'active');
COMMIT;

--SET DEFINE OFF;
Insert into JBPM4_DEPLOYPROP
(DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_,
LONGVAL_)
Values
(65446, 65444, 'ClaimsProcessingGroup', 'pdversion', NULL,
2);
Insert into JBPM4_DEPLOYPROP
(DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_,
LONGVAL_)
Values
(65447, 65444, 'ClaimsProcessingGroup', 'pdkey', 'ClaimsProcessingGroup',
NULL);
Insert into JBPM4_DEPLOYPROP
(DBID_, DEPLOYMENT_, OBJNAME_, KEY_, STRINGVAL_,
LONGVAL_)
Values
(65448, 65444, 'ClaimsProcessingGroup', 'pdid', 'ClaimsProcessingGroup-2',
NULL);
COMMIT;

--SET DEFINE OFF;
Insert into JBPM4_LOB
(DBID_, DBVERSION_, BLOB_VALUE_, DEPLOYMENT_, NAME_)
Values
(65445, 0, NULL, 65444, 'ClaimsProcessingGroup.jpdl.xml');
COMMIT;