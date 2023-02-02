-- t_act table
drop table if exists t_act;
create table t_act(
                      id bigint primary key auto_increment,
                      actno varchar(255),
                      balance decimal(15,2)
);

INSERT INTO `t_act` (`id`, `actno`, `balance`) VALUES (1, 'act001', 20000.00);
INSERT INTO `t_act` (`id`, `actno`, `balance`) VALUES (2, 'act002', 30000.00);

commit;

select * from t_act;