# SpringCloud
## config-client
1.从config-server拿取配置信息
## config-server
1.配置中心
## eureka-provider
1.向其他服务提供接口
## eureka-server
1.注册中心
## feign-service
1.使用feign调用eureka-provider提供的接口  
2.搭配Hystrix实现降级
## rabbit-server
1.rabbitmq的使用
## ribbon-service
1.使用ribbon调用eureka-provider提供的接口  
2.搭配Hystrix实现降级  
3.增加SpringCache,使用redis缓存
## zuul- server
1.路由
