package shippo.vn.delivery.exception;


import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;


@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DATA_NOT_FOUND = "Exception.notfound";
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";

    private MessageSource messageSource;

    @Autowired
    public CustomRestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // 400



    protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers,
                                                        final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type " + ex.getRequiredType();
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);

        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, name, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex, final HttpHeaders headers,
                                                                     final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final String error = ex.getRequestPartName() + " part is missing";
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);

        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, name, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers,
                                                                          final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final String error = ex.getParameterName() + " parameter is missing";
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);

        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, name, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    //

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);


        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, name, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    // 404

    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex, final HttpHeaders headers,
                                                                   final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);


        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, name, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    // 405

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers,
                                                                         final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);


        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.METHOD_NOT_ALLOWED, name, ex.getLocalizedMessage(), builder.toString());
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    // 415

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex, final HttpHeaders headers,
                                                                     final HttpStatus status, final WebRequest request, Locale locale) {
        logger.info(ex.getClass().getName());
        //
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t + " "));

        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);


        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, name, ex.getLocalizedMessage(), builder.substring(0, builder.length() - 2));
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), errorMessage.getHttpCode());
    }

    // 500

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex, Locale locale) {
        logger.info(ex.getClass().getName());
        logger.error("error", ex);
        //
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        final String message = messageSource.getMessage(DATA_NOT_FOUND, null, locale);
        final ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, name, message);

        Map<String, Object> response = new HashMap<String, Object>();

        response.put("error", errorMessage);

        return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);

    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request, Locale locale)
    {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final String name = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);


        ErrorMessage errorMessage =
                new ErrorMessage(HttpStatus.BAD_REQUEST, name, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
                ex, errorMessage, headers, errorMessage.getHttpCode(), request);
    }

}

