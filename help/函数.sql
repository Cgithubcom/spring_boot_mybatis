
-- 查询菜单
CREATE DEFINER=`root`@`localhost` FUNCTION `queryMenum`(`rootId` text) RETURNS text CHARSET utf8
BEGIN
DECLARE sTemp text;
DECLARE sTempChd text;

SET sTemp = '$';
SET sTempChd = rootId;

WHILE sTempChd is not NULL DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM t_sys_resource t where FIND_IN_SET(t.parent_id,sTempChd)>0;
END WHILE;
return sTemp;
END