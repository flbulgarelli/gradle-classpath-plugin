package com.zauberlabs.gradle.plugins.classpath

import static org.junit.Assert.*

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class ClasspathPluginTest {

  @Test
  public void greeterPluginAddsGreetingTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'classpath'
    project.apply from: 'classpath://snippet'

    assert project.getAllTasks(true).toString() == "[root project 'test':[task ':demo']]"
  }
}