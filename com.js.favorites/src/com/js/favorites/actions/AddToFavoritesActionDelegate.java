package com.js.favorites.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class AddToFavoritesActionDelegate implements IObjectActionDelegate, IViewActionDelegate{
	
	private IWorkbenchPart targetPart;
	private IProject project;

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method 
		//만약에 한다고하면 여기서 소스 파싱 관련된 기능이 필요함.
		MessageDialog.openInformation(this.targetPart.getSite().getShell(),"add to Favorites " , "triggered the " + getClass().getName() + " action");
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		project = root.getProject("teste1111");
		
		
		System.out.println("######## " + project);
		if (!project.isOpen())
			try {
				project.open(null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (!project.exists())
			try {
				project.create(null);
				
			} catch (CoreException e) {
				e.printStackTrace();
			}
		
		System.out.println("######## " + project);
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IAdaptable)
	        {
	            IProject project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	            IPath path = project.getFullPath();
	            System.out.println(path);
	        }
	    }
		
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		this.targetPart = targetPart;
		
	}

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		System.out.println("iVeiwPart init");
		System.out.println(view);
		this.targetPart = view;
//		MessageDialog.openInformation(this.targetPart.getSite().getShell(),"add to Favorites " , "triggered the " + getClass().getName() + " action");
		
	}


}
