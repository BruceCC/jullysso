--自定义认证相关数据表参考spring security oauth2源码中的schema
-- used in tests that use HSQL
DROP TABLE IF EXISTS oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

DROP TABLE IF EXISTS oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

DROP TABLE IF EXISTS oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

DROP TABLE IF EXISTS oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);

DROP TABLE IF EXISTS oauth_code;
create table oauth_code (
  code VARCHAR(256), authentication BLOB
);

DROP TABLE IF EXISTS oauth_approvals;
create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
DROP TABLE IF EXISTS ClientDetails;
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);


--mysql sequence  , reference link http://ronaldbradford.com/blog/sequences-in-mysql-2006-01-26/
DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence (
name              VARCHAR(128) NOT NULL,
current_value INT NOT NULL,
increment       INT NOT NULL DEFAULT 1,
PRIMARY KEY (name)
) ENGINE=InnoDB;

DROP FUNCTION IF EXISTS currval;
DELIMITER $
CREATE FUNCTION currval (seq_name VARCHAR(128))
RETURNS INTEGER
CONTAINS SQL
BEGIN
  DECLARE value INTEGER;
  SET value = 0;
  SELECT current_value INTO value
  FROM sequence
  WHERE name = seq_name;
  RETURN value;
END$
DELIMITER ;


DROP FUNCTION IF EXISTS curr_seq_val;
DELIMITER $
CREATE  FUNCTION `curr_seq_val`(`v_seq_name` varchar(128)) RETURNS varchar(2048) CHARSET utf8
BEGIN
	DECLARE r_current_val BIGINT;
	DECLARE r_max_val BIGINT;
	set r_current_val=0;
	set r_max_val=0;
	SELECT t.current_val, t.max_val from july_sequence t where t.seq_name=v_seq_name
	into r_current_val, r_max_val;


	RETURN LPAD(r_current_val,LENGTH(r_max_val),'0');
END$
DELIMITER ;

DROP FUNCTION IF EXISTS next_seq_val;
DELIMITER $
CREATE  FUNCTION `next_seq_val`(`v_seq_name` varchar(128)) RETURNS varchar(2048) CHARSET utf8
BEGIN
	update july_sequence t set t.current_val = t.current_val + t.increment_val  where t.seq_name = v_seq_name;
	return curr_seq_val(v_seq_name);
END$
DELIMITER ;



DROP TABLE IF EXISTS user_login_info;
--user login info
CREATE TABLE `user_login_info` (
  `user_id` varchar(12) NOT NULL,
  `password` varchar(512) NOT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `state` int(2) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idx_login_name` (`login_name`) USING BTREE,
  UNIQUE KEY `idx_mobile` (`mobile`) USING BTREE,
  UNIQUE KEY `idx_email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
