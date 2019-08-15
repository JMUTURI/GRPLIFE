ALTER TABLE TQ_LMS.LMS_QUOTATIONS
ADD (quo_orig_quo_code NUMBER)

COMMENT ON COLUMN 
TQ_LMS.LMS_QUOTATIONS.quo_orig_quo_code IS 
'original quotation code';