package com.cards.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Card Already Exists")
public class CardAlreadyExistsException extends RuntimeException { }
