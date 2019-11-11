# simple-spring-di
> 研究spring依赖注入
## yu.problem
```
运行 yu.problem.Application 会抛出循环引用的依赖
```
> 产生了循环依赖,让我们debug代码并分析下原因

```$xslt
简单的写一个 产生此原因的demo
```

> 动手写一个类似框架的循环依赖解决方案