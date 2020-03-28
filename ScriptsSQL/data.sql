--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-03-24 19:14:47

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
-- TOC entry 3030 (class 0 OID 25609)
-- Dependencies: 228
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
-- TOC entry 3026 (class 0 OID 25587)
-- Dependencies: 224
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
-- TOC entry 3011 (class 0 OID 25503)
-- Dependencies: 209
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
-- TOC entry 3012 (class 0 OID 25511)
-- Dependencies: 210
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
-- TOC entry 3010 (class 0 OID 25494)
-- Dependencies: 208
-- Data for Name: description; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.description (description_id, description, info) VALUES (1, 'Parmi les mythes du Verdon, Courchon, situé dans les basses gorges, a longtemps tenu sa place de spot "secret", mais quand même connu de beaucoup de grimpeurs. Les infos sur ce petit paradis de la grimpe hivernale sont longtemps restées fragmentaires et incomplètes, mais aujourd’hui, Courchon ne se cache plus. Avec environ 80 voies réparties sur plusieurs falaises, la dominante est au dévers, au très raide, aux longues lignes, aux réglettes, concrétions, trous, plats et pinces… Avec tout ça, l’escalade est aussi belle que variée, mais avec rien de vraiment facile. Le site s’adresse à des grimpeurs de 6b minimum, mais mieux vaut être un septo ou octogradiste confirmé pour savourer pleinement tout ce que Courchon a à offrir. Un beau rocher coloré, une vue imprenable sur le lac de Sainte Croix et le plateau de Valensole, et une toute autre ambiance, sur ces baumes orangées baignées de soleil, que dans le grand canyon si proche.', 'Courchon est un site d''escalade de type calcaire, situé à Courchon, dans le département Alpes-de-Haute-Provence (Provence-Alpes-Côte d"Azur).');
INSERT INTO public.description (description_id, description, info) VALUES (2, 'Juste au-dessus de Menton, Castillon se classe haut la main parmi les sites majeurs des Alpes-Maritimes. On y trouve un rocher d’une raideur et d’une qualité exceptionnelles, du dévers jusqu’à plus soif, du dur, du dur et du dur, et pour en profiter jusqu’au bout, une orientation plein soleil jusqu’à la nuit, ce qui en fait un parfait spot d’hiver et de demi-saison. D’autant qu’il est assez fréquenté l’été. Mieux vaut avoir une bonne caisse physique pour aller grimper là-bas. Sinon, pas loin, il y a la mer, la plage et les parasols. Mais ça serait dommage, parce que même sans grimper, vous pouvez y croiser des vrais people de la grimpe internationale! La paternité de la falaise revient à Axel Franco et Philippe Maurel qui y ont ouvert une première ligne (Mortal Kombat) en 1997. Par la suite, d’autres talentueux équipeurs y ont ajouté leur signature, pour une œuvre collective de 55 voies du 6b au 8c+.', 'Castillon est un site d''escalade de type calcaire, situé à Castillon, dans le département Alpes-Maritimes (Provence-Alpes-Côte d"Azur).');


--
-- TOC entry 3016 (class 0 OID 25532)
-- Dependencies: 214
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
-- TOC entry 3014 (class 0 OID 25521)
-- Dependencies: 212
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (1, 'Moustiers', 4);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (2, 'Menton', 6);


--
-- TOC entry 3018 (class 0 OID 25543)
-- Dependencies: 216
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (1, 'Courchon', true, 2, 13, 4, 1, 1);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (2, 'Castillon', false, 2, 13, 6, 2, 2);


--
-- TOC entry 3024 (class 0 OID 25576)
-- Dependencies: 222
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (1, 'Courchon', 1, 'Ajouter une description pour ce secteur.');


--
-- TOC entry 3028 (class 0 OID 25598)
-- Dependencies: 226
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (1, 'Babo babo', 24, 1, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (2, 'Combat de coq', 24, 1, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (3, 'Illusion', 23, 1, 18);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (4, 'Le nain violent', 28, 1, 20);


--
-- TOC entry 3031 (class 0 OID 25618)
-- Dependencies: 229
-- Data for Name: caracteristique_voie; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3001 (class 0 OID 25442)
-- Dependencies: 199
-- Data for Name: reference; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reference (reference_id, valeur) VALUES (1, 'site');
INSERT INTO public.reference (reference_id, valeur) VALUES (2, 'secteur');
INSERT INTO public.reference (reference_id, valeur) VALUES (3, 'voie');
INSERT INTO public.reference (reference_id, valeur) VALUES (4, 'logo');


--
-- TOC entry 3004 (class 0 OID 25462)
-- Dependencies: 202
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (username, password, email, enabled) VALUES ('admin', '$2a$10$sL12QiafQAxcjMJ539sfUuuELv0goPAIxbNLatCbNWXLBacQtmmz.', 'admin@ocp6.com', true);
INSERT INTO public.users (username, password, email, enabled) VALUES ('user', '$2a$10$nYonh2.1uF9krK6omzoGL.adZZguao6ILexuBtPFvpjAB6SPf88nC', 'user@ocp6.com', true);


--
-- TOC entry 3006 (class 0 OID 25472)
-- Dependencies: 204
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.commentaire (commentaire_id, commentaire, users_username, reference_id, date_publication, ref_id, valide) VALUES (15, 'Comment 1', 'user', 1, '2020-03-24', 2, false);
INSERT INTO public.commentaire (commentaire_id, commentaire, users_username, reference_id, date_publication, ref_id, valide) VALUES (16, 'Comment 2', 'user', 1, '2020-03-24', 2, false);
INSERT INTO public.commentaire (commentaire_id, commentaire, users_username, reference_id, date_publication, ref_id, valide) VALUES (18, 'Comment 4', 'user', 1, '2020-03-24', 2, false);
INSERT INTO public.commentaire (commentaire_id, commentaire, users_username, reference_id, date_publication, ref_id, valide) VALUES (17, 'Comment 3 update dans page site', 'user', 1, '2020-03-24', 2, true);


--
-- TOC entry 3003 (class 0 OID 25453)
-- Dependencies: 201
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (1, 'logo_escalade.png', 0, 4);


--
-- TOC entry 2999 (class 0 OID 25431)
-- Dependencies: 197
-- Data for Name: statut; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.statut (id, etat) VALUES (1, 'validée');
INSERT INTO public.statut (id, etat) VALUES (2, 'en attente');
INSERT INTO public.statut (id, etat) VALUES (3, 'annulée');


--
-- TOC entry 3020 (class 0 OID 25554)
-- Dependencies: 218
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3022 (class 0 OID 25565)
-- Dependencies: 220
-- Data for Name: topo_reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3008 (class 0 OID 25483)
-- Dependencies: 206
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_roles (user_role_id, username, role) VALUES (2, 'admin', 'ROLE_ADMIN');
INSERT INTO public.user_roles (user_role_id, username, role) VALUES (3, 'user', 'ROLE_USER');


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 227
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caracteristique_caracteristique_id_seq', 1, false);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 203
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_commentaire_id_seq', 18, true);


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 223
-- Name: cotation_cotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cotation_cotation_id_seq', 1, false);


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 207
-- Name: description_description_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.description_description_id_seq', 2, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 200
-- Name: photo_photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_photo_id_seq', 2, true);


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 198
-- Name: reference_reference_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reference_reference_id_seq', 1, false);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 221
-- Name: secteur_secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_secteur_id_seq', 1, true);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 215
-- Name: site_site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_site_id_seq', 2, true);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 196
-- Name: statut_statut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.statut_statut_id_seq', 1, false);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 219
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_reservation_reservation_id_seq', 1, false);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 217
-- Name: topo_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_topo_id_seq', 1, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 213
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_roche_type_roche_id_seq', 1, false);


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 205
-- Name: user_role_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_role_user_role_id_seq', 3, true);


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 211
-- Name: ville_ville_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ville_ville_id_seq', 2, true);


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 225
-- Name: voie_voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_voie_id_seq', 4, true);


-- Completed on 2020-03-24 19:14:47

--
-- PostgreSQL database dump complete
--

