
package com.stack.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Item {

	@SerializedName("tags")
	@Expose
	@Valid
	private List<String> tags = new ArrayList<String>();
	@SerializedName("owner")
	@Expose
	@Valid
	private Owner owner;
	@SerializedName("is_answered")
	@Expose
	private Boolean isAnswered;
	@SerializedName("view_count")
	@Expose
	private Integer viewCount;
	@SerializedName("answer_count")
	@Expose
	private Integer answerCount;
	@SerializedName("score")
	@Expose
	private Integer score;
	@SerializedName("last_activity_date")
	@Expose
	private Long lastActivityDate;
	@SerializedName("creation_date")
	@Expose
	private Long creationDate;
	@SerializedName("question_id")
	@Expose
	private Long questionId;
	@SerializedName("link")
	@Expose
	private String link;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("last_edit_date")
	@Expose
	private Long lastEditDate;
	@SerializedName("bounty_amount")
	@Expose
	private Integer bountyAmount;
	@SerializedName("bounty_closes_date")
	@Expose
	private Long bountyClosesDate;
	@SerializedName("accepted_answer_id")
	@Expose
	private Integer acceptedAnswerId;
	@SerializedName("protected_date")
	@Expose
	private Long protectedDate;
	@SerializedName("closed_date")
	@Expose
	private Long closedDate;
	@SerializedName("closed_reason")
	@Expose
	private String closedReason;

	/**
	 * 
	 * @return The tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 *            The tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * 
	 * @return The owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * 
	 * @param owner
	 *            The owner
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * 
	 * @return The isAnswered
	 */
	public Boolean getIsAnswered() {
		return isAnswered;
	}

	/**
	 * 
	 * @param isAnswered
	 *            The is_answered
	 */
	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	/**
	 * 
	 * @return The viewCount
	 */
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * 
	 * @param viewCount
	 *            The view_count
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * 
	 * @return The answerCount
	 */
	public Integer getAnswerCount() {
		return answerCount;
	}

	/**
	 * 
	 * @param answerCount
	 *            The answer_count
	 */
	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	/**
	 * 
	 * @return The score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * 
	 * @param score
	 *            The score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * 
	 * @return The lastActivityDate
	 */
	public Long getLastActivityDate() {
		return lastActivityDate;
	}

	/**
	 * 
	 * @param lastActivityDate
	 *            The last_activity_date
	 */
	public void setLastActivityDate(Long lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	/**
	 * 
	 * @return The creationDate
	 */
	public Long getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * @param creationDate
	 *            The creation_date
	 */
	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 
	 * @return The questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * 
	 * @param questionId
	 *            The question_id
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * 
	 * @return The link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * 
	 * @param link
	 *            The link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The lastEditDate
	 */
	public Long getLastEditDate() {
		return lastEditDate;
	}

	/**
	 * 
	 * @param lastEditDate
	 *            The last_edit_date
	 */
	public void setLastEditDate(Long lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	/**
	 * 
	 * @return The bountyAmount
	 */
	public Integer getBountyAmount() {
		return bountyAmount;
	}

	/**
	 * 
	 * @param bountyAmount
	 *            The bounty_amount
	 */
	public void setBountyAmount(Integer bountyAmount) {
		this.bountyAmount = bountyAmount;
	}

	/**
	 * 
	 * @return The bountyClosesDate
	 */
	public Long getBountyClosesDate() {
		return bountyClosesDate;
	}

	/**
	 * 
	 * @param bountyClosesDate
	 *            The bounty_closes_date
	 */
	public void setBountyClosesDate(Long bountyClosesDate) {
		this.bountyClosesDate = bountyClosesDate;
	}

	/**
	 * 
	 * @return The acceptedAnswerId
	 */
	public Integer getAcceptedAnswerId() {
		return acceptedAnswerId;
	}

	/**
	 * 
	 * @param acceptedAnswerId
	 *            The accepted_answer_id
	 */
	public void setAcceptedAnswerId(Integer acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}

	/**
	 * 
	 * @return The protectedDate
	 */
	public Long getProtectedDate() {
		return protectedDate;
	}

	/**
	 * 
	 * @param protectedDate
	 *            The protected_date
	 */
	public void setProtectedDate(Long protectedDate) {
		this.protectedDate = protectedDate;
	}

	/**
	 * 
	 * @return The closedDate
	 */
	public Long getClosedDate() {
		return closedDate;
	}

	/**
	 * 
	 * @param closedDate
	 *            The closed_date
	 */
	public void setClosedDate(Long closedDate) {
		this.closedDate = closedDate;
	}

	/**
	 * 
	 * @return The closedReason
	 */
	public String getClosedReason() {
		return closedReason;
	}

	/**
	 * 
	 * @param closedReason
	 *            The closed_reason
	 */
	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}

}
