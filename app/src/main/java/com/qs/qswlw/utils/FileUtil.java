package com.qs.qswlw.utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	private static final String TAG = "FileUtil";
	private static final File parentPath = Environment.getExternalStorageDirectory();
	private static String storagePath = "";
	private static final String DST_FOLDER_NAME = "PlayCamera";
	private static final String DIR_NAME = "Leo";

	/**初始化保存路径
	 * @return
	 */
	private static String initPath(){
		if(storagePath.equals("")){
			storagePath = parentPath.getAbsolutePath()+"/" + DST_FOLDER_NAME;
			File f = new File(storagePath);
			if(!f.exists()){
				f.mkdir();
			}
		}
		return storagePath;
	}

	/**保存Bitmap到sdcard
	 * @param b
	 */
	public static File saveBitmap(Bitmap b){

		File jpegName = getOutputMediaFile();
		Log.i(TAG, "saveBitmap:jpegName = " + jpegName);
		try {
			FileOutputStream fout = new FileOutputStream(jpegName);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
			Log.i(TAG, "saveBitmap成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.i(TAG, "saveBitmap:失败");
			e.printStackTrace();
		}
		return jpegName;
	}
	/**保存Bitmap到sdcard
	 * @param b
	 */
	public static File saveBitmap(Bitmap b, String path){
		File mediaStorageDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				DIR_NAME);
		mkdirs(mediaStorageDir);

		mediaStorageDir = new File(mediaStorageDir.getPath() + File.separator
				+path+ ".jpg");
		try {
			FileOutputStream fout = new FileOutputStream(mediaStorageDir);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
			Log.i(TAG, "saveBitmap成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.i(TAG, "saveBitmap:失败");
			e.printStackTrace();
		}
		return mediaStorageDir;
	}
	public static File loadApkFile() {
		File mediaStorageDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
				DIR_NAME);
		mkdirs(mediaStorageDir);

		return new File(mediaStorageDir.getPath() + File.separator
				+ "Scorpio.apk");
	}
	public static File getOutputMediaFile() {
		File mediaStorageDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				DIR_NAME);
		mkdirs(mediaStorageDir);

		return new File(mediaStorageDir.getPath() + File.separator
				+ "userPicture.jpg");
	}

	public static File loadImageFile() {
		File mediaStorageDir = new File(
				Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				DIR_NAME);
		mkdirs(mediaStorageDir);

		return new File(mediaStorageDir.getPath() + File.separator
				+ "myImage.jpg");
	}

	public static boolean mkdirs(File folder) {
		boolean existed = folder.exists();
		if (existed && !folder.isDirectory()) {
			existed = !folder.delete();
		}
		return existed ? false : folder.mkdirs();
	}
}
