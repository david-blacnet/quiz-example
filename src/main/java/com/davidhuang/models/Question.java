package com.davidhuang.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idSubTopic;
    private String questionText;
    private Integer idQuestionType;

    public Question() {
    }

    public Question(Integer idSubTopic, Integer idQuestionType, String questionText) {
        this.idSubTopic = idSubTopic;
        this.idQuestionType = idQuestionType;
        this.questionText = questionText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSubTopic() {
        return idSubTopic;
    }

    public void setIdSubTopic(Integer idSubTopic) {
        this.idSubTopic = idSubTopic;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(Integer idQuestionType) {
        this.idQuestionType = idQuestionType;
    }
}
