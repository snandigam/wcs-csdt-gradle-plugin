package com.snandigam.wcs.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class CsdtTaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('csdtCmd', type: CsdtTask)
        assertTrue(task instanceof CsdtTask)
    }
}
