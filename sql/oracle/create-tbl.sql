CREATE TABLE meet_point (
	id VARCHAR2(15) PRIMARY KEY,
	x NUMBER(19) NOT NULL,
	y NUMBER(19) NOT NULL);

COMMIT;
/

--�������� ��� ���� �������
alter table meet_point modify(
    y NUMBER(19)
)

select * from meet_point
insert into meet_point(id, x, y) values('point1', 0, 0)