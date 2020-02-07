package com.java.bootcamp.projects.di;

import java.io.IOException;
import java.util.Optional;

/**
 * Simple dependency injection framework demo.
 */
public interface DependencyInjector {

    /**
     * Scans classpath looking for classes annotated as {@link com.java.bootcamp.projects.di.annotations.ManagedService}
     * and initialize those (create new instances) using constructor dependency injection. Dependencies are created by
     * scanning same classpath and created by calling methods annotated {@link com.java.bootcamp.projects.di.annotations.InjectableFactory}.
     * This must be called before any use of this service.
     * @param classPath classpath to scan. For example "com.example.services".
     * @throws IOException thrown in case classpath can't be scanned.
     * @throws ClassNotFoundException thrown in case class not found.
     */
    void scanClassPath(String classPath) throws IOException, ClassNotFoundException;

    /**
     * Returns instances of initialized classes annotated by {@link com.java.bootcamp.projects.di.annotations.ManagedService}.
     * Classpath scan must be commenced before this method call.
     * @param type class type to return.
     * @param <T>
     * @return {@link Optional} of the managed service or empty if no such service has been initialized.
     */
    <T> Optional<T> getManagedService(Class<T> type);

}
