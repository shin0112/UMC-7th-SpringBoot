package com.umc.study.global.apiPayload.exception;

import com.umc.study.global.apiPayload.ApiResponse;
import com.umc.study.global.apiPayload.code.ReasonDto;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> validation(
        final ConstraintViolationException e,
        final WebRequest request
    ) {
        String errorMessage = e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

        return handleExceptionInternalConstraint(
            e,
            ErrorStatus.valueOf(errorMessage),
            request
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        final MethodArgumentNotValidException e,
        final HttpHeaders headers,
        final HttpStatusCode status,
        final WebRequest request
    ) {

        Map<String, String> errors = new LinkedHashMap<>();

        e.getBindingResult().getFieldErrors()
            .forEach(fieldError -> {
                String fieldName = fieldError.getField();
                String message = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
                errors.merge(
                    fieldName,
                    message,
                    (existingErrorMessage, newErrorMessage)
                        -> existingErrorMessage + ", " + newErrorMessage);
            });

        return handleExceptionInternalArgs(
            e,
            ErrorStatus.valueOf("_BAD_REQUEST"),
            request,
            errors
        );
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(
        final Exception e,
        final WebRequest request
    ) {
        e.printStackTrace();

        return handleExceptionInternalFalse(
            e,
            ErrorStatus._INTERNAL_SERVER_ERROR.getHttpStatus(),
            request,
            e.getMessage()
        );
    }

    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity<Object> onThrowException(
        final GeneralException generalException,
        final HttpServletRequest request
    ) {
        ReasonDto errorReasonDto = generalException.getErrorReasonHttpStatusDto();

        return handleExceptionInternal(
            generalException,
            errorReasonDto,
            request
        );
    }

    private ResponseEntity<Object> handleExceptionInternal(
        final Exception e,
        final ReasonDto reasonDto,
        final HttpServletRequest request
    ) {
        ApiResponse<Object> apiResponse = ApiResponse.error(
            reasonDto.getCode(),
            reasonDto.getMessage(),
            null
        );
        WebRequest webRequest = new ServletWebRequest(request);

        return super.handleExceptionInternal(
            e,
            apiResponse,
            HttpHeaders.EMPTY,
            reasonDto.getHttpStatus(),
            webRequest
        );
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(
        final Exception e,
        final HttpStatusCode httpStatus,
        final WebRequest request,
        final String message
    ) {
        ApiResponse<Object> apiResponse = ApiResponse.error(
            ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),
            ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(),
            message
        );

        return super.handleExceptionInternal(
            e,
            apiResponse,
            HttpHeaders.EMPTY,
            httpStatus,
            request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(
        final Exception e,
        final ErrorStatus errorStatus,
        final WebRequest request,
        final Map<String, String> errors
    ) {
        ApiResponse<Object> apiResponse = ApiResponse.error(
            errorStatus.getCode(),
            errorStatus.getMessage(),
            errors
        );

        return super.handleExceptionInternal(
            e,
            apiResponse,
            HttpHeaders.EMPTY,
            errorStatus.getHttpStatus(),
            request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(
        final Exception e,
        final ErrorStatus errorStatus,
        final WebRequest request
    ) {
        ApiResponse<Object> apiResponse = ApiResponse.error(
            errorStatus.getCode(),
            errorStatus.getMessage(),
            null
        );

        return super.handleExceptionInternal(
            e,
            apiResponse,
            HttpHeaders.EMPTY,
            errorStatus.getHttpStatus(),
            request
        );
    }
}
