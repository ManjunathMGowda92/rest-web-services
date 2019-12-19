package org.manjunath.fileapiservice.service;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public interface FileUploadService {
	
	public void saveFilesToTarget(InputStream fileInputStream, FormDataContentDisposition fileMetaData);
}
