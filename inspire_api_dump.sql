-- MySQL dump 10.13  Distrib 9.3.0, for macos15.2 (arm64)
--
-- Host: localhost    Database: inspire_api
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inspire_sessions`
--

DROP TABLE IF EXISTS `inspire_sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspire_sessions` (
  `session_id` char(36) NOT NULL,
  `breathe_content` varchar(255) DEFAULT NULL,
  `learn_content` varchar(255) DEFAULT NULL,
  `quote_content` varchar(255) DEFAULT NULL,
  `created_at` datetime(3) NOT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inspire_sessions`
--

LOCK TABLES `inspire_sessions` WRITE;
/*!40000 ALTER TABLE `inspire_sessions` DISABLE KEYS */;
INSERT INTO `inspire_sessions` VALUES ('afe6d250-8c36-11f0-86ec-0e887fe4fb3e','Breathe in, hold for 4 min, breathe out. Do this 5 times.','In Java, the meaning of final keyword is not final. It can be a final class, final method, final field, or final variable.','Ive learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel. ― Maya Angelou','2025-09-07 23:51:19.000'),('b1234567-89ab-cdef-0123-456789abcdef','Breathe: complete five full breath cycles. Each breath cycle (inhale and exhale) should last about 12 seconds.','Hiding internal data from the outside world, and accessing it only through publicly exposed methods is known as data encapsulation.','Hide nothing, for time, which sees all and hears all, exposes all. - Sophocles','2025-09-07 23:51:19.000'),('c1234567-89ab-cdef-0123-456789abcdef','Close your eyes. Breathe slowly as you scan from head to toe, noticing and releasing tension with each exhale.','In the Java programming language, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.','To design is to communicate clearly by whatever means you can control or master. - Milton Glaser','2025-09-07 23:51:19.000');
/*!40000 ALTER TABLE `inspire_sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules` (
  `module_id` char(36) NOT NULL,
  `module_type` varchar(10) NOT NULL,
  `module_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES ('a2234567-89ab-cdef-0123-456789abcdef','BREATHE','Inhale slowly, guiding your awareness from your head down to your toes, softening each muscle as you exhale.'),('b2234567-89ab-cdef-0123-456789abcdef','LEARN','In the Java language, classes can be derived from other classes, thereby inheriting fields and methods from those classes.'),('c2234567-89ab-cdef-0123-456789abcdef','QUOTE','I have learned over the years that when ones mind is made up, this diminishes fear; knowing what must be done does away with fear. - Rosa Parks'),('d1234567-89ab-cdef-0123-456789abcdef','BREATHE','Breathe deeply and slowly sweep your attention from head to toes, relaxing each area as you go.'),('d2234567-89ab-cdef-0123-456789abcdef','BREATHE','Breathe deeply and gently scan your body from crown to feet, releasing tension with every breath out.'),('e1234567-89ab-cdef-0123-456789abcdef','LEARN','Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces.'),('e2234567-89ab-cdef-0123-456789abcdef','LEARN','Cybersecurity is the practice of protecting people, systems and data from cyberattacks by using various technologies, processes and policies.'),('f1234567-89ab-cdef-0123-456789abcdef','QUOTE','I did then what I knew how to do. Now that I know better, I do better. - Maya Angelou'),('f2234567-89ab-cdef-0123-456789abcdef','QUOTE','Where there is a woman there is magic. — Ntozake Shange');
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-08  0:10:45
