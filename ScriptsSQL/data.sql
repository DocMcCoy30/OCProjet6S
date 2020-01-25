--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.0

-- Started on 2020-01-25 19:27:34

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

--
-- TOC entry 2983 (class 0 OID 24889)
-- Dependencies: 201
-- Data for Name: caracteristique; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (2, 'bloc', 'Petit rocher, généralement de 3 à 5 mètres de haut, sur lequel on a ouvert des voies d"escalade, non équipées d"ancrages, que l"on parcourt sans être assuré.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (1, 'arête', 'Ligne déterminée par la rencontre de deux parois.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (3, 'big-wall', 'Grande paroi rocheuse dont l"ascension exige plusieurs jours d"escalade.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (4, 'cheminée', 'Fissure large dans laquelle on évolue grâce à des techniques d"opposition.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (5, 'colonnette', 'Structure de rocher née du même phénomène que celui donnant naissance aux stalactites, faisant penser à un tronc d"arbre pétrifié de petit diamètre accolé à la falaise.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (6, 'couenne', 'Voie d"une seule longueur, généralement équipée pour l"escalade sportive.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (7, 'couloir', 'Nom donné à un itinéraire, en général de neige, et dessinant une ligne d’ascension relativement évidente vers le sommet ou le col.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (8, 'dalle', 'Type de mur n"allant pas au-delà de la verticale, très lisse et fournissant peu de prises.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (9, 'dévers', 'Mur dont l"inclinaison est au-delà de la verticale.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (10, 'dièdre', 'Falaise ou mur où deux pans verticaux se rejoignant à la façon d"un livre ouvert.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (11, 'fissure', 'Structure du rocher dans laquelle s"effectuent des coincements de doigts/mains/poings/poignets/coudes/pieds/genoux.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (12, 'goulet', 'Couloir, passage étroit sur une paroi.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (13, 'surplomb', 'Paroi rocheuse s"avançant au-dessus du vide.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (14, 'toit', 'Passage où la roche est (sub-)horizontale, éventuellement tournée vers le bas (déversant horizontal).');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (15, 'traversée', 'Section d"une voie nécessitant une progression horizontale sur une paroi.');
INSERT INTO public.caracteristique (caracteristique_id, nom, definition) VALUES (16, 'bombé', 'Bombement rocheux.');


--
-- TOC entry 2979 (class 0 OID 24867)
-- Dependencies: 197
-- Data for Name: cotation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cotation (cotation_id, valeur) VALUES (1, '1');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (2, '2');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (3, '3');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (4, '4');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (5, '5a');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (6, '5b');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (7, '5c');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (8, '6a');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (9, '6a+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (10, '6b');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (11, '6b+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (12, '6c');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (13, '6c+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (14, '7a');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (15, '7a+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (16, '7b');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (17, '7b+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (18, '7c');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (19, '7c+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (20, '8a');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (21, '8a+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (22, '8b');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (23, '8b+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (24, '8c');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (25, '8c+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (26, '9a');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (27, '9a+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (28, '9b');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (29, '9b+');
INSERT INTO public.cotation (cotation_id, valeur) VALUES (30, '9c');


--
-- TOC entry 2981 (class 0 OID 24878)
-- Dependencies: 199
-- Data for Name: region; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.region (region_id, nom) VALUES (1, 'Auvergne-Rhône-Alpes');
INSERT INTO public.region (region_id, nom) VALUES (2, 'Bourgogne-Franche-Comté');
INSERT INTO public.region (region_id, nom) VALUES (3, 'Bretagne');
INSERT INTO public.region (region_id, nom) VALUES (4, 'Centre-Val de Loire');
INSERT INTO public.region (region_id, nom) VALUES (5, 'Corse');
INSERT INTO public.region (region_id, nom) VALUES (6, 'Grand-Est');
INSERT INTO public.region (region_id, nom) VALUES (7, 'Hauts-de-France');
INSERT INTO public.region (region_id, nom) VALUES (8, 'Ile-de-France');
INSERT INTO public.region (region_id, nom) VALUES (9, 'Normandie');
INSERT INTO public.region (region_id, nom) VALUES (10, 'Nouvelle-Aquitaine');
INSERT INTO public.region (region_id, nom) VALUES (11, 'Occitanie');
INSERT INTO public.region (region_id, nom) VALUES (12, 'Pays de la Loire');
INSERT INTO public.region (region_id, nom) VALUES (13, 'Provence-Alpes-Côte d"Azur');
INSERT INTO public.region (region_id, nom) VALUES (14, 'Guadeloupe');
INSERT INTO public.region (region_id, nom) VALUES (15, 'Martinique');
INSERT INTO public.region (region_id, nom) VALUES (16, 'Guyanne');
INSERT INTO public.region (region_id, nom) VALUES (17, 'La Réunion');
INSERT INTO public.region (region_id, nom) VALUES (18, 'Mayotte');


--
-- TOC entry 2985 (class 0 OID 24919)
-- Dependencies: 203
-- Data for Name: departement; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departement (code, nom, region_id) VALUES (1, 'Ain', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (3, 'Allier', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (7, 'Ardeche', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (15, 'Cantal', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (26, 'Drôme', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (38, 'Isère', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (42, 'Loire', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (43, 'Haute-Loire', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (63, 'Puy-de-Dôme', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (69, 'Rhône', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (73, 'Savoie', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (74, 'Haute-Savoie', 1);
INSERT INTO public.departement (code, nom, region_id) VALUES (21, 'Côte-d"Or', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (25, 'Doubs', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (39, 'Jura', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (58, 'Nièvre', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (70, 'Haute-Saône', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (71, 'Saône-et-Loire', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (89, 'Yonne', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (90, 'Territoire de Belfort', 2);
INSERT INTO public.departement (code, nom, region_id) VALUES (22, 'Côte-d"Armor', 3);
INSERT INTO public.departement (code, nom, region_id) VALUES (29, 'Finistère', 3);
INSERT INTO public.departement (code, nom, region_id) VALUES (35, 'Ille-et-Vilaine', 3);
INSERT INTO public.departement (code, nom, region_id) VALUES (56, 'Morbihan', 3);
INSERT INTO public.departement (code, nom, region_id) VALUES (18, 'Cher', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (28, 'Eure-et-Loir', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (36, 'Indre', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (37, 'Indre-et-Loir', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (41, 'Loir-et-Cher', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (45, 'Loiret', 4);
INSERT INTO public.departement (code, nom, region_id) VALUES (8, 'Ardennes', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (10, 'Aube', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (51, 'Marne', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (52, 'Haute-Marne', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (54, 'Meurthe-et-Moselle', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (55, 'Meuse', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (57, 'Moselle', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (67, 'Bas-Rhin', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (68, 'Haut-Rhin', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (88, 'Vosges', 6);
INSERT INTO public.departement (code, nom, region_id) VALUES (973, 'Guyanne', 16);
INSERT INTO public.departement (code, nom, region_id) VALUES (2, 'Aisne', 7);
INSERT INTO public.departement (code, nom, region_id) VALUES (59, 'Nord', 7);
INSERT INTO public.departement (code, nom, region_id) VALUES (60, 'Oise', 7);
INSERT INTO public.departement (code, nom, region_id) VALUES (62, 'Pas-de-Calais', 7);
INSERT INTO public.departement (code, nom, region_id) VALUES (80, 'Somme', 7);
INSERT INTO public.departement (code, nom, region_id) VALUES (75, 'Paris', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (77, 'Seine-et-Marne', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (78, 'Yvelines', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (91, 'Essonne', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (92, 'Haut-de-Seine', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (93, 'Seine-Saint-Denis', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (94, 'Val-de-Marne', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (95, 'Val-d"Oise', 8);
INSERT INTO public.departement (code, nom, region_id) VALUES (974, 'La Réunion', 17);
INSERT INTO public.departement (code, nom, region_id) VALUES (972, 'Martinique', 15);
INSERT INTO public.departement (code, nom, region_id) VALUES (976, 'Mayotte', 18);
INSERT INTO public.departement (code, nom, region_id) VALUES (14, 'Calvados', 9);
INSERT INTO public.departement (code, nom, region_id) VALUES (27, 'Eure', 9);
INSERT INTO public.departement (code, nom, region_id) VALUES (50, 'Manche', 9);
INSERT INTO public.departement (code, nom, region_id) VALUES (61, 'Orne', 9);
INSERT INTO public.departement (code, nom, region_id) VALUES (76, 'Seine-Maritime', 9);
INSERT INTO public.departement (code, nom, region_id) VALUES (16, 'Charente', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (17, 'Charente-Maritime', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (19, 'Corrèze', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (23, 'Creuse', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (24, 'Dordogne', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (33, 'Gironde', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (40, 'Landes', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (47, 'Lot-et-Garonne', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (64, 'Pyrénées-Atlantiques', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (79, 'Deux-Sèvres', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (86, 'Vienne', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (87, 'Haute-Vienne', 10);
INSERT INTO public.departement (code, nom, region_id) VALUES (9, 'Ariège', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (11, 'Aude', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (12, 'Aveyron', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (30, 'Gard', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (31, 'Haute-Garonne', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (32, 'Gers', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (34, 'Hérault', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (46, 'Lot', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (48, 'Lozère', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (65, 'Haute-Pyrénées', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (66, 'Pyranées-Orientales', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (81, 'Tarn', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (82, 'Tarn-et-Garonne', 11);
INSERT INTO public.departement (code, nom, region_id) VALUES (44, 'Loire-Atlantique', 12);
INSERT INTO public.departement (code, nom, region_id) VALUES (49, 'Maine-et-Loire', 12);
INSERT INTO public.departement (code, nom, region_id) VALUES (53, 'Mayenne', 12);
INSERT INTO public.departement (code, nom, region_id) VALUES (72, 'Sarthe', 12);
INSERT INTO public.departement (code, nom, region_id) VALUES (85, 'Vendée', 12);
INSERT INTO public.departement (code, nom, region_id) VALUES (4, 'Alpes-de-Haute-Provence', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (5, 'Hautes-Alpes', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (6, 'Alpes-Maritimes', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (13, 'Bouches-du-Rhône', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (83, 'Var', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (84, 'Vaucluse', 13);
INSERT INTO public.departement (code, nom, region_id) VALUES (971, 'Guadeloupe', 14);
INSERT INTO public.departement (code, nom, region_id) VALUES (202, 'Haute-Corse', 5);
INSERT INTO public.departement (code, nom, region_id) VALUES (201, 'Corse-du-Sud', 5);


--
-- TOC entry 2989 (class 0 OID 24951)
-- Dependencies: 207
-- Data for Name: type_roche; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.type_roche (type_roche_id, nom) VALUES (1, 'basalte');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (2, 'calcaire');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (3, 'conglomérats');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (4, 'gneiss');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (5, 'granite');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (6, 'grès');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (7, 'migmatite');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (8, 'quartzite');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (9, 'schiste');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (10, 'silex');
INSERT INTO public.type_roche (type_roche_id, nom) VALUES (11, 'inconnu');


--
-- TOC entry 2987 (class 0 OID 24929)
-- Dependencies: 205
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (1, 'Collias', 30);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (2, 'Pont-Saint-Nicolas', 30);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (3, 'Rochefort-Du-Gard', 30);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (4, 'Russan', 30);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (5, 'Seynes', 30);


--
-- TOC entry 2991 (class 0 OID 24962)
-- Dependencies: 209
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.site (site_id, nom, description, nb_de_secteurs, nb_de_voies, hauteur, officiel, type_roche_id, region_id, departement_code, ville_id) VALUES (1, 'Collias', 'xxxxxxxxxx', 14, 51, 60, NULL, 2, 11, 30, 1);


--
-- TOC entry 2993 (class 0 OID 24973)
-- Dependencies: 211
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2995 (class 0 OID 24984)
-- Dependencies: 213
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2998 (class 0 OID 25004)
-- Dependencies: 216
-- Data for Name: caracteristique_voie; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2984 (class 0 OID 24898)
-- Dependencies: 202
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (username, password, email, enabled) VALUES ('admin', '$2a$10$at7H9AD7ZhXDPVLnMNNAJ.QBMnXwTSVLFsSJ3cfa.s5jJY2ANgGJm', 'admin@gmail.com', true);
INSERT INTO public.users (username, password, email, enabled) VALUES ('user', '$2a$10$Brioy2rHwVT4PNQTIGWOB.2Kj0UveutGW/5VWyVFCsyMSZ9FdKMOe', 'user@gmail.com', true);


--
-- TOC entry 3004 (class 0 OID 25038)
-- Dependencies: 222
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2999 (class 0 OID 25009)
-- Dependencies: 217
-- Data for Name: mes_sites; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3001 (class 0 OID 25019)
-- Dependencies: 219
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3002 (class 0 OID 25028)
-- Dependencies: 220
-- Data for Name: mes_topos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2997 (class 0 OID 24995)
-- Dependencies: 215
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3006 (class 0 OID 25227)
-- Dependencies: 224
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_roles (user_role_id, username, role) VALUES (29, 'admin', 'ROLE_ADMIN');
INSERT INTO public.user_roles (user_role_id, username, role) VALUES (30, 'user', 'ROLE_USER');


--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 200
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caracteristique_caracteristique_id_seq', 17, true);


--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 221
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_commentaire_id_seq', 1, false);


--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 196
-- Name: cotation_cotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cotation_cotation_id_seq', 1, false);


--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 214
-- Name: photo_photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_photo_id_seq', 1, false);


--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 198
-- Name: region_region_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.region_region_id_seq', 1, false);


--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 210
-- Name: secteur_secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_secteur_id_seq', 1, false);


--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 208
-- Name: site_site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_site_id_seq', 1, true);


--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 218
-- Name: topo_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_topo_id_seq', 1, false);


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 206
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_roche_type_roche_id_seq', 1, false);


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 223
-- Name: user_roles_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_seq', 30, true);


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 204
-- Name: ville_ville_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ville_ville_id_seq', 5, true);


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 212
-- Name: voie_voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_voie_id_seq', 1, false);


-- Completed on 2020-01-25 19:27:35

--
-- PostgreSQL database dump complete
--

