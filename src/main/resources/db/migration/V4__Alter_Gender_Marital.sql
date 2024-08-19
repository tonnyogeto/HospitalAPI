ALTER TABLE person DROP COLUMN gender;

ALTER TABLE person DROP COLUMN marital_status;


DROP TYPE IF EXISTS public.maritalstatus;

DROP TYPE IF EXISTS public.gender;

ALTER TABLE person ADD gender VARCHAR(10) CHECK (gender IN('M', 'F', 'Other'));

ALTER TABLE person ADD marital_status VARCHAR(50) CHECK
(marital_status IN('married', 'separated', 'single', 'divorced', 'widowed'));

