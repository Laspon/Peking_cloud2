/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package awd.mis.servers.service;

public interface PublicService {

	String test(String param);
	
	String getFtpFileByName(String fileName);

	String uploadPulicFileToFtp(String fileName, String fileContent);
	
	String deleteFtpFolder(String remotePath);

	String readFtpFileToEntity();
}
