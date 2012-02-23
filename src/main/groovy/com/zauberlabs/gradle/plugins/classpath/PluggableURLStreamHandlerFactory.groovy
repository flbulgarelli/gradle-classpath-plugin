package com.zauberlabs.gradle.plugins.classpath

import java.net.URL
import java.net.URLStreamHandler

class PluggableURLStreamHandlerFactory implements URLStreamHandlerFactory {

  final streamHandlers = [:]
  static final PluggableURLStreamHandlerFactory instance =  new PluggableURLStreamHandlerFactory()

  URLStreamHandler createURLStreamHandler(String protocol) {
    _factoryFrom(protocol)
  }

  def _factoryFrom(protocol) {
    streamHandlers[protocol]
  }

  def registerProtocol(protocol, factory){
    streamHandlers[protocol] = factory
  }

  /**
   * Warning: not thread safe
   */
  def registerIntoJVM() {
    if (URL.factory != this) 
      URL.URLStreamHandlerFactory = this
  }
}

