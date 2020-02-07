package com.java.bootcamp.projects.di;

import com.java.bootcamp.projects.di.annotations.InjectableFactory;
import com.java.bootcamp.projects.di.annotations.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DependencyInjector {

    private static final Logger LOG = LoggerFactory.getLogger(DependencyInjector.class);

    private final Map<Class<?>, Object> managedServices;

    public DependencyInjector() {
        this.managedServices = new HashMap<>();
    }

    public void scanClassPath(String classPath) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String normalizedClassPath = classPath.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(normalizedClassPath);

        //1. scan classpath, get classes in package
        List<Class<?>> classesFound = new ArrayList<>();
        while(resources.hasMoreElements()) {
            File directory = new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8"));
            File[] files = directory.listFiles();
            for (File file : files) {
                if ((file.getName().endsWith(".class")) && (!file.getName().contains("$"))) {
                    String filePath = file.getPath();
                    int index = filePath.indexOf(normalizedClassPath);
                    String packagePrefix = filePath.substring(index).replace('/', '.');
                    String className = packagePrefix.substring(0, packagePrefix.length() - 6);
                    Class<?> clazz = Class.forName(className);
                    classesFound.add(clazz);
                }
            }
        }

        //2. find Injectable factories and create injectables
        Map<Class<?>, Object> injectables = new HashMap<>();
        for (Class<?> clazz: classesFound) {
            Method[] methods = clazz.getMethods();
            for (Method method: methods) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                for (Annotation annotation: declaredAnnotations) {
                    if (annotation instanceof InjectableFactory) {
                        LOG.info("Factory found: {}", annotation.toString());
                        Class<?> returnType = method.getReturnType();
                        Constructor<?>[] constructors = clazz.getConstructors();
                        for (Constructor constructor: constructors) {
                            if (constructor.getParameterCount() == 0) {
                                try {
                                    Object factoryInstance = constructor.newInstance();
                                    Method factoryMethod = factoryInstance.getClass().getMethod(method.getName());
                                    Object injectable = factoryMethod.invoke(factoryInstance);
                                    injectables.put(returnType, injectable);
                                } catch (Exception e) {
                                    LOG.info("Can't create factory instance: {}", clazz.getCanonicalName());
                                }
                            }
                        }
                    }
                }
            }
        }

        //3. find ManagedServices and inject objects into constructors
        for (Class<?> clazz: classesFound) {
            Annotation[] declaredAnnotations = clazz.getAnnotations();
            for (Annotation annotation: declaredAnnotations) {
                if (annotation instanceof ManagedService) {
                    Constructor<?>[] constructors = clazz.getConstructors();
                    if (constructors.length == 1) {
                        int parameterCount = constructors[0].getParameterCount();
                        if (parameterCount == 0) {
                            try {
                                Object managedServiceInstance = constructors[0].newInstance();
                                managedServices.put(clazz, managedServiceInstance);
                            } catch (Exception e) {
                                LOG.info("Can't create managed service instance: {}", clazz.getCanonicalName());
                            }
                            break;
                        } else {
                            try {
                                Class<?>[] parameterTypes = constructors[0].getParameterTypes();
                                Object[] parameterInstances = new Object[parameterTypes.length];
                                for (int i=0; i<parameterTypes.length; i++) {
                                    Class<?> parameterType = parameterTypes[i];
                                    parameterInstances[i] = injectables.get(parameterType);
                                }
                                Object managedServiceInstance = constructors[0].newInstance(parameterInstances);
                                managedServices.put(clazz, managedServiceInstance);
                            } catch (Exception e) {
                                LOG.info("Can't create managed service instance: {}", clazz.getCanonicalName());
                            }
                            break;
                        }
                    } else {
                        LOG.info("Too many constructors: {}", clazz.getCanonicalName());
                    }
                }
            }
        }
    }

    public <T> Optional<T> getManagedService(Class<T> type) {
        Object service = managedServices.get(type);
        if (service != null) {
            return Optional.of((T)service);
        } else {
            return Optional.empty();
        }
    }

}
