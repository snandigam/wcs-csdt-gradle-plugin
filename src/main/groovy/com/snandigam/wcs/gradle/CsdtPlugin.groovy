package com.snandigam.wcs.gradle

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class CsdtPlugin implements Plugin<Project> {
	public static final String PLUGIN_TASK_NAME = "csdtCmd"
	public static final String PLUGIN_EXTENSIONS_NAME = "csdtCmdArgs"
	
    void apply(Project project) {
		project.extensions.create(PLUGIN_EXTENSIONS_NAME, CsdtPluginExtension)
        project.task(PLUGIN_TASK_NAME, type: CsdtTask)
    }
}