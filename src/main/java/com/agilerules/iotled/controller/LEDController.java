package com.agilerules.iotled.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LEDController {
	
	public static GpioPinDigitalOutput pin;
	
	@RequestMapping("/")
	public String greeting(){
		return "Hello World!!";
	}
    /*

    	@RequestMapping("/switch")
	public String test(){
		// ******************************************************************
		// INITIALIZE
		// ******************************************************************

		// momentary push-button switch; activates when button is pushed
		GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalInput buttonPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_UP);

		// led; illuminates when GPIO is HI
		final GpioPinDigitalOutput ledPin =  gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);

		// make sure the LED is turned off when program shuts down
		gpio.setShutdownOptions(true, PinState.LOW, ledPin);

		// ******************************************************************
		// GPIO EVENT LISTENER(S)
		// ******************************************************************

		// create button event listener
		buttonPin.addListener(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

				// display console message
				System.out.println("Button pressed: state = " + event.getState());

				if(event.getState().isHigh()){
					// turn off LED pin
					ledPin.setState(PinState.LOW);
				}
				else{
					// turn on LED pin
					ledPin.setState(PinState.HIGH);
				}
			}
		});

        // display console message when LED pin state changes
        ledPin.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState().isHigh()){
                    System.out.println("LED is ON");
                }
                else{
                    System.out.println("LED is OFF");
                }
            }
        });

		return "TEST COMPLETED" ;
	};

     */
	@RequestMapping("/light")
	public String light(){
		if(pin==null){
			GpioController gpio = GpioFactory.getInstance();
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18,"My LED",PinState.LOW);
		}
		pin.toggle();
		return "Response from light!!";
	}

}
