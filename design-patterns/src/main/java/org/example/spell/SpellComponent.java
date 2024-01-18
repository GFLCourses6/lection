package org.example.spell;

import org.springframework.beans.factory.annotation.Value;

public class SpellComponent {
    //@Value(value = "${fixed.daily.rate:defaultValue}")
//    @Value(value = "#{testComponent.testParam}") // spell language
//    @Value(value = "#{2>1?'a':'b'}") // spell language
    @Value(value = "#{exampleComponent.testParam != null ? testComponent.testParam:'default'}") // spell language
    public String spellOne;
    @Value(value = "#{exampleComponent.listExample[0]}")
    public String spellTwo;
    @Value(value = "#{exampleComponent.mapExample['TestKey']}")
    public String spellThree;
    @Value(value = "#{exampleComponent.testMethod()}")
    public String boolExample;

}
