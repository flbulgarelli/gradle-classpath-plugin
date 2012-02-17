package com.zauberlabs.gradle.plugins.classpath

import org.gradle.api.*


class ClasspathPlugin implements Plugin<Project> {
  def void apply(Project project) {
    PluggableURLStreamHandlerFactory.instance.with {
      registerIntoJVM()
      registerProtocol('classpath', new ClasspathURLStreamHandler())
    }
  }
}

