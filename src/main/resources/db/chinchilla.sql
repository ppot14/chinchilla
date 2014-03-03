-- phpMyAdmin SQL Dump
-- version 4.0.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 01, 2014 at 04:27 PM
-- Server version: 5.1.63-rel13.4
-- PHP Version: 5.3.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gonzalol_chinchilla`
--
CREATE DATABASE IF NOT EXISTS `gonzalol_chinchilla` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gonzalol_chinchilla`;

-- --------------------------------------------------------

--
-- Table structure for table `t_coordenadas_parcela`
--
-- Creation: Feb 05, 2013 at 09:16 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_coordenadas_parcela`;
CREATE TABLE IF NOT EXISTS `t_coordenadas_parcela` (
  `id_parcela` int(11) NOT NULL,
  `orden` int(3) NOT NULL,
  `latitud` decimal(20,14) NOT NULL,
  `longitud` decimal(20,14) NOT NULL,
  PRIMARY KEY (`id_parcela`,`orden`),
  KEY `fk_id_parcela` (`id_parcela`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_coordenadas_parcela`
--

INSERT INTO `t_coordenadas_parcela` (`id_parcela`, `orden`, `latitud`, `longitud`) VALUES
(2000089, 1, '37.32581213723724', '-5.20609771010492'),
(2000089, 2, '37.32723241767651', '-5.20654894019015'),
(2000089, 3, '37.32747413127642', '-5.20665242675339'),
(2000089, 4, '37.32770054438954', '-5.20682862660831'),
(2000089, 5, '37.32792271565705', '-5.20711377031493'),
(2000089, 6, '37.33030737020313', '-5.21036160990746'),
(2000089, 7, '37.32823101573629', '-5.21047940931528'),
(2000089, 8, '37.32798284074460', '-5.21042734926474'),
(2000089, 9, '37.32766391234159', '-5.21040731379852'),
(2000089, 10, '37.32741050338930', '-5.21034635773272'),
(2000089, 11, '37.32687522444653', '-5.21004189960393'),
(2000089, 12, '37.32674555486990', '-5.20990151193722'),
(2000089, 13, '37.32653882514867', '-5.20988077810648'),
(2000089, 14, '37.32636388113608', '-5.20919042874792'),
(2000089, 15, '37.32777102328256', '-5.20908891800949'),
(2000089, 16, '37.32767374301000', '-5.20757894530745'),
(2000089, 17, '37.32689250379336', '-5.20764837611747'),
(2000089, 18, '37.32614025409322', '-5.20770783501562'),
(2000089, 19, '37.32597626620206', '-5.20734348311040'),
(2000089, 20, '37.32577051686874', '-5.20706237479735'),
(2000077, 1, '37.32613647107554', '-5.20770914267971'),
(2000077, 2, '37.32763538683333', '-5.20757740849877'),
(2000077, 3, '37.32767087088162', '-5.20827666728207'),
(2000077, 4, '37.32719366029252', '-5.20832613856187'),
(2000077, 5, '37.32721883956175', '-5.20850051580789'),
(2000077, 6, '37.32767353146886', '-5.20844330568103'),
(2000077, 7, '37.32772532586768', '-5.20905577154521'),
(2000077, 8, '37.32705003383480', '-5.20911698643145'),
(2000077, 9, '37.32699859980671', '-5.20852657114758'),
(2000077, 10, '37.32684268792949', '-5.20833114570802'),
(2000077, 11, '37.32633909103195', '-5.20834153093327'),
(2000077, 12, '37.32631734721964', '-5.20818732636527'),
(2000077, 13, '37.32613647107554', '-5.20770914267971'),
(2000077, 14, '37.32613647107554', '-5.20770914267971'),
(2000087, 1, '37.32630731879300', '-5.20836174488068'),
(2000087, 2, '37.32627532559188', '-5.20817935466766'),
(2000087, 3, '37.32601724660466', '-5.20750075578690'),
(2000087, 4, '37.32584341604341', '-5.20720973610878'),
(2000087, 5, '37.32542590112001', '-5.20677186548710'),
(2000087, 6, '37.32525153596338', '-5.20663440227509'),
(2000087, 7, '37.32506170677014', '-5.20654186606407'),
(2000087, 8, '37.32431304988354', '-5.20627766847611'),
(2000087, 9, '37.32438983554853', '-5.20668804645538'),
(2000087, 10, '37.32429598639179', '-5.20778238773346'),
(2000087, 11, '37.32581035619789', '-5.20881772041321'),
(2000087, 12, '37.32580822330416', '-5.20841270685196'),
(2000088, 1, '37.32633291334408', '-5.20922005176544'),
(2000088, 2, '37.32650994208379', '-5.20990669727325'),
(2000088, 3, '37.32629878727403', '-5.21007433533669'),
(2000088, 4, '37.32588714033288', '-5.21030098199844'),
(2000088, 5, '37.32411895243612', '-5.21042972803116'),
(2000088, 6, '37.32429598639179', '-5.20778238773346'),
(2000088, 7, '37.32578049567978', '-5.20880430936813'),
(2000088, 8, '37.32581248909160', '-5.20924419164658'),
(2000088, 9, '37.32604710702868', '-5.20926162600517'),
(2000079, 1, '37.32964946682724', '-5.20883113145828'),
(2000079, 2, '37.33069878959581', '-5.21031707525253'),
(2000079, 3, '37.33076170584081', '-5.20986847579479'),
(2000079, 4, '37.33077183641773', '-5.20954091101885'),
(2000079, 5, '37.33075424120433', '-5.20924016833305'),
(2000079, 6, '37.33071051974716', '-5.20910941064358'),
(2000079, 7, '37.33037247737817', '-5.20867019891739'),
(2000079, 8, '37.33026050717298', '-5.20860314369202'),
(2000079, 9, '37.33012987505600', '-5.20859912037849'),
(2000079, 10, '37.33001123956929', '-5.20862393081188'),
(2000078, 1, '37.32726070993510', '-5.21078109741211'),
(2000078, 2, '37.32715406723152', '-5.21198675036430'),
(2000078, 3, '37.32708155010658', '-5.21325141191483'),
(2000078, 4, '37.32566531928451', '-5.21317631006241'),
(2000078, 5, '37.32588607388710', '-5.21238036453724'),
(2000078, 6, '37.32634144485920', '-5.21105870604515'),
(2000078, 7, '37.32657819401661', '-5.21014273166657'),
(2000078, 8, '37.32671043196005', '-5.21025538444519'),
(2000078, 9, '37.32706821974514', '-5.21039754152298'),
(2000078, 10, '37.32715300080372', '-5.21045923233032'),
(2000078, 11, '37.32722871713992', '-5.21059870719910'),
(2000086, 1, '37.32702183006882', '-5.21564394235611'),
(2000086, 2, '37.32708155010658', '-5.21325945854187'),
(2000086, 3, '37.32565038899809', '-5.21319776773453'),
(2000086, 4, '37.32552454789492', '-5.21355316042900'),
(2000086, 5, '37.32538164333573', '-5.21387636661530'),
(2000086, 6, '37.32520247902683', '-5.21421700716019'),
(2000086, 7, '37.32490707027515', '-5.21461263298988'),
(2000086, 8, '37.32463298963665', '-5.21491169929504'),
(2000086, 9, '37.32461379328989', '-5.21553665399551'),
(2000086, 10, '37.32612815669128', '-5.21560639142990'),
(2000085, 1, '37.32601937949249', '-5.21964043378830'),
(2000085, 2, '37.32448368458807', '-5.21953850984573'),
(2000085, 3, '37.32461379328989', '-5.21553665399551'),
(2000085, 4, '37.32612815669128', '-5.21560639142990'),
(2000074, 1, '37.32885393390417', '-5.21575659513474'),
(2000074, 2, '37.32613882111402', '-5.21562784910202'),
(2000074, 3, '37.32602151238022', '-5.21964177489281'),
(2000074, 4, '37.32596819016796', '-5.21965384483337'),
(2000074, 5, '37.32571650881529', '-5.22514432668686'),
(2000074, 6, '37.32576556541628', '-5.22525966167450'),
(2000074, 7, '37.32844443378041', '-5.22544741630554'),
(2000075, 1, '37.32845723069308', '-5.22546082735062'),
(2000075, 2, '37.33113813583308', '-5.22547423839569'),
(2000075, 3, '37.33157108131073', '-5.21583706140518'),
(2000075, 4, '37.32885606671142', '-5.21575659513474'),
(2000076, 1, '37.33384880263159', '-5.22541791200638'),
(2000076, 2, '37.33370271490045', '-5.22545143961906'),
(2000076, 3, '37.33222209438279', '-5.22541992366314'),
(2000076, 4, '37.33113813583308', '-5.22547423839569'),
(2000076, 5, '37.33157108131073', '-5.21583706140518'),
(2000076, 6, '37.33428173248747', '-5.21582096815109'),
(2000072, 1, '37.32730123412278', '-5.21107345819473'),
(2000072, 2, '37.32714393616678', '-5.21325744688511'),
(2000072, 3, '37.32711467604456', '-5.21326088346541'),
(2000072, 4, '37.32710674448330', '-5.21355668082833'),
(2000072, 5, '37.32715486705229', '-5.21379690617323'),
(2000072, 6, '37.32710181225146', '-5.21402522921562'),
(2000072, 7, '37.32704315865915', '-5.21564662456512'),
(2000072, 8, '37.33157108131073', '-5.21583706140518'),
(2000072, 9, '37.33428173248747', '-5.21582096815109'),
(2000072, 10, '37.33424274491028', '-5.21575190126896'),
(2000072, 11, '37.33296680696391', '-5.21506592631340'),
(2000072, 12, '37.33230873574632', '-5.21456301212311'),
(2000072, 13, '37.33154708809221', '-5.21389514207840'),
(2000072, 14, '37.33030342910471', '-5.21270826458931'),
(2000072, 15, '37.32994272415790', '-5.21228313446045'),
(2000072, 16, '37.32879794769082', '-5.21063759922981'),
(2000072, 17, '37.32835245590665', '-5.21062217652798'),
(2000072, 18, '37.32776499456958', '-5.21058496087790'),
(2000072, 19, '37.32763762402777', '-5.21071387454867'),
(2000072, 20, '37.32748009349594', '-5.21077028475702'),
(2000072, 21, '37.32729255275056', '-5.21076093893498'),
(2000072, 22, '37.32726703350944', '-5.21106740226969'),
(2000073, 1, '37.32459459693820', '-5.21494388580322'),
(2000073, 2, '37.32379687754360', '-5.21548032760620'),
(2000073, 3, '37.32356651849563', '-5.21554470062256'),
(2000073, 4, '37.32325084013478', '-5.21556079387665'),
(2000073, 5, '37.32312712798307', '-5.21561980247498'),
(2000073, 6, '37.32298421886461', '-5.21572977304459'),
(2000073, 7, '37.32284237596340', '-5.21590277552605'),
(2000073, 8, '37.32230806308216', '-5.21667927503586'),
(2000073, 9, '37.32221101183183', '-5.21688312292099'),
(2000073, 10, '37.32217528414218', '-5.21700784564018'),
(2000073, 11, '37.32216515240618', '-5.21717816591263'),
(2000073, 12, '37.32223340828536', '-5.21765291690826'),
(2000073, 13, '37.32223660777815', '-5.21788626909256'),
(2000073, 14, '37.32223127529004', '-5.21805524826050'),
(2000073, 15, '37.32217581739138', '-5.21822690963745'),
(2000073, 16, '37.32175561582929', '-5.21891623735428'),
(2000073, 17, '37.32164149977096', '-5.21905973553658'),
(2000073, 18, '37.32157377660769', '-5.21923609077930'),
(2000073, 19, '37.32155697912072', '-5.21939937025309'),
(2000073, 20, '37.32159137397094', '-5.21994352340698'),
(2000073, 21, '37.32183667012061', '-5.22124171257019'),
(2000073, 22, '37.32194118736720', '-5.22163063287735'),
(2000073, 23, '37.32201584245436', '-5.22173121571541'),
(2000073, 24, '37.32207663297054', '-5.22186197340488'),
(2000073, 25, '37.32238058481384', '-5.22233873605728'),
(2000073, 26, '37.32260241555856', '-5.22281348705292'),
(2000073, 27, '37.32270906472196', '-5.22290468215942'),
(2000073, 28, '37.32299061778620', '-5.22298514842987'),
(2000073, 29, '37.32373715489526', '-5.22340357303619'),
(2000073, 30, '37.32376061736991', '-5.22334724664688'),
(2000073, 31, '37.32364863731132', '-5.22301599383354'),
(2000073, 32, '37.32327643572698', '-5.22205173969269'),
(2000073, 33, '37.32351319454126', '-5.22168561816216'),
(2000073, 34, '37.32380540934668', '-5.22110491991043'),
(2000073, 35, '37.32416694360992', '-5.22029221057892'),
(2000073, 36, '37.32444742474577', '-5.21954387426376'),
(2000080, 1, '37.32248723429208', '-5.19266545772553'),
(2000080, 2, '37.31892079364852', '-5.19217729568481'),
(2000080, 3, '37.31870748441850', '-5.19211828708649'),
(2000080, 4, '37.32027316008073', '-5.18783748149872'),
(2000080, 5, '37.32140953435196', '-5.18805205821991'),
(2000080, 6, '37.32227073569305', '-5.18815934658051'),
(2000080, 7, '37.32280451559490', '-5.18826663494110'),
(2000080, 8, '37.32285624031893', '-5.18830418586731'),
(2000081, 1, '37.31887813185094', '-5.19161671400070'),
(2000081, 2, '37.31619252295291', '-5.19025951623917'),
(2000081, 3, '37.31815501069832', '-5.18590897321701'),
(2000081, 4, '37.31819234013170', '-5.18590763211250'),
(2000081, 5, '37.31824246819870', '-5.18582046031952'),
(2000081, 6, '37.32033928462930', '-5.18730640411377'),
(2000081, 7, '37.32039367735947', '-5.18739625811577'),
(2000081, 8, '37.32037981254963', '-5.18750220537186'),
(2000082, 1, '37.31619892245276', '-5.19024610519409'),
(2000082, 2, '37.31361774664877', '-5.18897205591202'),
(2000082, 3, '37.31346415322857', '-5.18887482583523'),
(2000082, 4, '37.31342148833393', '-5.18880441784859'),
(2000082, 5, '37.31603466845129', '-5.18425673246384'),
(2000082, 6, '37.31607626527780', '-5.18422320485115'),
(2000082, 7, '37.31816354314186', '-5.18575608730316'),
(2000082, 8, '37.31814327858687', '-5.18583655357361'),
(2000082, 9, '37.31816141003108', '-5.18590092658997'),
(2000084, 1, '37.32069763600949', '-5.18025755882263'),
(2000084, 2, '37.31877574343800', '-5.17921686172485'),
(2000084, 3, '37.31868012080005', '-5.17933718394488'),
(2000084, 4, '37.31811094861122', '-5.18035872839391'),
(2000084, 5, '37.31748027799466', '-5.18158642575145'),
(2000084, 6, '37.31733669153390', '-5.18176730722189'),
(2000084, 7, '37.31715617483287', '-5.18212370574474'),
(2000084, 8, '37.31723603419499', '-5.18218187615275'),
(2000084, 9, '37.31724076709276', '-5.18226594664156'),
(2000084, 10, '37.31718577213558', '-5.18229905515909'),
(2000084, 11, '37.31710871246728', '-5.18222495913506'),
(2000084, 12, '37.31609866355947', '-5.18417894840241'),
(2000084, 13, '37.31818487424646', '-5.18572658300400'),
(2000084, 14, '37.31822167038771', '-5.18567226827145'),
(2000084, 15, '37.31826699894275', '-5.18566086888313'),
(2000083, 1, '37.32069763600949', '-5.18025755882263'),
(2000083, 2, '37.32244884049738', '-5.18122851848602'),
(2000083, 3, '37.32277198765743', '-5.18147528171539'),
(2000083, 4, '37.32267766989023', '-5.18180284649134'),
(2000083, 5, '37.32238711709873', '-5.18245764076710'),
(2000083, 6, '37.32127275440725', '-5.18502250313759'),
(2000083, 7, '37.32082721800752', '-5.18625229597092'),
(2000083, 8, '37.32043953786612', '-5.18735468387604'),
(2000083, 9, '37.31827659792730', '-5.18578827381134'),
(2000083, 10, '37.31829846227661', '-5.18571786582470'),
(2000083, 11, '37.31826699894275', '-5.18566086888313');

-- --------------------------------------------------------

--
-- Table structure for table `t_costes_maquinaria`
--
-- Creation: Nov 15, 2012 at 12:34 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_costes_maquinaria`;
CREATE TABLE IF NOT EXISTS `t_costes_maquinaria` (
  `id_coste_maquinaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `valor_compra` decimal(10,3) DEFAULT NULL,
  `valor_desecho` decimal(10,3) DEFAULT NULL,
  `horas_trabajo` int(11) DEFAULT NULL,
  `interes` decimal(10,3) DEFAULT NULL,
  `anyos_mas_1` int(11) DEFAULT NULL,
  `reparacion_variable` decimal(10,3) DEFAULT NULL,
  `alojamiento_variable` decimal(10,3) DEFAULT NULL,
  `prima_seguro` decimal(10,3) DEFAULT NULL,
  `cv` int(11) DEFAULT NULL,
  `litros_cv_y_hora` decimal(10,3) DEFAULT NULL,
  `horas_cambio_aceite` int(11) DEFAULT NULL,
  `litros_aceite` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`id_coste_maquinaria`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5000031 ;

--
-- Dumping data for table `t_costes_maquinaria`
--

INSERT INTO `t_costes_maquinaria` (`id_coste_maquinaria`, `nombre`, `tipo`, `valor_compra`, `valor_desecho`, `horas_trabajo`, `interes`, `anyos_mas_1`, `reparacion_variable`, `alojamiento_variable`, `prima_seguro`, `cv`, `litros_cv_y_hora`, `horas_cambio_aceite`, `litros_aceite`) VALUES
(5000000, 'Tractor 6220', 'Tractor', '42412.630', '10000.000', 8000, '0.035', 11, '0.600', '0.010', '142.490', 95, '0.060', 500, '15.000'),
(5000001, 'Tractor 6830', 'Tractor', '66120.000', '20000.000', 8000, '0.035', 11, '0.600', '0.010', '156.720', 140, '0.075', 250, '15.000'),
(5000002, 'Sembra. Noli', '', '4115.000', '1100.000', 900, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000003, 'Gradas', '', '4207.080', '1500.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000004, 'Congkirde 55 mtrs', '', '1502.530', '600.000', 2000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 100, '0.020'),
(5000005, 'Semivolteable 7 cabe.', '', '2043.000', '800.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000006, 'Congkirde 4 mtrs', '', '781.320', '300.000', 1000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 100, '0.020'),
(5000007, 'Cultichisel', '', '1442.430', '500.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000008, 'Subsolador', '', '1532.580', '600.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 100, '0.020'),
(5000009, 'Abonadora', '', '1812.650', '600.000', 750, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000010, 'Maquina tratamientos', '', '1757.320', '600.000', 1000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000011, 'Despedregadora', '', '10682.010', '4300.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000012, 'Sembra. Gil', '', '3572.420', '600.000', 900, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000013, 'Remolque Espejo', '', '5986.080', '2400.000', 2000, '0.035', 21, '0.600', '0.010', '14.570', 0, '0.200', 6, '0.020'),
(5000014, 'Desbrozadora', '', '5577.120', '2000.000', 1000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000015, 'Rulo', '', '3200.000', '2000.000', 400, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 12, '0.020'),
(5000016, 'Sembra. Monosem', '', '11600.000', '3000.000', 1200, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000017, 'Vibradora', '', '18252.000', '3650.000', 2750, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000018, 'Diter 57 CV con bomba', 'Motor', '9547.660', '1000.000', 15000, '0.035', 11, '0.600', '0.010', '142.490', 57, '0.053', 500, '7.000'),
(5000019, 'Campeón 24 CV con bomba', 'Motor', '5644.450', '600.000', 15000, '0.035', 11, '0.600', '0.010', '0.000', 24, '0.040', 500, '2.500'),
(5000020, 'Diter 18 CV con bomba', 'Motor', '4428.480', '300.000', 15000, '0.035', 11, '0.600', '0.010', '0.000', 18, '0.030', 500, '2.500'),
(5000021, 'Campeón 15 CV con bomba', 'Motor', '4310.890', '0.000', 10000, '0.035', 11, '0.600', '0.010', '0.000', 15, '0.030', 500, '3.000'),
(5000022, 'Goteros', 'GotAsp', '24465.850', '3000.000', 22500, '0.035', 16, '0.100', '0.002', '0.000', 0, '0.200', 12, '0.020'),
(5000023, 'Maquina tratamientos Fitosa', '', '6048.000', '1200.000', 1500, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000024, 'Aspersores', 'GotAsp', '4710.000', '0.000', 4500, '0.035', 16, '0.100', '0.002', '0.000', 0, '0.200', 12, '0.020'),
(5000025, 'Regabina 7 cuerpos', '', '1309.000', '600.000', 300, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 100, '0.020'),
(5000026, 'Remolque Gomez', '', '8932.000', '3000.000', 2000, '0.035', 21, '0.600', '0.010', '14.570', 0, '0.200', 6, '0.020'),
(5000027, 'Atomizador Fitosa', '', '8100.000', '1620.000', 1000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000028, 'Sistema riego olivos', '', '19421.560', '1000.000', 15000, '0.035', 16, '0.600', '0.010', '0.000', 10, '1.000', 6, '0.020'),
(5000029, 'Vareadoras Olivelos 3', '', '3870.000', '300.000', 2000, '0.035', 16, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020'),
(5000030, 'Pala Tenias', '', '7189.680', '2500.000', 2000, '0.035', 11, '0.600', '0.010', '0.000', 0, '0.200', 6, '0.020');

-- --------------------------------------------------------

--
-- Table structure for table `t_costes_personal`
--
-- Creation: Aug 09, 2013 at 08:40 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_costes_personal`;
CREATE TABLE IF NOT EXISTS `t_costes_personal` (
  `id_coste_personal` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `funcion` varchar(45) DEFAULT NULL,
  `salario_base` decimal(10,3) DEFAULT NULL,
  `paga_extra` decimal(10,3) DEFAULT NULL,
  `horas_anuales` int(11) DEFAULT NULL,
  `base_ssp` decimal(10,3) DEFAULT NULL,
  `desempleo_pc` decimal(10,3) DEFAULT NULL,
  `plus_distancia` decimal(10,3) DEFAULT NULL,
  `km` decimal(10,3) DEFAULT NULL,
  `horas_dia` decimal(10,3) DEFAULT NULL,
  `validez_inicio` date NOT NULL DEFAULT '1999-01-01',
  `validez_fin` date NOT NULL DEFAULT '2100-12-31',
  PRIMARY KEY (`id_coste_personal`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4000004 ;

--
-- Dumping data for table `t_costes_personal`
--

INSERT INTO `t_costes_personal` (`id_coste_personal`, `tipo`, `funcion`, `salario_base`, `paga_extra`, `horas_anuales`, `base_ssp`, `desempleo_pc`, `plus_distancia`, `km`, `horas_dia`, `validez_inicio`, `validez_fin`) VALUES
(4000000, 'Fijo', NULL, '28.590', '2573.100', 1785, '39.000', '0.055', '0.000', '0.000', '6.500', '1999-01-01', '2100-12-31'),
(4000001, 'Eventual', 'Poda', '43.200', '0.000', 0, '39.000', '0.067', '1.090', '0.000', '6.330', '1999-01-01', '2100-12-31'),
(4000002, 'Eventual', 'Desvarete y escarda', '41.750', '0.000', 0, '39.000', '0.067', '1.090', '0.000', '6.330', '1999-01-01', '2100-12-31'),
(4000003, 'Eventual', 'Cogedores', '43.200', '0.000', 0, '39.000', '0.067', '1.090', '0.000', '6.330', '1999-01-01', '2100-12-31');

-- --------------------------------------------------------

--
-- Table structure for table `t_cultivos`
--
-- Creation: Nov 10, 2012 at 11:16 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_cultivos`;
CREATE TABLE IF NOT EXISTS `t_cultivos` (
  `id_cultivo` int(11) NOT NULL AUTO_INCREMENT,
  `variedad` varchar(45) DEFAULT NULL,
  `especie` varchar(45) DEFAULT NULL,
  `destino` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cultivo`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1000019 ;

--
-- Dumping data for table `t_cultivos`
--

INSERT INTO `t_cultivos` (`id_cultivo`, `variedad`, `especie`, `destino`) VALUES
(1000000, 'Alameda', 'Haba', ''),
(1000001, 'Duro Avispa', 'Trigo', ''),
(1000002, 'Blando Arthur Nick', 'Trigo', ''),
(1000003, '', 'Algodon', ''),
(1000004, 'Hojiblancas', 'Aceituna', 'Oxidacion-Verdeo'),
(1000005, 'Hojiblancas', 'Aceituna', 'Molino'),
(1000006, 'Aberquinos', 'Aceituna', 'Molino'),
(1000007, 'Sirios', 'Garbanzo', ''),
(1000008, 'Jerez', 'Habas', ''),
(1000009, 'Pioner A-76', 'Girasol', ''),
(1000010, 'Pioner A-77', 'Girasol', ''),
(1000011, 'Pioner A-78', 'Girasol', ''),
(1000012, 'Pioner A-79', 'Girasol', ''),
(1000013, 'Navio', 'Girasol', ''),
(1000014, 'Duro Beldur', 'Trigo', NULL),
(1000015, 'Blando Salma', 'Trigo', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_formulas`
--
-- Creation: Nov 10, 2012 at 11:16 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_formulas`;
CREATE TABLE IF NOT EXISTS `t_formulas` (
  `id_formula` int(11) NOT NULL AUTO_INCREMENT,
  `funcion` varchar(45) DEFAULT NULL,
  `sub_funcion` varchar(45) DEFAULT NULL,
  `formula` text,
  `descripcion` text,
  PRIMARY KEY (`id_formula`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7000005 ;

--
-- Dumping data for table `t_formulas`
--

INSERT INTO `t_formulas` (`id_formula`, `funcion`, `sub_funcion`, `formula`, `descripcion`) VALUES
(7000000, 'CosteLabor', 'AplicacionMaquinaria', '(CM+CM+CP)*C', 'Calculo de coste por hectarea de una labor de una o dos maquinarias (tractor y/o maquinaria) mas el coste del personal multiplicado por el coste de tiempo por hectarea'),
(7000001, 'CosteLabor', 'AplicacionProducto', 'C*FSF+C*FSF+C*FSF+C*FSF+C*FSF', 'Calculo del coste por hectarea de una labor de aplicacion de productos del tipo fertilizantes, semillas y fitosanitarios. Multiplicados cada uno por la cantidad de unidades de cada producto empleada en la labor'),
(7000002, 'CosteLabor', 'Fijo', 'C', 'Calculo del coste por hectarea de una labor con valor fijo'),
(7000003, 'CosteLabor', 'AspersoresGotero', 'CM+CM*C+C/sum(R)', 'Calculo del coste por hectarea de una labor de aspersores y goteros, de riego de olivos o coste de la electricidad'),
(7000004, 'CosteLabor', 'Motores', '((CM*C+CM+CM+CM+CM)*C)/P*C', 'Calculo del coste por hectarea de una labor de hasta 5 motores (maquinaria)');

-- --------------------------------------------------------

--
-- Table structure for table `t_l_costes_personal`
--
-- Creation: Aug 09, 2013 at 08:39 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_l_costes_personal`;
CREATE TABLE IF NOT EXISTS `t_l_costes_personal` (
  `id_labor` int(11) NOT NULL,
  `id_coste_personal` int(11) NOT NULL,
  `id_personal` int(11) NOT NULL DEFAULT '0',
  `multiplicador` decimal(10,3) NOT NULL DEFAULT '1.000',
  `constante` decimal(10,3) NOT NULL DEFAULT '0.000',
  `posicion_formula` int(11) NOT NULL,
  PRIMARY KEY (`id_labor`,`id_coste_personal`,`id_personal`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_l_costes_personal`
--

INSERT INTO `t_l_costes_personal` (`id_labor`, `id_coste_personal`, `id_personal`, `multiplicador`, `constante`, `posicion_formula`) VALUES
(9000001, 4000000, 0, '1.000', '0.000', 1),
(9000002, 4000000, 0, '1.000', '0.000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_labores`
--
-- Creation: Aug 09, 2013 at 08:40 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_labores`;
CREATE TABLE IF NOT EXISTS `t_labores` (
  `id_labor` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_labor` int(11) NOT NULL,
  `fecha_comienzo` date NOT NULL,
  `cantidad_dosis_por_ha` decimal(10,3) NOT NULL,
  `duracion` decimal(10,3) NOT NULL,
  `litros_gasoil` decimal(10,3) NOT NULL,
  PRIMARY KEY (`id_labor`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9000003 ;

--
-- Dumping data for table `t_labores`
--

INSERT INTO `t_labores` (`id_labor`, `id_tipo_labor`, `fecha_comienzo`, `cantidad_dosis_por_ha`, `duracion`, `litros_gasoil`) VALUES
(9000001, 8000057, '2012-02-20', '1.000', '7.800', '48.260'),
(9000002, 8000019, '2012-02-14', '1.000', '9.760', '120.540');

-- --------------------------------------------------------

--
-- Table structure for table `t_labores_parcelas`
--
-- Creation: Aug 08, 2013 at 03:49 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_labores_parcelas`;
CREATE TABLE IF NOT EXISTS `t_labores_parcelas` (
  `id_labor` int(11) NOT NULL,
  `id_parcela` int(11) NOT NULL,
  PRIMARY KEY (`id_labor`,`id_parcela`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_labores_parcelas`
--

INSERT INTO `t_labores_parcelas` (`id_labor`, `id_parcela`) VALUES
(9000001, 2000084),
(9000002, 2000084);

-- --------------------------------------------------------

--
-- Table structure for table `t_meteo`
--
-- Creation: Aug 09, 2013 at 08:41 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_meteo`;
CREATE TABLE IF NOT EXISTS `t_meteo` (
  `id_meteo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `publio_chinchilla` decimal(10,3) NOT NULL,
  `publio_osuna` decimal(10,3) NOT NULL,
  `viento` varchar(45) CHARACTER SET latin1 NOT NULL,
  `estado` varchar(45) CHARACTER SET latin1 NOT NULL,
  `temp_max` decimal(10,3) NOT NULL,
  `temp_min` decimal(10,3) NOT NULL,
  PRIMARY KEY (`id_meteo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_ordenes_compra`
--
-- Creation: Aug 09, 2013 at 08:41 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_ordenes_compra`;
CREATE TABLE IF NOT EXISTS `t_ordenes_compra` (
  `id_orden_compra` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `cantidad` decimal(10,3) NOT NULL,
  `precio` decimal(10,3) NOT NULL,
  `marca` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `proveedor` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `fecha` date NOT NULL,
  `medida` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id_orden_compra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_parcelas`
--
-- Creation: Feb 05, 2013 at 10:17 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_parcelas`;
CREATE TABLE IF NOT EXISTS `t_parcelas` (
  `id_parcela` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `nombre_corto` varchar(45) DEFAULT NULL,
  `zona` varchar(45) DEFAULT NULL,
  `extension` decimal(10,3) DEFAULT NULL,
  `cultivo_fijo` varchar(45) DEFAULT NULL,
  `color` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id_parcela`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2000090 ;

--
-- Dumping data for table `t_parcelas`
--

INSERT INTO `t_parcelas` (`id_parcela`, `nombre`, `nombre_corto`, `zona`, `extension`, `cultivo_fijo`, `color`) VALUES
(2000077, 'Ruedo Huerta', 'Rd Ht', 'Chinchilla', '1.880', '', 'FB9A99'),
(2000078, 'Ruedo Pozo', 'Rd Pz', 'Chinchilla', '3.280', '', 'FDBF6F'),
(2000079, 'Ruedo Canal', 'Rd Cn', 'Chinchilla', '1.000', '', 'B2DF8A'),
(2000080, 'I Rancho', 'I Rn', 'Rancho', '14.260', '', 'A6CEE3'),
(2000081, 'II Rancho', 'II Rn', 'Rancho', '12.970', '', '1F78B4'),
(2000082, 'III Rancho', 'III Rn', 'Rancho', '14.630', '', 'CAB2D6'),
(2000083, 'IV Rancho', 'IV Rn', 'Rancho', '14.870', '', '6A3D9A'),
(2000084, 'V Rancho', 'V Rn', 'Rancho', '14.160', '', 'E31A1C'),
(2000085, 'Los Seis', 'Las6', 'Chinchilla', '6.000', 'Hojiblanca', 'FB9A99'),
(2000086, 'Chaparro', 'Chap', 'Chinchilla', '4.950', 'Hojiblanca', 'A6CEE3'),
(2000087, 'Ruedo este', 'Ru O', 'Chinchilla', '2.890', 'Hojiblanca', '32A02C'),
(2000088, 'Ruedo oeste', 'Ru E', 'Chinchilla', '3.910', 'Arbequino', 'E31A1C'),
(2000089, 'Huerta', 'Ht', 'Chinchilla', '7.850', 'Arbequino', '1F78B4'),
(2000072, 'I Chinchilla', 'I Ch', 'Chinchilla', '20.450', '', 'CAB2D6'),
(2000073, 'II Chinchilla', 'II Ch', 'Chinchilla', '15.780', '', '6A3D9A'),
(2000074, 'III Chinchilla', 'III Ch', 'Chinchilla', '25.000', '', 'B2DF8A'),
(2000075, 'IV Chinchilla', 'IV Ch', 'Chinchilla', '25.000', '', '32A02C'),
(2000076, 'V Chinchilla', 'V Ch', 'Chinchilla', '25.000', '', 'FF7F00');

-- --------------------------------------------------------

--
-- Table structure for table `t_personal`
--
-- Creation: Aug 09, 2013 at 08:41 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_personal`;
CREATE TABLE IF NOT EXISTS `t_personal` (
  `id_personal` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  PRIMARY KEY (`id_personal`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_producciones`
--
-- Creation: Nov 10, 2012 at 11:16 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_producciones`;
CREATE TABLE IF NOT EXISTS `t_producciones` (
  `id_produccion` int(11) NOT NULL AUTO_INCREMENT,
  `id_cultivo` int(11) NOT NULL,
  `id_parcela` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `kilos` int(11) DEFAULT NULL,
  `precio_kilo` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`id_produccion`),
  KEY `id_cultivo` (`id_cultivo`),
  KEY `id_parcela` (`id_parcela`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6000227 ;

--
-- Dumping data for table `t_producciones`
--

INSERT INTO `t_producciones` (`id_produccion`, `id_cultivo`, `id_parcela`, `fecha`, `kilos`, `precio_kilo`) VALUES
(6000000, 1000001, 2000072, '2010-01-01', 10845, NULL),
(6000001, 1000001, 2000072, '2010-01-01', 8845, NULL),
(6000002, 1000001, 2000072, '2010-01-01', 12955, NULL),
(6000003, 1000001, 2000072, '2010-01-01', 13045, NULL),
(6000004, 1000001, 2000072, '2010-01-01', 7530, NULL),
(6000005, 1000009, 2000073, '2010-01-01', 5790, NULL),
(6000006, 1000010, 2000073, '2010-01-01', 5885, NULL),
(6000007, 1000011, 2000073, '2010-01-01', 5565, NULL),
(6000008, 1000012, 2000073, '2010-01-01', 2000, NULL),
(6000009, 1000013, 2000074, '2010-01-01', 6225, NULL),
(6000010, 1000013, 2000074, '2010-01-01', 4330, NULL),
(6000011, 1000008, 2000075, '2010-01-01', 7800, NULL),
(6000012, 1000008, 2000075, '2010-01-01', 12820, NULL),
(6000013, 1000008, 2000075, '2010-01-01', 4930, NULL),
(6000014, 1000008, 2000075, '2010-01-01', 4735, NULL),
(6000015, 1000001, 2000076, '2010-01-01', 12255, NULL),
(6000016, 1000001, 2000076, '2010-01-01', 12515, NULL),
(6000017, 1000001, 2000076, '2010-01-01', 11905, NULL),
(6000018, 1000001, 2000076, '2010-01-01', 8830, NULL),
(6000019, 1000001, 2000076, '2010-01-01', 13000, NULL),
(6000020, 1000009, 2000078, '2010-01-01', 3000, NULL),
(6000021, 1000009, 2000079, '2010-01-01', 1305, NULL),
(6000022, 1000002, 2000080, '2010-01-01', 8230, NULL),
(6000023, 1000002, 2000080, '2010-01-01', 12910, NULL),
(6000024, 1000002, 2000080, '2010-01-01', 8410, NULL),
(6000025, 1000002, 2000080, '2010-01-01', 10470, NULL),
(6000026, 1000002, 2000080, '2010-01-01', 6000, NULL),
(6000027, 1000002, 2000080, '2010-01-01', 4500, NULL),
(6000028, 1000009, 2000081, '2010-01-01', 6050, NULL),
(6000029, 1000010, 2000081, '2010-01-01', 6150, NULL),
(6000030, 1000011, 2000081, '2010-01-01', 3420, NULL),
(6000031, 1000012, 2000081, '2010-01-01', 6025, NULL),
(6000032, 1000003, 2000082, '2010-01-01', 2782, NULL),
(6000033, 1000003, 2000082, '2010-01-01', 4570, NULL),
(6000034, 1000008, 2000083, '2010-01-01', 13090, NULL),
(6000035, 1000008, 2000083, '2010-01-01', 9085, NULL),
(6000036, 1000008, 2000083, '2010-01-01', 10275, NULL),
(6000037, 1000008, 2000083, '2010-01-01', 13000, NULL),
(6000038, 1000003, 2000084, '2010-01-01', 9984, NULL),
(6000039, 1000003, 2000084, '2010-01-01', 4177, NULL),
(6000040, 1000004, 2000087, '2010-01-01', 5392, NULL),
(6000041, 1000005, 2000087, '2010-01-01', 5120, NULL),
(6000042, 1000005, 2000087, '2010-01-01', 4777, NULL),
(6000043, 1000005, 2000087, '2010-01-01', 4623, NULL),
(6000044, 1000006, 2000088, '2010-01-01', 1232, NULL),
(6000045, 1000006, 2000088, '2010-01-01', 224, NULL),
(6000046, 1000006, 2000088, '2010-01-01', 1975, NULL),
(6000047, 1000006, 2000088, '2010-01-01', 1742, NULL),
(6000048, 1000006, 2000088, '2010-01-01', 1548, NULL),
(6000049, 1000006, 2000088, '2010-01-01', 1377, NULL),
(6000050, 1000006, 2000088, '2010-01-01', 112, NULL),
(6000051, 1000004, 2000086, '2010-01-01', 1627, NULL),
(6000052, 1000004, 2000086, '2010-01-01', 1900, NULL),
(6000053, 1000004, 2000086, '2010-01-01', 2142, NULL),
(6000054, 1000004, 2000086, '2010-01-01', 4121, NULL),
(6000055, 1000004, 2000086, '2010-01-01', 3666, NULL),
(6000056, 1000004, 2000086, '2010-01-01', 2926, NULL),
(6000057, 1000004, 2000086, '2010-01-01', 1672, NULL),
(6000058, 1000004, 2000085, '2010-01-01', 2788, NULL),
(6000059, 1000004, 2000085, '2010-01-01', 5480, NULL),
(6000060, 1000004, 2000085, '2010-01-01', 5905, NULL),
(6000061, 1000004, 2000085, '2010-01-01', 5402, NULL),
(6000062, 1000004, 2000085, '2010-01-01', 6550, NULL),
(6000063, 1000004, 2000085, '2010-01-01', 6576, NULL),
(6000064, 1000004, 2000085, '2010-01-01', 5851, NULL),
(6000065, 1000004, 2000085, '2010-01-01', 6444, NULL),
(6000066, 1000004, 2000085, '2010-01-01', 5712, NULL),
(6000067, 1000006, 2000089, '2010-01-01', 1064, NULL),
(6000068, 1000006, 2000089, '2010-01-01', 1121, NULL),
(6000069, 1000006, 2000089, '2010-01-01', 1256, NULL),
(6000070, 1000006, 2000089, '2010-01-01', 1748, NULL),
(6000071, 1000006, 2000089, '2010-01-01', 716, NULL),
(6000072, 1000006, 2000089, '2010-01-01', 1015, NULL),
(6000073, 1000006, 2000089, '2010-01-01', 985, NULL),
(6000074, 1000006, 2000089, '2010-01-01', 1031, NULL),
(6000226, 1000012, 2000089, '2013-09-25', 999999, '0.567');

-- --------------------------------------------------------

--
-- Table structure for table `t_productos`
--
-- Creation: Sep 30, 2013 at 12:51 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_productos`;
CREATE TABLE IF NOT EXISTS `t_productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `grupo` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `num_reg_ma` varchar(45) DEFAULT NULL,
  `plazo_seguridad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3000085 ;

--
-- Dumping data for table `t_productos`
--

INSERT INTO `t_productos` (`id_producto`, `grupo`, `tipo`, `nombre`, `descripcion`, `num_reg_ma`, `plazo_seguridad`) VALUES
(3000000, 'Fertilizantes', 'Fertilizantes', '0-24-8', NULL, NULL, NULL),
(3000001, 'Fertilizantes', 'Fertilizantes', '18-46-0', NULL, NULL, NULL),
(3000002, 'Fertilizantes', 'Fertilizantes', '8-24-8', NULL, NULL, NULL),
(3000003, 'Fertilizantes', 'Fertilizantes', 'Ac. Ni.', NULL, NULL, NULL),
(3000004, 'Fertilizantes', 'Fertilizantes', 'Aminoacidos', NULL, NULL, NULL),
(3000005, 'Fertilizantes', 'Fertilizantes', 'Bioacido 2-3-14', NULL, NULL, NULL),
(3000006, 'Fertilizantes', 'Fertilizantes', 'Bioacidos 0-0-12', NULL, NULL, NULL),
(3000007, 'Fertilizantes', 'Fertilizantes', 'Bioacidos 8-4-12', NULL, NULL, NULL),
(3000008, 'Fertilizantes', 'Fertilizantes', 'Bo 5%', NULL, NULL, NULL),
(3000009, 'Fertilizantes', 'Fertilizantes', 'Carbotec K-44', NULL, NULL, NULL),
(3000010, 'Fertilizantes', 'Fertilizantes', 'K-37%', NULL, NULL, NULL),
(3000011, 'Fertilizantes', 'Fertilizantes', 'Mg 5%', NULL, NULL, NULL),
(3000012, 'Fertilizantes', 'Fertilizantes', 'N 20%', NULL, NULL, NULL),
(3000013, 'Fertilizantes', 'Fertilizantes', 'Nitrato K', NULL, NULL, NULL),
(3000014, 'Fertilizantes', 'Fertilizantes', 'NSA 27 %', NULL, NULL, NULL),
(3000015, 'Fertilizantes', 'Fertilizantes', 'S. nitro', NULL, NULL, NULL),
(3000016, 'Fertilizantes', 'Fertilizantes', 'S.N.32%', NULL, NULL, NULL),
(3000017, 'Fertilizantes', 'Fertilizantes', 'Triple 20', NULL, NULL, NULL),
(3000018, 'Fertilizantes', 'Fertilizantes', 'Urea', NULL, NULL, NULL),
(3000019, 'Fertilizantes', 'Fertilizantes', 'Urea 46%', NULL, NULL, NULL),
(3000020, 'Fertilizantes', 'Fertilizantes', 'Zn 5%', NULL, NULL, NULL),
(3000021, 'Fitosanitarios', 'Desfoliantes y otros', 'Dash', NULL, NULL, NULL),
(3000022, 'Fitosanitarios', 'Desfoliantes y otros', 'Ditene moja. 20%', NULL, NULL, NULL),
(3000023, 'Fitosanitarios', 'Desfoliantes y otros', 'Mojante', NULL, NULL, NULL),
(3000024, 'Fitosanitarios', 'Desfoliantes y otros', 'Ph', NULL, NULL, NULL),
(3000025, 'Fitosanitarios', 'Desfoliantes y otros', 'Ph optimal', NULL, NULL, NULL),
(3000026, 'Fitosanitarios', 'Desfoliantes y otros', 'Temojan', NULL, NULL, NULL),
(3000027, 'Fitosanitarios', 'Desfoliantes y otros', 'Tidiazuron 50%', NULL, NULL, NULL),
(3000028, 'Fitosanitarios', 'Fungicidas', 'Hidro cobre 36%', NULL, NULL, NULL),
(3000029, 'Fitosanitarios', 'Fungicidas', 'Oxi cloru cobre 52%', NULL, NULL, NULL),
(3000030, 'Fitosanitarios', 'Fungicidas', 'Punch', NULL, NULL, NULL),
(3000031, 'Fitosanitarios', 'Fungicidas', 'Sultato cuprico 20%', NULL, NULL, NULL),
(3000032, 'Fitosanitarios', 'Herbicidas', '24 D+ MCPA', NULL, NULL, NULL),
(3000033, 'Fitosanitarios', 'Herbicidas', 'Alacloro 48%', NULL, NULL, NULL),
(3000034, 'Fitosanitarios', 'Herbicidas', 'Atlantis', NULL, NULL, NULL),
(3000035, 'Fitosanitarios', 'Herbicidas', 'Clopiralida+24-D', NULL, NULL, NULL),
(3000036, 'Fitosanitarios', 'Herbicidas', 'Diclofop 36%', NULL, NULL, NULL),
(3000037, 'Fitosanitarios', 'Herbicidas', 'Dicua-Paraqua', NULL, NULL, NULL),
(3000038, 'Fitosanitarios', 'Herbicidas', 'Doble sal FCPO', NULL, NULL, NULL),
(3000039, 'Fitosanitarios', 'Herbicidas', 'Esta. Fluroxipir 20%', NULL, NULL, NULL),
(3000040, 'Fitosanitarios', 'Herbicidas', 'Fluometuron 50%', NULL, NULL, NULL),
(3000041, 'Fitosanitarios', 'Herbicidas', 'Galant.Haloxifop', NULL, NULL, NULL),
(3000042, 'Fitosanitarios', 'Herbicidas', 'Glifosato 36%', NULL, NULL, NULL),
(3000043, 'Fitosanitarios', 'Herbicidas', 'Glifosato 45%', NULL, NULL, NULL),
(3000044, 'Fitosanitarios', 'Herbicidas', 'Glifosato 66% transord', NULL, NULL, NULL),
(3000045, 'Fitosanitarios', 'Herbicidas', 'Granstar.Tribenuron 75%', NULL, NULL, NULL),
(3000046, 'Fitosanitarios', 'Herbicidas', 'Grotex Comples', NULL, NULL, NULL),
(3000047, 'Fitosanitarios', 'Herbicidas', 'Linuron 45%', NULL, NULL, NULL),
(3000048, 'Fitosanitarios', 'Herbicidas', 'Mcpa 40%', NULL, NULL, NULL),
(3000049, 'Fitosanitarios', 'Herbicidas', 'Oxifluorfen 24%', NULL, NULL, NULL),
(3000050, 'Fitosanitarios', 'Herbicidas', 'Posta', NULL, NULL, NULL),
(3000051, 'Fitosanitarios', 'Herbicidas', 'Pulsar 40', NULL, NULL, NULL),
(3000052, 'Fitosanitarios', 'Herbicidas', 'Puma super n', NULL, NULL, NULL),
(3000053, 'Fitosanitarios', 'Herbicidas', 'Rokenil', NULL, NULL, NULL),
(3000054, 'Fitosanitarios', 'Herbicidas', 'Simazina', NULL, NULL, NULL),
(3000055, 'Fitosanitarios', 'Herbicidas', 'Topix Evo', NULL, NULL, NULL),
(3000056, 'Fitosanitarios', 'Herbicidas', 'Trifularina 06', NULL, NULL, NULL),
(3000057, 'Fitosanitarios', 'Herbicidas', 'Trimmer', NULL, NULL, NULL),
(3000058, 'Fitosanitarios', 'Herbicidas', 'Zarpa-Diflufenican 4%+Glifosato 16%', NULL, NULL, NULL),
(3000059, 'Fitosanitarios', 'Insecticidas', 'Alfacipermetrina 10%', NULL, NULL, NULL),
(3000060, 'Fitosanitarios', 'Insecticidas', 'Cipermetri. 10%', NULL, NULL, NULL),
(3000061, 'Fitosanitarios', 'Insecticidas', 'Clorpirifos 48%', NULL, NULL, NULL),
(3000062, 'Fitosanitarios', 'Insecticidas', 'Curater Carbofurano 5%', NULL, NULL, NULL),
(3000063, 'Fitosanitarios', 'Insecticidas', 'Dimetoato 40%', NULL, NULL, NULL),
(3000064, 'Fitosanitarios', 'Insecticidas', 'Endosulfan 35%', NULL, NULL, NULL),
(3000065, 'Fitosanitarios', 'Insecticidas', 'Fosmet 20%', NULL, NULL, NULL),
(3000066, 'Fitosanitarios', 'Insecticidas', 'Fosmet 50%', NULL, NULL, NULL),
(3000067, 'Fitosanitarios', 'Insecticidas', 'Metomilo 20%', NULL, NULL, NULL),
(3000068, 'Semilllas', 'Semilllas', 'Algodón Betica', NULL, NULL, NULL),
(3000069, 'Semilllas', 'Semilllas', 'Algodón Lider', NULL, NULL, NULL),
(3000070, 'Semilllas', 'Semilllas', 'Amilcar Trigo Duro', NULL, NULL, NULL),
(3000071, 'Semilllas', 'Semilllas', 'Artur nick granel Trigo Blando', NULL, NULL, NULL),
(3000072, 'Semilllas', 'Semilllas', 'Beldur Trigo Duro R-2', NULL, NULL, NULL),
(3000073, 'Semilllas', 'Semilllas', 'Garbanzos', NULL, NULL, NULL),
(3000074, 'Semilllas', 'Semilllas', 'Girasol', NULL, NULL, NULL),
(3000075, 'Semilllas', 'Semilllas', 'Girasol Mauro', NULL, NULL, NULL),
(3000076, 'Semilllas', 'Semilllas', 'Girasol Neoma', NULL, NULL, NULL),
(3000077, 'Semilllas', 'Semilllas', 'Girasol Pioner A76', NULL, NULL, NULL),
(3000078, 'Semilllas', 'Semilllas', 'Habas', NULL, NULL, NULL),
(3000079, 'Semilllas', 'Semilllas', 'Habas Jerez', NULL, NULL, NULL),
(3000080, 'Semilllas', 'Semilllas', 'Iride Trigo Duro', NULL, NULL, NULL),
(3000081, 'Semilllas', 'Semilllas', 'Salama Trigo Blando R-2', NULL, NULL, NULL),
(3000082, 'Semilllas', 'Semilllas', 'Saragolla Trigo Blando monton', NULL, NULL, NULL),
(3000083, 'Semilllas', 'Semilllas', 'Trigo Blando', NULL, NULL, NULL),
(3000084, 'Carburante', 'Gasoleo', 'Gasoleo Agricola', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_riegos`
--
-- Creation: Aug 09, 2013 at 08:42 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_riegos`;
CREATE TABLE IF NOT EXISTS `t_riegos` (
  `id_riego` int(11) NOT NULL AUTO_INCREMENT,
  `id_parcela` int(11) NOT NULL,
  `litros` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `horas` decimal(10,3) NOT NULL,
  PRIMARY KEY (`id_riego`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_t_l_costes_maquinaria`
--
-- Creation: Aug 08, 2013 at 03:35 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_t_l_costes_maquinaria`;
CREATE TABLE IF NOT EXISTS `t_t_l_costes_maquinaria` (
  `id_tipo_labor` int(11) NOT NULL,
  `id_coste_maquinaria` int(11) NOT NULL,
  `multiplicador` decimal(10,3) DEFAULT '1.000',
  `constante` decimal(10,3) DEFAULT '0.000',
  `posicion_formula` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_labor`,`id_coste_maquinaria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_t_l_costes_maquinaria`
--

INSERT INTO `t_t_l_costes_maquinaria` (`id_tipo_labor`, `id_coste_maquinaria`, `multiplicador`, `constante`, `posicion_formula`) VALUES
(8000000, 5000000, '1.000', '0.000', 1),
(8000000, 5000009, '1.000', '0.000', 2),
(8000005, 5000000, '1.000', '0.000', 1),
(8000005, 5000027, '1.000', '0.000', 2),
(8000006, 5000000, '1.000', '0.000', 1),
(8000006, 5000025, '1.000', '0.000', 2),
(8000019, 5000001, '1.000', '0.000', 1),
(8000019, 5000003, '1.000', '0.000', 2),
(8000057, 5000001, '1.000', '0.000', 1),
(8000057, 5000015, '1.000', '0.000', 2);

-- --------------------------------------------------------

--
-- Table structure for table `t_t_l_productos`
--
-- Creation: Aug 09, 2013 at 08:42 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_t_l_productos`;
CREATE TABLE IF NOT EXISTS `t_t_l_productos` (
  `id_tipo_labor` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `multiplicador` decimal(10,3) NOT NULL,
  `constante` decimal(10,3) NOT NULL,
  `posicion_formula` int(11) NOT NULL,
  PRIMARY KEY (`id_tipo_labor`,`id_producto`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_t_l_productos`
--

INSERT INTO `t_t_l_productos` (`id_tipo_labor`, `id_producto`, `multiplicador`, `constante`, `posicion_formula`) VALUES
(8000020, 3000032, '1.000', '0.000', 1),
(8000021, 3000039, '0.350', '0.000', 1),
(8000021, 3000043, '3.000', '0.000', 2),
(8000021, 3000024, '0.075', '0.000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `t_t_l_variables`
--
-- Creation: Aug 09, 2013 at 08:31 AM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_t_l_variables`;
CREATE TABLE IF NOT EXISTS `t_t_l_variables` (
  `id_tipo_labor` int(11) NOT NULL,
  `posicion_formula` int(11) NOT NULL,
  `valor` decimal(10,3) NOT NULL,
  PRIMARY KEY (`id_tipo_labor`,`posicion_formula`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_t_l_variables`
--

INSERT INTO `t_t_l_variables` (`id_tipo_labor`, `posicion_formula`, `valor`) VALUES
(8000000, 1, '0.150'),
(8000005, 1, '0.200'),
(8000006, 1, '0.650'),
(8000019, 1, '0.600'),
(8000057, 1, '0.280');

-- --------------------------------------------------------

--
-- Table structure for table `t_tipos_labores`
--
-- Creation: Jan 17, 2013 at 12:29 PM
-- Last update: Feb 17, 2014 at 09:33 AM
-- Last check: Feb 17, 2014 at 09:33 AM
--

DROP TABLE IF EXISTS `t_tipos_labores`;
CREATE TABLE IF NOT EXISTS `t_tipos_labores` (
  `id_tipo_labor` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `id_coste_maquinaria_1` int(11) DEFAULT NULL,
  `id_coste_maquinaria_2` int(11) DEFAULT NULL,
  `id_coste_maquinaria_3` int(11) DEFAULT NULL,
  `id_coste_maquinaria_4` int(11) DEFAULT NULL,
  `id_coste_maquinaria_5` int(11) DEFAULT NULL,
  `id_coste_personal` int(11) DEFAULT NULL,
  `id_producto_1` int(11) DEFAULT NULL,
  `id_producto_2` int(11) DEFAULT NULL,
  `id_producto_3` int(11) DEFAULT NULL,
  `id_producto_4` int(11) DEFAULT NULL,
  `id_producto_5` int(11) DEFAULT NULL,
  `variable_1` decimal(11,3) DEFAULT NULL,
  `variable_2` decimal(11,3) DEFAULT NULL,
  `variable_3` decimal(11,3) DEFAULT NULL,
  `variable_4` decimal(11,3) DEFAULT NULL,
  `variable_5` decimal(11,3) DEFAULT NULL,
  `id_formula` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_labor`),
  KEY `fk_id_coste_maquinaria_1` (`id_coste_maquinaria_1`),
  KEY `fk_id_coste_maquinaria_2` (`id_coste_maquinaria_2`),
  KEY `fk_id_coste_maquinaria_3` (`id_coste_maquinaria_3`),
  KEY `fk_id_coste_maquinaria_4` (`id_coste_maquinaria_4`),
  KEY `fk_id_coste_maquinaria_5` (`id_coste_maquinaria_5`),
  KEY `fk_id_coste_personal` (`id_coste_personal`),
  KEY `fk_id_producto_1` (`id_producto_1`),
  KEY `fk_id_producto_2` (`id_producto_2`),
  KEY `fk_id_producto_3` (`id_producto_3`),
  KEY `fk_id_producto_4` (`id_producto_4`),
  KEY `fk_id_producto_5` (`id_producto_5`),
  KEY `fk_id_formula` (`id_formula`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8000090 ;

--
-- Dumping data for table `t_tipos_labores`
--

INSERT INTO `t_tipos_labores` (`id_tipo_labor`, `tipo`, `nombre`, `descripcion`, `id_coste_maquinaria_1`, `id_coste_maquinaria_2`, `id_coste_maquinaria_3`, `id_coste_maquinaria_4`, `id_coste_maquinaria_5`, `id_coste_personal`, `id_producto_1`, `id_producto_2`, `id_producto_3`, `id_producto_4`, `id_producto_5`, `variable_1`, `variable_2`, `variable_3`, `variable_4`, `variable_5`, `id_formula`) VALUES
(8000000, 'Abono', 'Abonado', NULL, 5000000, 5000009, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000001, 'Abono', 'Abonado fondo 18-46-0', NULL, 0, 0, 0, 0, 0, 0, 3000001, 0, 0, 0, 0, '185.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000002, 'Abono', 'Abonado 50. Empre.', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000002),
(8000003, 'Abono', 'Abono cobertera Urea', NULL, 0, 0, 0, 0, 0, 0, 3000018, 0, 0, 0, 0, '220.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000004, 'Abono', 'Abonos otros', NULL, 0, 0, 0, 0, 0, 0, 3000014, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000005, '', 'Atomizador Fitosa', NULL, 5000000, 5000027, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000006, '', 'Binado', NULL, 5000000, 5000025, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000007, 'Porte y carga', 'Carga 6830+pala molino hora', NULL, 5000001, 5000030, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000008, 'Porte y carga', 'Carga 6830+pala verdeo hora', NULL, 5000001, 5000030, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000009, '', 'Congkirde de 4', NULL, 5000000, 5000006, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000010, '', 'Congkirde de 5,5', NULL, 5000001, 5000004, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000011, 'Riego', 'Coste riego hora', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 0),
(8000012, '', 'Cultichisel', NULL, 5000001, 5000007, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000013, '', 'Desbrozado 6220', NULL, 5000000, 5000014, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000014, '', 'Desbrozado 6830', NULL, 5000001, 5000014, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000015, '', 'Desbrozado hierbas', NULL, 5000001, 5000014, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000016, '', 'Despedregado', NULL, 5000000, 5000011, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '3.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000017, '', 'Fertirrigación', NULL, 0, 0, 0, 0, 0, 0, 3000005, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000018, 'Tratamiento', 'Fungicida Punch 0,75', NULL, 0, 0, 0, 0, 0, 0, 3000030, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000019, '', 'Gradas', NULL, 5000001, 5000003, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000020, 'Aplicacion Herbicida', 'Herbi. Pos. Doble Sal', NULL, 0, 0, 0, 0, 0, 0, 3000032, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000021, 'Aplicacion Herbicida', 'Herbi. Pos. Fluoxi 0,35 Glifo 3 Ph 0,075', NULL, 0, 0, 0, 0, 0, 0, 3000039, 3000043, 3000024, 0, 0, '0.000', '3.000', '0.000', '0.000', '0.000', 7000001),
(8000022, 'Aplicacion Herbicida', 'Herbi. Pos. Glifo. 1 Oxiflu. 2,5', NULL, 0, 0, 0, 0, 0, 0, 3000043, 3000049, 0, 0, 0, '1.000', '3.000', '0.000', '0.000', '0.000', 7000001),
(8000023, 'Aplicacion Herbicida', 'Herbi. Pos. Glifo. 2,2 Sterane 0,73 Ph 0,12', NULL, 0, 0, 0, 0, 0, 0, 3000043, 3000039, 3000025, 0, 0, '2.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000024, 'Aplicacion Herbicida', 'Herbi. Pos. Glifo. 3 Oxiflu. 2', NULL, 0, 0, 0, 0, 0, 0, 3000043, 3000049, 0, 0, 0, '3.000', '2.000', '0.000', '0.000', '0.000', 7000001),
(8000025, 'Aplicacion Herbicida', 'Herbi. Pos. Glifo. 6 Oxiflu. 0,6', NULL, 0, 0, 0, 0, 0, 0, 3000043, 3000049, 0, 0, 0, '6.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000026, 'Aplicacion Herbicida', 'Herbi. Pos. Grotex Comples 1,5l/ha+Mojante 0,12l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000046, 3000023, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000027, 'Aplicacion Herbicida', 'Herbi. Pos. Topix Evo 0,25 l/ha Mojante 0,12 l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000055, 3000023, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000028, 'Aplicacion Herbicida', 'Herbi. Pos. Trimmer 0,025kg/ha, Mojante 0,12l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000057, 3000023, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000029, 'Aplicacion Herbicida', 'Herbi. Pos.2,4 D y MCPA 1,5l/ha+Temojan 0,15l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000032, 3000026, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000030, 'Aplicacion Herbicida', 'Herbi. Pos.Glifo. 3 Oxifluor. 0,5 Ph 0,1', NULL, 0, 0, 0, 0, 0, 0, 3000042, 3000049, 3000025, 0, 0, '3.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000031, 'Aplicacion Herbicida', 'Herbi. Pos.Glifo. 45% 3 l', NULL, 0, 0, 0, 0, 0, 0, 3000043, 0, 0, 0, 0, '3.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000032, 'Aplicacion Herbicida', 'Herbi. Pos.Glifo. tras 0,5 Oxiflu 2 Ph 0,2', NULL, 0, 0, 0, 0, 0, 0, 3000044, 3000049, 3000026, 0, 0, '1.000', '2.000', '0.000', '0.000', '0.000', 7000001),
(8000033, 'Aplicacion Herbicida', 'Herbi. Pos.Glifo. tras 2,5 Oxiflu 0,5 Ph 0,2', NULL, 0, 0, 0, 0, 0, 0, 3000044, 3000049, 3000026, 0, 0, '3.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000034, 'Aplicacion Herbicida', 'Herbi. Pos.Glifosato 36% 3l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000042, 0, 0, 0, 0, '3.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000035, 'Aplicacion Herbicida', 'Herbi. Pos.Paraqua-Dicuat', NULL, 0, 0, 0, 0, 0, 0, 3000037, 0, 0, 0, 0, '3.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000036, 'Aplicacion Herbicida', 'Herbi. Pre.Glifosato 2l/ha+Oxifluorfen 0,25l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000042, 3000049, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000037, 'Aplicacion Herbicida', 'Herbi. Pre.Linuron 1,14 l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000047, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000038, 'Aplicacion Herbicida', 'Herbi. Pre.Linuron 1,4 l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000047, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000039, 'Aplicacion Herbicida', 'Herbi. Pre.Linuron 45% 1,08 l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000047, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000040, 'Aplicacion Herbicida', 'Herbi. Pre.Linuron 45% 1,5l/ha', NULL, 0, 0, 0, 0, 0, 0, 3000047, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000041, 'Aplicacion Herbicida', 'Herbi. Pre.Trifu.', NULL, 0, 0, 0, 0, 0, 0, 3000055, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000042, 'Aplicacion Herbicida', 'Herbi. Pre.Zarpa 3 Ph 0,6', NULL, 0, 0, 0, 0, 0, 0, 3000058, 3000025, 0, 0, 0, '3.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000043, 'Mano de obra', 'Mano de obra cogida dia molino', NULL, 0, 0, 0, 0, 0, 4000003, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000044, 'Mano de obra', 'Mano de obra cogida dia verdeo', NULL, 0, 0, 0, 0, 0, 4000003, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000045, 'Mano de obra', 'Mano de obra desba. escar. Dia', NULL, 0, 0, 0, 0, 0, 4000002, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000046, 'Mano de obra', 'Mano de obra fijo dia', NULL, 0, 0, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000047, 'Mano de obra', 'Mano de obra poda dia', NULL, 0, 0, 0, 0, 0, 4000001, 0, 0, 0, 0, 0, '6.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000048, '', 'Picado hierba', NULL, 5000000, 5000014, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000049, '', 'Picado ramon', NULL, 5000001, 5000014, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000050, '', 'Planta.amort.25 años', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0.000', '25.000', '0.000', '0.000', '0.000', 0),
(8000051, 'Porte y carga', 'Porte 6220', NULL, 5000000, 5000026, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000052, 'Porte y carga', 'Porte 6220 1,5 h', NULL, 5000000, 5000026, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000053, 'Porte y carga', 'Porte 6830', NULL, 5000001, 5000013, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000054, 'Porte y carga', 'Porte 6830 1,5 h', NULL, 5000001, 5000026, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000055, '', 'Rastreado con gomas', NULL, 5000000, 0, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000056, 'Riego', 'Riego 2 motores', NULL, 5000018, 5000019, 5000022, 0, 0, 0, 0, 0, 0, 0, 0, '576.000', '1.000', '0.000', '0.000', '0.000', 0),
(8000057, '', 'Rulado', NULL, 5000001, 5000015, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000058, 'Sembrado', 'Semilla girasol Mauro', NULL, 0, 0, 0, 0, 0, 0, 3000075, 0, 0, 0, 0, '4.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000059, 'Sembrado', 'Semilla girasol Pioner A76', NULL, 0, 0, 0, 0, 0, 0, 3000077, 0, 0, 0, 0, '5.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000060, 'Sembrado', 'Semilla habas', NULL, 0, 0, 0, 0, 0, 0, 3000079, 0, 0, 0, 0, '161.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000061, 'Sembrado', 'Semilla Trigo Blando Arthur Nick monton', NULL, 0, 0, 0, 0, 0, 0, 3000071, 0, 0, 0, 0, '283.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000062, 'Sembrado', 'Semilla Trigo Blando Salama', NULL, 0, 0, 0, 0, 0, 0, 3000081, 0, 0, 0, 0, '300.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000063, 'Sembrado', 'Semilla Trigo Duro Beldur R-2', NULL, 0, 0, 0, 0, 0, 0, 3000072, 0, 0, 0, 0, '270.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000064, 'Sembrado', 'Semilla Trigo Duro Saragolla monton', NULL, 0, 0, 0, 0, 0, 0, 3000082, 0, 0, 0, 0, '238.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000065, '', 'Semivolteable', NULL, 5000001, 5000005, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000066, '', 'Siega', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '45.000', '0.000', '0.000', '0.000', '0.000', 7000002),
(8000067, 'Sembrado', 'Siembra Gil', NULL, 5000001, 5000012, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000068, 'Sembrado', 'Siembra Monosem', NULL, 5000000, 5000016, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000069, 'Sembrado', 'Siembra Noli', NULL, 5000000, 5000002, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000070, '', 'Subsolado', NULL, 5000001, 5000008, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '2.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000071, 'Tratamiento', 'Trata. Clorpirifos 48% 2,5 l/1000 Ph 1 l/1000', NULL, 0, 0, 0, 0, 0, 0, 3000066, 3000025, 0, 0, 0, '3.000', '1.000', '0.000', '0.000', '0.000', 7000001),
(8000072, 'Tratamiento', 'Trata. Cobre 1,16 N 1,16 K 1,74', NULL, 0, 0, 0, 0, 0, 0, 3000029, 3000012, 3000009, 0, 0, '1.000', '1.000', '2.000', '0.000', '0.000', 7000001),
(8000073, 'Tratamiento', 'Trata. Cobre B 2,1 K-44 3,5', NULL, 0, 0, 0, 0, 0, 0, 3000029, 3000009, 0, 0, 0, '2.000', '4.000', '0.000', '0.000', '0.000', 7000001),
(8000074, 'Tratamiento', 'Trata. Cu 1,165 N 2,31 Mg 1,165 Zn 1,165 Bo 1,165', NULL, 0, 0, 0, 0, 0, 0, 3000029, 3000012, 3000011, 3000020, 3000008, '1.000', '2.000', '1.000', '1.000', '1.000', 7000001),
(8000075, 'Tratamiento', 'Trata. Dimeto.0,12 Oxi cloru 0,16 triple 20 0,4', NULL, 0, 0, 0, 0, 0, 0, 3000063, 3000029, 3000017, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000076, 'Tratamiento', 'Trata. Dimeto.0,5 Cobre 1,05 N.1,05 K.1,75 Ph 0,35', NULL, 0, 0, 0, 0, 0, 0, 3000063, 3000029, 3000012, 3000010, 3000025, '1.000', '1.000', '1.000', '2.000', '0.000', 7000001),
(8000077, 'Tratamiento', 'Trata. Dimeto.0,6 N 1,2 K 1,2  Ph 0,3', NULL, 0, 0, 0, 0, 0, 0, 3000063, 3000012, 3000010, 3000025, 0, '1.000', '1.000', '1.000', '0.000', '0.000', 7000001),
(8000078, 'Tratamiento', 'Trata. Dimeto.0,6 Ph 0,3', NULL, 0, 0, 0, 0, 0, 0, 3000063, 3000025, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000079, 'Tratamiento', 'Trata. Fosmet 0,2 Amino. 0,2 ph 0,1', NULL, 0, 0, 0, 0, 0, 0, 3000066, 3000004, 3000025, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000080, 'Tratamiento', 'Trata. Fosmet 1,16 Cu 1,16 N 1,16 K 1,74 Ph 0,3', NULL, 0, 0, 0, 0, 0, 0, 3000065, 3000029, 3000012, 3000009, 3000024, '1.000', '1.000', '1.000', '2.000', '0.000', 7000001),
(8000081, 'Tratamiento', 'Trata. Karate 0,12 Triple 20 0,4 Amino 0,16 Ph 0,08', NULL, 0, 0, 0, 0, 0, 0, 3000063, 3000017, 3000004, 3000026, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000001),
(8000082, 'Tratamiento', 'Trata. Sulf Cu 2,1 N 1,05 K 1,75', NULL, 0, 0, 0, 0, 0, 0, 3000031, 3000012, 3000010, 0, 0, '2.000', '1.000', '2.000', '0.000', '0.000', 7000001),
(8000083, 'Tratamiento', 'Tratamiento 50. Asema con baras', NULL, 5000000, 5000010, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000084, 'Tratamiento', 'Tratamiento 50. empre.', NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '7.000', '0.000', '0.000', '0.000', '0.000', 7000002),
(8000085, 'Tratamiento', 'Tratamiento 50. Fitosa', NULL, 5000001, 5000023, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '0.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000086, '', 'Vareadoras Olivelo 3 molino', NULL, 5000029, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000087, '', 'Vareadoras Olivelo 3 verdeo', NULL, 5000029, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000088, '', 'Vibradora B. Santi. Molino hora', NULL, 5000000, 5000017, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000),
(8000089, '', 'Vibradora B. Santi. Verdo hora', NULL, 5000000, 5000017, 0, 0, 0, 4000000, 0, 0, 0, 0, 0, '1.000', '0.000', '0.000', '0.000', '0.000', 7000000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
