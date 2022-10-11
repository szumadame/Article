CREATE TABLE `article` (
  `article_id` INT NOT NULL auto_increment,
  `uri` MEDIUMTEXT NOT NULL,
  `title` MEDIUMTEXT NOT NULL,
  `published_date` DATE NOT NULL,
  `section` TINYTEXT NOT NULL,
  `subsection` TINYTEXT NULL,
  `abstract` MEDIUMTEXT NULL,
  `author` TINYTEXT NULL,
  PRIMARY KEY (`article_id`),
  UNIQUE INDEX `article_id_UNIQUE` (`article_id` ASC) VISIBLE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;