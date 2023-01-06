package com.kodilla.travel_backend.scheduler;

import com.kodilla.travel_backend.config.AdminConfig;
import com.kodilla.travel_backend.domain.Mail;
import com.kodilla.travel_backend.repository.OrderRepository;
import com.kodilla.travel_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EmailScheduler {

    private static final String SUBJECT = "Number of daily orders";
    private static final String MESSAGE = "In the database: ";

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 23 * * *")
    public void sendInformationEmail() {
        long size = orderRepository.count();
        emailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, MESSAGE + size + ((size != 1) ? " orders" : " order")));
    }
}
