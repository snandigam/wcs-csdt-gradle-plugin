package com.snandigam.wcs.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class CsdtPluginTest {
    @Test
    public void csdtPluginAddscsdtCmdTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'wcs-csdt'
		
        assertTrue(project.tasks.csdtCmd instanceof CsdtTask)
    }
}
