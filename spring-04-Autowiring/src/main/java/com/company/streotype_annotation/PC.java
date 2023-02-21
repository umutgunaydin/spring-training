package com.company.streotype_annotation;

import com.company.streotype_annotation.casefactory.Case;
import com.company.streotype_annotation.monitorfactory.Monitor;
import com.company.streotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    @Autowired//  After version 4.3 if we have only one constructor in the class we can omit writing this annotation
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
