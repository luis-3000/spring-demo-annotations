package com.joselcastillo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// Make use of the Spring Java source code configuration file recently created (SportConfig)
		// by reading it
		AnnotationConfigApplicationContext appContext = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the Spring container
		// Changed from passing the explicit "thatSillyCoach" bean id, to a default bean id 'tennisCoach'
		// (which should be the class name in use but with the first letter converted to lower case)
		Coach_Interface theCoach = appContext.getBean("tennisCoach", Coach_Interface.class);
		
		// Call some methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call new method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the application context
		appContext.close();
		
	}

}

/* SAMPLE OUTPUT
   -------------
   
	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	>> TennisCoach class: inside the default constructor TennisCoach()
	 >> TennisCoach class: inside the doMyStartupStuff() method
	Your Tennis workout: Practice your backhand volley
	Tennis coach fortune says: The Journey is the reward
	 >> TennisCoach class: inside the doMyCleanupStuff() method
	 
	 
	SECOND SAMPLE OUTPUT
	--------------------
	 
	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService class: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	>> TennisCoach class: inside the default constructor TennisCoach()
	 >> TennisCoach class: inside the doMyStartupStuff() method
	Your Tennis workout: Practice your backhand volley
	Tennis coach fortune says: Beware of the wolf in sheep's clothing
	 >> TennisCoach class: inside the doMyCleanupStuff() method


	THIRD SAMPEL OUTPUT AFTER SETTING UP THE LOGGING MESSAGES
	---------------------------------------------------------
	
	>> FileFortuneService class: inside default constructor FileFortuneService()
	>> FileFortuneService class: inside method loadTheFortunesFile()
	Reading fortunes from file: fortune-data.txt
	File exists class: true
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Finished creating instance of bean 'myLoggerConfig'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.DefaultSingletonBeanRegistry getSingleton
	FINE: Creating shared instance of singleton bean 'pingPongCoach'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Creating instance of bean 'pingPongCoach'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InjectionMetadata checkConfigMembers
	FINEST: Registered injected element on class [com.joselcastillo.springdemo.PingPongCoach]: AutowiredFieldElement for private com.joselcastillo.springdemo.FortuneService_Interface com.joselcastillo.springdemo.PingPongCoach.fortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory doCreateBean
	FINEST: Eagerly caching bean 'pingPongCoach' to allow for resolving potential circular references
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InjectionMetadata inject
	FINEST: Processing injected element of bean 'pingPongCoach': AutowiredFieldElement for private com.joselcastillo.springdemo.FortuneService_Interface com.joselcastillo.springdemo.PingPongCoach.fortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractBeanFactory doGetBean
	FINEST: Returning cached instance of singleton bean 'fileFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor registerDependentBeans
	FINEST: Autowiring by type from bean name 'pingPongCoach' to bean named 'fileFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Finished creating instance of bean 'pingPongCoach'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.DefaultSingletonBeanRegistry getSingleton
	FINE: Creating shared instance of singleton bean 'RESTFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Creating instance of bean 'RESTFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory doCreateBean
	FINEST: Eagerly caching bean 'RESTFortuneService' to allow for resolving potential circular references
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Finished creating instance of bean 'RESTFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.DefaultSingletonBeanRegistry getSingleton
	FINE: Creating shared instance of singleton bean 'randomFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Creating instance of bean 'randomFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory doCreateBean
	FINEST: Eagerly caching bean 'randomFortuneService' to allow for resolving potential circular references
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Finished creating instance of bean 'randomFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.DefaultSingletonBeanRegistry getSingleton
	FINE: Creating shared instance of singleton bean 'tennisCoach'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Creating instance of bean 'tennisCoach'
	>> TennisCoach class: inside the default constructor TennisCoach()
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor lambda$buildLifecycleMetadata$0
	FINEST: Found init method on class [com.joselcastillo.springdemo.TennisCoach]: public void com.joselcastillo.springdemo.TennisCoach.doMyStartupStuff()
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor lambda$buildLifecycleMetadata$0
	FINEST: Found destroy method on class [com.joselcastillo.springdemo.TennisCoach]: public void com.joselcastillo.springdemo.TennisCoach.doMyCleanupStuff()
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata checkConfigMembers
	FINEST: Registered init method on class [com.joselcastillo.springdemo.TennisCoach]: org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement@4e70aaae
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata checkConfigMembers
	FINEST: Registered destroy method on class [com.joselcastillo.springdemo.TennisCoach]: org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement@b58416e7
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InjectionMetadata checkConfigMembers
	FINEST: Registered injected element on class [com.joselcastillo.springdemo.TennisCoach]: AutowiredFieldElement for private com.joselcastillo.springdemo.FortuneService_Interface com.joselcastillo.springdemo.TennisCoach.fortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory doCreateBean
	FINEST: Eagerly caching bean 'tennisCoach' to allow for resolving potential circular references
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InjectionMetadata inject
	FINEST: Processing injected element of bean 'tennisCoach': AutowiredFieldElement for private com.joselcastillo.springdemo.FortuneService_Interface com.joselcastillo.springdemo.TennisCoach.fortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractBeanFactory doGetBean
	FINEST: Returning cached instance of singleton bean 'randomFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor registerDependentBeans
	FINEST: Autowiring by type from bean name 'tennisCoach' to bean named 'randomFortuneService'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata invokeInitMethods
	FINEST: Invoking init method on bean 'tennisCoach': public void com.joselcastillo.springdemo.TennisCoach.doMyStartupStuff()
	 >> TennisCoach class: inside the doMyStartupStuff() method
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory createBean
	FINEST: Finished creating instance of bean 'tennisCoach'
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.SportConfig$$EnhancerBySpringCGLIB$$4cbe56c7
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.DatabaseFortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.FileFortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.HappyFortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.MyLoggerConfig$$EnhancerBySpringCGLIB$$362ea409
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.PingPongCoach
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.RESTFortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.RandomFortuneService
	Jun 02, 2020 8:46:51 PM org.springframework.context.event.EventListenerMethodProcessor processBean
	FINEST: No @EventListener annotations found on bean class: com.joselcastillo.springdemo.TennisCoach
	Jun 02, 2020 8:46:51 PM org.springframework.context.support.AbstractApplicationContext initLifecycleProcessor
	FINEST: No 'lifecycleProcessor' bean, using [DefaultLifecycleProcessor]
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractBeanFactory doGetBean
	FINEST: Returning cached instance of singleton bean 'lifecycleProcessor'
	Jun 02, 2020 8:46:51 PM org.springframework.core.env.PropertySourcesPropertyResolver getProperty
	FINEST: Searching for key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemProperties'
	Jun 02, 2020 8:46:51 PM org.springframework.core.env.PropertySourcesPropertyResolver getProperty
	FINEST: Searching for key 'spring.liveBeansView.mbeanDomain' in PropertySource 'systemEnvironment'
	Jun 02, 2020 8:46:51 PM org.springframework.core.env.PropertySourcesPropertyResolver getProperty
	FINEST: Searching for key 'spring.liveBeansView.mbeanDomain' in PropertySource 'class path resource [mylogger.properties]'
	Jun 02, 2020 8:46:51 PM org.springframework.core.env.PropertySourcesPropertyResolver getProperty
	FINEST: Could not find key 'spring.liveBeansView.mbeanDomain' in any property source
	Jun 02, 2020 8:46:51 PM org.springframework.core.io.support.SpringFactoriesLoader loadFactories
	FINEST: Loaded [org.springframework.beans.BeanInfoFactory] names: [org.springframework.beans.ExtendedBeanInfoFactory, org.springframework.beans.ExtendedBeanInfoFactory]
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractBeanFactory doGetBean
	FINEST: Returning cached instance of singleton bean 'tennisCoach'
	Your Tennis workout: Practice your backhand volley
	Tennis coach fortune says: The Journey is the reward
	Jun 02, 2020 8:46:51 PM org.springframework.context.support.AbstractApplicationContext doClose
	FINE: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@7e774085, started on Tue Jun 02 20:46:51 CDT 2020
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.AbstractBeanFactory doGetBean
	FINEST: Returning cached instance of singleton bean 'lifecycleProcessor'
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.support.DefaultSingletonBeanRegistry destroySingletons
	FINEST: Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@436e852b: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,sportConfig,databaseFortuneService,fileFortuneService,happyFortuneService,myLoggerConfig,pingPongCoach,RESTFortuneService,randomFortuneService,tennisCoach]; root of factory hierarchy
	Jun 02, 2020 8:46:51 PM org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata invokeDestroyMethods
	FINEST: Invoking destroy method on bean 'tennisCoach': public void com.joselcastillo.springdemo.TennisCoach.doMyCleanupStuff()
	 >> TennisCoach class: inside the doMyCleanupStuff() method
	 
*/ 