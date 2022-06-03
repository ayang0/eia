-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eia
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `warn_info`
--

DROP TABLE IF EXISTS `warn_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warn_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布人',
  `time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warn_info`
--

LOCK TABLES `warn_info` WRITE;
/*!40000 ALTER TABLE `warn_info` DISABLE KEYS */;
INSERT INTO `warn_info` VALUES (13,'预计信息测试','test warn info','ayang','2022-05-03 23:36:56'),(14,'小区常态化管理','## 常态化管理\n除封控区、管控区继续按照规定严格管理外，其他小区也仍然要持续做好出入管理，做到查看青城码、戴口罩、测体温等防控措施不松懈。对发现的异常人员，第一时间向属地社区（村）报告。\n','ayang','2022-05-07 15:58:59'),(15,'2022五一假期四川学生可以出省吗？回来要隔离吗？','*倡导非必要不离川，如确须离川，请第一时间向班主任报备，并配合落实属地疫情防控措施。返川需提供48小时内核酸检测阴性证明、查验健康码和通信行程卡外，还须在各查验点通过“四川天府健康通”扫描“入川即检特殊场所码”。*\n　　++【实施AB类地区分类管控】++\n1. 　　1、A类地区\n　　对7天内有A类地区旅居史的来(返)川人员，实施集中隔离直至抵川后满7天，第1、3、7天进行咽拭子核酸检测，最后1次双采双检阴性后解除隔离。\n\n2. 　　2、B类地区\n　　对7天内有B类地区旅居史的来(返)川人员，按以下方式实施分类管理：\n　　(1)对有本土疫情发生的县(市、区、旗)旅居史的来(返)川人员，实施居家隔离直至抵川后满7天，第1、3、7天进行咽拭子核酸检测，最后1次双采双检阴性后解除隔离，不具备居家隔离条件的，实施集中隔离。\n　　(2)对有其他县(市、区、旗)旅居史的来(返)川人员，入川后实施3天2次(间隔24小时)咽拭子核酸检测，检测结果未出之前，非必要不外出、不聚集。\n温馨提示：微信搜索并关注公众号成都本地宝，在聊天对话框回复【进出川】即可获取外省人员来返四川最新出行规定（含隔离政策+核酸检测要求）。','ayang','2022-05-07 21:03:13'),(16,'小区出入管理','# 入小区\n提供健康码','ayang','2022-05-07 21:03:17'),(17,'新型冠状病毒肺炎疫情最新情况','5月8日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例415例。其中境外输入病例14例（广东7例，福建4例，上海2例，广西1例），含2例由无症状感染者转为确诊病例（福建1例，广东1例）；本土病例401例（上海322例，北京33例，广东28例，河南14例，青海2例，浙江1例，湖南1例），含236例由无症状感染者转为确诊病例（上海230例，北京5例，广东1例）。新增死亡病例11例，均为本土病例，均在上海；无新增疑似病例。','ayang','2022-05-07 21:03:21'),(18,'进出成都预警','1.从5月9日起，离蓉人员不再要求提供核酸阴性证明。但部分城市要求返回人员提供48小时核酸检测阴性证明，具体以当地规定为准。\n2，省外返蓉：48h核酸+落地24h核酸\n3.乘机抵蓉：24h核酸\n4.有本土疫情县：居家隔离+核酸','ayang','2022-05-07 21:03:52');
/*!40000 ALTER TABLE `warn_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 14:24:37
