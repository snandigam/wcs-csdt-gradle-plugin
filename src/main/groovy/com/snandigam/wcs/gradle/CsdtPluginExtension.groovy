package com.snandigam.wcs.gradle

class CsdtPluginExtension {
	String csdtVersion
	String baseUri
	String username
	String password
	String resources
	String cmd
	
	//optional arguments
	String fromSites
	String toSites
	String modifiedSince
	String datastore
	String includeDeps
	String idMapping
}
