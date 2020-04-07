--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-07 20:00:34

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
-- TOC entry 196 (class 1259 OID 27540)
-- Name: caracteristique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique (
    caracteristique_id integer NOT NULL,
    nom character varying NOT NULL,
    definition character varying NOT NULL
);


ALTER TABLE public.caracteristique OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 27546)
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
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 197
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caracteristique_caracteristique_id_seq OWNED BY public.caracteristique.caracteristique_id;


--
-- TOC entry 198 (class 1259 OID 27548)
-- Name: caracteristique_voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.caracteristique_voie (
    voie_id integer NOT NULL,
    caracteristique_id integer NOT NULL
);


ALTER TABLE public.caracteristique_voie OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 27551)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    commentaire_id integer NOT NULL,
    commentaire character varying NOT NULL,
    username character varying NOT NULL,
    reference_id integer NOT NULL,
    date_publication date NOT NULL,
    ref_id integer NOT NULL,
    valide boolean NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 27557)
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
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 200
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_commentaire_id_seq OWNED BY public.commentaire.commentaire_id;


--
-- TOC entry 201 (class 1259 OID 27559)
-- Name: cotation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cotation (
    cotation_id integer NOT NULL,
    valeur character varying NOT NULL
);


ALTER TABLE public.cotation OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 27565)
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
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 202
-- Name: cotation_cotation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cotation_cotation_id_seq OWNED BY public.cotation.cotation_id;


--
-- TOC entry 203 (class 1259 OID 27567)
-- Name: departement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departement (
    code integer NOT NULL,
    nom character varying NOT NULL,
    region_id integer NOT NULL
);


ALTER TABLE public.departement OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 27573)
-- Name: description; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.description (
    description_id integer NOT NULL,
    description character varying NOT NULL,
    info character varying NOT NULL
);


ALTER TABLE public.description OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 27579)
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
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 205
-- Name: description_description_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.description_description_id_seq OWNED BY public.description.description_id;


--
-- TOC entry 206 (class 1259 OID 27581)
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
-- TOC entry 207 (class 1259 OID 27587)
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
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 207
-- Name: photo_photo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.photo_photo_id_seq OWNED BY public.photo.photo_id;


--
-- TOC entry 208 (class 1259 OID 27589)
-- Name: reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference (
    reference_id integer NOT NULL,
    valeur character varying NOT NULL
);


ALTER TABLE public.reference OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 27595)
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
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 209
-- Name: reference_reference_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reference_reference_id_seq OWNED BY public.reference.reference_id;


--
-- TOC entry 210 (class 1259 OID 27597)
-- Name: region; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.region (
    region_id integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 27603)
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
-- TOC entry 212 (class 1259 OID 27609)
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
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 212
-- Name: secteur_secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_secteur_id_seq OWNED BY public.secteur.secteur_id;


--
-- TOC entry 213 (class 1259 OID 27611)
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
-- TOC entry 214 (class 1259 OID 27617)
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
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 214
-- Name: site_site_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.site_site_id_seq OWNED BY public.site.site_id;


--
-- TOC entry 215 (class 1259 OID 27619)
-- Name: statut; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statut (
    id integer NOT NULL,
    etat character varying NOT NULL
);


ALTER TABLE public.statut OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 27625)
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
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 216
-- Name: statut_statut_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.statut_statut_id_seq OWNED BY public.statut.id;


--
-- TOC entry 217 (class 1259 OID 27627)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    topo_id integer NOT NULL,
    nom character varying NOT NULL,
    date_parution integer NOT NULL,
    site_id integer NOT NULL,
    username character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 27633)
-- Name: topo_reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo_reservation (
    reservation_id integer NOT NULL,
    reservation_date date NOT NULL,
    reservation_topo_id integer NOT NULL,
    username character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.topo_reservation OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 27639)
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
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 219
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_reservation_reservation_id_seq OWNED BY public.topo_reservation.reservation_id;


--
-- TOC entry 220 (class 1259 OID 27641)
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
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 220
-- Name: topo_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;


--
-- TOC entry 221 (class 1259 OID 27643)
-- Name: type_roche; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_roche (
    type_roche_id integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.type_roche OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 27649)
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
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 222
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_roche_type_roche_id_seq OWNED BY public.type_roche.type_roche_id;


--
-- TOC entry 223 (class 1259 OID 27651)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    user_role_id integer NOT NULL,
    username character varying NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 27657)
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_roles_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_roles_user_role_id_seq OWNER TO postgres;

--
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_roles_user_role_id_seq OWNED BY public.user_roles.user_role_id;


--
-- TOC entry 225 (class 1259 OID 27659)
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
-- TOC entry 226 (class 1259 OID 27665)
-- Name: ville; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ville (
    ville_id integer NOT NULL,
    nom character varying NOT NULL,
    departement_code integer NOT NULL
);


ALTER TABLE public.ville OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 27671)
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
-- TOC entry 3081 (class 0 OID 0)
-- Dependencies: 227
-- Name: ville_ville_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ville_ville_id_seq OWNED BY public.ville.ville_id;


--
-- TOC entry 228 (class 1259 OID 27673)
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
-- TOC entry 229 (class 1259 OID 27679)
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
-- TOC entry 3084 (class 0 OID 0)
-- Dependencies: 229
-- Name: voie_voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_voie_id_seq OWNED BY public.voie.voie_id;


--
-- TOC entry 2803 (class 2604 OID 27681)
-- Name: caracteristique caracteristique_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique ALTER COLUMN caracteristique_id SET DEFAULT nextval('public.caracteristique_caracteristique_id_seq'::regclass);


--
-- TOC entry 2804 (class 2604 OID 27682)
-- Name: commentaire commentaire_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN commentaire_id SET DEFAULT nextval('public.commentaire_commentaire_id_seq'::regclass);


--
-- TOC entry 2805 (class 2604 OID 27683)
-- Name: cotation cotation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation ALTER COLUMN cotation_id SET DEFAULT nextval('public.cotation_cotation_id_seq'::regclass);


--
-- TOC entry 2806 (class 2604 OID 27684)
-- Name: description description_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.description ALTER COLUMN description_id SET DEFAULT nextval('public.description_description_id_seq'::regclass);


--
-- TOC entry 2807 (class 2604 OID 27685)
-- Name: photo photo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo ALTER COLUMN photo_id SET DEFAULT nextval('public.photo_photo_id_seq'::regclass);


--
-- TOC entry 2808 (class 2604 OID 27686)
-- Name: reference reference_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference ALTER COLUMN reference_id SET DEFAULT nextval('public.reference_reference_id_seq'::regclass);


--
-- TOC entry 2809 (class 2604 OID 27687)
-- Name: secteur secteur_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN secteur_id SET DEFAULT nextval('public.secteur_secteur_id_seq'::regclass);


--
-- TOC entry 2810 (class 2604 OID 27688)
-- Name: site site_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site ALTER COLUMN site_id SET DEFAULT nextval('public.site_site_id_seq'::regclass);


--
-- TOC entry 2811 (class 2604 OID 27689)
-- Name: statut id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut ALTER COLUMN id SET DEFAULT nextval('public.statut_statut_id_seq'::regclass);


--
-- TOC entry 2812 (class 2604 OID 27690)
-- Name: topo topo_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN topo_id SET DEFAULT nextval('public.topo_topo_id_seq'::regclass);


--
-- TOC entry 2813 (class 2604 OID 27691)
-- Name: topo_reservation reservation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.topo_reservation_reservation_id_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 27692)
-- Name: type_roche type_roche_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche ALTER COLUMN type_roche_id SET DEFAULT nextval('public.type_roche_type_roche_id_seq'::regclass);


--
-- TOC entry 2815 (class 2604 OID 27693)
-- Name: user_roles user_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles ALTER COLUMN user_role_id SET DEFAULT nextval('public.user_roles_user_role_id_seq'::regclass);


--
-- TOC entry 2816 (class 2604 OID 27694)
-- Name: ville ville_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville ALTER COLUMN ville_id SET DEFAULT nextval('public.ville_ville_id_seq'::regclass);


--
-- TOC entry 2817 (class 2604 OID 27695)
-- Name: voie voie_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN voie_id SET DEFAULT nextval('public.voie_voie_id_seq'::regclass);


--
-- TOC entry 2998 (class 0 OID 27540)
-- Dependencies: 196
-- Data for Name: caracteristique; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caracteristique (caracteristique_id, nom, definition) FROM stdin;
2	bloc	Petit rocher, généralement de 3 à 5 mètres de haut, sur lequel on a ouvert des voies d"escalade, non équipées d"ancrages, que l"on parcourt sans être assuré.
1	arête	Ligne déterminée par la rencontre de deux parois.
3	big-wall	Grande paroi rocheuse dont l"ascension exige plusieurs jours d"escalade.
4	cheminée	Fissure large dans laquelle on évolue grâce à des techniques d"opposition.
5	colonnette	Structure de rocher née du même phénomène que celui donnant naissance aux stalactites, faisant penser à un tronc d"arbre pétrifié de petit diamètre accolé à la falaise.
6	couenne	Voie d"une seule longueur, généralement équipée pour l"escalade sportive.
7	couloir	Nom donné à un itinéraire, en général de neige, et dessinant une ligne d’ascension relativement évidente vers le sommet ou le col.
8	dalle	Type de mur n"allant pas au-delà de la verticale, très lisse et fournissant peu de prises.
9	dévers	Mur dont l"inclinaison est au-delà de la verticale.
10	dièdre	Falaise ou mur où deux pans verticaux se rejoignant à la façon d"un livre ouvert.
11	fissure	Structure du rocher dans laquelle s"effectuent des coincements de doigts/mains/poings/poignets/coudes/pieds/genoux.
12	goulet	Couloir, passage étroit sur une paroi.
13	surplomb	Paroi rocheuse s"avançant au-dessus du vide.
14	toit	Passage où la roche est (sub-)horizontale, éventuellement tournée vers le bas (déversant horizontal).
15	traversée	Section d"une voie nécessitant une progression horizontale sur une paroi.
16	bombé	Bombement rocheux.
\.


--
-- TOC entry 3000 (class 0 OID 27548)
-- Dependencies: 198
-- Data for Name: caracteristique_voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caracteristique_voie (voie_id, caracteristique_id) FROM stdin;
\.


--
-- TOC entry 3001 (class 0 OID 27551)
-- Dependencies: 199
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (commentaire_id, commentaire, username, reference_id, date_publication, ref_id, valide) FROM stdin;
2	Très beau site !	admin	1	2020-04-07	8	t
\.


--
-- TOC entry 3003 (class 0 OID 27559)
-- Dependencies: 201
-- Data for Name: cotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cotation (cotation_id, valeur) FROM stdin;
1	1
2	2
3	3
4	4
5	5a
6	5b
7	5c
8	6a
9	6a+
10	6b
11	6b+
12	6c
13	6c+
14	7a
15	7a+
16	7b
17	7b+
18	7c
19	7c+
20	8a
21	8a+
22	8b
23	8b+
24	8c
25	8c+
26	9a
27	9a+
28	9b
29	9b+
30	9c
\.


--
-- TOC entry 3005 (class 0 OID 27567)
-- Dependencies: 203
-- Data for Name: departement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.departement (code, nom, region_id) FROM stdin;
1	Ain	1
3	Allier	1
7	Ardeche	1
15	Cantal	1
26	Drôme	1
38	Isère	1
42	Loire	1
43	Haute-Loire	1
63	Puy-de-Dôme	1
69	Rhône	1
73	Savoie	1
74	Haute-Savoie	1
21	Côte-d"Or	2
25	Doubs	2
39	Jura	2
58	Nièvre	2
70	Haute-Saône	2
71	Saône-et-Loire	2
89	Yonne	2
90	Territoire de Belfort	2
22	Côte-d"Armor	3
29	Finistère	3
35	Ille-et-Vilaine	3
56	Morbihan	3
18	Cher	4
28	Eure-et-Loir	4
36	Indre	4
37	Indre-et-Loir	4
41	Loir-et-Cher	4
45	Loiret	4
8	Ardennes	6
10	Aube	6
51	Marne	6
52	Haute-Marne	6
54	Meurthe-et-Moselle	6
55	Meuse	6
57	Moselle	6
67	Bas-Rhin	6
68	Haut-Rhin	6
88	Vosges	6
973	Guyanne	16
2	Aisne	7
59	Nord	7
60	Oise	7
62	Pas-de-Calais	7
80	Somme	7
75	Paris	8
77	Seine-et-Marne	8
78	Yvelines	8
91	Essonne	8
92	Haut-de-Seine	8
93	Seine-Saint-Denis	8
94	Val-de-Marne	8
95	Val-d"Oise	8
974	La Réunion	17
972	Martinique	15
976	Mayotte	18
14	Calvados	9
27	Eure	9
50	Manche	9
61	Orne	9
76	Seine-Maritime	9
16	Charente	10
17	Charente-Maritime	10
19	Corrèze	10
23	Creuse	10
24	Dordogne	10
33	Gironde	10
40	Landes	10
47	Lot-et-Garonne	10
64	Pyrénées-Atlantiques	10
79	Deux-Sèvres	10
86	Vienne	10
87	Haute-Vienne	10
9	Ariège	11
11	Aude	11
12	Aveyron	11
30	Gard	11
31	Haute-Garonne	11
32	Gers	11
34	Hérault	11
46	Lot	11
48	Lozère	11
65	Haute-Pyrénées	11
66	Pyranées-Orientales	11
81	Tarn	11
82	Tarn-et-Garonne	11
44	Loire-Atlantique	12
49	Maine-et-Loire	12
53	Mayenne	12
72	Sarthe	12
85	Vendée	12
4	Alpes-de-Haute-Provence	13
5	Hautes-Alpes	13
6	Alpes-Maritimes	13
13	Bouches-du-Rhône	13
83	Var	13
84	Vaucluse	13
971	Guadeloupe	14
202	Haute-Corse	5
201	Corse-du-Sud	5
\.


--
-- TOC entry 3006 (class 0 OID 27573)
-- Dependencies: 204
-- Data for Name: description; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.description (description_id, description, info) FROM stdin;
2	Ablon, c’est la falaise d’alpages, nichée à l’écart, dans un recoin sauvage et préservé en plein cœur du massif des Bornes. On est loin de la montagne à touristes, il n’y a plus aucun bruit de moteur... Là, sur le plateau des Glières, lieu célèbre pour la page d’histoire qui s’y est écrite au cours de la dernière guerre mondiale, où les résistants ont fui les occupants allemands, se trouve le Val d’Ablon, un joyau de falaise haut-savoyard encore inconnu il y a une vingtaine d’années. Sur ses fantastiques dalles grises très sculptées, où le rocher est beau partout, l’escalade présente une variété de styles avec prédominance de grandes envolées en 6b, 6c ou 7a, tout en continuité. On doit plus des deux tiers de ces fabuleuses lignes à Robert Durieux, équipeur motivé et amoureux des lieux depuis au moins trente ans. Autre atout de poids : le pied des voies s’ancre dans un alpage ombragé, moelleux et confortable, idéal pour un assurage serein ou des bambins remuants. Ablon, c’est le site majeur de Haute Savoie pour le cadre, la qualité des lignes et du rocher. Ambiance épicéas, oxygène, clarines et reblochon !	Ablon est un site d'escalade de type calcaire, situé à Aviernoz, dans le département Haute-Savoie (Auvergne-Rhône-Alpes).
4	Ajouter une description pour ce site.	Annot est un site d'escalade de type grès, situé à Annot, dans le département Alpes-de-Haute-Provence (Provence-Alpes-Côte d"Azur).
5	Un site incontournable pour l'initiation des enfants, ou la grimpe en famille. Les voies sont équipées spécialement pour l'initiation des enfants. On y trouve près de 140 voies réparties sur 13 rochers différents, avec une vraie diversité d'escalade, en dalles et murs, du 2 au 6b, et de 3 à 22m, dans un cadre magnifique. Le haut des rochers est facilement accessible pour l'installation de moulinettes. Pour la plupart des rochers, une corde de 45m est conseillée. Période idéale : printemps été et automne. L'accès depuis le parking se fait en 2mn pour le rocher le plus proche, et 20mn pour le plus éloigné.	Bachat Bouloud est un site d'escalade de type gneiss, situé à Chamrousse, dans le département Isère (Auvergne-Rhône-Alpes).
6	Ajouter une description pour ce site.	Ballon d'Alsace est un site d'escalade de type granite, situé à Saint-Maurice-sur-Moselle, dans le département Vosges (Grand-Est).
7	Ajouter une description pour ce site.	Mont Aiguille est un site d'escalade de type calcaire, situé à Saint-Michel-les-Portes, dans le département Isère (Auvergne-Rhône-Alpes).
8	Ailefroide est un site d'escalade situé à Ailefroide dans le département Hautes-Alpes (fr).\r\nOn y trouve 314 lignes allant de 2a à 8c.	Ailefroide est un site d'escalade de type granite, situé à Ailefroide, dans le département Hautes-Alpes (Provence-Alpes-Côte d"Azur).
3	Un grand cirque, avec une belle ambiance typique des calanques, qui offre une grimpe variée. Il est orienté Sud-Ouest et Ouest, bien ensoleillé, qui est très agréable en hiver ou à l'intersaison, mais qui se transforme vite en four en été (il est bien abrité du mistral).\r\nIl offre des voies pour la plupart équipées, mais certaines sont en terrain d'aventure, et d'autres n'ont pas été rééquipées et l'équipement est vieillissant, prudence donc.\r\nAu total, on y trouve 13 voies, d'1 à 5 longueurs, de 50 à 100m de haut. Les cotations sont abordables, de 3a à 7b, avec une majorité de voies en 6a-6c. C'est donc un secteur intéressant avant tout pour les grimpeurs confirmés.\r\nL'accès se fait en 10-15mn environ depuis le parking (tout dépend du temps que vous mettez pour effectuer les rappels d'accès aux voies), avec 3 rappels successifs pour atteindre le pied de la paroi.	14 juillet est un site d'escalade de type calcaire, situé à La Ciotat, dans le département Alpes-de-Haute-Provence (Provence-Alpes-Côte d"Azur).
10	Un site bien ensoleillé, orienté majoritairement Sud, et réparti sur 4 secteur différents. Il est idéal pour les journées d'hiver ou à l'intersaison, mais il peut y faire très chaud en été ! Le cadre est très sympa et agréable, juste à côté du Gardon. On y trouve un grand nombre de voies : près de 280 au total, d'une à 3 longueurs, du 4b au 8bplus. Les débutants tout comme les grimpeurs fort auront largement de quoi y faire. L'escalade y est principalement en dalle, et les voies font entre 20 et 60m, pour les plus longues. L'accès est facile, et se fait en 15mn environ depuis le parking (un peu plus pour les secteurs plus éloignés)	Collias est un site d'escalade de type calcaire, situé à Collias, dans le département Gard (Occitanie).
11	Ajouter une description pour ce site.	Russan est un site d'escalade de type calcaire, situé à Russan, dans le département Gard (Occitanie).
9	 Ce site est une ancienne carrière équipée pour l’escalade, ce qui lui donne un style d’escalade atypique. Sa grande facilité d’accès (centre ville) permet de pratiquer lors de conditions incertaines ou de manque de temps. Attention les chutes de pierres ne sont pas rares. Enfin, les jours de forte chaleur, il est conseillé de privilégier les soirées et profiter de l’éclairage public pour finir la séance sans se soucier de la pénombre. (certains secteurs ne bénéficient pas de l’éclairage)\r\nIl est possible de réaliser plusieurs blocs ainsi qu’une traversée complète du site au pied des voies.	Carrière Collot – Site d’escalade Philippe MENGIN est un site d'escalade de type grès, situé à Epinal, dans le département Vosges (Grand-Est).
\.


--
-- TOC entry 3008 (class 0 OID 27581)
-- Dependencies: 206
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.photo (photo_id, nom, ref_id, reference_id) FROM stdin;
1	logo_escalade.png	0	4
15	Site2_89219_ablon1.jpeg	2	1
16	Site2_279400_ablon2.jpeg	2	1
17	Site2_139407_ablon.jpeg	2	1
18	Site8_661891_Ailefroide.jpeg	8	1
19	Site8_34461_Ailefroide.jpeg	8	1
20	Site8_430019_Ailefroide.jpeg	8	1
21	Site8_666796_Ailefroide.jpeg	8	1
22	Site4_285183_annot.jpeg	4	1
23	Site4_142348_annot.jpeg	4	1
24	Site4_299832_annot.jpeg	4	1
25	Site4_802993_annot.jpeg	4	1
26	Site4_787418_annot.jpeg	4	1
27	Site4_903164_annot.jpeg	4	1
28	Site7_399154_montaiguille.jpeg	7	1
29	Site7_680365_montaiguille.jpeg	7	1
30	Site7_3165_montaiguille.jpeg	7	1
31	Site7_759061_montaiguille.jpeg	7	1
32	Site7_801418_montaiguille.jpeg	7	1
34	Site11_480_russan.jpeg	11	1
35	Site11_690810_russan.jpeg	11	1
\.


--
-- TOC entry 3010 (class 0 OID 27589)
-- Dependencies: 208
-- Data for Name: reference; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reference (reference_id, valeur) FROM stdin;
1	site
2	secteur
3	voie
4	logo
\.


--
-- TOC entry 3012 (class 0 OID 27597)
-- Dependencies: 210
-- Data for Name: region; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.region (region_id, nom) FROM stdin;
1	Auvergne-Rhône-Alpes
2	Bourgogne-Franche-Comté
3	Bretagne
4	Centre-Val de Loire
5	Corse
6	Grand-Est
7	Hauts-de-France
8	Ile-de-France
9	Normandie
10	Nouvelle-Aquitaine
11	Occitanie
12	Pays de la Loire
13	Provence-Alpes-Côte d"Azur
14	Guadeloupe
15	Martinique
16	Guyanne
17	La Réunion
18	Mayotte
\.


--
-- TOC entry 3013 (class 0 OID 27603)
-- Dependencies: 211
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (secteur_id, nom, site_id, description) FROM stdin;
1	Secteur 14 juillet	3	25 minutes d'approche, au soleil l'après-midi.
2	Impact	2	Ajouter une description pour ce secteur.
4	Résistance et Liberté	2	50 minutes d'approche.
3	La ligne du temps	2	                                                                                        Ajouter une description pour ce secteur.
5	Dalle de la Bèïte	4	Ajouter une description pour ce secteur.
6	L'Airain	4	Ajouter une description pour ce secteur.
7	L'Etrave	4	Ajouter une description pour ce secteur.
8	La Grande Pyramide	4	Ajouter une description pour ce secteur.
9	La Petite Pyramide	4	Ajouter une description pour ce secteur.
10	Les arbrisseaux	5	Ajouter une description pour ce secteur.
11	Les carnivores	5	Ajouter une description pour ce secteur.
12	Capucin	6	20 minutes d'approche
13	Dalle à Paulet	6	20 minutes d'approche
14	Dalton	6	20 minutes d'approche
15	Nord Ouest	7	Ajouter une description pour ce secteur.
16	Pilier S	7	Ajouter une description pour ce secteur.
17	Amigo	8	Ajouter une description pour ce secteur.
18	Ecole buissonière	8	Ajouter une description pour ce secteur.
19	Face Bouc	8	Ajouter une description pour ce secteur.
20	Green peace	8	Ajouter une description pour ce secteur.
21	La Draye - Amigos	8	Ajouter une description pour ce secteur.
22	Secteur A	9	Ajouter une description pour ce secteur.
23	Secteur B	9	Ajouter une description pour ce secteur.
24	Secteur C	9	Ajouter une description pour ce secteur.
25	Secteur D	9	Ajouter une description pour ce secteur.
26	Secteur E	9	Ajouter une description pour ce secteur.
27	Secteur F	9	Ajouter une description pour ce secteur.
28	Secteur G	9	Ajouter une description pour ce secteur.
29	Secteur H	9	Ajouter une description pour ce secteur.
30	Brazza	10	4 ligne(s) de 6a à 7a
31	Grande Paroi - Berlingot	10	Ajouter une description pour ce secteur.
32	Grande paroi - Exelsior	10	Ajouter une description pour ce secteur.
33	Grande paroi - Hyper-patate	10	Ajouter une description pour ce secteur.
34	Grande paroi - Le zéro et l'infini	10	2 ligne(s) de 6a à 7a
35	Rouquette gauche	10	5 minutes d'approche, ensoleillé toute la journée, Exposé à la pluie
\.


--
-- TOC entry 3015 (class 0 OID 27611)
-- Dependencies: 213
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) FROM stdin;
4	Annot	f	6	13	4	5	4
5	Bachat Bouloud	f	4	1	38	6	5
6	Ballon d'Alsace	t	5	6	88	7	6
7	Mont Aiguille	f	2	1	38	8	7
3	14 juillet	t	2	13	4	3	3
10	Collias	f	2	11	30	11	10
11	Russan	f	2	11	30	12	11
9	Carrière Collot – Site d’escalade Philippe MENGIN	f	6	6	88	10	9
2	Ablon	f	2	1	74	4	2
8	Ailefroide	f	5	13	5	9	8
\.


--
-- TOC entry 3017 (class 0 OID 27619)
-- Dependencies: 215
-- Data for Name: statut; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.statut (id, etat) FROM stdin;
1	validée
2	en attente
3	annulée
\.


--
-- TOC entry 3019 (class 0 OID 27627)
-- Dependencies: 217
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (topo_id, nom, date_parution, site_id, username, description) FROM stdin;
3	40 Falaises - Escalade choisie aux environs du lac d’Annecy - R. Durieux	2007	2	admin	1497 longueurs du 3a au 9a (de quoi vous amuser quelque temps...). Une nouvelle édition élargie de 28 falaises autour d'Annecy.
4	Grimpe à Annot et Entrevaux	2003	4	admin	Grimpe à Annot et Entrevaux est un topo édité par Vive les Gestes en 2003
5	Escalade en Isère - Ze topo Volume 2	2013	5	admin	Escalade en Isère - Ze topo Volume 2 est un topo édité par CD38 FFME en 2013
6	Est Calades	2010	6	admin	Est Calades est un topo édité par Club Alpin Français de Mulhouse en 2010
7	Escalades autour d'Ailefroide	2013	8	user	Auteur : J.-M.Cambon
8	Escalade plaisir - Alpes du Sud, Provence	2014	8	user	Escalade plaisir - Alpes du Sud, Provence est un topo édité par Olizane en 2014\r\nAuteur : Hervé Galley\r\nPrix conseillé : 22,00 €\r\nNombre de page : 336 page
9	Les falaises du Gard	2017	10	user	Les falaises du Gard est un topo édité par en 2017\r\nNombre de site d'oblyk présent dans ce topo : 14\r\nAuteur : Laurent Pierret, Thomas Sandri, Sarah Hirst\r\nPrix conseillé : 27,00 €\r\nNombre de page : 192 p
\.


--
-- TOC entry 3020 (class 0 OID 27633)
-- Dependencies: 218
-- Data for Name: topo_reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo_reservation (reservation_id, reservation_date, reservation_topo_id, username, id) FROM stdin;
\.


--
-- TOC entry 3023 (class 0 OID 27643)
-- Dependencies: 221
-- Data for Name: type_roche; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type_roche (type_roche_id, nom) FROM stdin;
1	basalte
2	calcaire
3	conglomérats
4	gneiss
5	granite
6	grès
7	migmatite
8	quartzite
9	schiste
10	silex
11	inconnu
\.


--
-- TOC entry 3025 (class 0 OID 27651)
-- Dependencies: 223
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_roles (user_role_id, username, role) FROM stdin;
3	user	ROLE_USER
2	admin	ROLE_ADMIN
\.


--
-- TOC entry 3027 (class 0 OID 27659)
-- Dependencies: 225
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (username, password, email, enabled) FROM stdin;
admin	$2a$10$Q1Sd7.CqWZs8BNtDV5d25utOfvhmLZecw9McC9373TuQ3bICFywqC	admin@ocp6.com	t
user	$2a$10$rN3JHOyZw/IMY2HRHi.uu.KxI.vS7o/JzIL5TFpGche7KjxW4THyK	user@ocp6.com	t
\.


--
-- TOC entry 3028 (class 0 OID 27665)
-- Dependencies: 226
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ville (ville_id, nom, departement_code) FROM stdin;
2	Thorens	74
3	La Ciotat	4
4	Aviernoz	74
5	Annot	4
6	Chamrousse	38
7	Saint-Maurice-sur-Moselle	88
8	Saint-Michel-les-Portes	38
9	Ailefroide	5
10	Epinal	88
11	Collias	30
12	Russan	30
\.


--
-- TOC entry 3030 (class 0 OID 27673)
-- Dependencies: 228
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) FROM stdin;
1	Casquette jaune	100	1	5
2	Gringo loco (ya basta)	100	1	4
3	L'édon de la mer	100	1	3
4	La salcoquet	100	1	5
5	Le 14 juillet	100	1	5
6	Le rat qui pue	50	1	12
7	Impact	25	2	14
8	Les croûtes aux fromages	35	2	20
9	Les soeurs qui quêtent	35	2	16
10	Chaud qui peut	20	3	12
11	Douce Violence	20	3	12
12	Grattons et frottons	0	3	14
13	Harmonie	15	3	12
14	La prise du koweit	20	3	10
15	Berlin 90	0	4	12
16	Chèvres en péril	0	4	11
17	Dilatation des neurones	0	4	13
18	Jardin extraordinaire	0	4	9
19	Jean d'ablon	0	4	10
20	Picocanthrope	0	4	5
21	Picothérapie	0	4	8
22	Amer	15	5	5
23	Ciel Noir	15	5	8
24	Clapotis	15	5	8
25	Errance	15	5	5
26	Grain de sable	15	5	7
27	L'Algue	15	5	5
28	La crevette	15	5	8
29	La plage	15	5	7
30	Le Port	15	5	7
31	Sourire	30	5	4
32	Crapouillot	10	6	6
34	Métal Hurlant	10	6	10
33	Ocre	10	6	10
35	De but en blanc	20	7	17
36	Haut fond	20	7	14
37	La Biscotte épicée	20	7	7
38	Le nid	20	7	12
39	Les Grumeaux	25	7	11
40	Hatchepsout	0	8	7
41	Hiéroglyphes	25	8	6
42	Khéphren	0	8	8
43	Osiris	15	8	6
44	Papyrus	10	8	11
45	Pharaon	14	8	9
46	Ramsès	14	8	6
47	La petite Réva	10	9	8
48	Odeur	13	9	7
49	Scoliose	20	9	4
50	See Slide	11	9	6
51	Vague à l'âme	15	9	8
52	L'airelle des marais	0	10	3
53	L'airelle noire (myrtille)	0	10	3
54	L'airelle rouge	0	10	3
55	L'arbousier des alpes	0	10	2
56	L'azalée couchée	0	10	3
57	Le rhododendron	0	10	2
58	L'hermine	0	11	4
59	La belette	0	11	3
60	La fouine	0	11	4
61	Le renard	0	11	4
62	Le sanglier	0	11	4
63	Capucin	0	12	7
64	Les Daltons	0	12	11
65	Dalle en biais	0	13	10
66	Dièdre de gauche	0	13	5
67	Dièdre du milieu	0	13	4
68	Directe de droite	0	13	12
69	La dalle	0	13	12
70	Paradis artificiel	0	14	12
71	Voie normale	250	15	4
72	\tPilier S	0	16	8
73	Voie des étudiants	0	16	10
74	Amigo	20	17	7
75	Flore del fango	20	17	8
76	Ecole buissonière	20	18	6
77	Filou	20	18	4
78	Gringalet	20	18	3
79	Jeu d'enfant	20	18	4
80	Les enfants du roc	20	18	6
81	Ouistiti	20	18	3
82	Petit prince	20	18	3
83	Quand je serai grand	20	18	4
84	Benchoucrane	30	19	11
85	Cambon beurre	15	19	15
86	Dans tes rêves	30	19	17
87	Dis-moi Céline	30	19	8
88	Elichat botté	15	19	16
89	En un come back douteux	35	19	21
90	Face Bouc	35	19	24
91	Faschi nautique	35	19	19
92	Gipsy crack	25	19	12
93	Le foyer des vieux branleurs	35	19	22
94	La giroquoi	20	19	19
95	Mon héros	20	19	15
96	DST	20	20	5
97	Green Peace	20	20	8
98	Muruoa	20	20	6
99	Aioli tartiflette	30	21	18
100	Buisson ardent	30	21	7
101	Diable rouge	25	21	7
102	Fais attention	30	21	14
103	Fissure trou-trou	15	21	7
104	Gare au raoul	35	21	10
105	Kaliripinos	25	21	15
106	Rue Béole	0	22	3
107	Eruption	0	22	4
108	Pustule	0	22	4
109	Moulinette	0	22	4
110	Joe	0	22	3
111	Jack	0	22	4
112	William	0	22	4
113	Averell	0	22	4
114	Rantanplan	0	22	5
115	Phéromores à suivre	0	22	4
116	Le cocotier branlant	0	22	7
117	Captain Hard rock	0	23	5
118	Radio lucien	0	23	7
119	Dévotion	0	23	5
120	Collotmaniaque	0	23	6
121	Tirelire	0	23	7
122	Hamster jovial	0	23	7
123	Juste un zeste	0	24	7
124	Vision	0	24	8
125	La parfaite lumière	0	24	8
126	Poupon la peste	0	24	9
127	Excalibur	0	24	8
128	Friendise	0	24	7
129	La Menace	0	24	12
130	Droit de défonce	0	25	10
131	Calambredaine	0	25	11
132	Camisole de force	0	25	11
133	…………	0	25	10
134	Trois pommes et un boudin	0	25	11
135	Les cauchemars d’une fourmis	0	25	12
136	Momo le morbaque	0	25	13
137	Tranxene 2 le matin	0	25	13
138	Air du sud	0	26	7
139	Y’a plus de saison	0	26	7
140	Ganglion	0	26	12
141	Frites saucisse	0	27	14
142	Jonny l’albinnos	0	27	15
143	Apocalypse à Ambrail	0	27	16
144	Iznogood	0	27	12
145	Sueurs froides	0	27	11
146	Le concombre masqué	0	27	12
147	Demande express	0	28	8
148	Voie de presse	0	28	8
149	Touches pas à mes noisettes	0	28	19
150	Haute pression	0	28	7
151	Agrippine	0	29	11
152	Bol de riz	0	29	9
153	L’avenir en rose	0	29	7
154	Chinoiserie	0	29	12
155	Brazza	25	30	14
156	Carline	20	30	8
157	Tango Panache	22	30	8
158	Uhuru	26	30	9
159	Jours étranges	17	32	12
160	Peepone	25	33	9
161	Le zéro et l'infini	30	34	15
162	Sanzisu	35	34	9
163	Capsulo-plasti	0	35	18
164	Chaos technique	0	35	20
165	Citadelle	0	35	3
166	Citadelle L1+L2	0	35	6
167	Coeur sauvage	0	35	18
168	De la fuite dans les idées	0	35	19
169	Délivrance	0	35	22
170	Dièdre rouge	0	35	8
171	Eternelle present	0	35	16
172	Ganymède	0	35	18
173	Je meurs innocent	0	35	19
174	L'âge d'or	0	35	12
175	La machine à plastifier les rêves	0	35	23
176	Légende des siècles	0	35	14
177	Les spéciales	0	35	16
178	Ma chaire et tendre pope	0	35	20
179	Nathalie	0	35	20
180	Noces	0	35	20
181	Papagallo	0	35	20
182	Pégase	0	35	17
183	Potemkine	0	35	21
184	Refuse/Resist	0	35	20
185	Rousserolle	0	35	7
\.


--
-- TOC entry 3086 (class 0 OID 0)
-- Dependencies: 197
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caracteristique_caracteristique_id_seq', 1, false);


--
-- TOC entry 3087 (class 0 OID 0)
-- Dependencies: 200
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_commentaire_id_seq', 4, true);


--
-- TOC entry 3088 (class 0 OID 0)
-- Dependencies: 202
-- Name: cotation_cotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cotation_cotation_id_seq', 1, false);


--
-- TOC entry 3089 (class 0 OID 0)
-- Dependencies: 205
-- Name: description_description_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.description_description_id_seq', 11, true);


--
-- TOC entry 3090 (class 0 OID 0)
-- Dependencies: 207
-- Name: photo_photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_photo_id_seq', 37, true);


--
-- TOC entry 3091 (class 0 OID 0)
-- Dependencies: 209
-- Name: reference_reference_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reference_reference_id_seq', 1, false);


--
-- TOC entry 3092 (class 0 OID 0)
-- Dependencies: 212
-- Name: secteur_secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_secteur_id_seq', 35, true);


--
-- TOC entry 3093 (class 0 OID 0)
-- Dependencies: 214
-- Name: site_site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_site_id_seq', 11, true);


--
-- TOC entry 3094 (class 0 OID 0)
-- Dependencies: 216
-- Name: statut_statut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.statut_statut_id_seq', 1, false);


--
-- TOC entry 3095 (class 0 OID 0)
-- Dependencies: 219
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_reservation_reservation_id_seq', 16, true);


--
-- TOC entry 3096 (class 0 OID 0)
-- Dependencies: 220
-- Name: topo_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_topo_id_seq', 9, true);


--
-- TOC entry 3097 (class 0 OID 0)
-- Dependencies: 222
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_roche_type_roche_id_seq', 1, false);


--
-- TOC entry 3098 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_user_role_id_seq', 9, true);


--
-- TOC entry 3099 (class 0 OID 0)
-- Dependencies: 227
-- Name: ville_ville_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ville_ville_id_seq', 12, true);


--
-- TOC entry 3100 (class 0 OID 0)
-- Dependencies: 229
-- Name: voie_voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_voie_id_seq', 185, true);


--
-- TOC entry 2819 (class 2606 OID 27697)
-- Name: caracteristique caracteristique_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique
    ADD CONSTRAINT caracteristique_pk PRIMARY KEY (caracteristique_id);


--
-- TOC entry 2821 (class 2606 OID 27699)
-- Name: caracteristique_voie caracteristique_voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_voie_pk PRIMARY KEY (voie_id, caracteristique_id);


--
-- TOC entry 2823 (class 2606 OID 27701)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (commentaire_id);


--
-- TOC entry 2825 (class 2606 OID 27703)
-- Name: cotation cotation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cotation
    ADD CONSTRAINT cotation_pk PRIMARY KEY (cotation_id);


--
-- TOC entry 2827 (class 2606 OID 27705)
-- Name: departement departement_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT departement_pk PRIMARY KEY (code);


--
-- TOC entry 2829 (class 2606 OID 27707)
-- Name: description description_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.description
    ADD CONSTRAINT description_pk PRIMARY KEY (description_id);


--
-- TOC entry 2831 (class 2606 OID 27709)
-- Name: photo photo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT photo_pk PRIMARY KEY (photo_id);


--
-- TOC entry 2833 (class 2606 OID 27711)
-- Name: reference reference_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference
    ADD CONSTRAINT reference_pk PRIMARY KEY (reference_id);


--
-- TOC entry 2835 (class 2606 OID 27713)
-- Name: region region_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pk PRIMARY KEY (region_id);


--
-- TOC entry 2837 (class 2606 OID 27715)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (secteur_id);


--
-- TOC entry 2839 (class 2606 OID 27717)
-- Name: site site_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT site_pk PRIMARY KEY (site_id);


--
-- TOC entry 2841 (class 2606 OID 27719)
-- Name: statut statut_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut
    ADD CONSTRAINT statut_pk PRIMARY KEY (id);


--
-- TOC entry 2843 (class 2606 OID 27721)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (topo_id);


--
-- TOC entry 2845 (class 2606 OID 27723)
-- Name: topo_reservation topo_reservation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT topo_reservation_pk PRIMARY KEY (reservation_id);


--
-- TOC entry 2847 (class 2606 OID 27725)
-- Name: type_roche type_roche_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_roche
    ADD CONSTRAINT type_roche_pk PRIMARY KEY (type_roche_id);


--
-- TOC entry 2849 (class 2606 OID 27727)
-- Name: user_roles user_roles_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pk PRIMARY KEY (user_role_id);


--
-- TOC entry 2851 (class 2606 OID 27729)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (username);


--
-- TOC entry 2853 (class 2606 OID 27731)
-- Name: ville ville_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT ville_pk PRIMARY KEY (ville_id);


--
-- TOC entry 2855 (class 2606 OID 27733)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (voie_id);


--
-- TOC entry 2856 (class 2606 OID 27734)
-- Name: caracteristique_voie caracteristique_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT caracteristique_caracteristique_voie_fk FOREIGN KEY (caracteristique_id) REFERENCES public.caracteristique(caracteristique_id);


--
-- TOC entry 2875 (class 2606 OID 27739)
-- Name: voie cotation_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT cotation_voie_fk FOREIGN KEY (cotation_id) REFERENCES public.cotation(cotation_id);


--
-- TOC entry 2863 (class 2606 OID 27744)
-- Name: site departement_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT departement_site_fk FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2874 (class 2606 OID 27749)
-- Name: ville departement_ville_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ville
    ADD CONSTRAINT departement_ville_fk FOREIGN KEY (departement_code) REFERENCES public.departement(code);


--
-- TOC entry 2864 (class 2606 OID 27754)
-- Name: site description_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT description_site_fk FOREIGN KEY (description_id) REFERENCES public.description(description_id);


--
-- TOC entry 2858 (class 2606 OID 27759)
-- Name: commentaire reference_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT reference_commentaire_fk FOREIGN KEY (reference_id) REFERENCES public.reference(reference_id);


--
-- TOC entry 2861 (class 2606 OID 27764)
-- Name: photo reference_photo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.photo
    ADD CONSTRAINT reference_photo_fk FOREIGN KEY (reference_id) REFERENCES public.reference(reference_id);


--
-- TOC entry 2860 (class 2606 OID 27769)
-- Name: departement region_departement_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departement
    ADD CONSTRAINT region_departement_fk FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2865 (class 2606 OID 27774)
-- Name: site region_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT region_site_fk FOREIGN KEY (region_id) REFERENCES public.region(region_id);


--
-- TOC entry 2876 (class 2606 OID 27779)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(secteur_id);


--
-- TOC entry 2862 (class 2606 OID 27784)
-- Name: secteur site_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT site_secteur_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2868 (class 2606 OID 27789)
-- Name: topo site_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT site_topo_fk FOREIGN KEY (site_id) REFERENCES public.site(site_id);


--
-- TOC entry 2870 (class 2606 OID 27794)
-- Name: topo_reservation statut_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT statut_topo_reservation_fk FOREIGN KEY (id) REFERENCES public.statut(id);


--
-- TOC entry 2871 (class 2606 OID 27799)
-- Name: topo_reservation topo_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT topo_topo_reservation_fk FOREIGN KEY (reservation_topo_id) REFERENCES public.topo(topo_id);


--
-- TOC entry 2866 (class 2606 OID 27804)
-- Name: site type_roche_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT type_roche_site_fk FOREIGN KEY (type_roche_id) REFERENCES public.type_roche(type_roche_id);


--
-- TOC entry 2859 (class 2606 OID 27809)
-- Name: commentaire users_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT users_commentaire_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2869 (class 2606 OID 27814)
-- Name: topo users_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT users_topo_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2872 (class 2606 OID 27819)
-- Name: topo_reservation users_topo_reservation_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo_reservation
    ADD CONSTRAINT users_topo_reservation_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2873 (class 2606 OID 27824)
-- Name: user_roles users_user_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT users_user_role_fk FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2867 (class 2606 OID 27829)
-- Name: site ville_site_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.site
    ADD CONSTRAINT ville_site_fk FOREIGN KEY (ville_id) REFERENCES public.ville(ville_id);


--
-- TOC entry 2857 (class 2606 OID 27834)
-- Name: caracteristique_voie voie_caracteristique_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caracteristique_voie
    ADD CONSTRAINT voie_caracteristique_voie_fk FOREIGN KEY (voie_id) REFERENCES public.voie(voie_id);


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE caracteristique; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.caracteristique TO dmc30;


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 197
-- Name: SEQUENCE caracteristique_caracteristique_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.caracteristique_caracteristique_id_seq TO dmc30;


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE caracteristique_voie; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.caracteristique_voie TO dmc30;


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE commentaire; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.commentaire TO dmc30;


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE commentaire_commentaire_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.commentaire_commentaire_id_seq TO dmc30;


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE cotation; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.cotation TO dmc30;


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 202
-- Name: SEQUENCE cotation_cotation_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.cotation_cotation_id_seq TO dmc30;


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE departement; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.departement TO dmc30;


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE description; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.description TO dmc30;


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 205
-- Name: SEQUENCE description_description_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.description_description_id_seq TO dmc30;


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE photo; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.photo TO dmc30;


--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 207
-- Name: SEQUENCE photo_photo_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.photo_photo_id_seq TO dmc30;


--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE reference; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.reference TO dmc30;


--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 209
-- Name: SEQUENCE reference_reference_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.reference_reference_id_seq TO dmc30;


--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE region; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.region TO dmc30;


--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE secteur; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.secteur TO dmc30;


--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 212
-- Name: SEQUENCE secteur_secteur_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.secteur_secteur_id_seq TO dmc30;


--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE site; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.site TO dmc30;


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 214
-- Name: SEQUENCE site_site_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.site_site_id_seq TO dmc30;


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE statut; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.statut TO dmc30;


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 216
-- Name: SEQUENCE statut_statut_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.statut_statut_id_seq TO dmc30;


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE topo; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.topo TO dmc30;


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE topo_reservation; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.topo_reservation TO dmc30;


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE topo_reservation_reservation_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.topo_reservation_reservation_id_seq TO dmc30;


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 220
-- Name: SEQUENCE topo_topo_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.topo_topo_id_seq TO dmc30;


--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE type_roche; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.type_roche TO dmc30;


--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 222
-- Name: SEQUENCE type_roche_type_roche_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.type_roche_type_roche_id_seq TO dmc30;


--
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE user_roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.user_roles TO dmc30;


--
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 224
-- Name: SEQUENCE user_roles_user_role_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.user_roles_user_role_id_seq TO dmc30;


--
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO dmc30;


--
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE ville; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.ville TO dmc30;


--
-- TOC entry 3082 (class 0 OID 0)
-- Dependencies: 227
-- Name: SEQUENCE ville_ville_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.ville_ville_id_seq TO dmc30;


--
-- TOC entry 3083 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE voie; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.voie TO dmc30;


--
-- TOC entry 3085 (class 0 OID 0)
-- Dependencies: 229
-- Name: SEQUENCE voie_voie_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.voie_voie_id_seq TO dmc30;


-- Completed on 2020-04-07 20:00:34

--
-- PostgreSQL database dump complete
--

