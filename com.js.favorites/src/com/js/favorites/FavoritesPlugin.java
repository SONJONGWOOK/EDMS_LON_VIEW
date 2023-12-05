package com.js.favorites;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FavoritesPlugin extends AbstractUIPlugin{

	// The plug-in ID
	public static final String PLUGIN_ID = "com.js.favorites"; //$NON-NLS-1$

	// The shared instance
	private static FavoritesPlugin plugin;
	
	/**
	 * The constructor
	 */
	public FavoritesPlugin() {
	}
	
	//플랫폼 테스트용
	public void getPlatformTest() {
		System.out.println("########### TEST 시작" );
		
		IBundleGroupProvider[] bList =  Platform.getBundleGroupProviders();
		for(IBundleGroupProvider b : bList) {
			System.out.println(b);
		}

		
		
	}
	
	
	//플랫폼 컨피크 위치.
	public File getConfigDir() {
		Location location = Platform.getConfigurationLocation();
		if(location != null) {
			URL url  =location.getURL();
			if(url != null && url.getProtocol().startsWith("file")){
				System.out.println("###########");
				System.out.println(url.getFile());
				System.out.println("###########");
				
				
				
				
				
				
				return new File(url.getFile() , PLUGIN_ID);
				
			}
			
		}
		return null;
	}
	
	//IStartUp 구현체... 지금은 우선 주석처리  implements IStartup 
	//아마 start 하기전 미리구동되어야할것들
//	@Override
//	public void earlyStartup() {
//		// TODO Auto-generated method stub
//		
//	}

	//플러그인 활성화시점에 호출
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.getConfigDir();
//		this.getPlatformTest();
		
	}
	//플러그인 종료(중단)시점에 호출
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FavoritesPlugin getDefault() {
		return plugin;
	}

//	AbstractUIPlugin 화면관련된건 이걸로 한다.
//	아래는 AbstractUIPlugin 메서드들 세부 사항을 코멘트 달아놓을꺼임.
	
	//플러그인 자주사용되는 이미지 레지스트
	@Override
	protected ImageRegistry createImageRegistry() {
		// TODO Auto-generated method stub
		return super.createImageRegistry();
	}

	//UI플러그인 대화창 생성
	@Override
	public IDialogSettings getDialogSettings() {
		// TODO Auto-generated method stub
		return super.getDialogSettings();
	}

	//이미지 레지스트 반환
	@Override
	public ImageRegistry getImageRegistry() {
		// TODO Auto-generated method stub
		return super.getImageRegistry();
	}

	//이미지 레지스트 초기화
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		//                                                  TODO Auto-generated method stub
		super.initializeImageRegistry(reg);
	}
	
	

}
