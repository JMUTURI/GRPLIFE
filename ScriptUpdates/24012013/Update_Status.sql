begin
update lms_policy_member_covers
set pcm_status='E'
where pcm_endr_code=2012233387
and pcm_polm_code=20121893931;
COMMIT;
end;
/