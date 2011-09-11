package com.itap.callcenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class PagingController {
	
	private Logger logger = LoggerFactory.getLogger(PagingController.class);
	
	// default value
	protected int rowsPerPage = 25;
	protected int currentPage = 1;
	protected int totalRows = 0;
	protected int firstRow = 0;
	protected int lastRow = 0;
	
	/**
	 *  update 
	 *  	- list of result
	 *  	- totalRows
	 * @param startRow
	 * @param endRow
	 */
	abstract public void search();
	
	// control pagination
	public void firstPage() {
		if (!isEnableFirstPage()) return;
		currentPage = 1;
		firstRow = 0;
		search();
		
	}
	public void nextPage() {
		if (!isEnableNextPage()) return;
		currentPage++;
		firstRow = ((currentPage - 1) * rowsPerPage);
		search();
	}
	public void previousPage() {
		if (!isEnablePreviousPage()) return;
		currentPage--;
		firstRow = ((currentPage - 1) * rowsPerPage);
		search();
	}
	public void lastPage() {
		if (!isEnableLastPage()) return;
		currentPage = (totalRows / rowsPerPage) + (totalRows % rowsPerPage == 0 ? 0 : 1);
		firstRow = totalRows % rowsPerPage == 0 ? (totalRows / rowsPerPage - 1) * rowsPerPage : totalRows - totalRows % rowsPerPage;
		search();
	}

	public boolean isEnableFirstPage() {
		return currentPage > 1;
	}
	public boolean isEnableLastPage() {
		return currentPage < (totalRows / rowsPerPage) + (totalRows % rowsPerPage == 0 ? 0 : 1);
	}
	public boolean isEnableNextPage() {
		return (currentPage - 1) * rowsPerPage + rowsPerPage < totalRows;
	}
	public boolean isEnablePreviousPage() {
		return (currentPage - 1) * rowsPerPage + 1 > 1;
	}
	
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	public int getFirstRow() {
		return firstRow + 1;
	}
	
	public int getLastRow() {
		lastRow = totalRows > (firstRow + rowsPerPage) ? (firstRow + rowsPerPage) : totalRows;
		return lastRow;
	}
	
	
}
