insert into adresa(id, city, street) values ('6', 'asd', 'dsa')
insert into adresa(id, city, street) values ('7', 'asd', 'dsa')
insert into adresa(id, city, street) values ('8', 'grad3', 'ulica3')
insert into adresa(id, city, street) values ('9', 'grad4', 'ulica4')
insert into adresa(id, city, street) values ('10', 'Novi Sad', 'Bulevar Oslobodjenja 25')
insert into adresa(id, city, street) values ('11', 'Novi Sad', 'Bulevar Oslobodjenja 66')
insert into adresa(id, city, street) values ('12', 'Novi Sad', 'adresa 24')
insert into adresa(id, city, street) values ('13', 'Novi Sad', 'Danila Kisa 13')
insert into adresa(id, city, street) values ('14', 'Novi Sad', 'Tolstojeva 15')
insert into adresa(id, city, street) values ('15', 'Novi Sad', 'Modene 20')
insert into adresa(id, city, street) values ('16', 'Novi Sad', 'Futoska 140')


insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('admin', '1234', 'SYSTEMADMIN', '6', 'asd@gmail.com', 'Marko', 'Markovic', false, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('ftn', 'ftn', 'REGISTEREDUSER', '7', 'srbulovicdusan@gmail.com', 'Pera', 'Peric', true, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('reguser', '123123123', 'REGISTEREDUSER', '10', 'reg@gmail.com', 'Nikola', 'Nikolic', false, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('reguser2', '123123123', 'REGISTEREDUSER', '9', 'reg2@gmail.com', 'Nemanja', 'Nemanjic', false, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('sara', 'sara', 'CINEMAADMIN', '11', 'sarapetrovic03@gmail.com', 'Sara', 'Petrovic', true, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('reguser3', '123123123', 'REGISTEREDUSER', '13', 'reg@gmail.com', 'Mara', 'Maric', false, 'default-profile-picture.jpg', true)
insert into user(username, password, usertype, address_id, email, firstname, lastname, is_first_login, profile_picture, activated) values ('reguser4', '123123123', 'REGISTEREDUSER', '14', 'reg@gmail.com', 'Ana', 'Anic', false, 'default-profile-picture.jpg', true)


insert into item_ad( name, description ,version, owner_id, picture) values ( 'majica', 'opis' ,0,2 , 'item1.jpg')
insert into item_ad( name, description ,version, owner_id, picture) values ( 'kapa', 'opis' ,0, 2,'item.jpg')
insert into item_ad( name, description ,version, owner_id, picture) values ( 'duks', 'opis' ,0, 2,'item2.jpg')
insert into official_item( name, price,description,version, quantity, picture) values ( 'duks', '700', 'opis', 0 ,2, 'item2.jpg')

insert into item_reservation (id, user_id, official_item_id) values ('1' , '1', '1')
insert into item_offer(user_id, price, item_ad_id, version) values ('1', '500', '2', '0')
insert into item_offer(user_id, price, item_ad_id, version) values ('2', '500', '3', '0')

insert into isa.friendship(userid1, userid2, action_userid, status) values (2, 3, 3, 2)
insert into isa.friendship(userid1, userid2, action_userid, status) values (1, 3, 1, 2)
insert into isa.friendship(userid1, userid2, action_userid, status) values (1, 7, 1, 2)
insert into isa.friendship(userid1, userid2, action_userid, status) values (2, 7, 2, 2)
insert into isa.friendship(userid1, userid2, action_userid, status) values (3, 7, 3, 2)
insert into isa.friendship(userid1, userid2, action_userid, status) values (6, 7, 6, 2)


insert into theater_or_cinema(average_mark, description, is_cinema, name, adress_id) values ('4', 'Opis...', true, 'Cinema1', '10')
insert into theater_or_cinema(average_mark, description, is_cinema, name, adress_id) values ('5', 'Opis2...', false, 'Theater1', '12')
insert into theater_or_cinema(average_mark, description, is_cinema, name, adress_id) values ('2', 'Opis3...', false, 'Theater2', '15')
insert into theater_or_cinema(average_mark, description, is_cinema, name, adress_id) values ('5', 'Opis4...', true, 'Cinema2', '16')
