package com.xlx.common.exception;

import com.xlx.common.response.ErrorMessageResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessageResult<?> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return ErrorMessageResult.fail(400, "Validation Failed: " + msg, null, req.getRequestURI(), (String)req.getAttribute("requestId"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorMessageResult<?> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest req) {
        return ErrorMessageResult.fail(400, "Malformed JSON request", null, req.getRequestURI(), (String)req.getAttribute("requestId"));
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public ErrorMessageResult<?> handleNotFound(UsernameNotFoundException ex, HttpServletRequest req) {
        return ErrorMessageResult.fail(404, ex.getMessage(), null, req.getRequestURI(), (String)req.getAttribute("requestId"));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ErrorMessageResult<?> handleBadCreds(BadCredentialsException ex, HttpServletRequest req) {
        return ErrorMessageResult.fail(401, "Invalid Credentials", null, req.getRequestURI(), (String)req.getAttribute("requestId"));
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessageResult<?> handleAll(Exception ex, HttpServletRequest req) {
        log.error("Unexpected error", ex);
        return ErrorMessageResult.fail(500, "Internal Server Error", null, req.getRequestURI(), (String)req.getAttribute("requestId"));
    }


}