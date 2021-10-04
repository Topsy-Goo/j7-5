package ru.gb.antonov.j75.dtos.errorhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*   Этот класс-бин используется для обработки исключений, бросаемых в приложении. С его
помощью необрабатываемые исключения «превращаются» в сообщения и отправляются клиенту.
*/
@ControllerAdvice   //< наследуется от @Component
public class GlobalExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<?> catchResouceNotFoundException (ResourceNotFoundException e)
    {
        return new ResponseEntity<>(new ErrorMessage (e.getMessage ()), HttpStatus.NOT_FOUND);
    }
}
