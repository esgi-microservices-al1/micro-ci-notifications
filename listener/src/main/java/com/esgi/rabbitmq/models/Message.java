package com.esgi.rabbitmq.models;

public class Message {
    private String content;
    private String subject;
    private Long projectId;

    public Message() {
    }

    public Message(String content, String subject, Long projectId) {
        this.content = content;
        this.subject = subject;
        this.projectId = projectId;
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
