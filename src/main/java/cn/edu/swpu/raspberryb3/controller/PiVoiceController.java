package cn.edu.swpu.raspberryb3.controller;

import cn.edu.swpu.raspberryb3.service.PiBaseService;
import cn.edu.swpu.raspberryb3.service.PiVoiceService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/raspberry3")
@Slf4j
public class PiVoiceController {

    @Autowired
    private PiVoiceService piVoiceService;

    @Autowired
    private PiBaseService piBaseService;

    @RequestMapping(value = "/voicesensor", method = RequestMethod.GET)
    private Map<String, String> getEdge() {
        piVoiceService.getEdge();
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("status", "success");
        return statusMap;
    }

    @RequestMapping(value = "/turnOnFirst", method = RequestMethod.GET)
    private void turnOnFirst() {
        piBaseService.turnOnFirst();
    }

    @RequestMapping(value = "/turnOnSecond", method = RequestMethod.GET)
    private void turnOnSecond() {
        piBaseService.turnOnSecond();
    }

    @RequestMapping(value = "/turnOffSecond", method = RequestMethod.GET)
    private void turnOffSecond() {

        piBaseService.turnOffSecond();
    }

    @RequestMapping(value = "/turnOnBuzzer", method = RequestMethod.GET)
    private void turnOnBuzzer() {
        piBaseService.turnOnBuzzer();
    }

    @RequestMapping(value = "/turnOffFirst", method = RequestMethod.GET)
    private void turnOffFirst() {
        piBaseService.turnOffFirst();
    }

    @RequestMapping(value = "/turnOffBuzzer", method = RequestMethod.GET)
    private void turnOffBuzzer() {
        piBaseService.turnOffBuzzer();
    }

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    private String sample() {

        return "sample !";
    }

    @RequestMapping(value = "/switchOn", method = RequestMethod.GET)
    private void switchOn() {

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();


        // provision gpio pin #02
        final GpioPinDigitalOutput led2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);

        // continuously blink the led every 1/2 second for 15 seconds
        led2.high();
        System.out.println("GPIO 2 HIGH");
        gpio.shutdown();
        gpio.unprovisionPin(led2);
    }

    @RequestMapping(value = "/switchOff", method = RequestMethod.GET)
    private void switchOff() {

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();


        // provision gpio pin #02
        final GpioPinDigitalOutput led2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);

        // continuously blink the led every 1/2 second for 15 seconds
        led2.low();
        System.out.println("GPIO 2 LOW");
        gpio.shutdown();
        gpio.unprovisionPin(led2);
    }


}
