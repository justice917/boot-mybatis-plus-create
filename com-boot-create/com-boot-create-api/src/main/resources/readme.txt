1 本地新建一个msql数据库
2 新建一个mytest的实例库
3 执行mysql.sql
4 删除
	com.boot.create.mysql.template.entity,
	com.boot.create.mysql.template.mapper,
	com.boot.create.mysql.template.service,
	com.boot.create.mysql.template.service.impl
	这几个package
4 修改com-boot-create-mysql项目中的resources下的application.yml中的链接datasource地址，以便读取表结构生成代码
5 执行MysqlGenerator,输入表明user_test（即mysql.sql中的表）系统会自动生成相关dao和service代码在com.boot.create.mysql.template下
6 样例测试可以参考com.boot.create.test.SampleTest
