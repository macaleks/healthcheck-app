package ru.otus.mvc.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import ru.otus.mvc.service.BookService;

@Component
public class DbTabCountHealthIndicator implements HealthIndicator {

    private final BookService bookService;

    public DbTabCountHealthIndicator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Health health() {
        long count = bookService.count();
        return Health.up()
                .withDetail("Book count", String.valueOf(count)).build();
    }
}
