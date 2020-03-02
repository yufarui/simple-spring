# simple-spring-di
> 研究spring依赖注入
## yu.problem2
```
运行 yu.problem2.Application 会抛出循环引用的依赖
```
> 产生了循环依赖,让我们debug代码并分析下原因

```
   // 代码大致流程:
   // 1.创建BeanA实例,在用 AutowiredAnnotationBeanPostProcessor,发现需要使用构造器去创建实例
   // 2.BeanA构造器创造实例时,需要解析参数BeanB,并需要创建BeanB的实例
   // 3.BeanB也是用构造器创造实例,需要创建BeanA的实例
   // 4.这时 beforeSingletonCreation 检查到 singletonsCurrentlyInCreation(Set)已经存在了BeanA和BeanB,发现了循环依赖

   // 开始创建BeanA实例:
   AbstractAutowireCapableBeanFactory.createBeanInstance
   
   // autowiredBeanPostProcessors 会找到 我们注入的构造器
   Constructor<?>[] ctors = determineConstructorsFromBeanPostProcessors(beanClass, beanName);
   if (ctors != null || mbd.getResolvedAutowireMode() == AUTOWIRE_CONSTRUCTOR ||
           mbd.hasConstructorArgumentValues() || !ObjectUtils.isEmpty(args)) {
       // 找到构造器,则开始创建实例
       return autowireConstructor(beanName, mbd, ctors, args);
   }
   
   // autowireConstructor开始用构造器构建实例:
   ...
   AutowireUtils.sortConstructors(candidates);
   ...
   for (Constructor<?> candidate : candidates) {
       ...
       String[] paramNames = ConstructorPropertiesChecker.evaluate(candidate, paramTypes.length);
       if (paramNames == null) {
           ParameterNameDiscoverer pnd = this.beanFactory.getParameterNameDiscoverer();
           if (pnd != null) {
               // 从beanFactory获取参数名称
               paramNames = pnd.getParameterNames(candidate);
           }
       }
       // 创建参数数组,内部方法包含解析参数
       argsHolder = createArgumentArray(beanName, mbd, resolvedValues, bw, paramTypes, paramNames,
               getUserDeclaredConstructor(candidate), autowiring, candidates.length == 1);
       ...
   }
   
   // createArgumentArray:
   ...
   for (int paramIndex = 0; paramIndex < paramTypes.length; paramIndex++) {
       ...
       // 解析到BeanA的参数BeanB
       Object autowiredArgument = resolveAutowiredArgument(methodParam, beanName, autowiredBeanNames, converter, fallback);
       ...
   }
   ...
   
   // resolveAutowiredArgument
   return this.beanFactory.resolveDependency(new DependencyDescriptor(param, true), beanName, autowiredBeanNames, typeConverter);
   
   // 解析到最后,我们需要去创建BeanB的实例
   resolveCandidate(String beanName, Class<?> requiredType, BeanFactory beanFactory)
   
    // 接着我们去创建BeanB,但是BeanB 还需要创建BeanA,
    // 然后BeanA再去创建BeanB时被发现了循环引用     
	protected void beforeSingletonCreation(String beanName) {
		if (!this.inCreationCheckExclusions.contains(beanName) && !this.singletonsCurrentlyInCreation.add(beanName)) {
			throw new BeanCurrentlyInCreationException(beanName);
		}
	}

```
## yu.problem2 参考资料
> Circular Dependencies in Spring https://www.baeldung.com/circular-dependencies-in-spring

## 延申
> spring如何解决循环依赖

```

    // 解决循环依赖的核心:
    // 1.Spring实例化一个bean的时候，是分两步进行的，首先实例化目标bean，然后为其注入属性。
    // 2.以三个cache构成了三级缓存，Spring就用这三级缓存巧妙的解决了循环依赖问题。
    
    AbstractBeanFactory.doGetBean时
    ...
    // Eagerly check singleton cache for manually registered singletons.
    Object sharedInstance = getSingleton(beanName);
    ...
    
    // 从缓存中取单例
    protected Object getSingleton(String beanName, boolean allowEarlyReference) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            synchronized (this.singletonObjects) {
                singletonObject = this.earlySingletonObjects.get(beanName);
                if (singletonObject == null && allowEarlyReference) {
                    ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        singletonObject = singletonFactory.getObject();
                        this.earlySingletonObjects.put(beanName, singletonObject);
                        this.singletonFactories.remove(beanName);
                    }
                }
            }
        }
        return singletonObject;
    }
    
    // 放入缓存的地方
    // 创建实例时,调用的getSingleton
    if (newSingleton) {
        addSingleton(beanName, singletonObject);
    }
    
   /**
    * Add the given singleton object to the singleton cache of this factory.
    * <p>To be called for eager registration of singletons.
    * @param beanName the name of the bean
    * @param singletonObject the singleton object
    */
	protected void addSingleton(String beanName, Object singletonObject) {
		synchronized (this.singletonObjects) {
			this.singletonObjects.put(beanName, singletonObject);
			this.singletonFactories.remove(beanName);
			this.earlySingletonObjects.remove(beanName);
			this.registeredSingletons.add(beanName);
		}
	}

```
## yu.problem2 参考资料
> Spring源码初探-IOC(4)-Bean的初始化-循环依赖的解决 https://www.jianshu.com/p/6c359768b1dc

> Spring如何解决循环依赖的问题 https://my.oschina.net/zhangxufeng/blog/3096394
