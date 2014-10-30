package com.snandigam.wcs.gradle

import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction;

import com.fatwire.csdt.client.main.CSDT;

class CsdtTask extends DefaultTask {
	
		String resources, cmd, fromSites, toSites, modifiedSince,
				datastore, includeDeps, idMapping	
	
		@TaskAction
		def csdtCmd() {
			println "==== CSDT command start ===="
			verifyCsdtArguments()
			/*
			StringBuilder argsBuilder = new StringBuilder()
			argsBuilder.append("${project.csdtCmdArgs.baseUri}/ContentServer").append(",")
			argsBuilder.append("username=${project.csdtCmdArgs.username}").append(",")
			argsBuilder.append("password=${project.csdtCmdArgs.password}").append(",")
			argsBuilder.append("cmd=${cmd}").append(",")
			argsBuilder.append("resources=${resources}")
			//argsBuilder.append("").append(",")
			//argsBuilder.append("").append(",")
			
			List argsList = argsBuilder.tokenize(",")
			*/
			
			
			def args = [
				"${project.csdtCmdArgs.baseUri}/ContentServer", 
				"username=${project.csdtCmdArgs.username}", 
				"password=${project.csdtCmdArgs.password}", 
				"cmd=${cmd}",
				"resources=${resources}",
			]
			
			if (null != fromSites) {
				args.add("fromSites=${fromSites}")
			}
			
			if (null != toSites) {
				args.add("toSites=${toSites}")
			}
			
			if (null != modifiedSince) {
				args.add("modifiedSince=${modifiedSince}")
			}
			
			if (null != datastore) {
				args.add("datastore=${datastore}")
			}
			
			if (null != includeDeps) {
				args.add("includeDeps=${includeDeps}")
			}
			
			if (null != idMapping) {
				args.add("idMapping=${idMapping}")
			}
			
			CSDT.main(args as String[])
		}
		
		private void verifyCsdtArguments() {
			if (null == project.csdtCmdArgs.csdtVersion) {
				//throw new GradleException("Specify CSDT version")
			} else {
				//TODO: Check if CSDT library exists in dependencies
			}
			
			if (null == project.csdtCmdArgs.baseUri) {
				throw new GradleException("'baseUri' should be of format : http://host-name:port/cs")
			}
			
			if (null == project.csdtCmdArgs.username || null == project.csdtCmdArgs.password) {
				throw new GradleException("'username' and 'password' are missing from arguments")
			}
			
			if (null == project.csdtCmdArgs.resources && null == resources) {
				throw new GradleException("You must specify 'resources' to import/export on WCS")
			}
			
			if (null == resources && null != project.csdtCmdArgs.resources) {
				resources = project.csdtCmdArgs.resources;
			}
			
			if (null == project.csdtCmdArgs.cmd && null == cmd) {
				throw new GradleException("You must specify 'cmd' as 'import' or 'export'")
			}
			
			if (null == cmd && null != project.csdtCmdArgs.cmd) {
				cmd = project.csdtCmdArgs.cmd;
			}
			
			if (null == fromSites && null != project.csdtCmdArgs.fromSites) {
				fromSites = project.csdtCmdArgs.fromSites
			}
			
			if (null == toSites && null != project.csdtCmdArgs.toSites) {
				toSites = project.csdtCmdArgs.toSites
			}
			
			if (null == modifiedSince && null != project.csdtCmdArgs.modifiedSince) {
				modifiedSince = project.csdtCmdArgs.modifiedSince
			}
			
			if (null == datastore && null != project.csdtCmdArgs.datastore) {
				datastore = project.csdtCmdArgs.datastore
			}
			
			if (null == includeDeps && null != project.csdtCmdArgs.includeDeps) {
				includeDeps = project.csdtCmdArgs.includeDeps
			}
			
			if (null == idMapping && null != project.csdtCmdArgs.idMapping) {
				idMapping = project.csdtCmdArgs.idMapping
			}
		}
}
