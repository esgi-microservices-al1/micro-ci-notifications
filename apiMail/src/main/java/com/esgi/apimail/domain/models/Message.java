package com.esgi.apimail.domain.models;

public class Message  extends ModelBase{
    private String content;
    private String subject;
    private Long projectId;

    public Message() {
        this(null, null);
    }

    public Message(String content, String subject) {
        this(null, content, subject);
    }

    public Message(Long id, String content, String subject) {
        super(id);
        this.content = content;
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
