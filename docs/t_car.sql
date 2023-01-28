use SRS;
# --  t_user table
# drop table if exists t_user;

# create table t_user(
                         #     id int primary key auto_increment,
                         #     username varchar(255),
                         #     password varchar(255)
                             # );

# insert into t_user(username, password) VALUES ('admin','123456');
# insert into t_user(username, password) VALUES ('root','456789');


# commit;

# select * from t_user;



#-- t_car table
drop table if exists t_car;
create table t_car(
                      id bigint primary key auto_increment,
                      car_num varchar(255),
                      brand varchar(255),
                      guide_price decimal(10,2),
                      produce_time char(10),
                      car_type varchar(255)
);
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (165, '6666', '丰田霸道', 32.00, '2020-11-11', '燃油车');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (166, '1202', '大众速腾', 30.00, '2020-11-11', '燃油车');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (167, '1203', '奔驰GLC', 5.00, '2010-12-03', '燃油车');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (168, '1204', '奥迪Q7', 3.00, '2009-10-11', '燃油车');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (169, '1205', '朗逸', 4.00, '2001-10-11', '新能源');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (171, '1207', '奥迪A6', 30.00, '2000-01-02', '燃油车');
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (172, '6666', '丰田霸道', 32.00, '2020-11-11', '燃油车');
commit;
select * from t_car;










