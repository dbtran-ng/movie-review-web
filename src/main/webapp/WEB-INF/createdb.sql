CREATE TABLE MOVIEUSERS
(
    user_id NUMBER(3)              NOT NULL,
	user_name VARCHAR2(50)      NOT NULL,
    user_password VARCHAR2(50)  NOT NULL,
    email VARCHAR2(100) 		NOT NULL,
	fname VARCHAR2(50) 			NOT NULL,
	lname VARCHAR2(50) 			NOT NULL,
    address VARCHAR2(50)                ,
    state VARCHAR2(3)                   ,
    primary key(user_id,user_name)
);

CREATE TABLE LOGINUSERS(
	user_name VARCHAR2(50)       NOT NULL,
    user_password VARCHAR2(50)       NOT NULL,
    PRIMARY KEY (user_name)
);
CREATE TABLE MOVIES(
	movie_id NUMBER(5) 		    NOT NULL,
	title VARCHAR2(50) 			NOT NULL,
	country VARCHAR2(50) 		NOT NULL,
	year NUMBER(4) 				NOT NULL,
	description VARCHAR2(500) 	NOT NULL,
	imagePath VARCHAR2(200) 	NOT NULL,
	youtubeTrailer VARCHAR2(200) NOT NULL,
	PRIMARY KEY (movie_id)
);
CREATE TABLE REVIEW(
	review_id NUMBER(5) 	NOT NULL,
	movie_id  NUMBER(5) 	NOT NULL,
	author_name VARCHAR2(50) 	NOT NULL,
	title VARCHAR2(100) 	NOT NULL,
	description VARCHAR2(500) 		NOT NULL,
	PRIMARY KEY (review_id),
	FOREIGN KEY (movie_id) REFERENCES MOVIES(movie_id)
		ON DELETE CASCADE,
	FOREIGN KEY (author_name) REFERENCES LOGINUSERS(user_name)
		ON DELETE CASCADE
);
create sequence users_id_seq start with 1 nocache;
create sequence movie_id_seq start with 1 nocache;
create sequence review_id_seq start with 1 nocache;


insert into MOVIES values (movie_id_seq.nextval,'Avengers EndGame','USA','2020','abc','https://cdn.shopify.com/s/files/1/0057/3728/3618/products/108b520c55e3c9760f77a06110d6a73b_480x.progressive.jpg?v=1573652543','https://youtu.be/eOrNdBpGMv8');
insert into MOVIES values (movie_id_seq.nextval,'Ava','USA','2020','A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.','https://m.media-amazon.com/images/M/MV5BMTMzMTg1MjgtOWNhYy00NmZmLWExOTctMjA2OTZhZDFkNDhhXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_.jpg','https://youtu.be/eLEwNo78f0k');
insert into MOVIES values (movie_id_seq.nextval,'Monsters at Work','USA','2021',
	'Ever since he was a kid, Tylor Tuskmon has dreamed of becoming a Scarer just like his idol James P. Sullivan, and now that dream is about to come true... or not. The day he arrives at Monsters Incorporated to begin his dream job as a Scarer, he learns that scaring is out and laughter is in! After being reassigned to the Monsters, Inc. Facilities Team, Tylor sets his sights on a new goal: figuring out how to be funny and becoming a Jokester.','https://posterspy.com/wp-content/uploads/2019/09/monsters-at-workkk.jpg','https://youtu.be/ijsh5RVYnoY');
insert into MOVIES values (movie_id_seq.nextval,'Dont Breathe 2','USA','2021','The Blind Man has been hiding out for several years in an isolated cabin and has taken in and raised a young girl orphaned from a devastating house fire. Their quiet life together is shattered when a group of criminals kidnap the girl, forcing the Blind Man to leave his safe haven to save her.','https://media.comicbook.com/2021/07/don-t-breathe-2-sequel-poster-stephen-lang-1275056.jpeg?auto=webp&width=750&height=938&crop=750:938,smart','https://youtu.be/gRbG2tjHYCA');

insert into MOVIESADMIN values ('admin','admin');

commit;

