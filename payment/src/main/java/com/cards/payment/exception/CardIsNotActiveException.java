package com.cards.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Card Is Not Active")
public class CardIsNotActiveException extends RuntimeException {
}
