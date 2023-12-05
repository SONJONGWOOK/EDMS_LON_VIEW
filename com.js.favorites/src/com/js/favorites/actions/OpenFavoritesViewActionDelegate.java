package com.js.favorites.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;

import com.js.favorites.FavoritesLog;
import com.js.favorites.views.FavoritesView;

public class OpenFavoritesViewActionDelegate implements IWorkbenchWindowActionDelegate {
	
	private IWorkbenchWindow window;
	public static final String ID = "com.js.favorites.views.FavoritesView";

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		System.out.println("run");
		System.out.println("초기구동");
		//페이지 구동시
		if(this.window == null) {
			return;
		}
		
		
		IWorkbenchPage page = this.window.getActivePage();
		System.out.println("윈도우");
		System.out.println(this.window);
		System.out.println("페이지 ");
		System.out.println(page);
		if(page == null) {
			return;
		}
		try {
			System.out.println("뷰실행 " + FavoritesView.ID);
			page.showView(FavoritesView.ID);
			
			
		} catch (PartInitException e) {
			FavoritesLog.logError("뷰 오픈 에러발생 " ,e);
		}

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		System.out.println("selectionChanged");
		System.out.println(action.getClass());
		System.out.println(selection.getClass());
		//이거보니깐 view 이동될때마다 호출됨.
		//selection provider를 찾아서 받아주면될듯 View에 있다는데 아직 못찾음.
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("dispose");

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		System.out.println("init");
		System.out.println(window.getClass());
		this.window = window;

	}

}
