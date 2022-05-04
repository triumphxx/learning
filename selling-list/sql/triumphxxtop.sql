CREATE TABLE `goods`
(
    `goods_id`     varchar(45) COLLATE utf8_bin NOT NULL,
    `goods_name`   varchar(100) COLLATE utf8_bin DEFAULT NULL,
    `goods_common` varchar(200) COLLATE utf8_bin DEFAULT NULL,
    PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sell`
(
    `sell_id`   varchar(20) COLLATE utf8_bin NOT NULL,
    `goods_id`  varchar(20) COLLATE utf8_bin DEFAULT NULL,
    `sell_num`  tinyint(10) DEFAULT NULL,
    `sell_date` varchar(20) COLLATE utf8_bin DEFAULT NULL,
    PRIMARY KEY (`sell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/*
-- Query: SELECT * FROM triumphxxtop.goods
LIMIT 0, 1000

-- Date: 2020-05-16 22:07
*/
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('0', '华为0', '名族大品牌0');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('1', '华为1', '名族大品牌1');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('10', '华为10', '名族大品牌10');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('100', '华为100', '名族大品牌100');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('11', '华为11', '名族大品牌11');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('12', '华为12', '名族大品牌12');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('13', '华为13', '名族大品牌13');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('14', '华为14', '名族大品牌14');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('15', '华为15', '名族大品牌15');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('16', '华为16', '名族大品牌16');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('17', '华为17', '名族大品牌17');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('18', '华为18', '名族大品牌18');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('19', '华为19', '名族大品牌19');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('2', '华为2', '名族大品牌2');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('20', '华为20', '名族大品牌20');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('21', '华为21', '名族大品牌21');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('22', '华为22', '名族大品牌22');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('23', '华为23', '名族大品牌23');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('24', '华为24', '名族大品牌24');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('25', '华为25', '名族大品牌25');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('26', '华为26', '名族大品牌26');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('27', '华为27', '名族大品牌27');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('28', '华为28', '名族大品牌28');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('29', '华为29', '名族大品牌29');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('3', '华为3', '名族大品牌3');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('30', '华为30', '名族大品牌30');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('31', '华为31', '名族大品牌31');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('32', '华为32', '名族大品牌32');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('33', '华为33', '名族大品牌33');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('34', '华为34', '名族大品牌34');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('35', '华为35', '名族大品牌35');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('36', '华为36', '名族大品牌36');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('37', '华为37', '名族大品牌37');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('38', '华为38', '名族大品牌38');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('39', '华为39', '名族大品牌39');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('4', '华为4', '名族大品牌4');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('40', '华为40', '名族大品牌40');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('41', '华为41', '名族大品牌41');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('42', '华为42', '名族大品牌42');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('43', '华为43', '名族大品牌43');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('44', '华为44', '名族大品牌44');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('45', '华为45', '名族大品牌45');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('46', '华为46', '名族大品牌46');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('47', '华为47', '名族大品牌47');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('48', '华为48', '名族大品牌48');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('49', '华为49', '名族大品牌49');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('5', '华为5', '名族大品牌5');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('50', '华为50', '名族大品牌50');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('51', '华为51', '名族大品牌51');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('52', '华为52', '名族大品牌52');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('53', '华为53', '名族大品牌53');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('54', '华为54', '名族大品牌54');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('55', '华为55', '名族大品牌55');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('56', '华为56', '名族大品牌56');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('57', '华为57', '名族大品牌57');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('58', '华为58', '名族大品牌58');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('59', '华为59', '名族大品牌59');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('6', '华为6', '名族大品牌6');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('60', '华为60', '名族大品牌60');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('61', '华为61', '名族大品牌61');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('62', '华为62', '名族大品牌62');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('63', '华为63', '名族大品牌63');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('64', '华为64', '名族大品牌64');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('65', '华为65', '名族大品牌65');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('66', '华为66', '名族大品牌66');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('67', '华为67', '名族大品牌67');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('68', '华为68', '名族大品牌68');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('69', '华为69', '名族大品牌69');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('7', '华为7', '名族大品牌7');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('70', '华为70', '名族大品牌70');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('71', '华为71', '名族大品牌71');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('72', '华为72', '名族大品牌72');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('73', '华为73', '名族大品牌73');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('74', '华为74', '名族大品牌74');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('75', '华为75', '名族大品牌75');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('76', '华为76', '名族大品牌76');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('77', '华为77', '名族大品牌77');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('78', '华为78', '名族大品牌78');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('79', '华为79', '名族大品牌79');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('8', '华为8', '名族大品牌8');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('80', '华为80', '名族大品牌80');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('81', '华为81', '名族大品牌81');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('82', '华为82', '名族大品牌82');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('83', '华为83', '名族大品牌83');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('84', '华为84', '名族大品牌84');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('85', '华为85', '名族大品牌85');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('86', '华为86', '名族大品牌86');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('87', '华为87', '名族大品牌87');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('88', '华为88', '名族大品牌88');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('89', '华为89', '名族大品牌89');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('9', '华为9', '名族大品牌9');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('90', '华为90', '名族大品牌90');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('91', '华为91', '名族大品牌91');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('92', '华为92', '名族大品牌92');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('93', '华为93', '名族大品牌93');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('94', '华为94', '名族大品牌94');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('95', '华为95', '名族大品牌95');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('96', '华为96', '名族大品牌96');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('97', '华为97', '名族大品牌97');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('98', '华为98', '名族大品牌98');
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_common`)
VALUES ('99', '华为99', '名族大品牌99');


/*
-- Query: SELECT * FROM triumphxxtop.sell
LIMIT 0, 1000

-- Date: 2020-05-18 22:09
*/
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('0', '0', 79, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('1', '1', 77, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('10', '10', 43, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('100', '100', 2, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('11', '11', 14, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('12', '12', 47, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('13', '13', 33, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('14', '14', 74, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('15', '15', 39, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('16', '16', 40, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('17', '17', 69, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('18', '18', 90, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('19', '19', 14, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('2', '2', 9, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('20', '20', 48, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('21', '21', 54, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('22', '22', 68, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('23', '23', 9, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('24', '24', 6, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('25', '25', 40, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('26', '26', 90, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('27', '27', 72, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('28', '28', 89, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('29', '29', 68, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('3', '3', 72, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('30', '30', 49, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('31', '31', 96, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('32', '32', 59, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('33', '33', 6, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('34', '34', 75, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('35', '35', 1, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('36', '36', 87, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('37', '37', 61, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('38', '38', 12, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('39', '39', 15, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('4', '4', 86, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('40', '40', 77, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('41', '41', 97, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('42', '42', 88, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('43', '43', 52, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('44', '44', 80, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('45', '45', 88, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('46', '46', 6, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('47', '47', 88, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('48', '48', 92, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('49', '49', 0, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('5', '5', 70, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('50', '50', 27, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('51', '51', 3, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('52', '52', 17, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('53', '53', 63, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('54', '54', 71, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('55', '55', 14, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('56', '56', 63, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('57', '57', 75, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('58', '58', 40, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('59', '59', 30, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('6', '6', 95, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('60', '60', 95, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('61', '61', 70, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('62', '62', 26, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('63', '63', 21, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('64', '64', 73, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('65', '65', 76, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('66', '66', 22, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('67', '67', 14, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('68', '68', 66, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('69', '69', 10, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('7', '7', 58, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('70', '70', 72, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('71', '71', 47, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('72', '72', 30, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('73', '73', 80, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('74', '74', 91, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('75', '75', 20, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('76', '76', 27, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('77', '77', 80, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('78', '78', 86, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('79', '79', 19, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('8', '8', 49, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('80', '80', 62, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('81', '81', 65, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('82', '82', 34, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('83', '83', 85, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('84', '84', 79, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('85', '85', 72, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('86', '86', 35, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('87', '87', 67, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('88', '88', 21, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('89', '89', 85, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('9', '9', 7, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('90', '90', 68, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('91', '91', 74, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('92', '92', 84, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('93', '93', 16, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('94', '94', 37, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('95', '95', 47, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('96', '96', 51, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('97', '97', 39, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('98', '98', 41, '2020-05-18');
INSERT INTO `sell` (`sell_id`, `goods_id`, `sell_num`, `sell_date`)
VALUES ('99', '99', 3, '2020-05-18');