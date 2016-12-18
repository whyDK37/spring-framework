/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework;

import java.io.Serializable;

import org.springframework.aop.SpringProxy;

/**
 * Default {@link AopProxyFactory} implementation,
 * creating either a CGLIB proxy or a JDK dynamic proxy.
 * <p>
 * <p>Creates a CGLIB proxy if one the following is true
 * for a given {@link AdvisedSupport} instance:
 * <ul>
 * <li>the "optimize" flag is set
 * <li>the "proxyTargetClass" flag is set
 * <li>no proxy interfaces have been specified
 * </ul>
 * <p>
 * <p>Note that the CGLIB library classes have to be present on
 * the class path if an actual CGLIB proxy needs to be created.
 * <p>
 * <p>In general, specify "proxyTargetClass" to enforce a CGLIB proxy,
 * or specify one or more interfaces to use a JDK dynamic proxy.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see AdvisedSupport#setOptimize
 * @see AdvisedSupport#setProxyTargetClass
 * @see AdvisedSupport#setInterfaces
 * @since 12.03.2004
 */
@SuppressWarnings("serial")
public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {


    /**
     * @param config the AOP configuration in the form of an
     *               AdvisedSupport object
     * @return
     * @throws AopConfigException
     */
    public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
        //importance
//		spring 是通过三个条件决定使用什么代理的
//		optimize : 用来控制通过CGLIB创建的代理是否使用激进的优化策略，除非完全了解aop代理是如何处理优化，否则不推荐用户使用这个设置。
//		目前这个属性仅用于GCLIB代理，对于JDK动态代理无效。
//		proxyTargetClass:这个属性为true时，目标类本身被代理而不是目标类的接口，如果这个属性被设置为ture，cglib代理江北创建，
//		设置方式：<aop:aspectj-autoproxy proxy-target-class=true />
//		hasNoUserSuppliedProxyInterfaces:是否存在代理接口
        if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
            Class targetClass = config.getTargetClass();
            if (targetClass == null) {
                throw new AopConfigException("TargetSource cannot determine target class: " +
                        "Either an interface or a target is required for proxy creation.");
            }
            if (targetClass.isInterface()) {
                return new JdkDynamicAopProxy(config);
            }
            return CglibProxyFactory.createCglibProxy(config);
        } else {
            return new JdkDynamicAopProxy(config);
        }
    }

    /**
     * Determine whether the supplied {@link AdvisedSupport} has only the
     * {@link org.springframework.aop.SpringProxy} interface specified
     * (or no proxy interfaces specified at all).
     */
    private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
        Class[] interfaces = config.getProxiedInterfaces();
        return (interfaces.length == 0 || (interfaces.length == 1 && SpringProxy.class.equals(interfaces[0])));
    }


    /**
     * Inner factory class used to just introduce a CGLIB dependency
     * when actually creating a CGLIB proxy.
     */
    private static class CglibProxyFactory {

        public static AopProxy createCglibProxy(AdvisedSupport advisedSupport) {
            return new CglibAopProxy(advisedSupport);
        }
    }

}
