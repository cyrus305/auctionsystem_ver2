
INSERT INTO credentials(username,password,role) VALUES ('admin','admin', 'ROLE_ADMIN');
INSERT INTO credentials(username,password,role) VALUES ('guest','guest', 'ROLE_USER');
INSERT INTO address (street, city, state, zipcode) VALUES ('admin', 'admin', 'admin', 'admin');
INSERT INTO user (firstName, lastName, email, userNumber, addressid, credentialsid) VALUES ('admin', 'admin', 'admin@admin.com',1,1,1);

INSERT INTO categories(id, name, description) VALUES (null, 'Electrnoics', 'electronic goods');

INSERT INTO tbl_product(product_id, description,  minBiddingPrice, name, timetobid, category_id) values (null,'very good phone',  200, 'IPhone','2012-2-2', 1);

INSERT INTO tbl_product(product_id, description,  minBiddingPrice, name, timetobid, category_id) values (null,'Old Damage Phone',  200, 'iPhone 10s','2020-2-2', 1);

 

				
