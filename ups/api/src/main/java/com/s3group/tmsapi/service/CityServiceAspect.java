//package com.s3group.tmsapi.service;
//
//import com.s3group.tmsapi.config.multitenant.TenantContext;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.hibernate.Session;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class CityServiceAspect {
//  @Before("execution(* com.s3group.tmsapi.service.CityService.*(..)) " +
//      "&& " +
//      "!execution(* com.s3group.tmsapi.service.CityService.run(..)) && target" +
//      "(cityService)")
//  public void aroundExecution(JoinPoint pjp, CityService cityService) throws Throwable {
//    org.hibernate.Filter filter =
//        cityService.entityManager.unwrap(Session.class).enableFilter(
//            "tenantFilter");
//    filter.setParameter("tenantId", TenantContext.getCurrentTenant());
//    filter.validate();
//  }
//}