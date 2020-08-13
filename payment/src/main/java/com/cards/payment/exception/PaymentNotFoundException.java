package com.cards.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Payment Not Found")
public class PaymentNotFoundException extends RuntimeException { }
