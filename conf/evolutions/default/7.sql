# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

INSERT INTO `espece_synonyme` (`synonyme_id`,`synonyme_nom`,`synonyme_origine_aer`,`synonyme_espece_espece_id`) VALUES
(80,'Erythromma lindenii',0,20),
(1,'Phasma gallica',0,69),
(2,'Barbitistes pyrenaea',0,73),
(3,'Barbitistes scutata',0,77),
(4,'Conocephalus discolor',0,78),
(5,'Platycleis tessellata',0,87),
(6,'Metrioptera roeselii',0,89),
(7,'Ephippiger diurnus',0,93),
(8,'Ephippiger rugosicollis',0,94),
(9,'Gryllus domesticus',0,96),
(10,'Tartarogryllus bordigalensis',0,98),
(11,'Tetrix depressa',0,104),
(12,'Uvarovitettix depressus',0,104),
(13,'Tetrix meridionalis',0,105),
(14,'Mecostethus alliaceus',0,124),
(15,'Euchorthippus pulvinatus',0,132),
(81,'Omocestus petraeus',0,135),
(16,'Chorthippus parallelus',0,140),
(17,'Chorthippus montanus',0,141),
(82,'Chorthippus vagans',0,144),
(83,'Chorthippus brunneus',0,145),
(84,'Chorthippus mollis',0,146),
(85,'Chorthippus biguttulus',0,147),
(86,'Chorthippus binotatus',0,148),
(18,'Lophyridia littoralis',0,166),
(19,'Campalita auropunctatum',0,172),
(20,'Carabus arvensis',0,174),
(21,'Carabus purpurascens',0,183),
(22,'Aphodius rufus',0,212),
(23,'Aphodius scybalarius (auct. nec Fabricius)',0,217),
(24,'Gnorimus octopunctatus',0,300),
(25,'Prionus coriarus',1,312),
(26,'Grammoptera variegata',0,322),
(27,'Pedostrangalia reverstita',1,326),
(28,'Brachyleptura cordigera',0,335),
(29,'Corymbia fontenayi',0,336),
(30,'Brachyleptura fulva',0,337),
(31,'Stictoleptura fulva',0,337),
(32,'Stictoleptura maculicornis',0,338),
(33,'Corymbia rubra',0,339),
(34,'Pseudallosterna livida',0,345),
(35,'Leptura maculata',0,347),
(36,'Arhopalus tristis',0,357),
(37,'Purpuricenus kaelheri',1,368),
(38,'Hylotrupes bajalus',1,383),
(39,'Phymatoderus lividus',0,391),
(40,'Phymatoderus pusillus',0,392),
(41,'Rusticoclytus rusticus',0,395),
(42,'Chlorophorus pilosus',0,402),
(43,'Dorcadion fuliginator',0,407),
(44,'Aphelocnemia nebulosa',0,409),
(45,'Eupogonocherus caroli',0,422),
(46,'Eupogonocherus hispidulus',0,425),
(47,'Eupogonocherus hispidus',0,426),
(48,'Anaerea carcharias',0,438),
(49,'Compsidia populnea',0,440),
(50,'Tetrops praeusta',0,455),
(87,'Hyles galii',1,507),
(88,'Carcharodus flocciferus',0,514),
(89,'Thymelicus lineolus',0,525),
(121,'Ochlodes venatus',0,528),
(90,'Colias crocea',0,542),
(91,'Neozephyrus quercus',0,547),
(92,'Heodes tityrus',0,555),
(93,'Thersamolycaena dispar',0,556),
(94,'Everes argiades',0,560),
(95,'Everes alcetas',0,561),
(96,'Maculinea alcon',0,565),
(97,'Maculinea arion',0,566),
(98,'Maculinea telejus',0,567),
(99,'Pseudotergumia fidia',0,595),
(100,'Neohipparchia statilinus',0,596),
(101,'Pandoriana pandora',0,602),
(102,'Speyeria aglaja',0,603),
(103,'Fabriciana adippe',0,604),
(104,'Fabriciana niobe',0,605),
(105,'Clossiana selene',0,609),
(106,'Clossiana euphrosyne',0,610),
(107,'Clossiana dia',0,611),
(109,'Ladoga camilla',0,613),
(110,'Azuritis reducta',0,614),
(111,'Inachis io',0,617),
(112,'Cynthia cardui',0,619),
(113,'Cynthia virginiensis',0,620),
(114,'Cinclidia phoebe',0,626),
(115,'Didymaeformia didyma',0,627),
(116,'Mellicta athalia',0,628),
(117,'Mellicta parthenoides',0,629),
(118,'Mellicta aurelia',0,630),
(51,'Cymatophorima diluta',0,638),
(52,'Thaumetopoea pityocampa',0,650),
(119,'Drymonia obliterata',0,662),
(53,'Dicallomera fascelina',0,687),
(54,'Wittia sororcula',0,706),
(55,'Spiris striata',0,718),
(56,'Hyphoraia aulica',0,721),
(57,'Epicallia villica',0,723),
(58,'Eucharia festiva',0,724),
(59,'Rhyparioides flavida',0,726),
(60,'Spilosoma luteum',0,729),
(120,'Watsonarctia casta',0,734),
(61,'Tapinoma erraticum madeirense',0,744),
(62,'Camponotus ligniperda',0,749),
(63,'Formica lusatica',0,765),
(64,'Formica candida',0,766),
(65,'Plagiolepis tauricus',0,787),
(66,'Myrmica sabuleti spinosior',0,802),
(67,'Leptothorax affinis',0,816),
(68,'Leptothorax albipennis',0,817),
(69,'Leptothorax nylanderi',0,818),
(70,'Leptothorax parvulus',0,819),
(71,'Leptothorax unifasciatus',0,820),
(122,'Callicnemis atlanticus',1,295),
(123,'Calicnemis atlanticus',0,295);

INSERT INTO `stade_sexe` (`stade_sexe_id`,`stade_sexe_intitule`,`stade_sexe_explication`) VALUES
(1,'Adulte vivant',''),
(2,'Chrysalide',''),
(3,'Nymphe',''),
(4,'Chenille',''),
(5,'Larve',''),
(6,'Œuf',''),
(7,'Indéterminé',''),
(10,'Mâle',''),
(11,'Femelle',''),
(12,'Reine',''),
(13,'Ouvrière',''),
(20,'Traces',''),
(21,'Restes imago',''),
(22,'Exuvie',''),
(23,'Cocon vide',''),
(24,'Mue larvaire',''),
(25,'Terrier larvaire',''),
(26,'Ponte vide',''),
(27,'Oothèque',''),
(28,'Nid','');

INSERT INTO `stade_sexe_hierarchie_dans_groupe` (`stade_sexe_hierarchie_dans_groupe_id`,`stade_sexe_stade_sexe_id`,`groupe_groupe_id`,`stade_sexe_pere_stade_sexe_id`) VALUES
(1,1,1,null);

INSERT INTO `ordre_has_sous_groupe` (`ordre_ordre_id`,`sous_groupe_sous_groupe_id`) VALUES
(2,3),
(4,6),
(5,7);

INSERT INTO `super_famille_has_sous_groupe` (`super_famille_super_famille_id`,`sous_groupe_sous_groupe_id`) VALUES
(1,1),
(2,1),
(3,1),
(4,2),
(5,2),
(6,2),
(8,4),
(9,4),
(10,5),
(11,5),
(22,32);

INSERT INTO `famille_has_sous_groupe` (`famille_famille_id`,`sous_groupe_sous_groupe_id`) VALUES
(29,12),
(30,13),
(31,14),
(32,15),
(33,16),
(34,17),
(35,18),
(36,19),
(37,20),
(38,21),
(41,31),
(46,33),
(47,34),
(48,35),
(49,36),
(50,37),
(51,38),
(52,39),
(53,40);

INSERT INTO `sous_famille_has_sous_groupe` (`sous_famille_sous_famille_id`,`sous_groupe_sous_groupe_id`) VALUES
(163,8),
(310,22),
(311,23),
(312,24),
(313,25),
(314,26),
(315,27),
(316,28),
(317,29),
(318,30),
(684,41),
(685,42),
(686,43),
(687,44),
(688,45),
(689,46);

INSERT INTO `espece_has_sous_groupe` (`espece_espece_id`,`sous_groupe_sous_groupe_id`) VALUES
(170,9),
(171,9),
(172,9),
(173,10),
(174,10),
(175,10),
(176,10),
(177,10),
(178,10),
(179,10),
(180,10),
(181,10),
(182,10),
(183,10),
(184,10),
(185,11),
(186,11);

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

DELETE FROM espece_synonyme;
DELETE FROM stade_sexe;
DELETE FROM stade_sexe_hierarchie_dans_groupe;
DELETE FROM ordre_has_sous_groupe;
DELETE FROM super_famille_has_sous_groupe;
DELETE FROM famille_has_sous_groupe;
DELETE FROM sous_famille_has_sous_groupe;
DELETE FROM espece_has_sous_groupe;

SET FOREIGN_KEY_CHECKS=1;
