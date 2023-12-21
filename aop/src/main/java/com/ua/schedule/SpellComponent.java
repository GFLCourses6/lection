package com.ua.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpellComponent {

    @Value(value = "#{2>1?'a':'b'}")
    public String spellOne;

    @Value(value = "#{testComponent.testParam!=null?'a':'b'}")
    public String spellTwo;

    @Value(value = "#{testComponent.testParam!=null?testComponent.testParam:'testParam'}")
    public String spellThree;

    @Value("#{testComponent.map['testKey'] != null ? testComponent.map['testKey'] : (testComponent.testKey != null ? testComponent.testKey : '${test.property}')}")
    public String spellFour;

    @Value(value = "#{testComponent.flag()}")
    public boolean spellFive;
}
