INSERT INTO mst_user
(user_name, password, family_name,first_name,family_name_kana,first_name_kana)
VALUES ('ooo@sample.com', 'taropw', '山田','太郎','やまだ','たろう');

INSERT INTO mst_category
(category_name)
VALUES('野球');
INSERT INTO mst_category
(category_name)
VALUES('バスケットボール');
INSERT INTO mst_category
(category_name)
VALUES('サッカー');

INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('野球ボール（三個入り）','やきゅうぼーる（さんこいり）',"お得な3個入りの野球ボール",1, 2980,'/img/Baseball.png',"2020/2/1","misuno");
INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('グローブ','ぐろーぶ',"頑丈なグローブ",1, 19800,'/img/glove.png',"2020/2/1","misuno");
INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('バスケットボール','ばすけっとぼーる',"ストリート用",2, 3980,'/img/Basketball.png',"2020/2/1","nikey");
INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('バスケシューズ','ばすけしゅーず',"横幅狭め",2, 12800,'/img/Basketball shoes.png',"2020/2/1","nikey");
INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('サッカーボール','さっかーぼーる',"一般的なデザイン",3, 4980,'/img/Soccerball.png',"2020/2/1","adidos");
INSERT INTO mst_product
(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) 
VALUES ('サッカースパイク','さっかーすぱいく',"履き心地良好",3, 11800,'/img/Soccer shoes.png',"2020/2/1","adidos");

INSERT INTO mst_destination
(user_id,family_name,first_name,tel_number,address)
VALUES(1,'山田','太郎','00000000000','東京都oo区oo丁目');
