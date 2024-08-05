
--
-- Name: gender; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.gender AS ENUM (
    'M',
    'F'
);


--
-- Name: marital_status; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.marital_status AS ENUM (
    'married',
    'single',
    'widowed',
    'separated',
    'divorced'
);


--
-- Name: maritalstatus; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE public.maritalstatus AS ENUM (
    'separated',
    'married',
    'single',
    'divorced',
    'widowed'
);


--
-- Name: father_child; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.father_child (
    father_child_id integer NOT NULL,
    father_id integer NOT NULL,
    child_id integer NOT NULL
);


--
-- Name: father_child_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.father_child_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- Name: father_child_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.father_child_id_seq OWNED BY public.father_child.father_child_id;


--
-- Name: mother_child; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.mother_child (
    mother_child_id integer NOT NULL,
    mother_id integer NOT NULL,
    child_id integer NOT NULL
);


--
-- Name: mother_child_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.mother_child_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- Name: mother_child_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.mother_child_id_seq OWNED BY public.mother_child.mother_child_id;


--
-- Name: person; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.person (
    person_id integer NOT NULL,
    name character varying(100) NOT NULL,
    registration_number character varying(50) NOT NULL,
    date_of_birth character varying(50) NOT NULL,
    gender public.gender NOT NULL,
    marital_status public.maritalstatus NOT NULL,
    weight integer NOT NULL
);


--
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.person_id_seq OWNED BY public.person.person_id;


--
-- Name: person_occupation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.person_occupation (
    person_occupation_id integer NOT NULL,
    person_id integer NOT NULL,
    occupation character varying(50) NOT NULL
);


--
-- Name: person_occupation_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.person_occupation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- Name: person_occupation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.person_occupation_id_seq OWNED BY public.person_occupation.person_occupation_id;


--
-- Name: person_place_of_birth; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.person_place_of_birth (
    person_place_of_birth_id integer NOT NULL,
    place_of_birth character varying(50) NOT NULL,
    person_id integer NOT NULL
);


--
-- Name: person_place_of_birth_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.person_place_of_birth_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 4294967296
    CACHE 1;


--
-- Name: person_place_of_birth_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.person_place_of_birth_seq OWNED BY public.person_place_of_birth.person_place_of_birth_id;


--
-- Name: father_child father_child_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.father_child
    ADD CONSTRAINT father_child_pkey PRIMARY KEY (father_child_id);


--
-- Name: mother_child mother_child_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mother_child
    ADD CONSTRAINT mother_child_pkey PRIMARY KEY (mother_child_id);


--
-- Name: person_occupation person_occupation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person_occupation
    ADD CONSTRAINT person_occupation_pkey PRIMARY KEY (person_occupation_id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (person_id);


--
-- Name: person_place_of_birth person_place_of_birth_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person_place_of_birth
    ADD CONSTRAINT person_place_of_birth_pkey PRIMARY KEY (person_place_of_birth_id);


--
-- Name: person person_registration_number_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_registration_number_key UNIQUE (registration_number);


--
-- Name: father_child father_child_child_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.father_child
    ADD CONSTRAINT father_child_child_id_fkey FOREIGN KEY (child_id) REFERENCES public.person(person_id);


--
-- Name: father_child father_child_father_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.father_child
    ADD CONSTRAINT father_child_father_id_fkey FOREIGN KEY (father_id) REFERENCES public.person(person_id);


--
-- Name: mother_child mother_child_child_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mother_child
    ADD CONSTRAINT mother_child_child_id_fkey FOREIGN KEY (child_id) REFERENCES public.person(person_id);


--
-- Name: mother_child mother_child_mother_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.mother_child
    ADD CONSTRAINT mother_child_mother_id_fkey FOREIGN KEY (mother_id) REFERENCES public.person(person_id);


--
-- Name: person_occupation person_occupation_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person_occupation
    ADD CONSTRAINT person_occupation_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- Name: person_place_of_birth person_place_of_birth_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.person_place_of_birth
    ADD CONSTRAINT person_place_of_birth_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- PostgreSQL database dump complete
--
