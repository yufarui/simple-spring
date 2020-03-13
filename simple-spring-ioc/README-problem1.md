# simple-spring-di
> 研究spring依赖注入
## yu.problem1
```
运行 Application 会抛出循环引用的依赖
```
> 产生了循环依赖,让我们debug代码并分析下原因

```$xslt
        //简单阐述下,产生循环依赖原因
        // 1.创建Servcie 需要注入 BeanA,
        // 2.注入BeanA 时,发现BeanA是一个FactoryBean,则需要构建Config
        // 3.构建Config时,需要注入BeanB
        // 4.注入BeanB,时需要注入BeanA; 到此产生了循环依赖
        createBeanInstance(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) { 
        		if (mbd.getFactoryMethodName() != null) {
        			return instantiateUsingFactoryMethod(beanName, mbd, args);
        		}
        }
        
        // instantiateUsingFactoryMethod
        String factoryBeanName = mbd.getFactoryBeanName();
        if (factoryBeanName != null) {
            if (factoryBeanName.equals(beanName)) {
                throw new BeanDefinitionStoreException(mbd.getResourceDescription(), beanName,
                        "factory-bean reference points back to the same bean definition");
            }
            factoryBean = this.beanFactory.getBean(factoryBeanName);
            if (mbd.isSingleton() && this.beanFactory.containsSingleton(beanName)) {
                throw new ImplicitlyAppearedSingletonException();
            }
            factoryClass = factoryBean.getClass();
            isStatic = false;
        }
```

## yu.problem1 参考资料

> 一个非典型Spring循环依赖的问题分析
https://blog.mythsman.com/post/5d838c7c2db8a452e9b7082c/ 