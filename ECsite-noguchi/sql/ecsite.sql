set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite4;

create database if not exists ecsite4;
use ecsite4;

/*ユーザーログイン情報*/
drop table if exists login_user_transaction;

create table login_user_transaction(
   login_id varchar(16) unique,
   login_pass varchar(16),
   user_name varchar(50),
   insert_date datetime,
   updated_date datetime
);

/*商品情報*/
drop table if exists item_info_transaction;

create table item_info_transaction(
/*呼び出すときに簡単にするためにidをつけている*/
   id int not null primary key auto_increment,
   item_name varchar(30),
   item_price int,
   item_stock int,
   item_category varchar(50),
   image_file_path varchar(100),
   insert_date datetime,
   update_date datetime
);

/*商品購入*/
drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
   id int not null primary key auto_increment,
   item_transaction_id int,
   total_price int,
   total_count int,
   user_master_id varchar(16),
   pay varchar(30),
   insert_date datetime,
   delete_date datetime
);

/*お問い合わせフォーム*/
 create table inquiry(
 name varchar(255),
 qtype varchar(255),
 body varchar(255)
 );

INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("ハリーポッター",800,20,"ファンタジー","./image/hon1.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("旅のラゴス",780,50,"ファンタジー","./image/hon2.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("和菓子のアン",750,10,"ミステリー","./image/hon3.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("シャーロックホームズの冒険",650,20,"ミステリー","./image/hon4.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("羊と鋼の森",600,15,"純文学","./image/hon5.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("横道世之介",680,50,"純文学","./image/hon6.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("お金2.0",1200,30,"ビジネス書","./image/hon7.jpg");
INSERT INTO item_info_transaction(item_name, item_price, item_stock, item_category, image_file_path) VALUES("嫌われる勇気",1400,50,"ビジネス書","./image/hon8.jpg");

INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous","internous01","test");
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("taro","123","yamadataro");