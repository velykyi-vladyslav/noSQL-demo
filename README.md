# NoSql demo application

Example of performing tasks with NoSQL databases compared to SQL.

Tasks:
1. Define data model for Mongo (the direct table-collection mapping is not the best idea).
2. Write data migration job (via SQL and MongoDriver operations).
3. Use aggregation mechanism to get grouped results from the database.

Solution:
1. The following model was chosen  [Embedded Data](https://www.mongodb.com/docs/manual/core/data-modeling-introduction/#embedded-data). 
Because It is close to the implementation version of the SQL-based in this project. 
Method to reproduce that: velykyi.vladyslav.NoSQLDemo.controller.UserController#createUserMongo()
2. Data migration job is implemented in velykyi.vladyslav.NoSQLDemo.service.impl.UserServiceImpl#migrateUserToMongo()
3. The necessary logic for the aggregation mechanism is implemented in the: velykyi.vladyslav.NoSQLDemo.service.impl.UserServiceImpl#getUserWithNullField().
Additional:
- configuration: velykyi.vladyslav.NoSQLDemo.config.MongoConfig class;
- [Class Criteria](https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/query/Criteria.html)
- [Aggregation Pipeline Operators](https://www.mongodb.com/docs/manual/reference/operator/aggregation/#aggregation-pipeline-operators)
