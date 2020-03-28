--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-03-24 19:07:27

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 228 (class 1259 OID 25609)
-- Name: caracteristique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique (
    caracteristique_id integer NOT NULL,
    nom character varying NOT NULL,
    definition character varying NOT NULL
);


ALTER TABLE public.caracteristique OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 25607)
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caracteristique_caracteristique_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caracteristique_caracteristique_id_seq OWNER TO postgres;

--
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 227
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caracteristique_caracteristique_id_seq OWNED BY public.caracteristique.caracteristique_id;


--
-- TOC entry 229 (class 1259 OID 25618)
-- Name: caracteristique_voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique_voie (
    voie_id integer NOT NULL,
    caracteristique_id integer NOT NULL
);


ALTER TABLE public.caracteristique_voie OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 25472)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    commentaire_id integer NOT NULL,
    commentaire character varying NOT NULL,
    users_username character varying NOT NULL,
    reference_id integer NOT NULL,
    date_publication date NOT NULL,
    ref_id integer NOT NULL,
    valide boolean NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 25470)
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 3008 (class 0 OID 0)
-- Dependencies: 203
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_commentaire_id_seq OWNED BY public.commentaire.commentaire_id;


--
-- TOC entry 224 (class 1259 OID 25587)
-- Name: cotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cotation (
    cotation_id integer NOT NULL,
    valeur character varying NOT NULL
);


ALTER TABLE public.cotation OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25585)
-- Name: cotation_cotation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cotation_cotation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cotation_cotation_id_seq OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 223
-- Name: cotation_cotation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cotation_cotation_id_seq OWNED BY public.cotation.cotation_id;


--
-- TOC entry 210 (class 1259 OID 25511)
-- Name: departement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement (
    code integer NOT NULL,
    nom character varying NOT NULL,
    region_id integer NOT NULL
);


ALTER TABLE public.departement OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 25494)
-- Name: description; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.description (
    description_id integer NOT NULL,
    description character varying NOT NULL,
    info character varying NOT NULL
);


ALTER TABLE public.description OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 25492)
-- Name: description_description_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.description_description_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.description_description_id_seq OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 207
-- Name: description_description_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.description_description_id_seq OWNED BY public.description.description_id;


--
-- TOC entry 201 (class 1259 OID 25453)
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    photo_id integer NOT NULL,
    nom character varying NOT NULL,
    ref_id integer NOT NULL,
    reference_id integer NOT NULL
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 25451)
-- Name: photo_photo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.photo_photo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.photo_photo_id_seq OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 200
-- Name: photo_photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.photo_photo_id_seq OWNED BY public.photo.photo_id;


--
-- TOC entry 199 (class 1259 OID 25442)
-- Name: reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference (
    reference_id integer NOT NULL,
    valeur character varying NOT NULL
);


ALTER TABLE public.reference OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 25440)
-- Name: reference_reference_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reference_reference_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reference_reference_id_seq OWNER TO postgres;

--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 198
-- Name: reference_reference_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reference_reference_id_seq OWNED BY public.reference.reference_id;


--
-- TOC entry 209 (class 1259 OID 25503)
-- Name: region; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.region (
    region_id integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 25576)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    secteur_id integer NOT NULL,
    nom character varying NOT NULL,
    site_id integer NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 25574)
-- Name: secteur_secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_secteur_id_seq OWNER TO postgres;

--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 221
-- Name: secteur_secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_secteur_id_seq OWNED BY public.secteur.secteur_id;


--
-- TOC entry 216 (class 1259 OID 25543)
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site (
    site_id integer NOT NULL,
    nom character varying NOT NULL,
    officiel boolean NOT NULL,
    type_roche_id integer NOT NULL,
    region_id integer NOT NULL,
    departement_code integer NOT NULL,
    ville_id integer NOT NULL,
    description_id integer NOT NULL
);


ALTER TABLE public.site OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 25541)
-- Name: site_site_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.site_site_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_site_id_seq OWNER TO postgres;

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 215
-- Name: site_site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_site_id_seq OWNED BY public.site.site_id;


--
-- TOC entry 197 (class 1259 OID 25431)
-- Name: statut; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statut (
    id integer NOT NULL,
    etat character varying NOT NULL
);


ALTER TABLE public.statut OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 25429)
-- Name: statut_statut_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.statut_statut_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.statut_statut_id_seq OWNER TO postgres;

--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 196
-- Name: statut_statut_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.statut_statut_id_seq OWNED BY public.statut.id;


--
-- TOC entry 218 (class 1259 OID 25554)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    topo_id integer NOT NULL,
    nom character varying NOT NULL,
    date_parution date NOT NULL,
    site_id integer NOT NULL,
    username character varying NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 25565)
-- Name: topo_reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo_reservation (
    reservation_id integer NOT NULL,
    reservation_date date NOT NULL,
    reservation_topo_id integer NOT NULL,
    username character varying NOT NULL,
    statut_id integer NOT NULL
);


ALTER TABLE public.topo_reservation OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 25563)
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_reservation_reservation_id_seq OWNER TO postgres;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 219
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_reservation_reservation_id_seq OWNED BY public.topo_reservation.reservation_id;


--
-- TOC entry 217 (class 1259 OID 25552)
-- Name: topo_topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_topo_id_seq OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 217
-- Name: topo_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;


--
-- TOC entry 214 (class 1259 OID 25532)
-- Name: type_roche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_roche (
    type_roche_id integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.type_roche OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 25530)
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_roche_type_roche_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_roche_type_roche_id_seq OWNER TO postgres;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 213
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_roche_type_roche_id_seq OWNED BY public.type_roche.type_roche_id;


--
-- TOC entry 206 (class 1259 OID 25483)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    user_role_id integer NOT NULL,
    username character varying NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 25481)
-- Name: user_role_user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_role_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_role_user_role_id_seq OWNER TO postgres;

--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 205
-- Name: user_role_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_role_user_role_id_seq OWNED BY public.user_roles.user_role_id;


--
-- TOC entry 202 (class 1259 OID 25462)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying NOT NULL,
    password character varying NOT NULL,
    email character varying NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 25521)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    ville_id integer NOT NULL,
    nom character varying NOT NULL,
    departement_code integer NOT NULL
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 25519)
-- Name: ville_ville_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ville_ville_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ville_ville_id_seq OWNER TO postgres;

--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 211
-- Name: ville_ville_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ville_ville_id_seq OWNED BY public.ville.ville_id;


--
-- TOC entry 226 (class 1259 OID 25598)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    voie_id integer NOT NULL,
    nom character varying NOT NULL,
    hauteur integer NOT NULL,
    secteur_id integer NOT NULL,
    cotation_id integer NOT NULL
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 25596)
-- Name: voie_voie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_voie_id_seq OWNER TO postgres;

--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 225
-- Name: voie_voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_voie_id_seq OWNED BY public.voie.voie_id;


--
-- TOC entry 2817 (class 2604 OID 25612)
-- Name: caracteristique caracteristique_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique ALTER COLUMN caracteristique_id SET DEFAULT nextval('public.caracteristique_caracteristique_id_seq'::regclass);


--
-- TOC entry 2806 (class 2604 OID 25475)
-- Name: commentaire commentaire_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN commentaire_id SET DEFAULT nextval('public.commentaire_commentaire_id_seq'::regclass);


--
-- TOC entry 2815 (class 2604 OID 25590)
-- Name: cotation cotation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation ALTER COLUMN cotation_id SET DEFAULT nextval('public.cotation_cotation_id_seq'::regclass);


--
-- TOC entry 2808 (class 2604 OID 25497)
-- Name: description description_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.description ALTER COLUMN description_id SET DEFAULT nextval('public.description_description_id_seq'::regclass);


--
-- TOC entry 2805 (class 2604 OID 25456)
-- Name: photo photo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo ALTER COLUMN photo_id SET DEFAULT nextval('public.photo_photo_id_seq'::regclass);


--
-- TOC entry 2804 (class 2604 OID 25445)
-- Name: reference reference_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference ALTER COLUMN reference_id SET DEFAULT nextval('public.reference_reference_id_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 25579)
-- Name: secteur secteur_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN secteur_id SET DEFAULT nextval('public.secteur_secteur_id_seq'::regclass);


--
-- TOC entry 2811 (class 2604 OID 25546)
-- Name: site site_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN site_id SET DEFAULT nextval('public.site_site_id_seq'::regclass);


--
-- TOC entry 2803 (class 2604 OID 25434)
-- Name: statut id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut ALTER COLUMN id SET DEFAULT nextval('public.statut_statut_id_seq'::regclass);


--
-- TOC entry 2812 (class 2604 OID 25557)
-- Name: topo topo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN topo_id SET DEFAULT nextval('public.topo_topo_id_seq'::regclass);


--
-- TOC entry 2813 (class 2604 OID 25568)
-- Name: topo_reservation reservation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.topo_reservation_reservation_id_seq'::regclass);


--
-- TOC entry 2810 (class 2604 OID 25535)
-- Name: type_roche type_roche_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche ALTER COLUMN type_roche_id SET DEFAULT nextval('public.type_roche_type_roche_id_seq'::regclass);


--
-- TOC entry 2807 (class 2604 OID 25486)
-- Name: user_roles user_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles ALTER COLUMN user_role_id SET DEFAULT nextval('public.user_role_user_role_id_seq'::regclass);


--
-- TOC entry 2809 (class 2604 OID 25524)
-- Name: ville ville_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville ALTER COLUMN ville_id SET DEFAULT nextval('public.ville_ville_id_seq'::regclass);


--
-- TOC entry 2816 (class 2604 OID 25601)
-- Name: voie voie_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN voie_id SET DEFAULT nextval('public.voie_voie_id_seq'::regclass);


--
-- TOC entry 2853 (class 2606 OID 25617)
-- Name: caracteristique caracteristique_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique
    ADD CONSTRAINT caracteristique_pk PRIMARY KEY (caracteristique_id);


--
-- TOC entry 2855 (class 2606 OID 25622)
-- Name: caracteristique_voie caracteristique_voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_voie_pk PRIMARY KEY (voie_id, caracteristique_id);


--
-- TOC entry 2827 (class 2606 OID 25480)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (commentaire_id);


--
-- TOC entry 2849 (class 2606 OID 25595)
-- Name: cotation cotation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation
    ADD CONSTRAINT cotation_pk PRIMARY KEY (cotation_id);


--
-- TOC entry 2835 (class 2606 OID 25518)
-- Name: departement departement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT departement_pk PRIMARY KEY (code);


--
-- TOC entry 2831 (class 2606 OID 25502)
-- Name: description description_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.description
    ADD CONSTRAINT description_pk PRIMARY KEY (description_id);


--
-- TOC entry 2823 (class 2606 OID 25461)
-- Name: photo photo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pk PRIMARY KEY (photo_id);


--
-- TOC entry 2821 (class 2606 OID 25450)
-- Name: reference reference_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference
    ADD CONSTRAINT reference_pk PRIMARY KEY (reference_id);


--
-- TOC entry 2833 (class 2606 OID 25510)
-- Name: region region_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pk PRIMARY KEY (region_id);


--
-- TOC entry 2847 (class 2606 OID 25584)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (secteur_id);


--
-- TOC entry 2841 (class 2606 OID 25551)
-- Name: site site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pk PRIMARY KEY (site_id);


--
-- TOC entry 2819 (class 2606 OID 25439)
-- Name: statut statut_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut
    ADD CONSTRAINT statut_pk PRIMARY KEY (id);


--
-- TOC entry 2843 (class 2606 OID 25562)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (topo_id);


--
-- TOC entry 2845 (class 2606 OID 25573)
-- Name: topo_reservation topo_reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT topo_reservation_pk PRIMARY KEY (reservation_id);


--
-- TOC entry 2839 (class 2606 OID 25540)
-- Name: type_roche type_roche_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche
    ADD CONSTRAINT type_roche_pk PRIMARY KEY (type_roche_id);


--
-- TOC entry 2829 (class 2606 OID 25491)
-- Name: user_roles user_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_role_pk PRIMARY KEY (user_role_id);


--
-- TOC entry 2825 (class 2606 OID 25469)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (username);


--
-- TOC entry 2837 (class 2606 OID 25529)
-- Name: ville ville_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pk PRIMARY KEY (ville_id);


--
-- TOC entry 2851 (class 2606 OID 25606)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (voie_id);


--
-- TOC entry 2876 (class 2606 OID 25723)
-- Name: caracteristique_voie caracteristique_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_caracteristique_voie_fk FOREIGN KEY (caracteristique_id) REFERENCES public.caracteristique(caracteristique_id);


--
-- TOC entry 2874 (class 2606 OID 25713)
-- Name: voie cotation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT cotation_voie_fk FOREIGN KEY (cotation_id) REFERENCES public.cotation(cotation_id);


--
-- TOC entry 2864 (class 2606 OID 25673)
-- Name: site departement_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT departement_site_fk FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2861 (class 2606 OID 25678)
-- Name: ville departement_ville_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT departement_ville_fk FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2862 (class 2606 OID 25658)
-- Name: site description_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT description_site_fk FOREIGN KEY (description_id) REFERENCES public.description(description_id);


--
-- TOC entry 2857 (class 2606 OID 25633)
-- Name: commentaire reference_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT reference_commentaire_fk FOREIGN KEY (reference_id) REFERENCES public.reference(reference_id);


--
-- TOC entry 2856 (class 2606 OID 25628)
-- Name: photo reference_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT reference_photo_fk FOREIGN KEY (reference_id) REFERENCES public.reference(reference_id);


--
-- TOC entry 2860 (class 2606 OID 25668)
-- Name: departement region_departement_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT region_departement_fk FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2863 (class 2606 OID 25663)
-- Name: site region_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT region_site_fk FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2873 (class 2606 OID 25708)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(secteur_id);


--
-- TOC entry 2872 (class 2606 OID 25693)
-- Name: secteur site_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT site_secteur_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2868 (class 2606 OID 25698)
-- Name: topo site_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT site_topo_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2869 (class 2606 OID 25623)
-- Name: topo_reservation statut_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT statut_topo_reservation_fk FOREIGN KEY (statut_id) REFERENCES public.statut(id);


--
-- TOC entry 2871 (class 2606 OID 25703)
-- Name: topo_reservation topo_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT topo_topo_reservation_fk FOREIGN KEY (reservation_topo_id) REFERENCES public.topo(topo_id);


--
-- TOC entry 2866 (class 2606 OID 25688)
-- Name: site type_roche_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT type_roche_site_fk FOREIGN KEY (type_roche_id) REFERENCES public.type_roche(type_roche_id);


--
-- TOC entry 2858 (class 2606 OID 25643)
-- Name: commentaire users_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT users_commentaire_fk FOREIGN KEY (users_username) REFERENCES public.users(username);


--
-- TOC entry 2867 (class 2606 OID 25648)
-- Name: topo users_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT users_topo_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2870 (class 2606 OID 25653)
-- Name: topo_reservation users_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT users_topo_reservation_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2859 (class 2606 OID 25638)
-- Name: user_roles users_user_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT users_user_role_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2865 (class 2606 OID 25683)
-- Name: site ville_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT ville_site_fk FOREIGN KEY (ville_id) REFERENCES public.ville(ville_id);


--
-- TOC entry 2875 (class 2606 OID 25718)
-- Name: caracteristique_voie voie_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT voie_caracteristique_voie_fk FOREIGN KEY (voie_id) REFERENCES public.voie(voie_id);


--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE caracteristique; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.caracteristique TO dmc30;


--
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 227
-- Name: SEQUENCE caracteristique_caracteristique_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.caracteristique_caracteristique_id_seq TO dmc30;


--
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 229
-- Name: TABLE caracteristique_voie; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.caracteristique_voie TO dmc30;


--
-- TOC entry 3007 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE commentaire; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.commentaire TO dmc30;


--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 203
-- Name: SEQUENCE commentaire_commentaire_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.commentaire_commentaire_id_seq TO dmc30;


--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE cotation; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.cotation TO dmc30;


--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 223
-- Name: SEQUENCE cotation_cotation_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.cotation_cotation_id_seq TO dmc30;


--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE departement; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.departement TO dmc30;


--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE description; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.description TO dmc30;


--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 207
-- Name: SEQUENCE description_description_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.description_description_id_seq TO dmc30;


--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE photo; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.photo TO dmc30;


--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE photo_photo_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.photo_photo_id_seq TO dmc30;


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE reference; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.reference TO dmc30;


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 198
-- Name: SEQUENCE reference_reference_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.reference_reference_id_seq TO dmc30;


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE region; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.region TO dmc30;


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE secteur; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.secteur TO dmc30;


--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 221
-- Name: SEQUENCE secteur_secteur_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.secteur_secteur_id_seq TO dmc30;


--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE site; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.site TO dmc30;


--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 215
-- Name: SEQUENCE site_site_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.site_site_id_seq TO dmc30;


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 197
-- Name: TABLE statut; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.statut TO dmc30;


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 196
-- Name: SEQUENCE statut_statut_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.statut_statut_id_seq TO dmc30;


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE topo; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.topo TO dmc30;


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE topo_reservation; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.topo_reservation TO dmc30;


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE topo_reservation_reservation_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.topo_reservation_reservation_id_seq TO dmc30;


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 217
-- Name: SEQUENCE topo_topo_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.topo_topo_id_seq TO dmc30;


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE type_roche; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.type_roche TO dmc30;


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 213
-- Name: SEQUENCE type_roche_type_roche_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.type_roche_type_roche_id_seq TO dmc30;


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE user_roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.user_roles TO dmc30;


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 205
-- Name: SEQUENCE user_role_user_role_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.user_role_user_role_id_seq TO dmc30;


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO dmc30;


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE ville; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.ville TO dmc30;


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 211
-- Name: SEQUENCE ville_ville_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.ville_ville_id_seq TO dmc30;


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE voie; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.voie TO dmc30;


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 225
-- Name: SEQUENCE voie_voie_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.voie_voie_id_seq TO dmc30;


-- Completed on 2020-03-24 19:07:28

--
-- PostgreSQL database dump complete
--

