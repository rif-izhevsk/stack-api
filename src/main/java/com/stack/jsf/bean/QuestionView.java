package com.stack.jsf.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
	private String intitle = "";

	public QuestionView() {
		super();
	}

	@PostConstruct
	public void init() {
		stackApi = new StackApiServiceImpl();
		gson = new GsonBuilder().create();
	}

	public void callSearch() {
		Response resp = stackApi.search(intitle);
		if (resp != null && resp.getStatus() == 200) {
			// TODO meaningful logs
			log.info("StackExchange response is handling...");
			String jsonResp = ResponseParser.parseGzip(resp);
			StackAnswer answer = gson.fromJson(jsonResp, StackAnswer.class);
			if (answer != null) {
				lastAnswer = answer;
			} else {
				log.error("Something wrong with answer {}", answer);
			}
		} else {
			log.error("StackExchange response is error: {}", resp.getEntity());
		}
	}

	public void buttonAction(ActionEvent actionEvent) {
		callSearch();
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

	public String formatDate(Long longDate) {
		if (longDate == null)
			return null;
		Date date = new Date(longDate * 1000);
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date);
	}
}