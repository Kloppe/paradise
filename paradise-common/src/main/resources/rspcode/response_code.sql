CREATE TABLE response_code
(
  `id`                   BIGINT(20)            AUTO_INCREMENT,
  `response_code_seq_no` CHAR(32)     NOT NULL
  COMMENT '响应码唯一标识',
  `code`                 CHAR(16)     NOT NULL
  COMMENT '响应码',
  `msg`                  VARCHAR(64)  NOT NULL
  COMMENT '响应消息',
  `remark`               VARCHAR(255) NULL
  COMMENT '响应描述',
  `project`              VARCHAR(32)  NULL
  COMMENT '项目',
  `category`             VARCHAR(32)  NULL
  COMMENT '分类',
  `created_time`         TIMESTAMP    NULL     DEFAULT NULL
  COMMENT '创建时间',
  `updated_time`         TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_response_code_seq_no`(`response_code_seq_no`),
  KEY `nk_ode`(`code`)
)
  COMMENT '响应码';
