package com.js.favorites;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class FavoritesLog {

	
	//serverity 심각도
	//code , 플러그인내 지정코드
	// message 메시지
	// t 예외처리용
	
	public static void log(String message) {
		log(IStatus.INFO , IStatus.OK , message , null);
	}
	
	public static void logError(Throwable t) {
		logError("에러발생", t);
	}
	
	
	public static void logError(String message , Throwable t) {
		log(IStatus.ERROR , IStatus.OK , message , t);
	}
	
	public static void log(int serverity , int code , String message, Throwable t) {
		log(createStatues(serverity, code, message, t));
	}
	
	public static IStatus createStatues(int serverity, int code , String message , Throwable t) {
		return new Status(serverity, FavoritesPlugin.PLUGIN_ID, code , message , t);
	}
	
	public static void log(IStatus status) {
		FavoritesPlugin.getDefault().getLog().log(status);
	}

}
 