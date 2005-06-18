/*
 * ============================================================================
 *                   GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2005 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 185, Berry Street, Suite 6200
 * San Francisco CA 94107
 * http://www.jaspersoft.com
 */

/*
 * Contributors:
 * Ryan Johnson - delscovich@users.sourceforge.net
 * Carlton Moore - cmoore79@users.sourceforge.net
 */
package net.sf.jasperreports.view;

import java.awt.BorderLayout;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class JasperViewer extends javax.swing.JFrame 
{


	/**
	 *
	 */
	private JRViewer viewer = null;

	/**
	 *
	 */
	private boolean isExitOnClose = true;
	
	
	/** Creates new form JasperViewer */
	public JasperViewer(
		String sourceFile, 
		boolean isXMLFile
		) throws JRException
	{
		this.isExitOnClose = true;

		initComponents();

		this.viewer = new JRViewer(sourceFile, isXMLFile);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}


	/** Creates new form JasperViewer */
	public JasperViewer(
		InputStream is, 
		boolean isXMLFile
		) throws JRException
	{
		this.isExitOnClose = true;

		initComponents();

		this.viewer = new JRViewer(is, isXMLFile);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}


	/** Creates new form JasperViewer */
	public JasperViewer(
		JasperPrint jasperPrint
		) throws JRException
	{
		this.isExitOnClose = true;

		initComponents();

		this.viewer = new JRViewer(jasperPrint);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}

	
	/** Creates new form JasperViewer */
	public JasperViewer(
		String sourceFile, 
		boolean isXMLFile,
		boolean isExitOnClose
		)  throws JRException
	{
		this.isExitOnClose = isExitOnClose;

		initComponents();

		this.viewer = new JRViewer(sourceFile, isXMLFile);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}


	/** Creates new form JasperViewer */
	public JasperViewer(
		InputStream is, 
		boolean isXMLFile,
		boolean isExitOnClose
		) throws JRException
	{
		this.isExitOnClose = isExitOnClose;

		initComponents();

		this.viewer = new JRViewer(is, isXMLFile);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}


	/** Creates new form JasperViewer */
	public JasperViewer(
		JasperPrint jasperPrint,
		boolean isExitOnClose
		) throws JRException
	{
		this.isExitOnClose = isExitOnClose;
		
		initComponents();

		this.viewer = new JRViewer(jasperPrint);
		this.pnlMain.add(this.viewer, BorderLayout.CENTER);
	}

	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents() {//GEN-BEGIN:initComponents
		pnlMain = new javax.swing.JPanel();

		setTitle("JasperViewer");
		setIconImage(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jasperreports/view/images/jricon.GIF")).getImage());
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm(evt);
			}
		});

		pnlMain.setLayout(new java.awt.BorderLayout());

		getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

		pack();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new java.awt.Dimension(750, 550));
		setLocation((screenSize.width-750)/2,(screenSize.height-550)/2);
	}//GEN-END:initComponents

	/** Exit the Application */
	private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
		
		if (this.isExitOnClose)
		{
			System.exit(0);
		}
		else
		{
			this.setVisible(false);
			this.viewer.clear();
			this.viewer = null;
			this.getContentPane().removeAll();
			this.dispose();
		}
		
	}//GEN-LAST:event_exitForm

	
	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) 
	{
		String fileName = null;
		boolean isXMLFile = false;

		if(args.length == 0)
		{
			usage();
			return;
		}

		int k = 0;
		while ( args.length > k )
		{
			if ( args[k].startsWith("-F") )
				fileName = args[k].substring(2);
			if ( args[k].startsWith("-XML") )
				isXMLFile = true;

			k++;	
		}

		try
		{
			viewReport(fileName, isXMLFile);
		}
		catch (JRException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}


	/**
	 *
	 */
	private static void usage()
	{
		System.out.println( "JasperViewer usage:" );
		System.out.println( "\tjava JasperViewer -XML -Ffile" );
	}


	/**
	 *
	 */
	public static void viewReport(
		String sourceFile, 
		boolean isXMLFile
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				sourceFile, 
				isXMLFile,
				true
				);
		jasperViewer.show();
	}

	/**
	 *
	 */
	public static void viewReport(
		InputStream is, 
		boolean isXMLFile
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				is, 
				isXMLFile,
				true
				);
		jasperViewer.show();
	}

	/**
	 *
	 */
	public static void viewReport(
		JasperPrint jasperPrint
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				jasperPrint,
				true
				);
		jasperViewer.show();
	}

	/**
	 *
	 */
	public static void viewReport(
		String sourceFile, 
		boolean isXMLFile,
		boolean isExitOnClose
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				sourceFile, 
				isXMLFile, 
				isExitOnClose
				);
		jasperViewer.show();
	}

	/**
	 *
	 */
	public static void viewReport(
		InputStream is, 
		boolean isXMLFile,
		boolean isExitOnClose
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				is, 
				isXMLFile,
				isExitOnClose
				);
		jasperViewer.show();
	}

	/**
	 *
	 */
	public static void viewReport(
		JasperPrint jasperPrint,
		boolean isExitOnClose
		) throws JRException
	{
		JasperViewer jasperViewer = 
			new JasperViewer(
				jasperPrint,
				isExitOnClose
				);
		jasperViewer.show();
	}


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel pnlMain;
	// End of variables declaration//GEN-END:variables

}
