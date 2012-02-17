/*
 Copyright (c) 2012, The Staccato-Commons Team
 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation; version 3 of the License.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 */
package com.zauberlabs.gradle.plugins.classpath

import java.net.URL
import java.net.URLStreamHandler

class PluggableURLStreamHandlerFactory implements URLStreamHandlerFactory {

  final streamHandlers = [:]
  static final PluggableURLStreamHandlerFactory instance = new PluggableURLStreamHandlerFactory()

  URLStreamHandler createURLStreamHandler(String protocol) {
    _factoryFrom(protocol)
  }

  def _factoryFrom(protocol) {
    streamHandlers[protocol]
  }

  def registerProtocol(protocol, factory){
    streamHandlers[protocol] = factory
  }

  def registerIntoJVM() {
    URL.URLStreamHandlerFactory = this
  }
}

