package com.pablito.sdahelper;

import com.pablito.sdahelper.builder.Car;
import com.pablito.sdahelper.chainofresp.Dispenser;
import com.pablito.sdahelper.chainofresp.Dollar10Dispenser;
import com.pablito.sdahelper.chainofresp.Dollar1Dispenser;
import com.pablito.sdahelper.chainofresp.Dollar20Dispenser;
import com.pablito.sdahelper.chainofresp.Dollar50Dispenser;
import com.pablito.sdahelper.command.LightOnCommand;
import com.pablito.sdahelper.command.LightsOffCommand;
import com.pablito.sdahelper.command.PlayTrackCommand;
import com.pablito.sdahelper.command.RoomExecutor;
import com.pablito.sdahelper.command.SmartHomeRoom;
import com.pablito.sdahelper.facade.AttendeeRepository;
import com.pablito.sdahelper.facade.CourseFacade;
import com.pablito.sdahelper.factory.Shape;
import com.pablito.sdahelper.factory.ShapeFactory;
import com.pablito.sdahelper.observerSolution.Attendee;
import com.pablito.sdahelper.observerSolution.Course;
import com.pablito.sdahelper.observerSolution.EmailGatewayMockup;
import com.pablito.sdahelper.observerSolution.SmsGatewayMockup;
import com.pablito.sdahelper.strategy.LinearTaxTaxationStrategy;
import com.pablito.sdahelper.strategy.ProgressiveTaxTaxationStrategy;
import com.pablito.sdahelper.strategy.TaxationStrategy;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;

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
        final AttendeeRepository repository = new AttendeeRepository(new LinkedList<>());
        final CourseFacade facade = new CourseFacade(repository);
        repository.addAttendee("Paweł");
        repository.addAttendee("Andrzej");
        repository.addAttendee("Maciej");
        repository.addAttendee("Piotr");
        repository.addAttendee("Kasia");

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

        //chain of responsibility
        final Dispenser dispenser =
                new Dollar50Dispenser(new Dollar20Dispenser(new Dollar10Dispenser(new Dollar1Dispenser(null))));

        System.out.println("127 dollars dipense:" + dispenser.withdraw(127));
        System.out.println("0 dollars dipense:" + dispenser.withdraw(0));
        System.out.println("300 dollars dipense:" + dispenser.withdraw(300));

        //observer
        //build Course here, build both Gateways here
        //add Gateways as observers of the course
        //add few attendees and check the log file
    }
}
