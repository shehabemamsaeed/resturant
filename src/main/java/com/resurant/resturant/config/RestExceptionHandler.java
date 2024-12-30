package com.resurant.resturant.config;

import com.resurant.resturant.model.ExceptionResponseModel;
import com.resurant.resturant.service.translator.TranslatorService;
import jakarta.transaction.SystemException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


@ExceptionHandler(SystemException.class)
    public ResponseEntity<ExceptionResponseModel> handleSystemException(SystemException systemException){
    return  ResponseEntity.ok(new ExceptionResponseModel(HttpStatus.BAD_REQUEST
            , TranslatorService.getMessageInArAndEn(systemException.getMessage())));
}
@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseModel> handleRunTimeExp(RuntimeException r){
    return ResponseEntity.ok(new ExceptionResponseModel(HttpStatus.NO_CONTENT,TranslatorService.getMessageInArAndEn(r.getMessage())));
}
@ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionResponseModel> handlePassExp(AuthenticationException p){
    return ResponseEntity.ok(new ExceptionResponseModel(HttpStatus.NON_AUTHORITATIVE_INFORMATION,TranslatorService.getMessageInArAndEn(p.getMessage())));
}

}
