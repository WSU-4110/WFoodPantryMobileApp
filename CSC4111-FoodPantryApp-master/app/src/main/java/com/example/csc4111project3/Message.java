package com.example.csc4111project3;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;


public class Message {
    public String recipient, subject, messageContent;

    //default
    public Message() {

    }

    //standard constructor
    public Message(String recipient, String subject, String messageContent){
        this.recipient = recipient;
        this.subject = subject;
        this.messageContent = messageContent;
    }

    //getters
    public String getRecipient(){
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessageContent() {
        return messageContent;
    }

    //setters

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    //to String
    @Override
    public String toString() {
        return "Message{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(getRecipient(), message.getRecipient()) &&
                Objects.equals(getSubject(), message.getSubject()) &&
                Objects.equals(getMessageContent(), message.getMessageContent());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getRecipient(), getSubject(), getMessageContent());
    }
}
