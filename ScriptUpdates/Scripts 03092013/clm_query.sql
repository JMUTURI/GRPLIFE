begin
update lms_claims
set clm_status='OS'
where clm_no='2013/GLC0060';
commit;
end;