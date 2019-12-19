package org.manjunath.fileapiservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public void saveFilesToTarget(InputStream fileInputStream, FormDataContentDisposition fileMetaData) {
		String fileName = fileMetaData.getFileName();
		String fileExtension = fileName.substring(fileName.lastIndexOf("."));

		switch (fileExtension) {
		case ".pdf":
			savePdfFiles(fileInputStream, fileName);
			break;
		case ".png":
		case ".jpg":
		case ".jpeg":
			saveImageFiles(fileInputStream, fileName);
			break;
		case ".doc":
		case ".docx":
			saveDocFiles(fileInputStream, fileName);
			break;
		case ".xls":
		case ".xlsx":
			saveExcelFiles(fileInputStream, fileName);
			break;

		default:
			break;
		}
	}

	private void savePdfFiles(InputStream fileInputStream, String fileName) {
		String fileLocation = FileFolders.PDF_FOLDER + File.separator + fileName;

		File uploadPath = new File(FileFolders.PDF_FOLDER);
		if (!uploadPath.exists())
			createFolder(uploadPath);

		saveFiles(fileInputStream, fileLocation);
	}
	
	private void saveImageFiles(InputStream fileInputStream, String fileName) {
		String fileLocation = FileFolders.IMG_FOLDER + File.separator + fileName;

		File uploadPath = new File(FileFolders.IMG_FOLDER);
		if (!uploadPath.exists())
			createFolder(uploadPath);

		saveFiles(fileInputStream, fileLocation);
	}
	
	private void saveDocFiles(InputStream fileInputStream, String fileName) {
		String fileLocation = FileFolders.DOC_FOLDER + File.separator + fileName;

		File uploadPath = new File(FileFolders.DOC_FOLDER);
		if (!uploadPath.exists())
			createFolder(uploadPath);

		saveFiles(fileInputStream, fileLocation);
	}
	
	private void saveExcelFiles(InputStream fileInputStream, String fileName) {
		String fileLocation = FileFolders.EXCEL_FOLDER + File.separator + fileName;

		File uploadPath = new File(FileFolders.EXCEL_FOLDER);
		if (!uploadPath.exists())
			createFolder(uploadPath);

		saveFiles(fileInputStream, fileLocation);
	}

	private void saveFiles(InputStream fileInputStream, String fileLocation) {
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(fileLocation);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = fileInputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean createFolder(File folderPath) {
		return folderPath.mkdir();
	}
}
