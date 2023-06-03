package dev.zevolution.springdistributedjobjobrunr.bootstrap;

import dev.zevolution.springdistributedjobjobrunr.bootstrap.exceptions.NotFoundException;
import dev.zevolution.springdistributedjobjobrunr.adapter.transportlayers.openapi.model.GeneralError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdviceConfiguration {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GeneralError notFoundHandler(NotFoundException e) {
        GeneralError generalError = new GeneralError();
        generalError.setCode(404);
        generalError.setMessage(e.getMessage());
        return generalError;
    }

}