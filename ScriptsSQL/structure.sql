--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.0

-- Started on 2020-01-23 18:57:10

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
-- TOC entry 201 (class 1259 OID 24889)
-- Name: caracteristique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique (
    caracteristique_id integer NOT NULL,
    nom character varying,
    definition character varying
);


ALTER TABLE public.caracteristique OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24887)
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
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 200
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caracteristique_caracteristique_id_seq OWNED BY public.caracteristique.caracteristique_id;


--
-- TOC entry 216 (class 1259 OID 25004)
-- Name: caracteristique_voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique_voie (
    voie_id integer NOT NULL,
    caracteristique_id integer NOT NULL
);


ALTER TABLE public.caracteristique_voie OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 25038)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    commentaire_id integer NOT NULL,
    commentaire character varying,
    site_id integer NOT NULL,
    users_username character varying NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 25036)
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
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 221
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_commentaire_id_seq OWNED BY public.commentaire.commentaire_id;


--
-- TOC entry 197 (class 1259 OID 24867)
-- Name: cotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cotation (
    cotation_id integer NOT NULL,
    cotation character varying
);


ALTER TABLE public.cotation OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24865)
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
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 196
-- Name: cotation_cotation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cotation_cotation_id_seq OWNED BY public.cotation.cotation_id;


--
-- TOC entry 203 (class 1259 OID 24919)
-- Name: departement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement (
    code character varying NOT NULL,
    nom character varying,
    region_id integer NOT NULL
);


ALTER TABLE public.departement OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 25009)
-- Name: mes_sites; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mes_sites (
    site_id integer NOT NULL,
    username character varying NOT NULL
);


ALTER TABLE public.mes_sites OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 25028)
-- Name: mes_topos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mes_topos (
    topo_id integer NOT NULL,
    username character varying NOT NULL
);


ALTER TABLE public.mes_topos OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24995)
-- Name: photo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.photo (
    photo_id integer NOT NULL,
    nom character varying,
    site_id integer,
    secteur_id integer,
    voie_id integer
);


ALTER TABLE public.photo OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 24993)
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
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 214
-- Name: photo_photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.photo_photo_id_seq OWNED BY public.photo.photo_id;


--
-- TOC entry 199 (class 1259 OID 24878)
-- Name: region; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.region (
    region_id integer NOT NULL,
    nom character varying
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24876)
-- Name: region_region_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.region_region_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.region_region_id_seq OWNER TO postgres;

--
-- TOC entry 2988 (class 0 OID 0)
-- Dependencies: 198
-- Name: region_region_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.region_region_id_seq OWNED BY public.region.region_id;


--
-- TOC entry 211 (class 1259 OID 24973)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    secteur_id integer NOT NULL,
    nom character varying,
    nb_de_voies integer,
    site_id integer NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24971)
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
-- TOC entry 2989 (class 0 OID 0)
-- Dependencies: 210
-- Name: secteur_secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_secteur_id_seq OWNED BY public.secteur.secteur_id;


--
-- TOC entry 209 (class 1259 OID 24962)
-- Name: site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.site (
    site_id integer NOT NULL,
    nom character varying,
    description character varying,
    nb_de_secteur integer,
    nb_de_voie integer,
    hauteur integer,
    officiel boolean,
    type_roche_id integer NOT NULL,
    region_id integer NOT NULL,
    departement_code character varying NOT NULL,
    ville_id integer NOT NULL
);


ALTER TABLE public.site OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 24960)
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
-- TOC entry 2990 (class 0 OID 0)
-- Dependencies: 208
-- Name: site_site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_site_id_seq OWNED BY public.site.site_id;


--
-- TOC entry 219 (class 1259 OID 25019)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    topo_id integer NOT NULL,
    description character varying,
    nom character varying,
    disponible boolean,
    date_parution date,
    site_id integer NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 25017)
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
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 218
-- Name: topo_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;


--
-- TOC entry 207 (class 1259 OID 24951)
-- Name: type_roche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_roche (
    type_roche_id integer NOT NULL,
    nom character varying
);


ALTER TABLE public.type_roche OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24949)
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
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 206
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_roche_type_roche_id_seq OWNED BY public.type_roche.type_roche_id;


--
-- TOC entry 223 (class 1259 OID 25225)
-- Name: user_roles_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_roles_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_roles_seq OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 25227)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    user_role_id integer DEFAULT nextval('public.user_roles_seq'::regclass) NOT NULL,
    username character varying(45) NOT NULL,
    role character varying(45) NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24898)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying NOT NULL,
    password character varying NOT NULL,
    email character varying,
    enabled boolean DEFAULT true NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24929)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    ville_id integer NOT NULL,
    nom character varying NOT NULL,
    departement_code character varying NOT NULL
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24927)
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
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 204
-- Name: ville_ville_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ville_ville_id_seq OWNED BY public.ville.ville_id;


--
-- TOC entry 213 (class 1259 OID 24984)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    voie_id integer NOT NULL,
    nom character varying,
    hauteur integer,
    nb_de_points integer,
    secteur_id integer NOT NULL,
    cotation_id integer
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24982)
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
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 212
-- Name: voie_voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_voie_id_seq OWNED BY public.voie.voie_id;


--
-- TOC entry 2788 (class 2604 OID 24892)
-- Name: caracteristique caracteristique_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique ALTER COLUMN caracteristique_id SET DEFAULT nextval('public.caracteristique_caracteristique_id_seq'::regclass);


--
-- TOC entry 2797 (class 2604 OID 25041)
-- Name: commentaire commentaire_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN commentaire_id SET DEFAULT nextval('public.commentaire_commentaire_id_seq'::regclass);


--
-- TOC entry 2786 (class 2604 OID 24870)
-- Name: cotation cotation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation ALTER COLUMN cotation_id SET DEFAULT nextval('public.cotation_cotation_id_seq'::regclass);


--
-- TOC entry 2795 (class 2604 OID 24998)
-- Name: photo photo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo ALTER COLUMN photo_id SET DEFAULT nextval('public.photo_photo_id_seq'::regclass);


--
-- TOC entry 2787 (class 2604 OID 24881)
-- Name: region region_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region ALTER COLUMN region_id SET DEFAULT nextval('public.region_region_id_seq'::regclass);


--
-- TOC entry 2793 (class 2604 OID 24976)
-- Name: secteur secteur_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN secteur_id SET DEFAULT nextval('public.secteur_secteur_id_seq'::regclass);


--
-- TOC entry 2792 (class 2604 OID 24965)
-- Name: site site_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN site_id SET DEFAULT nextval('public.site_site_id_seq'::regclass);


--
-- TOC entry 2796 (class 2604 OID 25022)
-- Name: topo topo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN topo_id SET DEFAULT nextval('public.topo_topo_id_seq'::regclass);


--
-- TOC entry 2791 (class 2604 OID 24954)
-- Name: type_roche type_roche_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche ALTER COLUMN type_roche_id SET DEFAULT nextval('public.type_roche_type_roche_id_seq'::regclass);


--
-- TOC entry 2790 (class 2604 OID 24932)
-- Name: ville ville_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville ALTER COLUMN ville_id SET DEFAULT nextval('public.ville_ville_id_seq'::regclass);


--
-- TOC entry 2794 (class 2604 OID 24987)
-- Name: voie voie_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN voie_id SET DEFAULT nextval('public.voie_voie_id_seq'::regclass);


--
-- TOC entry 2804 (class 2606 OID 24897)
-- Name: caracteristique caracteristique_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique
    ADD CONSTRAINT caracteristique_pk PRIMARY KEY (caracteristique_id);


--
-- TOC entry 2822 (class 2606 OID 25008)
-- Name: caracteristique_voie caracteristique_voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_voie_pk PRIMARY KEY (voie_id, caracteristique_id);


--
-- TOC entry 2830 (class 2606 OID 25046)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (commentaire_id);


--
-- TOC entry 2800 (class 2606 OID 24875)
-- Name: cotation cotation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation
    ADD CONSTRAINT cotation_pk PRIMARY KEY (cotation_id);


--
-- TOC entry 2808 (class 2606 OID 24926)
-- Name: departement departement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT departement_pk PRIMARY KEY (code);


--
-- TOC entry 2824 (class 2606 OID 25016)
-- Name: mes_sites mes_sites_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_sites
    ADD CONSTRAINT mes_sites_pk PRIMARY KEY (site_id, username);


--
-- TOC entry 2828 (class 2606 OID 25035)
-- Name: mes_topos mes_topos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_topos
    ADD CONSTRAINT mes_topos_pk PRIMARY KEY (topo_id, username);


--
-- TOC entry 2820 (class 2606 OID 25003)
-- Name: photo photo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pk PRIMARY KEY (photo_id);


--
-- TOC entry 2802 (class 2606 OID 24886)
-- Name: region region_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pk PRIMARY KEY (region_id);


--
-- TOC entry 2816 (class 2606 OID 24981)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (secteur_id);


--
-- TOC entry 2814 (class 2606 OID 24970)
-- Name: site site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pk PRIMARY KEY (site_id);


--
-- TOC entry 2826 (class 2606 OID 25027)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (topo_id);


--
-- TOC entry 2812 (class 2606 OID 24959)
-- Name: type_roche type_roche_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche
    ADD CONSTRAINT type_roche_pk PRIMARY KEY (type_roche_id);


--
-- TOC entry 2833 (class 2606 OID 25234)
-- Name: user_roles uni_username_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT uni_username_role UNIQUE (role, username);


--
-- TOC entry 2835 (class 2606 OID 25232)
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id);


--
-- TOC entry 2806 (class 2606 OID 24905)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (username);


--
-- TOC entry 2810 (class 2606 OID 24937)
-- Name: ville ville_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pk PRIMARY KEY (ville_id);


--
-- TOC entry 2818 (class 2606 OID 24992)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (voie_id);


--
-- TOC entry 2831 (class 1259 OID 25240)
-- Name: fk_username_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_username_idx ON public.user_roles USING btree (username);


--
-- TOC entry 2848 (class 2606 OID 25062)
-- Name: caracteristique_voie caracteristique_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_caracteristique_voie_fk FOREIGN KEY (caracteristique_id) REFERENCES public.caracteristique(caracteristique_id);


--
-- TOC entry 2856 (class 2606 OID 25242)
-- Name: commentaire commentaire_users_username_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_users_username_fkey FOREIGN KEY (users_username) REFERENCES public.users(username);


--
-- TOC entry 2843 (class 2606 OID 25047)
-- Name: voie cotation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT cotation_voie_fk FOREIGN KEY (cotation_id) REFERENCES public.cotation(cotation_id);


--
-- TOC entry 2837 (class 2606 OID 25092)
-- Name: ville departement_ville_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT departement_ville_fk FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2857 (class 2606 OID 25235)
-- Name: user_roles fk_username; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2836 (class 2606 OID 25057)
-- Name: departement region_departement_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT region_departement_fk FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2846 (class 2606 OID 25142)
-- Name: photo secteur_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT secteur_photo_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(secteur_id);


--
-- TOC entry 2844 (class 2606 OID 25137)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(secteur_id);


--
-- TOC entry 2855 (class 2606 OID 25112)
-- Name: commentaire site_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT site_commentaire_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2840 (class 2606 OID 25252)
-- Name: site site_departement_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_departement_code_fkey FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2851 (class 2606 OID 25122)
-- Name: mes_sites site_mes_sites_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_sites
    ADD CONSTRAINT site_mes_sites_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2845 (class 2606 OID 25132)
-- Name: photo site_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT site_photo_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2839 (class 2606 OID 25247)
-- Name: site site_region_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_region_id_fkey FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2842 (class 2606 OID 25127)
-- Name: secteur site_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT site_secteur_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2852 (class 2606 OID 25117)
-- Name: topo site_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT site_topo_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2841 (class 2606 OID 25257)
-- Name: site site_ville_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_ville_id_fkey FOREIGN KEY (ville_id) REFERENCES public.ville(ville_id);


--
-- TOC entry 2854 (class 2606 OID 25157)
-- Name: mes_topos topo_mes_topos_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_topos
    ADD CONSTRAINT topo_mes_topos_fk FOREIGN KEY (topo_id) REFERENCES public.topo(topo_id);


--
-- TOC entry 2838 (class 2606 OID 25107)
-- Name: site type_roche_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT type_roche_site_fk FOREIGN KEY (type_roche_id) REFERENCES public.type_roche(type_roche_id);


--
-- TOC entry 2850 (class 2606 OID 25067)
-- Name: mes_sites utilisateur_mes_sites_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_sites
    ADD CONSTRAINT utilisateur_mes_sites_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2853 (class 2606 OID 25072)
-- Name: mes_topos utilisateur_mes_topos_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mes_topos
    ADD CONSTRAINT utilisateur_mes_topos_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2849 (class 2606 OID 25147)
-- Name: caracteristique_voie voie_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT voie_caracteristique_voie_fk FOREIGN KEY (voie_id) REFERENCES public.voie(voie_id);


--
-- TOC entry 2847 (class 2606 OID 25152)
-- Name: photo voie_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT voie_photo_fk FOREIGN KEY (voie_id) REFERENCES public.voie(voie_id);


-- Completed on 2020-01-23 18:57:11

--
-- PostgreSQL database dump complete
--

