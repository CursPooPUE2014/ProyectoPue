create database dbFriki;

use dbFriki;

create table imagen (
	id_imagen int auto_increment primary key,
	id_articulo int not null,
	descripcion varchar(60),
	url_imagen varchar(120),
	novedad tinyint(1) not null default false
);

create table proveedor (
	id_proveedor int auto_increment primary key,
	cif_proveedor varchar(9) not null,
	nombre varchar(25),
	apellido1 varchar(25),
	apellido2 varchar(25),
	nombreEmpresa varchar(25) not null,
	direccion varchar(100),
	ciudad varchar(30),
	codigoPostal varchar(10),
	provincia varchar(30),
	pais varchar(25)
);

create table articulo (
  id_articulo int auto_increment primary key,
  nombre varchar(30) not null,
  descripcion varchar(80),
  precio double not null,
  stock int not null,
  id_categoria int not null,
  id_tipoProducto int not null,
  novedad tinyint(1),
  id_proveedor int
);

create table categoria (
  id_categoria int auto_increment primary key,
  nombre varchar(30),
  descripcion varchar(80)
);

create table tipoProducto (
  id_tipoProducto int auto_increment primary key,
  nombre varchar(30),
  descripcion varchar(80)
);

create table estado (
	id_estado int auto_increment primary key,
	estado varchar(25),
	descripcion varchar(60)
);

create table direccionEntrega (
  id_dirEntrega int auto_increment primary key,
  tipoVia varchar(15),
  direccion varchar(60) not null,
  numero varchar(7) not null,
  planta int,
  piso int,
  escalera varchar(10),
  bloque varchar(8),
  ciudad varchar(30) not null,
  provincia varchar(30) not null,
  pais varchar(25) not null,
  codigoPostal varchar(10) not null
);

create table pedido (
  id_pedido int auto_increment primary key,
  id_cliente int,
  fecha date,
  total_a_pagar double,
  id_estado int,
  id_dirEntrega int
);

create table usuarioCliente (
	id_usuario int auto_increment primary key,
	nombre varchar(25) not null,
	apellido1 varchar(25),
	apellido2 varchar(25),
	nif varchar(9),
	contrasenya varchar(30) not null,
	dir_postal varchar(100),
	email varchar(50) not null,
	telefono varchar(15)
);

create table usuarioAdministrador(
	id_usuario int auto_increment primary key,
	email varchar(50) not null,
	contrasenya varchar(30) not null,
	id_rol int not null
);

create table rol(
	id_rol int auto_increment primary key,
	nombre varchar(30) not null,
	descripcion varchar(50)
);

create table lineaPedido(
	id_pedido int,
	id_articulo int,
	cantidad int not null default 1,
	precio double not null,
	primary key (id_pedido,id_articulo)
);

alter table articulo add foreign key fk_categoria(id_categoria) references categoria(id_categoria);
alter table articulo add foreign key fk_tipoProducto(id_tipoProducto) references tipoProducto(id_tipoProducto);

alter table imagen add foreign key fk_articulo(id_articulo) references articulo(id_articulo);

alter table pedido add foreign key fk_id_cliente(id_cliente) references usuarioCliente(id_usuario);
alter table pedido add foreign key fk_id_estado(id_estado) references estado(id_estado);
alter table pedido add foreign key fk_id_dirEntrega(id_dirEntrega) references direccionEntrega(id_dirEntrega);

alter table lineaPedido add foreign key fk_id_pedido(id_pedido) references pedido(id_pedido);
alter table lineaPedido add foreign key fk_id_articulo(id_articulo) references articulo(id_articulo);

alter table usuarioAdministrador add foreign key fk_rol(id_rol) references rol(id_rol);


INSERT INTO categoria VALUES (1,'Series','Artículo relacionados con una Serie');
INSERT INTO categoria VALUES (2,'Peliculas','Artículo relacionados con una Película');
INSERT INTO categoria VALUES (3,'Otros','Artículo sin vinculación clara');

INSERT INTO tipoProducto VALUES (1,'Ropa','Prendas de ropa');
INSERT INTO tipoProducto VALUES (2,'Peluches','Peluches varios');
INSERT INTO tipoProducto VALUES (3,'Otros','Producto sin vinculación clara');

INSERT INTO articulo VALUES (1,'Camiseta Star Wars','Camiseta Star Wars Episodio1 Talla XL','20.3','12',1,1,false,3 );
INSERT INTO articulo VALUES (2,'Camiseta Juego de Tronos','Camiseta Juego de Tronos Winter Talla XL','24.5','30',1,1,false,2);
INSERT INTO articulo VALUES (3,'Peluche Dragón Desdentado','Peluche Desdentado Pelicula Cómo Entrenar a tu Dragón','35.0','6',2,2,true,1);

INSERT INTO imagen VALUES (1,1,'Imagen de camiseta Star Wars Episodio1','img\CamisetaStarWars.jpg',false);
INSERT INTO imagen VALUES (2,2,'Imagen de camiseta Juego de Tronos ','img\CamisetaJuegoTronos.jpg',false);
INSERT INTO imagen VALUES (3,3,'Peluche Desdentado','img\PelucheDesdentado.jpg',true);
INSERT INTO imagen VALUES (4,3,'Peluche Desdentado desde arriba','img\PelucheDesdentado2.jpg',true);

INSERT INTO usuarioCliente VALUES (1,'David','Campillo','Martinez','12654432B','1234','Rue del Percebe,13, Barcelona','dkampi73@gmail.com','645238596');
INSERT INTO usuarioCliente VALUES (2,'Gerard','Quintana','Cabra','65712432C','1234','Avda.Diagonal, 91, Barcelona','quermd@gmail.com','648892536');
INSERT INTO usuarioCliente VALUES (3,'Ricard','Beyloc','Gonzalez','32612486N','1234','Avda.Meridiana, 365, Barcelona','edmauri@gmail.com','637856891');

INSERT INTO estado VALUES (1,'Pagado','Pedido pagado en su totalidad');
INSERT INTO estado VALUES (2,'Pdte. Cobro','Pendiente de cobro');
INSERT INTO estado VALUES (3,'Primer plazo pagado','Primer plazo pagado');

INSERT INTO direccionEntrega VALUES (1,'Calle','Muntaner',210,5,3,'Izquierda','A','Barcelona','Barcelona','España','08016');
INSERT INTO direccionEntrega VALUES (2,'Avenida','Meridiana',355,7,1,' ',' ','Barcelona','Barcelona','España','08027');
INSERT INTO direccionEntrega VALUES (3,'Plaza','Mayor',10,2,1,' ',' ','Madrid','Madrid','España','28015');

INSERT INTO proveedor VALUES (1,'G23765890','Angel','Fernandez','Niebla','Famobil, S.A.', 'calle Aribau, 25', 'Barcelona','08010','Barcelona','España');
INSERT INTO proveedor VALUES (2,'K32987693','Juan','Garcia','De Capri','Garcia Textil, S.A.', 'calle Hermanos Badia, 12', 'Badalona','08036','Badalona','España');
INSERT INTO proveedor VALUES (3,'L41245022','Pedro','Martinez','Abenza','AB Moda, S.L.', 'calle Fontanelles, 110', 'Valencia','32465','Valencia','España');

INSERT INTO pedido VALUES (1,'3','2015-05-20','114.8',1,1);
INSERT INTO pedido VALUES (2,'1','2015-05-21','24.5',2,2);
INSERT INTO pedido VALUES (3,'2','2015-05-22','75.6',1,3);

INSERT INTO lineaPedido VALUES(1,'1','1','20.3');
INSERT INTO lineaPedido VALUES(1,'2','1','24.5');
INSERT INTO lineaPedido VALUES(1,'3','2','70.0');
INSERT INTO lineaPedido VALUES(2,'2','1','24.5');
INSERT INTO lineaPedido VALUES(3,'1','2','40.6');
INSERT INTO lineaPedido VALUES(3,'3','1','35.0');

INSERT INTO rol VALUES(1,'Admin_total','Administrador total');
INSERT INTO rol VALUES(2,'Admin_parcial','Administrador parcial');
INSERT INTO rol VALUES(3,'Ventas','Acceso a las ventas');

INSERT INTO usuarioAdministrador VALUES(1,'admin1','dkampi',1);
INSERT INTO usuarioAdministrador VALUES(2,'admin2','quermd',1);
INSERT INTO usuarioAdministrador VALUES(3,'admin3','edmauri',2);



