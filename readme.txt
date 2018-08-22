可参考 https://github.com/forezp/SpringCloudLearning
不过在他的基础上做了很多改动和尝试 并加入了一些个人的注释 以便日后可随时有demo修改和测试 记入注释和观察

一:项目中尚未解决的问题
   1.如果没有rabbitMQ 无法动态刷新 @RefreshScope  但是网上大多数博客 没用amqp 依然可以,暂时未排查出原因    --- s-cf-chapter6 => config-client