package io._10a.wfdemo;

import jakarta.persistence.*;

@Entity
@Table(name = "GREETINGS")
public class Greeting {

    @Id
    @Column(name ="GREETING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LANG")
    private String lang;

    @Column(name = "GREETING")
    private String greeting;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
