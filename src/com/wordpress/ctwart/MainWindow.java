package com.wordpress.ctwart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainWindow {
	private JFrame frame;
	private JMenuBar menuBar;
	private JScrollPane categoriesPane;
	private JScrollPane dataPane;
	private DefaultMutableTreeNode root;

	public MainWindow(String windowTitle) {
		frame = new JFrame(windowTitle);
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenuBar();
		createCategories();
		createDataPane();

		frame.setVisible(true);

	}

	private void createDataPane() {
		dataPane = new JScrollPane();
		frame.add(dataPane, BorderLayout.CENTER);
	}

	private void createCategories() {
		root = new DefaultMutableTreeNode("root");
		JTree categoriesTree = new JTree(root);
		categoriesPane = new JScrollPane(categoriesTree);
		categoriesTree.setRootVisible(false);
		categoriesPane.setPreferredSize(new Dimension(300, Integer.MAX_VALUE));
		frame.add(categoriesPane, BorderLayout.LINE_START);
	}

	private void createMenuBar() {
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		frame.add(menuBar, BorderLayout.PAGE_START);
	}
}
