package org.translifeline.cupcakehotline.models;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Call {
	@Id Long id;
	String twilioId;
	Date length;
	@Load Ref<Caller> caller;
	@Load Ref<Operator> operator;
	Date startedAt;
	Date endedAt;
	Date answeredAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTwilioId() {
		return twilioId;
	}
	public void setTwilioId(String twilioId) {
		this.twilioId = twilioId;
	}
	public Date getLength() {
		return length;
	}
	public void setLength(Date length) {
		this.length = length;
	}
	public Caller getCaller() {
		return caller.get();
	}
	public void setCaller(Caller caller) {
		this.caller = Ref.create(caller);
	}
	public Operator getOperator() {
		return operator.get();
	}
	public void setOperator(Operator operator) {
		this.operator = Ref.create(operator);
	}
	public Date getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}
	public Date getEndedAt() {
		return endedAt;
	}
	public void setEndedAt(Date endedAt) {
		this.endedAt = endedAt;
	}
	public Date getAnsweredAt() {
		return answeredAt;
	}
	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}
}
