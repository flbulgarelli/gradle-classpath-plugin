package com.zauberlabs.gradle.plugins.classpath;

class ClasspathURLStreamHandler extends URLStreamHandler {

  URLConnection openConnection(URL url) {
    new ClasspathURLConnection(url)
  }
}

class ClasspathURLConnection extends URLConnection {

  ClasspathURLConnection(URL url) {
    super(url)
  }

  void connect() {}

  def _fullPath() {
    url.with { host + file }
  }

  InputStream getInputStream() {
    def inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(_fullPath())
    assert inputStream != null, "$url not found "
    inputStream
  }
}