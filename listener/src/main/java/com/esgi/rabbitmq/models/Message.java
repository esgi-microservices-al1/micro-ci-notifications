package com.esgi.rabbitmq.models;

public class Message {
    private String content;
    private String subject;
    private String projectId;

    public Message() {
    }

    public Message(String content, String subject, String projectId) {
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
