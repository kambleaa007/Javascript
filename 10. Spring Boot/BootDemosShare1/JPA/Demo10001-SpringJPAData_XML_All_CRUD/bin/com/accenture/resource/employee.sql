
-- Dumping database structure for hibernatedemos
DROP DATABASE IF EXISTS springbootdemos;
CREATE DATABASE springbootdemos; 
USE springbootdemos;


-- Dumping structure for table hibernatedemos.employee
DROP TABLE IF EXISTS employee_Spring;
CREATE TABLE IF NOT EXISTS employee_spring (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  inserttime datetime DEFAULT NULL,
  salary double DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO employee_Spring (id, name, role, inserttime, salary) VALUES
	(1001, 'MSD', 'Sr.Analyst', '2016-01-28 00:00:00', 100000),
	(1002, 'James', 'Sr.Analyst', '2016-01-28 00:00:00', 0),
	(1003, 'Rocky', 'Sr.Analyst', '2016-01-28 00:00:00', 100000);
commit;
