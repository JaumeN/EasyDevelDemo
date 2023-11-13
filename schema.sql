DROP TABLE IF EXISTS t_section;
CREATE TABLE t_section (
id SERIAL,
nombre varchar(255) NOT NULL,
PRIMARY KEY ("id")
)