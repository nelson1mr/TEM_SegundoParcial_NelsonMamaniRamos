create database bd_biblioteca;

create table libros(
	id int auto_increment primary key,
	titulo varchar(100),
	autor varchar(100),
	disponible char(2) check(disponible in('SI','NO')),
	categoria varchar(100)
);

create table categorias(
	id int auto_increment primary key,
	categoria varchar(100)
);

insert into categorias(categoria) values('Ciencia Ficcion');
insert into categorias(categoria) values('Novela');
insert into categorias(categoria) values('Programacion');

insert into libros(titulo,autor,disponible, categoria) 
	values('Tecnologias Emergentes II','Nelson Mamani Ramos','SI','Programacion');
insert into libros(titulo,autor,disponible, categoria) 
	values('EL fin del mundo','Alex Mena','NO','Ciencia Ficcion');
insert into libros(titulo,autor,disponible, categoria) 
	values('Programacion elemental','Juan Perez','SI','Programacion');