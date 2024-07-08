package com.starbucks.coffee_order.exception;

import com.starbucks.coffee_order.pojo.Result;
import org.eclipse.angus.mail.smtp.SMTPAddressFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public Result handleException(Exception e)
    {
        e.printStackTrace();
        return Result.error(401,
                "用户名或密码长度不合法");
    }

    @ExceptionHandler(MailSendException.class)
    public Result<String> handleEmailException(MailSendException e)
    {
        e.printStackTrace();
        return Result.error(402,"邮箱不存在");
    }
}
