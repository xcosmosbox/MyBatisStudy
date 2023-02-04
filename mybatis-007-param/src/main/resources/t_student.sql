-- t_student table
drop table if exists t_student;
create table t_student(
                          id bigint primary key auto_increment,
                          name varchar(255),
                          age int,
                          height double,
                          birth date,
                          sex char(1)
);

INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (1, '张三', 20, 1.81, '1980-10-11', '男');
INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (2, '李四', 18, 1.61, '1988-10-11', '女');
INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (3, '赵六', 20, 1.81, '2022-09-01', '男');
INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (4, '赵六', 20, 1.81, '2022-09-01', '男');
INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (5, '张飞', 50, 10, '2022-09-01', '女');
INSERT INTO `t_student` (`id`, `name`, `age`, `height`, `birth`, `sex`) VALUES (6, '张飞', 50, 10, '2022-09-01', '女');


commit;

select * from t_student;