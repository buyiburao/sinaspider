CREATE TABLE `status` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `url` varchar(64) DEFAULT NULL,
  `userId` varchar(64) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `text` varchar(2048) DEFAULT NULL,
  `source` varchar(2048) DEFAULT NULL,
  `inReplyToStatusId` bigint(20) DEFAULT NULL,
  `inReplyToUserId` bigint(20) DEFAULT NULL,
  `inReplyToScreenName` varchar(2048) DEFAULT NULL,
  `thumbnailPic` varchar(2048) DEFAULT NULL,
  `middlePic` varchar(2048) DEFAULT NULL,
  `originalPic` varchar(2048) DEFAULT NULL,
  `retweetedStatusId` varchar(64) DEFAULT NULL,
  `annotations` varchar(2048) DEFAULT NULL,
  `poiid` varchar(64) DEFAULT NULL,
  `geo` varchar(2048) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `repostsCount` int(11) DEFAULT NULL,
  `commentsCount` int(11) DEFAULT NULL,
  `refreshTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user` (`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

