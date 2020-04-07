--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-07 20:00:05

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
-- TOC entry 2998 (class 0 OID 27540)
-- Dependencies: 196
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
-- TOC entry 3003 (class 0 OID 27559)
-- Dependencies: 201
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
-- TOC entry 3012 (class 0 OID 27597)
-- Dependencies: 210
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
-- TOC entry 3005 (class 0 OID 27567)
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
-- TOC entry 3006 (class 0 OID 27573)
-- Dependencies: 204
-- Data for Name: description; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.description (description_id, description, info) VALUES (2, 'Ablon, c’est la falaise d’alpages, nichée à l’écart, dans un recoin sauvage et préservé en plein cœur du massif des Bornes. On est loin de la montagne à touristes, il n’y a plus aucun bruit de moteur... Là, sur le plateau des Glières, lieu célèbre pour la page d’histoire qui s’y est écrite au cours de la dernière guerre mondiale, où les résistants ont fui les occupants allemands, se trouve le Val d’Ablon, un joyau de falaise haut-savoyard encore inconnu il y a une vingtaine d’années. Sur ses fantastiques dalles grises très sculptées, où le rocher est beau partout, l’escalade présente une variété de styles avec prédominance de grandes envolées en 6b, 6c ou 7a, tout en continuité. On doit plus des deux tiers de ces fabuleuses lignes à Robert Durieux, équipeur motivé et amoureux des lieux depuis au moins trente ans. Autre atout de poids : le pied des voies s’ancre dans un alpage ombragé, moelleux et confortable, idéal pour un assurage serein ou des bambins remuants. Ablon, c’est le site majeur de Haute Savoie pour le cadre, la qualité des lignes et du rocher. Ambiance épicéas, oxygène, clarines et reblochon !', 'Ablon est un site d''escalade de type calcaire, situé à Aviernoz, dans le département Haute-Savoie (Auvergne-Rhône-Alpes).');
INSERT INTO public.description (description_id, description, info) VALUES (4, 'Ajouter une description pour ce site.', 'Annot est un site d''escalade de type grès, situé à Annot, dans le département Alpes-de-Haute-Provence (Provence-Alpes-Côte d"Azur).');
INSERT INTO public.description (description_id, description, info) VALUES (5, 'Un site incontournable pour l''initiation des enfants, ou la grimpe en famille. Les voies sont équipées spécialement pour l''initiation des enfants. On y trouve près de 140 voies réparties sur 13 rochers différents, avec une vraie diversité d''escalade, en dalles et murs, du 2 au 6b, et de 3 à 22m, dans un cadre magnifique. Le haut des rochers est facilement accessible pour l''installation de moulinettes. Pour la plupart des rochers, une corde de 45m est conseillée. Période idéale : printemps été et automne. L''accès depuis le parking se fait en 2mn pour le rocher le plus proche, et 20mn pour le plus éloigné.', 'Bachat Bouloud est un site d''escalade de type gneiss, situé à Chamrousse, dans le département Isère (Auvergne-Rhône-Alpes).');
INSERT INTO public.description (description_id, description, info) VALUES (6, 'Ajouter une description pour ce site.', 'Ballon d''Alsace est un site d''escalade de type granite, situé à Saint-Maurice-sur-Moselle, dans le département Vosges (Grand-Est).');
INSERT INTO public.description (description_id, description, info) VALUES (7, 'Ajouter une description pour ce site.', 'Mont Aiguille est un site d''escalade de type calcaire, situé à Saint-Michel-les-Portes, dans le département Isère (Auvergne-Rhône-Alpes).');
INSERT INTO public.description (description_id, description, info) VALUES (8, 'Ailefroide est un site d''escalade situé à Ailefroide dans le département Hautes-Alpes (fr).
On y trouve 314 lignes allant de 2a à 8c.', 'Ailefroide est un site d''escalade de type granite, situé à Ailefroide, dans le département Hautes-Alpes (Provence-Alpes-Côte d"Azur).');
INSERT INTO public.description (description_id, description, info) VALUES (3, 'Un grand cirque, avec une belle ambiance typique des calanques, qui offre une grimpe variée. Il est orienté Sud-Ouest et Ouest, bien ensoleillé, qui est très agréable en hiver ou à l''intersaison, mais qui se transforme vite en four en été (il est bien abrité du mistral).
Il offre des voies pour la plupart équipées, mais certaines sont en terrain d''aventure, et d''autres n''ont pas été rééquipées et l''équipement est vieillissant, prudence donc.
Au total, on y trouve 13 voies, d''1 à 5 longueurs, de 50 à 100m de haut. Les cotations sont abordables, de 3a à 7b, avec une majorité de voies en 6a-6c. C''est donc un secteur intéressant avant tout pour les grimpeurs confirmés.
L''accès se fait en 10-15mn environ depuis le parking (tout dépend du temps que vous mettez pour effectuer les rappels d''accès aux voies), avec 3 rappels successifs pour atteindre le pied de la paroi.', '14 juillet est un site d''escalade de type calcaire, situé à La Ciotat, dans le département Alpes-de-Haute-Provence (Provence-Alpes-Côte d"Azur).');
INSERT INTO public.description (description_id, description, info) VALUES (10, 'Un site bien ensoleillé, orienté majoritairement Sud, et réparti sur 4 secteur différents. Il est idéal pour les journées d''hiver ou à l''intersaison, mais il peut y faire très chaud en été ! Le cadre est très sympa et agréable, juste à côté du Gardon. On y trouve un grand nombre de voies : près de 280 au total, d''une à 3 longueurs, du 4b au 8bplus. Les débutants tout comme les grimpeurs fort auront largement de quoi y faire. L''escalade y est principalement en dalle, et les voies font entre 20 et 60m, pour les plus longues. L''accès est facile, et se fait en 15mn environ depuis le parking (un peu plus pour les secteurs plus éloignés)', 'Collias est un site d''escalade de type calcaire, situé à Collias, dans le département Gard (Occitanie).');
INSERT INTO public.description (description_id, description, info) VALUES (11, 'Ajouter une description pour ce site.', 'Russan est un site d''escalade de type calcaire, situé à Russan, dans le département Gard (Occitanie).');
INSERT INTO public.description (description_id, description, info) VALUES (9, ' Ce site est une ancienne carrière équipée pour l’escalade, ce qui lui donne un style d’escalade atypique. Sa grande facilité d’accès (centre ville) permet de pratiquer lors de conditions incertaines ou de manque de temps. Attention les chutes de pierres ne sont pas rares. Enfin, les jours de forte chaleur, il est conseillé de privilégier les soirées et profiter de l’éclairage public pour finir la séance sans se soucier de la pénombre. (certains secteurs ne bénéficient pas de l’éclairage)
Il est possible de réaliser plusieurs blocs ainsi qu’une traversée complète du site au pied des voies.', 'Carrière Collot – Site d’escalade Philippe MENGIN est un site d''escalade de type grès, situé à Epinal, dans le département Vosges (Grand-Est).');


--
-- TOC entry 3023 (class 0 OID 27643)
-- Dependencies: 221
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
-- TOC entry 3028 (class 0 OID 27665)
-- Dependencies: 226
-- Data for Name: ville; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (2, 'Thorens', 74);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (3, 'La Ciotat', 4);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (4, 'Aviernoz', 74);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (5, 'Annot', 4);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (6, 'Chamrousse', 38);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (7, 'Saint-Maurice-sur-Moselle', 88);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (8, 'Saint-Michel-les-Portes', 38);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (9, 'Ailefroide', 5);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (10, 'Epinal', 88);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (11, 'Collias', 30);
INSERT INTO public.ville (ville_id, nom, departement_code) VALUES (12, 'Russan', 30);


--
-- TOC entry 3015 (class 0 OID 27611)
-- Dependencies: 213
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (4, 'Annot', false, 6, 13, 4, 5, 4);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (5, 'Bachat Bouloud', false, 4, 1, 38, 6, 5);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (6, 'Ballon d''Alsace', true, 5, 6, 88, 7, 6);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (7, 'Mont Aiguille', false, 2, 1, 38, 8, 7);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (3, '14 juillet', true, 2, 13, 4, 3, 3);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (10, 'Collias', false, 2, 11, 30, 11, 10);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (11, 'Russan', false, 2, 11, 30, 12, 11);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (9, 'Carrière Collot – Site d’escalade Philippe MENGIN', false, 6, 6, 88, 10, 9);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (2, 'Ablon', false, 2, 1, 74, 4, 2);
INSERT INTO public.site (site_id, nom, officiel, type_roche_id, region_id, departement_code, ville_id, description_id) VALUES (8, 'Ailefroide', false, 5, 13, 5, 9, 8);


--
-- TOC entry 3013 (class 0 OID 27603)
-- Dependencies: 211
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (1, 'Secteur 14 juillet', 3, '25 minutes d''approche, au soleil l''après-midi.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (2, 'Impact', 2, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (4, 'Résistance et Liberté', 2, '50 minutes d''approche.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (3, 'La ligne du temps', 2, '                                                                                        Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (5, 'Dalle de la Bèïte', 4, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (6, 'L''Airain', 4, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (7, 'L''Etrave', 4, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (8, 'La Grande Pyramide', 4, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (9, 'La Petite Pyramide', 4, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (10, 'Les arbrisseaux', 5, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (11, 'Les carnivores', 5, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (12, 'Capucin', 6, '20 minutes d''approche');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (13, 'Dalle à Paulet', 6, '20 minutes d''approche');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (14, 'Dalton', 6, '20 minutes d''approche');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (15, 'Nord Ouest', 7, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (16, 'Pilier S', 7, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (17, 'Amigo', 8, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (18, 'Ecole buissonière', 8, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (19, 'Face Bouc', 8, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (20, 'Green peace', 8, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (21, 'La Draye - Amigos', 8, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (22, 'Secteur A', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (23, 'Secteur B', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (24, 'Secteur C', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (25, 'Secteur D', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (26, 'Secteur E', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (27, 'Secteur F', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (28, 'Secteur G', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (29, 'Secteur H', 9, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (30, 'Brazza', 10, '4 ligne(s) de 6a à 7a');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (31, 'Grande Paroi - Berlingot', 10, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (32, 'Grande paroi - Exelsior', 10, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (33, 'Grande paroi - Hyper-patate', 10, 'Ajouter une description pour ce secteur.');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (34, 'Grande paroi - Le zéro et l''infini', 10, '2 ligne(s) de 6a à 7a');
INSERT INTO public.secteur (secteur_id, nom, site_id, description) VALUES (35, 'Rouquette gauche', 10, '5 minutes d''approche, ensoleillé toute la journée, Exposé à la pluie');


--
-- TOC entry 3030 (class 0 OID 27673)
-- Dependencies: 228
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (1, 'Casquette jaune', 100, 1, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (2, 'Gringo loco (ya basta)', 100, 1, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (3, 'L''édon de la mer', 100, 1, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (4, 'La salcoquet', 100, 1, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (5, 'Le 14 juillet', 100, 1, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (6, 'Le rat qui pue', 50, 1, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (7, 'Impact', 25, 2, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (8, 'Les croûtes aux fromages', 35, 2, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (9, 'Les soeurs qui quêtent', 35, 2, 16);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (10, 'Chaud qui peut', 20, 3, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (11, 'Douce Violence', 20, 3, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (12, 'Grattons et frottons', 0, 3, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (13, 'Harmonie', 15, 3, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (14, 'La prise du koweit', 20, 3, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (15, 'Berlin 90', 0, 4, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (16, 'Chèvres en péril', 0, 4, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (17, 'Dilatation des neurones', 0, 4, 13);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (18, 'Jardin extraordinaire', 0, 4, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (19, 'Jean d''ablon', 0, 4, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (20, 'Picocanthrope', 0, 4, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (21, 'Picothérapie', 0, 4, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (22, 'Amer', 15, 5, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (23, 'Ciel Noir', 15, 5, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (24, 'Clapotis', 15, 5, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (25, 'Errance', 15, 5, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (26, 'Grain de sable', 15, 5, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (27, 'L''Algue', 15, 5, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (28, 'La crevette', 15, 5, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (29, 'La plage', 15, 5, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (30, 'Le Port', 15, 5, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (31, 'Sourire', 30, 5, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (32, 'Crapouillot', 10, 6, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (34, 'Métal Hurlant', 10, 6, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (33, 'Ocre', 10, 6, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (35, 'De but en blanc', 20, 7, 17);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (36, 'Haut fond', 20, 7, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (37, 'La Biscotte épicée', 20, 7, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (38, 'Le nid', 20, 7, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (39, 'Les Grumeaux', 25, 7, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (40, 'Hatchepsout', 0, 8, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (41, 'Hiéroglyphes', 25, 8, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (42, 'Khéphren', 0, 8, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (43, 'Osiris', 15, 8, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (44, 'Papyrus', 10, 8, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (45, 'Pharaon', 14, 8, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (46, 'Ramsès', 14, 8, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (47, 'La petite Réva', 10, 9, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (48, 'Odeur', 13, 9, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (49, 'Scoliose', 20, 9, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (50, 'See Slide', 11, 9, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (51, 'Vague à l''âme', 15, 9, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (52, 'L''airelle des marais', 0, 10, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (53, 'L''airelle noire (myrtille)', 0, 10, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (54, 'L''airelle rouge', 0, 10, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (55, 'L''arbousier des alpes', 0, 10, 2);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (56, 'L''azalée couchée', 0, 10, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (57, 'Le rhododendron', 0, 10, 2);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (58, 'L''hermine', 0, 11, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (59, 'La belette', 0, 11, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (60, 'La fouine', 0, 11, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (61, 'Le renard', 0, 11, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (62, 'Le sanglier', 0, 11, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (63, 'Capucin', 0, 12, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (64, 'Les Daltons', 0, 12, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (65, 'Dalle en biais', 0, 13, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (66, 'Dièdre de gauche', 0, 13, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (67, 'Dièdre du milieu', 0, 13, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (68, 'Directe de droite', 0, 13, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (69, 'La dalle', 0, 13, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (70, 'Paradis artificiel', 0, 14, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (71, 'Voie normale', 250, 15, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (72, '	Pilier S', 0, 16, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (73, 'Voie des étudiants', 0, 16, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (74, 'Amigo', 20, 17, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (75, 'Flore del fango', 20, 17, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (76, 'Ecole buissonière', 20, 18, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (77, 'Filou', 20, 18, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (78, 'Gringalet', 20, 18, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (79, 'Jeu d''enfant', 20, 18, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (80, 'Les enfants du roc', 20, 18, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (81, 'Ouistiti', 20, 18, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (82, 'Petit prince', 20, 18, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (83, 'Quand je serai grand', 20, 18, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (84, 'Benchoucrane', 30, 19, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (85, 'Cambon beurre', 15, 19, 15);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (86, 'Dans tes rêves', 30, 19, 17);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (87, 'Dis-moi Céline', 30, 19, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (88, 'Elichat botté', 15, 19, 16);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (89, 'En un come back douteux', 35, 19, 21);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (90, 'Face Bouc', 35, 19, 24);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (91, 'Faschi nautique', 35, 19, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (92, 'Gipsy crack', 25, 19, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (93, 'Le foyer des vieux branleurs', 35, 19, 22);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (94, 'La giroquoi', 20, 19, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (95, 'Mon héros', 20, 19, 15);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (96, 'DST', 20, 20, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (97, 'Green Peace', 20, 20, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (98, 'Muruoa', 20, 20, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (99, 'Aioli tartiflette', 30, 21, 18);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (100, 'Buisson ardent', 30, 21, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (101, 'Diable rouge', 25, 21, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (102, 'Fais attention', 30, 21, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (103, 'Fissure trou-trou', 15, 21, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (104, 'Gare au raoul', 35, 21, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (105, 'Kaliripinos', 25, 21, 15);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (106, 'Rue Béole', 0, 22, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (107, 'Eruption', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (108, 'Pustule', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (109, 'Moulinette', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (110, 'Joe', 0, 22, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (111, 'Jack', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (112, 'William', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (113, 'Averell', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (114, 'Rantanplan', 0, 22, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (115, 'Phéromores à suivre', 0, 22, 4);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (116, 'Le cocotier branlant', 0, 22, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (117, 'Captain Hard rock', 0, 23, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (118, 'Radio lucien', 0, 23, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (119, 'Dévotion', 0, 23, 5);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (120, 'Collotmaniaque', 0, 23, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (121, 'Tirelire', 0, 23, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (122, 'Hamster jovial', 0, 23, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (123, 'Juste un zeste', 0, 24, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (124, 'Vision', 0, 24, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (125, 'La parfaite lumière', 0, 24, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (126, 'Poupon la peste', 0, 24, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (127, 'Excalibur', 0, 24, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (128, 'Friendise', 0, 24, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (129, 'La Menace', 0, 24, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (130, 'Droit de défonce', 0, 25, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (131, 'Calambredaine', 0, 25, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (132, 'Camisole de force', 0, 25, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (133, '…………', 0, 25, 10);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (134, 'Trois pommes et un boudin', 0, 25, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (135, 'Les cauchemars d’une fourmis', 0, 25, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (136, 'Momo le morbaque', 0, 25, 13);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (137, 'Tranxene 2 le matin', 0, 25, 13);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (138, 'Air du sud', 0, 26, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (139, 'Y’a plus de saison', 0, 26, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (140, 'Ganglion', 0, 26, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (141, 'Frites saucisse', 0, 27, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (142, 'Jonny l’albinnos', 0, 27, 15);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (143, 'Apocalypse à Ambrail', 0, 27, 16);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (144, 'Iznogood', 0, 27, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (145, 'Sueurs froides', 0, 27, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (146, 'Le concombre masqué', 0, 27, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (147, 'Demande express', 0, 28, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (148, 'Voie de presse', 0, 28, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (149, 'Touches pas à mes noisettes', 0, 28, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (150, 'Haute pression', 0, 28, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (151, 'Agrippine', 0, 29, 11);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (152, 'Bol de riz', 0, 29, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (153, 'L’avenir en rose', 0, 29, 7);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (154, 'Chinoiserie', 0, 29, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (155, 'Brazza', 25, 30, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (156, 'Carline', 20, 30, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (157, 'Tango Panache', 22, 30, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (158, 'Uhuru', 26, 30, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (159, 'Jours étranges', 17, 32, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (160, 'Peepone', 25, 33, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (161, 'Le zéro et l''infini', 30, 34, 15);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (162, 'Sanzisu', 35, 34, 9);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (163, 'Capsulo-plasti', 0, 35, 18);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (164, 'Chaos technique', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (165, 'Citadelle', 0, 35, 3);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (166, 'Citadelle L1+L2', 0, 35, 6);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (167, 'Coeur sauvage', 0, 35, 18);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (168, 'De la fuite dans les idées', 0, 35, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (169, 'Délivrance', 0, 35, 22);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (170, 'Dièdre rouge', 0, 35, 8);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (171, 'Eternelle present', 0, 35, 16);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (172, 'Ganymède', 0, 35, 18);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (173, 'Je meurs innocent', 0, 35, 19);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (174, 'L''âge d''or', 0, 35, 12);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (175, 'La machine à plastifier les rêves', 0, 35, 23);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (176, 'Légende des siècles', 0, 35, 14);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (177, 'Les spéciales', 0, 35, 16);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (178, 'Ma chaire et tendre pope', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (179, 'Nathalie', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (180, 'Noces', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (181, 'Papagallo', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (182, 'Pégase', 0, 35, 17);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (183, 'Potemkine', 0, 35, 21);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (184, 'Refuse/Resist', 0, 35, 20);
INSERT INTO public.voie (voie_id, nom, hauteur, secteur_id, cotation_id) VALUES (185, 'Rousserolle', 0, 35, 7);


--
-- TOC entry 3000 (class 0 OID 27548)
-- Dependencies: 198
-- Data for Name: caracteristique_voie; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3010 (class 0 OID 27589)
-- Dependencies: 208
-- Data for Name: reference; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reference (reference_id, valeur) VALUES (1, 'site');
INSERT INTO public.reference (reference_id, valeur) VALUES (2, 'secteur');
INSERT INTO public.reference (reference_id, valeur) VALUES (3, 'voie');
INSERT INTO public.reference (reference_id, valeur) VALUES (4, 'logo');


--
-- TOC entry 3027 (class 0 OID 27659)
-- Dependencies: 225
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (username, password, email, enabled) VALUES ('admin', '$2a$10$Q1Sd7.CqWZs8BNtDV5d25utOfvhmLZecw9McC9373TuQ3bICFywqC', 'admin@ocp6.com', true);
INSERT INTO public.users (username, password, email, enabled) VALUES ('user', '$2a$10$rN3JHOyZw/IMY2HRHi.uu.KxI.vS7o/JzIL5TFpGche7KjxW4THyK', 'user@ocp6.com', true);


--
-- TOC entry 3001 (class 0 OID 27551)
-- Dependencies: 199
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.commentaire (commentaire_id, commentaire, username, reference_id, date_publication, ref_id, valide) VALUES (2, 'Très beau site !', 'admin', 1, '2020-04-07', 8, true);


--
-- TOC entry 3008 (class 0 OID 27581)
-- Dependencies: 206
-- Data for Name: photo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (1, 'logo_escalade.png', 0, 4);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (15, 'Site2_89219_ablon1.jpeg', 2, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (16, 'Site2_279400_ablon2.jpeg', 2, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (17, 'Site2_139407_ablon.jpeg', 2, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (18, 'Site8_661891_Ailefroide.jpeg', 8, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (19, 'Site8_34461_Ailefroide.jpeg', 8, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (20, 'Site8_430019_Ailefroide.jpeg', 8, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (21, 'Site8_666796_Ailefroide.jpeg', 8, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (22, 'Site4_285183_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (23, 'Site4_142348_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (24, 'Site4_299832_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (25, 'Site4_802993_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (26, 'Site4_787418_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (27, 'Site4_903164_annot.jpeg', 4, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (28, 'Site7_399154_montaiguille.jpeg', 7, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (29, 'Site7_680365_montaiguille.jpeg', 7, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (30, 'Site7_3165_montaiguille.jpeg', 7, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (31, 'Site7_759061_montaiguille.jpeg', 7, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (32, 'Site7_801418_montaiguille.jpeg', 7, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (34, 'Site11_480_russan.jpeg', 11, 1);
INSERT INTO public.photo (photo_id, nom, ref_id, reference_id) VALUES (35, 'Site11_690810_russan.jpeg', 11, 1);


--
-- TOC entry 3017 (class 0 OID 27619)
-- Dependencies: 215
-- Data for Name: statut; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.statut (id, etat) VALUES (1, 'validée');
INSERT INTO public.statut (id, etat) VALUES (2, 'en attente');
INSERT INTO public.statut (id, etat) VALUES (3, 'annulée');


--
-- TOC entry 3019 (class 0 OID 27627)
-- Dependencies: 217
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (3, '40 Falaises - Escalade choisie aux environs du lac d’Annecy - R. Durieux', 2007, 2, 'admin', '1497 longueurs du 3a au 9a (de quoi vous amuser quelque temps...). Une nouvelle édition élargie de 28 falaises autour d''Annecy.');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (4, 'Grimpe à Annot et Entrevaux', 2003, 4, 'admin', 'Grimpe à Annot et Entrevaux est un topo édité par Vive les Gestes en 2003');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (5, 'Escalade en Isère - Ze topo Volume 2', 2013, 5, 'admin', 'Escalade en Isère - Ze topo Volume 2 est un topo édité par CD38 FFME en 2013');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (6, 'Est Calades', 2010, 6, 'admin', 'Est Calades est un topo édité par Club Alpin Français de Mulhouse en 2010');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (7, 'Escalades autour d''Ailefroide', 2013, 8, 'user', 'Auteur : J.-M.Cambon');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (8, 'Escalade plaisir - Alpes du Sud, Provence', 2014, 8, 'user', 'Escalade plaisir - Alpes du Sud, Provence est un topo édité par Olizane en 2014
Auteur : Hervé Galley
Prix conseillé : 22,00 €
Nombre de page : 336 page');
INSERT INTO public.topo (topo_id, nom, date_parution, site_id, username, description) VALUES (9, 'Les falaises du Gard', 2017, 10, 'user', 'Les falaises du Gard est un topo édité par en 2017
Nombre de site d''oblyk présent dans ce topo : 14
Auteur : Laurent Pierret, Thomas Sandri, Sarah Hirst
Prix conseillé : 27,00 €
Nombre de page : 192 p');


--
-- TOC entry 3020 (class 0 OID 27633)
-- Dependencies: 218
-- Data for Name: topo_reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3025 (class 0 OID 27651)
-- Dependencies: 223
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_roles (user_role_id, username, role) VALUES (3, 'user', 'ROLE_USER');
INSERT INTO public.user_roles (user_role_id, username, role) VALUES (2, 'admin', 'ROLE_ADMIN');


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 197
-- Name: caracteristique_caracteristique_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caracteristique_caracteristique_id_seq', 1, false);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 200
-- Name: commentaire_commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_commentaire_id_seq', 4, true);


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 202
-- Name: cotation_cotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cotation_cotation_id_seq', 1, false);


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 205
-- Name: description_description_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.description_description_id_seq', 11, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 207
-- Name: photo_photo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.photo_photo_id_seq', 37, true);


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 209
-- Name: reference_reference_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reference_reference_id_seq', 1, false);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 212
-- Name: secteur_secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_secteur_id_seq', 35, true);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 214
-- Name: site_site_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.site_site_id_seq', 11, true);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 216
-- Name: statut_statut_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.statut_statut_id_seq', 1, false);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 219
-- Name: topo_reservation_reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_reservation_reservation_id_seq', 16, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 220
-- Name: topo_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_topo_id_seq', 9, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 222
-- Name: type_roche_type_roche_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_roche_type_roche_id_seq', 1, false);


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_roles_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_user_role_id_seq', 9, true);


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 227
-- Name: ville_ville_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ville_ville_id_seq', 12, true);


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 229
-- Name: voie_voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_voie_id_seq', 185, true);


-- Completed on 2020-04-07 20:00:05

--
-- PostgreSQL database dump complete
--

