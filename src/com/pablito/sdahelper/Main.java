package com.pablito.sdahelper;

import com.pablito.sdahelper.builder.Car;
import com.pablito.sdahelper.command.LightOnCommand;
import com.pablito.sdahelper.command.LightsOffCommand;
import com.pablito.sdahelper.command.PlayTrackCommand;
import com.pablito.sdahelper.command.RoomExecutor;
import com.pablito.sdahelper.command.SmartHomeRoom;
import com.pablito.sdahelper.facade.CourseFacade;
import com.pablito.sdahelper.factory.Shape;
import com.pablito.sdahelper.factory.ShapeFactory;
import com.pablito.sdahelper.strategy.LinearTaxTaxationStrategy;
import com.pablito.sdahelper.strategy.ProgressiveTaxTaxationStrategy;
import com.pablito.sdahelper.strategy.TaxationStrategy;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public static void main(final String[] args) throws IOException {
        //factory
        final Shape circle = ShapeFactory.buildShape("CIRCLE");
        final Shape trapezoid = ShapeFactory.buildShape("TRAPEZOID");

        System.out.println(String.format("Circle area is: %s", circle.area()));
        System.out.println(String.format("Circle circumference: %s", circle.circumference()));
        System.out.println(String.format("Trapezoid area is: %s", trapezoid.area()));
        System.out.println(String.format("Trapezoid circumference: %s", trapezoid.circumference()));

        //builder
        final Car car = new Car.Builder()
                .body("cool body")
                .engine(1.6)
                .inside("colorful")
                .undercarriage("done right")
                .build();

        //facade
        final CourseFacade facade = new CourseFacade();
        facade.addAttendee("Paweł");
        facade.addAttendee("Andrzej");
        facade.addAttendee("Maciej");
        facade.addAttendee("Piotr");
        facade.addAttendee("Kasia");

        System.out.println("by name: " + facade.getAttendeesSortByName());
        System.out.println("by order: " + facade.getAttendeesSortByOrder());
        System.out.println("with length 5: " + facade.getAttendeesWithGivenNameLength(5));
        System.out.println("with prefix P: " + facade.getAttendeesWithNamesStartingWith("P"));

        //command
        final SmartHomeRoom livingRoom = new SmartHomeRoom("living room");
        final SmartHomeRoom office = new SmartHomeRoom("office");

        final RoomExecutor executor = new RoomExecutor();

        executor.executeOperation(new LightOnCommand(livingRoom));
        executor.executeOperation(new PlayTrackCommand("Come Together by Beatles", livingRoom));
        executor.executeOperation(new LightsOffCommand(office));
        executor.executeOperation(new PlayTrackCommand("Master of Puppets by Metallica", office));

        System.out.println(livingRoom.status());
        System.out.println(office.status());

        //strategy
        final TaxationStrategy linear = new LinearTaxTaxationStrategy();
        final TaxationStrategy progressive = new ProgressiveTaxTaxationStrategy();

        final BigDecimal income = new BigDecimal(100000);

        System.out.println(String.format("Linear tax for 100000 is: %s", linear.calculateTax(income).doubleValue()));
        System.out.println(String.format("Progressive tax for 100000 is: %s", progressive.calculateTax(income).doubleValue()));
    }
}
