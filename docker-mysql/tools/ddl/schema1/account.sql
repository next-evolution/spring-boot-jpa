SET NAMES utf8;
DROP TABLE IF EXISTS account CASCADE;

CREATE TABLE account (
	account_number           int unsigned    NOT NULL    auto_increment    COMMENT 'アカウントナンバー',
	email_address            varchar(128)    NOT NULL    COMMENT 'Emailアドレス',
	nick_name                varchar(64)     NOT NULL    COMMENT 'ニックネーム',
	delete_flag              bit(1)          NOT NULL    DEFAULT 0    COMMENT '削除フラグ(0:有効/1:削除)',
	created_at               datetime        NOT NULL    DEFAULT CURRENT_TIMESTAMP    COMMENT 'レコード作成日時',
	created_by               varchar(128)      NOT NULL    COMMENT 'レコード作成ApiCode',
	updated_at               datetime        NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP    COMMENT 'レコード更新日時',
	updated_by               varchar(128)      NOT NULL    COMMENT 'レコード更新ApiCode',
	PRIMARY KEY (account_number),
    KEY (email_address)
) ENGINE=Innodb DEFAULT CHARSET=utf8 COMMENT 'アカウント情報';
