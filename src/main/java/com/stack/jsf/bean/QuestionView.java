package com.stack.jsf.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stack.entity.StackAnswer;
import com.stack.srv.StackApiServiceImpl;
import com.stack.srv.interfaces.StackApiService;
import com.stack.util.ResponseParser;

@ViewScoped
@ManagedBean(name = "quesView")
public class QuestionView implements Serializable {

	private static final long serialVersionUID = 0L;
	private static final Logger log = LogManager.getLogger(QuestionView.class);
	private static final String dateFormat = "dd.MM.yyyy HH:mm:ss";
	private StackApiService stackApi = null;
	private Gson gson = null;
	private StackAnswer lastAnswer = null;
	private String lastError = null;
	private String intitle = "";
	private Integer page = null;
	private Integer pagesize = null;

	public QuestionView() {
		super();
	}

	@PostConstruct
	public void init() {
		stackApi = new StackApiServiceImpl();
		gson = new GsonBuilder().create();
	}

	private boolean execSearch() {
		Response resp = stackApi.search(intitle, page, pagesize);
		if (resp == null) {
			log.error("StackExchange response is null");
			lastError = "Server returned empty response";
			return false;
		}
			
		if (resp.getStatus() != 200) {
			log.error("StackExchange response is error #{}: {}", resp.getStatus(), resp.getEntity());
			lastError = "Server returned error " + resp.getStatus();
			return false;
		}
		log.info("StackExchange response is handling...");
		String jsonResp = ResponseParser.parseGzip(resp);
		StackAnswer answer = gson.fromJson(jsonResp, StackAnswer.class);
		if (answer == null) {
			log.error("Unable parse the answer {}", resp.getEntity());
			lastError = "Unable parse the answer";
			return false;
		}
		lastAnswer = answer;
		return true;
	}

	public void buttonAction(ActionEvent actionEvent) {
		if (!execSearch()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", lastError));
		}
	}

	public StackAnswer getLastAnswer() {
		return lastAnswer;
	}

	public String getIntitle() {
		return intitle;
	}

	public void setIntitle(String intitle) {
		this.intitle = intitle;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public String formatDate(Long longDate) {
		if (longDate == null)
			return null;
		Date date = new Date(longDate * 1000);
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date);
	}
}