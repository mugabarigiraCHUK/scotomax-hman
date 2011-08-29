package com.mt.pos.dto;

import java.io.Serializable;
import java.util.List;

import com.mt.pos.beans.Feeds;
import com.mt.pos.beans.News;

public abstract class HomeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6284267251166507013L;

	protected String keyword;
	protected List<Feeds> feeds;
	protected List<News> news;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Feeds> getFeeds() {
		return feeds;
	}
	public void setFeeds(List<Feeds> feeds) {
		this.feeds = feeds;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
	
}
