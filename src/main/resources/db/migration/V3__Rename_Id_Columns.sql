ALTER TABLE IF EXISTS public.father_child RENAME COLUMN father_child_id TO id;
ALTER TABLE IF EXISTS public.mother_child RENAME COLUMN mother_child_id TO id;
ALTER TABLE IF EXISTS public.person RENAME COLUMN person_id TO id;
ALTER TABLE IF EXISTS public.person_occupation RENAME COLUMN person_occupation_id TO id;
ALTER TABLE IF EXISTS public.person_place_of_birth RENAME COLUMN person_place_of_birth_id TO id;
