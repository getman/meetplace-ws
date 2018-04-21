CREATE TABLE meet_point (
	id VARCHAR2(15) PRIMARY KEY,
	x NUMBER(7,10) NOT NULL,
	y NUMBER(7,10) NOT NULL);

COMMIT;
/

select * from meet_point
insert into meet_point(id, x, y) values('point1', 0, 0)